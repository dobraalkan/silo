package com.silo.backend.domain.repository.user;

import static com.silo.backend.database.tables.User.USER;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import com.silo.backend.utils.ChecksUtilities;

@Repository
public class UserRepository {

	private final DSLContext dsl;

	public UserRepository(DSLContext dsl) {
		ChecksUtilities.checkNotNull(dsl, "dsl must not be null");
		this.dsl = dsl;
	}

	public String getPassword(String userName) {
		Record1<String> possiblePassword = dsl.select(USER.PASSWORD)
				.from(USER)
				.where(USER.USER_NAME.equalIgnoreCase(userName))
				.fetchOne();

		if (possiblePassword != null) {
			return possiblePassword.value1();
		} else {
			return null;
		}
	}

	public int create(String userName, String passwordHash) {
		return dsl.insertInto(USER)
				.set(USER.USER_NAME, userName).set(USER.PASSWORD, passwordHash)
				.onDuplicateKeyIgnore()
				.execute();
	}

	public List<String> findAllUserNames() {
		return dsl.select(USER.USER_NAME)
				.from(USER)
				.fetch(USER.USER_NAME);

	}

	public int deleteUser(String userName) {
		return dsl.delete(USER)
				.where(USER.USER_NAME.equalIgnoreCase(userName))
				.execute();
	}

	public int resetPassword(String userName, String passwordHash) {
		return dsl.update(USER)
				.set(USER.PASSWORD, passwordHash)
				.where(USER.USER_NAME.eq(userName))
				.execute();
	}
}
