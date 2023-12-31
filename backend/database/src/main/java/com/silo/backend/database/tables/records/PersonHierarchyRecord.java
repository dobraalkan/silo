/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.records;


import com.silo.backend.database.tables.PersonHierarchy;
import com.silo.backend.database.tables.interfaces.IPersonHierarchy;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
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
    name = "person_hierarchy"
)
public class PersonHierarchyRecord extends TableRecordImpl<PersonHierarchyRecord> implements IPersonHierarchy {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>person_hierarchy.manager_id</code>.
     */
    public PersonHierarchyRecord setManagerId(@Nonnull String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>person_hierarchy.manager_id</code>.
     */
    @Column(name = "manager_id", nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    @Nonnull
    @Override
    public String getManagerId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>person_hierarchy.employee_id</code>.
     */
    public PersonHierarchyRecord setEmployeeId(@Nonnull String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>person_hierarchy.employee_id</code>.
     */
    @Column(name = "employee_id", nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    @Nonnull
    @Override
    public String getEmployeeId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>person_hierarchy.level</code>.
     */
    public PersonHierarchyRecord setLevel(@Nullable Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>person_hierarchy.level</code>.
     */
    @Column(name = "level")
    @Nullable
    @Override
    public Integer getLevel() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IPersonHierarchy from) {
        setManagerId(from.getManagerId());
        setEmployeeId(from.getEmployeeId());
        setLevel(from.getLevel());
        resetChangedOnNotNull();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonHierarchyRecord
     */
    public PersonHierarchyRecord() {
        super(PersonHierarchy.PERSON_HIERARCHY);
    }

    /**
     * Create a detached, initialised PersonHierarchyRecord
     */
    @ConstructorProperties({ "managerId", "employeeId", "level" })
    public PersonHierarchyRecord(@Nonnull String managerId, @Nonnull String employeeId, @Nullable Integer level) {
        super(PersonHierarchy.PERSON_HIERARCHY);

        setManagerId(managerId);
        setEmployeeId(employeeId);
        setLevel(level);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised PersonHierarchyRecord
     */
    public PersonHierarchyRecord(com.silo.backend.database.tables.pojos.PersonHierarchy value) {
        super(PersonHierarchy.PERSON_HIERARCHY);

        if (value != null) {
            setManagerId(value.managerId());
            setEmployeeId(value.employeeId());
            setLevel(value.level());
            resetChangedOnNotNull();
        }
    }
}
