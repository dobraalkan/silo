/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.records;


import com.silo.backend.database.tables.Complexity;
import com.silo.backend.database.tables.interfaces.IComplexity;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.impl.TableRecordImpl;


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
@Entity
@Table(
    name = "complexity"
)
public class ComplexityRecord extends TableRecordImpl<ComplexityRecord> implements IComplexity {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>complexity.id</code>. unique identifier for this
     * complexity record within waltz
     */
    public ComplexityRecord setId(@Nullable Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>complexity.id</code>. unique identifier for this
     * complexity record within waltz
     */
    @Column(name = "id")
    @Nullable
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>complexity.complexity_kind_id</code>. the reference to
     * the complexity kind that describes this score
     */
    public ComplexityRecord setComplexityKindId(@Nonnull Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>complexity.complexity_kind_id</code>. the reference to
     * the complexity kind that describes this score
     */
    @Column(name = "complexity_kind_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getComplexityKindId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>complexity.entity_id</code>. the identifier for the
     * entity this score belongs to
     */
    public ComplexityRecord setEntityId(@Nonnull Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>complexity.entity_id</code>. the identifier for the
     * entity this score belongs to
     */
    @Column(name = "entity_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getEntityId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>complexity.entity_kind</code>. the kind of the entity
     * this score belongs to
     */
    public ComplexityRecord setEntityKind(@Nonnull String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>complexity.entity_kind</code>. the kind of the entity
     * this score belongs to
     */
    @Column(name = "entity_kind", nullable = false, length = 64)
    @NotNull
    @Size(max = 64)
    @Nonnull
    @Override
    public String getEntityKind() {
        return (String) get(3);
    }

    /**
     * Setter for <code>complexity.score</code>. the value of the complexity,
     * the value should fall between 0 and 1 indicating proximity to a baseline
     * (up to 3 decimal places)
     */
    public ComplexityRecord setScore(@Nonnull BigDecimal value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>complexity.score</code>. the value of the complexity,
     * the value should fall between 0 and 1 indicating proximity to a baseline
     * (up to 3 decimal places)
     */
    @Column(name = "score", nullable = false, precision = 10, scale = 3)
    @NotNull
    @Nonnull
    @Override
    public BigDecimal getScore() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>complexity.last_updated_at</code>. the datetime this
     * complexity record was last updated
     */
    public ComplexityRecord setLastUpdatedAt(@Nullable Timestamp value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>complexity.last_updated_at</code>. the datetime this
     * complexity record was last updated
     */
    @Column(name = "last_updated_at", precision = 6)
    @Nullable
    @Override
    public Timestamp getLastUpdatedAt() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>complexity.last_updated_by</code>. the last user to
     * update this complexity record
     */
    public ComplexityRecord setLastUpdatedBy(@Nonnull String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>complexity.last_updated_by</code>. the last user to
     * update this complexity record
     */
    @Column(name = "last_updated_by", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getLastUpdatedBy() {
        return (String) get(6);
    }

    /**
     * Setter for <code>complexity.provenance</code>. origination of this change
     * unit record
     */
    public ComplexityRecord setProvenance(@Nullable String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>complexity.provenance</code>. origination of this change
     * unit record
     */
    @Column(name = "provenance", length = 64)
    @Size(max = 64)
    @Nullable
    @Override
    public String getProvenance() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IComplexity from) {
        setId(from.getId());
        setComplexityKindId(from.getComplexityKindId());
        setEntityId(from.getEntityId());
        setEntityKind(from.getEntityKind());
        setScore(from.getScore());
        setLastUpdatedAt(from.getLastUpdatedAt());
        setLastUpdatedBy(from.getLastUpdatedBy());
        setProvenance(from.getProvenance());
        resetChangedOnNotNull();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ComplexityRecord
     */
    public ComplexityRecord() {
        super(Complexity.COMPLEXITY);
    }

    /**
     * Create a detached, initialised ComplexityRecord
     */
    @ConstructorProperties({ "id", "complexityKindId", "entityId", "entityKind", "score", "lastUpdatedAt", "lastUpdatedBy", "provenance" })
    public ComplexityRecord(@Nullable Long id, @Nonnull Long complexityKindId, @Nonnull Long entityId, @Nonnull String entityKind, @Nonnull BigDecimal score, @Nullable Timestamp lastUpdatedAt, @Nonnull String lastUpdatedBy, @Nullable String provenance) {
        super(Complexity.COMPLEXITY);

        setId(id);
        setComplexityKindId(complexityKindId);
        setEntityId(entityId);
        setEntityKind(entityKind);
        setScore(score);
        setLastUpdatedAt(lastUpdatedAt);
        setLastUpdatedBy(lastUpdatedBy);
        setProvenance(provenance);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised ComplexityRecord
     */
    public ComplexityRecord(com.silo.backend.database.tables.pojos.Complexity value) {
        super(Complexity.COMPLEXITY);

        if (value != null) {
            setId(value.id());
            setComplexityKindId(value.complexityKindId());
            setEntityId(value.entityId());
            setEntityKind(value.entityKind());
            setScore(value.score());
            setLastUpdatedAt(value.lastUpdatedAt());
            setLastUpdatedBy(value.lastUpdatedBy());
            setProvenance(value.provenance());
            resetChangedOnNotNull();
        }
    }
}
