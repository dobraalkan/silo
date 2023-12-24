package com.silo.backend.service.settings;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.silo.backend.domain.model.entity.settings.Setting;
import com.silo.backend.domain.model.entity.settings.UpdateSettingsCommand;
import com.silo.backend.domain.repository.settings.SettingsRepository;
import com.silo.backend.utils.CollectionUtilities;
import com.silo.backend.utils.ListUtilities;
import com.silo.backend.utils.MapUtilities;

@Service
public class SettingsService {

	public static final String DEFAULT_ROLES_KEY = "server.authentication.roles.default";
	public static final String ALLOW_COST_EXPORTS_KEY = "feature.data-extractor.entity-cost.enabled";

	private final SettingsRepository settingsRepository;
	private final Map<String, Setting> overridesByName;

	public SettingsService(SettingsRepository settingsRepository, Collection<Setting> overrides) {
		this.settingsRepository = settingsRepository;
		this.overridesByName = MapUtilities.indexBy(s -> s.name(), ListUtilities.ensureNotNull(overrides));
	}

	public Collection<Setting> findAll() {
		return CollectionUtilities.map(settingsRepository.findAll(),
				s -> Optional.ofNullable(overridesByName.get(s.name())).orElse(s));
	}

	public Setting getByName(String name) {
		return Optional.ofNullable(overridesByName.get(name)).orElse(settingsRepository.getByName(name));
	}

	public Optional<String> getValue(String name) {
		return Optional.ofNullable(getByName(name)).flatMap(s -> s.value());
	}

	public Map<String, String> indexByPrefix(String prefix) {
		return settingsRepository.indexByPrefix(prefix);
	}

	public int update(UpdateSettingsCommand cmd) {
		return settingsRepository.update(cmd);
	}

	public Integer create(Setting setting) {
		return settingsRepository.create(setting);
	}
}
