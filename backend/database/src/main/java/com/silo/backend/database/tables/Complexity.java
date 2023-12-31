/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables;


import com.silo.backend.database.DefaultSchema;
import com.silo.backend.database.tables.records.ComplexityRecord;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * a score of a given complexity kind for an entity in waltz
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Complexity extends TableImpl<ComplexityRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>complexity</code>
     */
    public static final Complexity COMPLEXITY = new Complexity();

    /**
     * The class holding records for this type
     */
    @Override
    @Nonnull
    public Class<ComplexityRecord> getRecordType() {
        return ComplexityRecord.class;
    }

    /**
     * The column <code>complexity.id</code>. unique identifier for this
     * complexity record within waltz
     */
    public final TableField<ComplexityRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "unique identifier for this complexity record within waltz");

    /**
     * The column <code>complexity.complexity_kind_id</code>. the reference to
     * the complexity kind that describes this score
     */
    public final TableField<ComplexityRecord, Long> COMPLEXITY_KIND_ID = createField(DSL.name("complexity_kind_id"), SQLDataType.BIGINT.nullable(false), this, "the reference to the complexity kind that describes this score");

    /**
     * The column <code>complexity.entity_id</code>. the identifier for the
     * entity this score belongs to
     */
    public final TableField<ComplexityRecord, Long> ENTITY_ID = createField(DSL.name("entity_id"), SQLDataType.BIGINT.nullable(false), this, "the identifier for the entity this score belongs to");

    /**
     * The column <code>complexity.entity_kind</code>. the kind of the entity
     * this score belongs to
     */
    public final TableField<ComplexityRecord, String> ENTITY_KIND = createField(DSL.name("entity_kind"), SQLDataType.VARCHAR(64).nullable(false), this, "the kind of the entity this score belongs to");

    /**
     * The column <code>complexity.score</code>. the value of the complexity,
     * the value should fall between 0 and 1 indicating proximity to a baseline
     * (up to 3 decimal places)
     */
    public final TableField<ComplexityRecord, BigDecimal> SCORE = createField(DSL.name("score"), SQLDataType.DECIMAL(10, 3).nullable(false), this, "the value of the complexity, the value should fall between 0 and 1 indicating proximity to a baseline (up to 3 decimal places)");

    /**
     * The column <code>complexity.last_updated_at</code>. the datetime this
     * complexity record was last updated
     */
    public final TableField<ComplexityRecord, Timestamp> LAST_UPDATED_AT = createField(DSL.name("last_updated_at"), SQLDataType.TIMESTAMP(6).nullable(false).defaultValue(DSL.field(DSL.raw("LOCALTIMESTAMP"), SQLDataType.TIMESTAMP)), this, "the datetime this complexity record was last updated");

    /**
     * The column <code>complexity.last_updated_by</code>. the last user to
     * update this complexity record
     */
    public final TableField<ComplexityRecord, String> LAST_UPDATED_BY = createField(DSL.name("last_updated_by"), SQLDataType.VARCHAR(255).nullable(false), this, "the last user to update this complexity record");

    /**
     * The column <code>complexity.provenance</code>. origination of this change
     * unit record
     */
    public final TableField<ComplexityRecord, String> PROVENANCE = createField(DSL.name("provenance"), SQLDataType.VARCHAR(64).nullable(false).defaultValue(DSL.field(DSL.raw("'waltz'"), SQLDataType.VARCHAR)), this, "origination of this change unit record");

    private Complexity(Name alias, Table<ComplexityRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Complexity(Name alias, Table<ComplexityRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("a score of a given complexity kind for an entity in waltz"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>complexity</code> table reference
     */
    public Complexity(String alias) {
        this(DSL.name(alias), COMPLEXITY);
    }

    /**
     * Create an aliased <code>complexity</code> table reference
     */
    public Complexity(Name alias) {
        this(alias, COMPLEXITY);
    }

    /**
     * Create a <code>complexity</code> table reference
     */
    public Complexity() {
        this(DSL.name("complexity"), null);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    @Nonnull
    public Identity<ComplexityRecord, Long> getIdentity() {
        return (Identity<ComplexityRecord, Long>) super.getIdentity();
    }

    @Override
    @Nonnull
    public Complexity as(String alias) {
        return new Complexity(DSL.name(alias), this);
    }

    @Override
    @Nonnull
    public Complexity as(Name alias) {
        return new Complexity(alias, this);
    }

    @Override
    @Nonnull
    public Complexity as(Table<?> alias) {
        return new Complexity(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public Complexity rename(String name) {
        return new Complexity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public Complexity rename(Name name) {
        return new Complexity(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @Nonnull
    public Complexity rename(Table<?> name) {
        return new Complexity(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public Complexity where(Condition condition) {
        return new Complexity(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public Complexity where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public Complexity where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public Complexity where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public Complexity where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public Complexity where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public Complexity where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    @PlainSQL
    public Complexity where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public Complexity whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @Nonnull
    public Complexity whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
