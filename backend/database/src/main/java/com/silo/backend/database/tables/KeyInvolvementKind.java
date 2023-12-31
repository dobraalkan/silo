/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables;


import com.silo.backend.database.DefaultSchema;
import com.silo.backend.database.tables.records.KeyInvolvementKindRecord;

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
 * Key Involvement Kind For Entity Kind
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class KeyInvolvementKind extends TableImpl<KeyInvolvementKindRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>key_involvement_kind</code>
     */
    public static final KeyInvolvementKind KEY_INVOLVEMENT_KIND = new KeyInvolvementKind();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<KeyInvolvementKindRecord> getRecordType() {
        return KeyInvolvementKindRecord.class;
    }

    /**
     * The column <code>key_involvement_kind.involvement_kind_id</code>.
     */
    public final TableField<KeyInvolvementKindRecord, Long> INVOLVEMENT_KIND_ID = createField(DSL.name("involvement_kind_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>key_involvement_kind.entity_kind</code>.
     */
    public final TableField<KeyInvolvementKindRecord, String> ENTITY_KIND = createField(DSL.name("entity_kind"), SQLDataType.VARCHAR(64).nullable(false), this, "");

    private KeyInvolvementKind(Name alias, Table<KeyInvolvementKindRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private KeyInvolvementKind(Name alias, Table<KeyInvolvementKindRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("Key Involvement Kind For Entity Kind"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>key_involvement_kind</code> table reference
     */
    public KeyInvolvementKind(String alias) {
        this(DSL.name(alias), KEY_INVOLVEMENT_KIND);
    }

    /**
     * Create an aliased <code>key_involvement_kind</code> table reference
     */
    public KeyInvolvementKind(Name alias) {
        this(alias, KEY_INVOLVEMENT_KIND);
    }

    /**
     * Create a <code>key_involvement_kind</code> table reference
     */
    public KeyInvolvementKind() {
        this(DSL.name("key_involvement_kind"), null);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @Nonnull
    public KeyInvolvementKind as(String alias) {
        return new KeyInvolvementKind(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public KeyInvolvementKind as(Name alias) {
        return new KeyInvolvementKind(alias, this);
    }

    @Override
    @Nonnull
    public KeyInvolvementKind as(Table<?> alias) {
        return new KeyInvolvementKind(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind rename(String name) {
        return new KeyInvolvementKind(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind rename(Name name) {
        return new KeyInvolvementKind(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind rename(Table<?> name) {
        return new KeyInvolvementKind(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind where(Condition condition) {
        return new KeyInvolvementKind(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public KeyInvolvementKind where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public KeyInvolvementKind where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public KeyInvolvementKind where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public KeyInvolvementKind where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public KeyInvolvementKind whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
