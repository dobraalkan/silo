package com.silo.backend.domain.repository.settings;

import com.silo.backend.database.tables.records.SettingsRecord;
import com.silo.backend.domain.model.entity.settings.ImmutableSetting;
import com.silo.backend.domain.model.entity.settings.Setting;
import com.silo.backend.domain.model.entity.settings.UpdateSettingsCommand;
import com.silo.backend.utils.StringUtilities;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static com.silo.backend.database.tables.Settings.SETTINGS;

@Repository
public class SettingsRepository {

    private final DSLContext dsl;

    public static final RecordMapper<? super Record, Setting> SETTINGS_MAPPER = r -> {
        SettingsRecord record = r.into(SETTINGS);
        return ImmutableSetting
                .builder()
                .name(record.getName())
                .value(Optional.ofNullable(r.getValue(SETTINGS.VALUE)).map(String::trim))
                .restricted(record.getRestricted())
                .description(record.getDescription())
                .build();
    };

    public SettingsRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Collection<Setting> findAll() {
        return dsl
                .select(SETTINGS.fields())
                .from(SETTINGS)
                .fetch(SETTINGS_MAPPER);
    }

    public Setting getByName(String name) {
        return dsl
                .select(SETTINGS.fields())
                .from(SETTINGS)
                .where(SETTINGS.NAME.eq(name))
                .fetchOne(SETTINGS_MAPPER);
    }

    public Map<String, String> indexByPrefix(String prefix) {
        return dsl
                .select(SETTINGS.NAME, SETTINGS.VALUE)
                .from(SETTINGS)
                .where(SETTINGS.NAME.startsWith(prefix))
                .and(SETTINGS.RESTRICTED.isFalse())
                .fetchMap(
                        SETTINGS.NAME,
                        r -> StringUtilities.mkSafe(r.get(SETTINGS.VALUE)).trim());
    }

    public int update(UpdateSettingsCommand cmd) {
        return dsl
                .update(SETTINGS)
                .set(SETTINGS.VALUE, cmd.value())
                .where(SETTINGS.NAME.eq(cmd.name()))
                .and(SETTINGS.RESTRICTED.isFalse())
                .execute();

    }

    public int create(Setting setting) {
        SettingsRecord record = dsl.newRecord(SETTINGS);
        record.setName(setting.name());
        record.setDescription(setting.description());
        record.setRestricted(setting.restricted());

        setting.value().ifPresent(record::setValue);

        return record.store();
    }
    
}
