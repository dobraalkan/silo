/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables;


import com.silo.backend.database.DefaultSchema;
import com.silo.backend.database.tables.records.ApplicationGroupRecord;

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
 * represents an ad-hoc collection of applications
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ApplicationGroup extends TableImpl<ApplicationGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>application_group</code>
     */
    public static final ApplicationGroup APPLICATION_GROUP = new ApplicationGroup();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<ApplicationGroupRecord> getRecordType() {
        return ApplicationGroupRecord.class;
    }

    /**
     * The column <code>application_group.id</code>.
     */
    public final TableField<ApplicationGroupRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>application_group.name</code>. display name for the
     * group
     */
    public final TableField<ApplicationGroupRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "display name for the group");

    /**
     * The column <code>application_group.kind</code>. the type of group (one
     * of: PUBLIC, PRIVATE).  Note, private groups can still be seen, they are
     * merely unlisted in the UI
     */
    public final TableField<ApplicationGroupRecord, String> KIND = createField(DSL.name("kind"), SQLDataType.VARCHAR(64).nullable(false).defaultValue(DSL.field(DSL.raw("'PUBLIC'"), SQLDataType.VARCHAR)), this, "the type of group (one of: PUBLIC, PRIVATE).  Note, private groups can still be seen, they are merely unlisted in the UI");

    /**
     * The column <code>application_group.description</code>. longer description
     * of the group, supports markdown
     */
    public final TableField<ApplicationGroupRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(1000000000), this, "longer description of the group, supports markdown");

    /**
     * The column <code>application_group.external_id</code>. external
     * identifier, typically used when creating/syncing groups via external jobs
     */
    public final TableField<ApplicationGroupRecord, String> EXTERNAL_ID = createField(DSL.name("external_id"), SQLDataType.VARCHAR(200), this, "external identifier, typically used when creating/syncing groups via external jobs");

    /**
     * The column <code>application_group.is_removed</code>. flag indicating if
     * the group has been deleted
     */
    public final TableField<ApplicationGroupRecord, Boolean> IS_REMOVED = createField(DSL.name("is_removed"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("FALSE"), SQLDataType.BOOLEAN)), this, "flag indicating if the group has been deleted");

    /**
     * The column <code>application_group.is_favourite_group</code>. a favourite
     * group is assigned to each user to allow them to quickly bookmark apps and
     * populate the change calendar on the homepage
     */
    public final TableField<ApplicationGroupRecord, Boolean> IS_FAVOURITE_GROUP = createField(DSL.name("is_favourite_group"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.field(DSL.raw("FALSE"), SQLDataType.BOOLEAN)), this, "a favourite group is assigned to each user to allow them to quickly bookmark apps and populate the change calendar on the homepage");

    private ApplicationGroup(Name alias, Table<ApplicationGroupRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private ApplicationGroup(Name alias, Table<ApplicationGroupRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("represents an ad-hoc collection of applications"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>application_group</code> table reference
     */
    public ApplicationGroup(String alias) {
        this(DSL.name(alias), APPLICATION_GROUP);
    }

    /**
     * Create an aliased <code>application_group</code> table reference
     */
    public ApplicationGroup(Name alias) {
        this(alias, APPLICATION_GROUP);
    }

    /**
     * Create a <code>application_group</code> table reference
     */
    public ApplicationGroup() {
        this(DSL.name("application_group"), null);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @Nonnull
    public Identity<ApplicationGroupRecord, Long> getIdentity() {
        return (Identity<ApplicationGroupRecord, Long>) super.getIdentity();
    }

    @Override
    @Nonnull
    public ApplicationGroup as(String alias) {
        return new ApplicationGroup(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public ApplicationGroup as(Name alias) {
        return new ApplicationGroup(alias, this);
    }

    @Override
    @Nonnull
    public ApplicationGroup as(Table<?> alias) {
        return new ApplicationGroup(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public ApplicationGroup rename(String name) {
        return new ApplicationGroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public ApplicationGroup rename(Name name) {
        return new ApplicationGroup(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public ApplicationGroup rename(Table<?> name) {
        return new ApplicationGroup(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public ApplicationGroup where(Condition condition) {
        return new ApplicationGroup(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public ApplicationGroup where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public ApplicationGroup where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public ApplicationGroup where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public ApplicationGroup where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public ApplicationGroup where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public ApplicationGroup where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public ApplicationGroup where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public ApplicationGroup whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public ApplicationGroup whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
