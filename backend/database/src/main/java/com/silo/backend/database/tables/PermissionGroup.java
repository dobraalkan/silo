/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables;


import com.silo.backend.database.DefaultSchema;
import com.silo.backend.database.tables.records.PermissionGroupRecord;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Collection;

import javax.annotation.processing.Generated;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Identity;
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
 * group describing the permissions different involvement kinds have against
 * waltz entities
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class PermissionGroup extends TableImpl<PermissionGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>permission_group</code>
     */
    public static final PermissionGroup PERMISSION_GROUP = new PermissionGroup();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<PermissionGroupRecord> getRecordType() {
        return PermissionGroupRecord.class;
    }

    /**
     * The column <code>permission_group.id</code>. unique identifier for this
     * cost record within waltz
     */
    public final TableField<PermissionGroupRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "unique identifier for this cost record within waltz");

    /**
     * The column <code>permission_group.name</code>. name of the permission
     * group
     */
    public final TableField<PermissionGroupRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "name of the permission group");

    /**
     * The column <code>permission_group.external_id</code>. external identifier
     * for this permission group
     */
    public final TableField<PermissionGroupRecord, String> EXTERNAL_ID = createField(DSL.name("external_id"), SQLDataType.VARCHAR(200).nullable(false), this, "external identifier for this permission group");

    /**
     * The column <code>permission_group.description</code>. longer description
     * to provide more information about this permission group
     */
    public final TableField<PermissionGroupRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(4000), this, "longer description to provide more information about this permission group");

    /**
     * The column <code>permission_group.provenance</code>. origination of this
     * permission group
     */
    public final TableField<PermissionGroupRecord, String> PROVENANCE = createField(DSL.name("provenance"), SQLDataType.VARCHAR(64).nullable(false), this, "origination of this permission group");

    /**
     * The column <code>permission_group.is_default</code>. flag to identify the
     * default permission group
     */
    public final TableField<PermissionGroupRecord, Boolean> IS_DEFAULT = createField(DSL.name("is_default"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("TRUE"), SQLDataType.BOOLEAN)), this, "flag to identify the default permission group");

    private PermissionGroup(Name alias, Table<PermissionGroupRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PermissionGroup(Name alias, Table<PermissionGroupRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("group describing the permissions different involvement kinds have against waltz entities"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>permission_group</code> table reference
     */
    public PermissionGroup(String alias) {
        this(DSL.name(alias), PERMISSION_GROUP);
    }

    /**
     * Create an aliased <code>permission_group</code> table reference
     */
    public PermissionGroup(Name alias) {
        this(alias, PERMISSION_GROUP);
    }

    /**
     * Create a <code>permission_group</code> table reference
     */
    public PermissionGroup() {
        this(DSL.name("permission_group"), null);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @Nonnull
    public Identity<PermissionGroupRecord, Long> getIdentity() {
        return (Identity<PermissionGroupRecord, Long>) super.getIdentity();
    }

    @Override
    @Nonnull
    public PermissionGroup as(String alias) {
        return new PermissionGroup(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public PermissionGroup as(Name alias) {
        return new PermissionGroup(alias, this);
    }

    @Override
    @Nonnull
    public PermissionGroup as(Table<?> alias) {
        return new PermissionGroup(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public PermissionGroup rename(String name) {
        return new PermissionGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public PermissionGroup rename(Name name) {
        return new PermissionGroup(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public PermissionGroup rename(Table<?> name) {
        return new PermissionGroup(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroup where(Condition condition) {
        return new PermissionGroup(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroup where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroup where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroup where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroup where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroup where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroup where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public PermissionGroup where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroup whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public PermissionGroup whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
