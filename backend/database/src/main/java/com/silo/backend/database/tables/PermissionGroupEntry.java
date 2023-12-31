/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables;


import com.silo.backend.database.DefaultSchema;
import com.silo.backend.database.tables.records.PermissionGroupEntryRecord;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Collection;

import javax.annotation.processing.Generated;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * entities which have specific permissions which replace the default permission
 * group
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PermissionGroupEntry extends TableImpl<PermissionGroupEntryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>permission_group_entry</code>
     */
    public static final PermissionGroupEntry PERMISSION_GROUP_ENTRY = new PermissionGroupEntry();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<PermissionGroupEntryRecord> getRecordType() {
        return PermissionGroupEntryRecord.class;
    }

    /**
     * The column <code>permission_group_entry.entity_id</code>. the id of the
     * entity being given specific permissions
     */
    public final TableField<PermissionGroupEntryRecord, Long> ENTITY_ID = createField(DSL.name("entity_id"), SQLDataType.BIGINT.nullable(false), this, "the id of the entity being given specific permissions");

    /**
     * The column <code>permission_group_entry.permission_group_id</code>.
     * identifier of the permission group being linked to
     */
    public final TableField<PermissionGroupEntryRecord, Long> PERMISSION_GROUP_ID = createField(DSL.name("permission_group_id"), SQLDataType.BIGINT.nullable(false), this, "identifier of the permission group being linked to");

    /**
     * The column <code>permission_group_entry.entity_kind</code>. the type of
     * the entity being given specific permissions
     */
    public final TableField<PermissionGroupEntryRecord, String> ENTITY_KIND = createField(DSL.name("entity_kind"), SQLDataType.VARCHAR(64).nullable(false), this, "the type of the entity being given specific permissions");

    private PermissionGroupEntry(Name alias, Table<PermissionGroupEntryRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PermissionGroupEntry(Name alias, Table<PermissionGroupEntryRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("entities which have specific permissions which replace the default permission group"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>permission_group_entry</code> table reference
     */
    public PermissionGroupEntry(String alias) {
        this(DSL.name(alias), PERMISSION_GROUP_ENTRY);
    }

    /**
     * Create an aliased <code>permission_group_entry</code> table reference
     */
    public PermissionGroupEntry(Name alias) {
        this(alias, PERMISSION_GROUP_ENTRY);
    }

    /**
     * Create a <code>permission_group_entry</code> table reference
     */
    public PermissionGroupEntry() {
        this(DSL.name("permission_group_entry"), null);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @Nonnull
    public PermissionGroupEntry as(String alias) {
        return new PermissionGroupEntry(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public PermissionGroupEntry as(Name alias) {
        return new PermissionGroupEntry(alias, this);
    }

    @Override
    @Nonnull
    public PermissionGroupEntry as(Table<?> alias) {
        return new PermissionGroupEntry(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry rename(String name) {
        return new PermissionGroupEntry(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry rename(Name name) {
        return new PermissionGroupEntry(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry rename(Table<?> name) {
        return new PermissionGroupEntry(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry where(Condition condition) {
        return new PermissionGroupEntry(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroupEntry where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroupEntry where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroupEntry where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroupEntry where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroupEntry whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
