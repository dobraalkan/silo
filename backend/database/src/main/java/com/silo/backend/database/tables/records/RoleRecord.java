/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.records;


import com.silo.backend.database.tables.Role;
import com.silo.backend.database.tables.interfaces.IRole;

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
    name = "role"
)
public class RoleRecord extends TableRecordImpl<RoleRecord> implements IRole {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>role.key</code>.
     */
    public RoleRecord setKey(@Nonnull String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>role.key</code>.
     */
    @Column(name = "key", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getKey() {
        return (String) get(0);
    }

    /**
     * Setter for <code>role.is_custom</code>.
     */
    public RoleRecord setIsCustom(@Nullable Boolean value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>role.is_custom</code>.
     */
    @Column(name = "is_custom")
    @Nullable
    @Override
    public Boolean getIsCustom() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>role.name</code>.
     */
    public RoleRecord setName(@Nonnull String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>role.name</code>.
     */
    @Column(name = "name", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>role.description</code>.
     */
    public RoleRecord setDescription(@Nonnull String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>role.description</code>.
     */
    @Column(name = "description", nullable = false, length = 4000)
    @NotNull
    @Size(max = 4000)
    @Nonnull
    @Override
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>role.user_selectable</code>.
     */
    public RoleRecord setUserSelectable(@Nullable Boolean value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>role.user_selectable</code>.
     */
    @Column(name = "user_selectable")
    @Nullable
    @Override
    public Boolean getUserSelectable() {
        return (Boolean) get(4);
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IRole from) {
        setKey(from.getKey());
        setIsCustom(from.getIsCustom());
        setName(from.getName());
        setDescription(from.getDescription());
        setUserSelectable(from.getUserSelectable());
        resetChangedOnNotNull();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleRecord
     */
    public RoleRecord() {
        super(Role.ROLE);
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    @ConstructorProperties({ "key", "isCustom", "name", "description", "userSelectable" })
    public RoleRecord(@Nonnull String key, @Nullable Boolean isCustom, @Nonnull String name, @Nonnull String description, @Nullable Boolean userSelectable) {
        super(Role.ROLE);

        setKey(key);
        setIsCustom(isCustom);
        setName(name);
        setDescription(description);
        setUserSelectable(userSelectable);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised RoleRecord
     */
    public RoleRecord(com.silo.backend.database.tables.pojos.Role value) {
        super(Role.ROLE);

        if (value != null) {
            setKey(value.key());
            setIsCustom(value.isCustom());
            setName(value.name());
            setDescription(value.description());
            setUserSelectable(value.userSelectable());
            resetChangedOnNotNull();
        }
    }
}
