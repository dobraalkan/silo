/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.records;


import com.silo.backend.database.tables.Person;
import com.silo.backend.database.tables.interfaces.IPerson;

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
    name = "person"
)
public class PersonRecord extends TableRecordImpl<PersonRecord> implements IPerson {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>person.id</code>.
     */
    public PersonRecord setId(@Nullable Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>person.id</code>.
     */
    @Column(name = "id")
    @Nullable
    @Override
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>person.employee_id</code>.
     */
    public PersonRecord setEmployeeId(@Nullable String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>person.employee_id</code>.
     */
    @Column(name = "employee_id", length = 128)
    @Size(max = 128)
    @Nullable
    @Override
    public String getEmployeeId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>person.display_name</code>.
     */
    public PersonRecord setDisplayName(@Nonnull String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>person.display_name</code>.
     */
    @Column(name = "display_name", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getDisplayName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>person.email</code>.
     */
    public PersonRecord setEmail(@Nonnull String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>person.email</code>.
     */
    @Column(name = "email", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>person.user_principal_name</code>.
     */
    public PersonRecord setUserPrincipalName(@Nullable String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>person.user_principal_name</code>.
     */
    @Column(name = "user_principal_name", length = 255)
    @Size(max = 255)
    @Nullable
    @Override
    public String getUserPrincipalName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>person.department_name</code>.
     */
    public PersonRecord setDepartmentName(@Nullable String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>person.department_name</code>.
     */
    @Column(name = "department_name", length = 255)
    @Size(max = 255)
    @Nullable
    @Override
    public String getDepartmentName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>person.kind</code>.
     */
    public PersonRecord setKind(@Nonnull String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>person.kind</code>.
     */
    @Column(name = "kind", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getKind() {
        return (String) get(6);
    }

    /**
     * Setter for <code>person.manager_employee_id</code>.
     */
    public PersonRecord setManagerEmployeeId(@Nullable String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>person.manager_employee_id</code>.
     */
    @Column(name = "manager_employee_id", length = 128)
    @Size(max = 128)
    @Nullable
    @Override
    public String getManagerEmployeeId() {
        return (String) get(7);
    }

    /**
     * Setter for <code>person.title</code>.
     */
    public PersonRecord setTitle(@Nullable String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>person.title</code>.
     */
    @Column(name = "title", length = 255)
    @Size(max = 255)
    @Nullable
    @Override
    public String getTitle() {
        return (String) get(8);
    }

    /**
     * Setter for <code>person.office_phone</code>.
     */
    public PersonRecord setOfficePhone(@Nullable String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>person.office_phone</code>.
     */
    @Column(name = "office_phone", length = 128)
    @Size(max = 128)
    @Nullable
    @Override
    public String getOfficePhone() {
        return (String) get(9);
    }

    /**
     * Setter for <code>person.mobile_phone</code>.
     */
    public PersonRecord setMobilePhone(@Nullable String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>person.mobile_phone</code>.
     */
    @Column(name = "mobile_phone", length = 128)
    @Size(max = 128)
    @Nullable
    @Override
    public String getMobilePhone() {
        return (String) get(10);
    }

    /**
     * Setter for <code>person.organisational_unit_id</code>.
     */
    public PersonRecord setOrganisationalUnitId(@Nullable Long value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>person.organisational_unit_id</code>.
     */
    @Column(name = "organisational_unit_id")
    @Nullable
    @Override
    public Long getOrganisationalUnitId() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>person.is_removed</code>.
     */
    public PersonRecord setIsRemoved(@Nullable Boolean value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>person.is_removed</code>.
     */
    @Column(name = "is_removed")
    @Nullable
    @Override
    public Boolean getIsRemoved() {
        return (Boolean) get(12);
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IPerson from) {
        setId(from.getId());
        setEmployeeId(from.getEmployeeId());
        setDisplayName(from.getDisplayName());
        setEmail(from.getEmail());
        setUserPrincipalName(from.getUserPrincipalName());
        setDepartmentName(from.getDepartmentName());
        setKind(from.getKind());
        setManagerEmployeeId(from.getManagerEmployeeId());
        setTitle(from.getTitle());
        setOfficePhone(from.getOfficePhone());
        setMobilePhone(from.getMobilePhone());
        setOrganisationalUnitId(from.getOrganisationalUnitId());
        setIsRemoved(from.getIsRemoved());
        resetChangedOnNotNull();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    @ConstructorProperties({ "id", "employeeId", "displayName", "email", "userPrincipalName", "departmentName", "kind", "managerEmployeeId", "title", "officePhone", "mobilePhone", "organisationalUnitId", "isRemoved" })
    public PersonRecord(@Nullable Long id, @Nullable String employeeId, @Nonnull String displayName, @Nonnull String email, @Nullable String userPrincipalName, @Nullable String departmentName, @Nonnull String kind, @Nullable String managerEmployeeId, @Nullable String title, @Nullable String officePhone, @Nullable String mobilePhone, @Nullable Long organisationalUnitId, @Nullable Boolean isRemoved) {
        super(Person.PERSON);

        setId(id);
        setEmployeeId(employeeId);
        setDisplayName(displayName);
        setEmail(email);
        setUserPrincipalName(userPrincipalName);
        setDepartmentName(departmentName);
        setKind(kind);
        setManagerEmployeeId(managerEmployeeId);
        setTitle(title);
        setOfficePhone(officePhone);
        setMobilePhone(mobilePhone);
        setOrganisationalUnitId(organisationalUnitId);
        setIsRemoved(isRemoved);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(com.silo.backend.database.tables.pojos.Person value) {
        super(Person.PERSON);

        if (value != null) {
            setId(value.id());
            setEmployeeId(value.employeeId());
            setDisplayName(value.displayName());
            setEmail(value.email());
            setUserPrincipalName(value.userPrincipalName());
            setDepartmentName(value.departmentName());
            setKind(value.kind());
            setManagerEmployeeId(value.managerEmployeeId());
            setTitle(value.title());
            setOfficePhone(value.officePhone());
            setMobilePhone(value.mobilePhone());
            setOrganisationalUnitId(value.organisationalUnitId());
            setIsRemoved(value.isRemoved());
            resetChangedOnNotNull();
        }
    }
}
