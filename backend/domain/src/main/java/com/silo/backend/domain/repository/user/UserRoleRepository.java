package com.silo.backend.domain.repository.user;

import com.silo.backend.domain.model.entity.user.ImmutableUser;
import com.silo.backend.domain.model.entity.user.User;
import com.silo.backend.utils.ChecksUtilities;
import com.silo.backend.utils.SetUtilities;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.silo.backend.database.tables.User.USER;
import static com.silo.backend.database.tables.UserRole.USER_ROLE;

@Repository
public class UserRoleRepository {

	private static final Logger LOG = LoggerFactory.getLogger(UserRoleRepository.class);

	private final DSLContext dsl;

	public UserRoleRepository(DSLContext dsl) {
		ChecksUtilities.checkNotNull(dsl, "dsl must not be null");

		this.dsl = dsl;
	}

	public Set<String> getUserRoles(String userName) {
		List<String> roles = dsl.select(USER_ROLE.ROLE)
				.from(USER_ROLE)
				.where(USER_ROLE.USER_NAME.equalIgnoreCase(userName))
				.fetch(USER_ROLE.ROLE);

		return new HashSet<String>(roles);
	}

	public List<User> findAllUsers() {
		Result<Record2<String, String>> records = dsl.select(USER.USER_NAME, USER_ROLE.ROLE)
				.from(USER)
				.leftOuterJoin(USER_ROLE).on(USER.USER_NAME.eq(USER_ROLE.USER_NAME))
				.fetch();

		Map<String, List<Record2<String, String>>> byUserName = records.stream()
				.collect(Collectors.groupingBy(r -> r.getValue(USER.USER_NAME)));

		return byUserName.entrySet().stream()
				.map(entry -> ImmutableUser.builder().userName(entry.getKey())
						.roles(entry.getValue().stream().map(record -> record.getValue(USER_ROLE.ROLE))
								.filter(Objects::nonNull).collect(Collectors.toList()))
						.build())
				.collect(Collectors.toList());
	}

	public int updateRoles(String userName, Set<String> newRoles) {
		Set<Tuple2<String, String>> updatesAsTuples = SetUtilities.map(newRoles, r -> tuple(userName, r));
		return replaceRoles(updatesAsTuples);
	}

	public int addRoles(Set<Tuple2<String, String>> usersAndRolesToUpdate) {
		return addRoles(dsl, usersAndRolesToUpdate);
	}

	public int removeRoles(Set<Tuple2<String, String>> usersAndRolesToUpdate) {
		return removeRoles(dsl, usersAndRolesToUpdate);
	}

	public int replaceRoles(Set<Tuple2<String, String>> usersAndRolesToUpdate) {
		Set<String> distinctUsers = map(usersAndRolesToUpdate, t -> t.v1);
		return dsl.transactionResult(ctx -> {
			DSLContext tx = ctx.dsl();
			int rmRcs = tx.deleteFrom(USER_ROLE).where(USER_ROLE.USER_NAME.in(distinctUsers)).execute();

			return addRoles(tx, usersAndRolesToUpdate);
		});
	}

	private int addRoles(DSLContext tx, Set<Tuple2<String, String>> usersAndRolesToUpdate) {
		Set<Tuple2<String, String>> existing = tx.select(USER_ROLE.USER_NAME, USER_ROLE.ROLE)
				.from(USER_ROLE)
				.where(USER_ROLE.USER_NAME.in(map(usersAndRolesToUpdate, t -> t.v1)))
				.fetchSet(r -> tuple(r.get(USER_ROLE.USER_NAME), r.get(USER_ROLE.ROLE)));

		DiffResult<Tuple2<String, String>> diff = mkDiff(existing, usersAndRolesToUpdate);

		int[] rc = diff.otherOnly().stream()
				.map(t -> tx.insertInto(USER_ROLE, USER_ROLE.USER_NAME, USER_ROLE.ROLE).values(t.v1(), t.v2()))
				.collect(Collectors.collectingAndThen(Collectors.toList(), tx::batch)).execute();

		return JooqUtilities.summarizeResults(rc);
	}

	private int removeRoles(DSLContext tx, Set<Tuple2<String, String>> usersAndRolesToUpdate) {
		int[] rc = usersAndRolesToUpdate.stream()
				.map(t -> tx.deleteFrom(USER_ROLE).where(USER_ROLE.USER_NAME.eq(t.v1())).and(USER_ROLE.ROLE.eq(t.v2())))
				.collect(Collectors.collectingAndThen(Collectors.toList(), tx::batch)).execute();

		return JooqUtilities.summarizeResults(rc);
	}
}
