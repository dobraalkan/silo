package com.silo.backend.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.silo.backend.domain.model.dto.ImmutableLoginRequest;
import com.silo.backend.domain.model.dto.LoginRequest;
import com.silo.backend.domain.model.dto.PasswordResetRequest;
import com.silo.backend.domain.model.dto.UserRegistrationRequest;
import com.silo.backend.domain.model.entity.settings.Setting;
import com.silo.backend.domain.repository.user.UserRepository;
import com.silo.backend.domain.repository.user.UserRoleRepository;
import com.silo.backend.service.settings.SettingsService;
import com.silo.backend.utils.ChecksUtilities;

@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	private final UserRepository userRepository;
	private final PasswordService passwordService;
	private final UserRoleRepository userRoleRepository;
	private final SettingsService settingsService;

	public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordService passwordService, SettingsService settingsService) {
		ChecksUtilities.checkNotNull(userRepository, "userDao must not be null");
		ChecksUtilities.checkNotNull(userRoleRepository, "userRoleDao cannot be null");
		ChecksUtilities.checkNotNull(passwordService, "passwordService must not be null");
		ChecksUtilities.checkNotNull(settingsService, "settingsService cannot be null");

		this.userRepository = userRepository;
		this.passwordService = passwordService;
		this.userRoleRepository = userRoleRepository;
		this.settingsService = settingsService;
	}

	public int registerNewUser(UserRegistrationRequest request) {
		LOG.info("Registering new user: " + request.userName());
		String passwordHash = passwordService.hashPassword(request.password());
		int rc = userRepository.create(request.userName(), passwordHash);
		assignDefaultRoles(request.userName());
		return rc;
	}

	public boolean authenticate(LoginRequest request) {
		String existingHashedPassword = userRepository.getPassword(request.userName());
		if (existingHashedPassword == null) {
			LOG.warn("Could not find " + request.userName() + " in database");
		}

		return passwordService.verifyPassword(request.password(), existingHashedPassword);
	}

	public boolean deleteUser(String userName) {
		LOG.info("Deleting user: " + userName);
		userRepository.deleteUser(userName);
		LOG.info("Deleted user: " + userName);
		return true;
	}

	public List<String> findAllUserNames() {
		return userRepository.findAllUserNames();
	}

	public boolean resetPassword(PasswordResetRequest resetRequest, boolean validate) {
		LOG.info("Resetting password for: " + resetRequest.userName());
		if (validate) {
			LoginRequest loginRequest = ImmutableLoginRequest.builder().password(resetRequest.currentPassword())
					.userName(resetRequest.userName()).build();
			if (!authenticate(loginRequest)) {
				return false;
			}
		}
		String hashedPassword = passwordService.hashPassword(resetRequest.newPassword());
		return userRepository.resetPassword(resetRequest.userName(), hashedPassword) == 1;
	}

	public boolean ensureExists(String username) {
		ChecksUtilities.checkNotEmpty(username, "Cannot ensure an empty username exists");
		int rc = userRepository.create(username, passwordService.hashPassword("temp4321"));
		boolean isNewUser = (rc == 1);

		if (isNewUser) {
			assignDefaultRoles(username);
		}

		return isNewUser;
	}

	private void assignDefaultRoles(String username) {
		ChecksUtilities.checkNotEmpty(username, "username cannot be empty");
		Setting setting = settingsService.getByName(SettingsService.DEFAULT_ROLES_KEY);
		if (setting != null) {
			setting.value().map(s -> tokenise(s, ","))
					.ifPresent(roles -> userRoleDao.updateRoles(username, fromCollection(roles)));

		}
	}

}
