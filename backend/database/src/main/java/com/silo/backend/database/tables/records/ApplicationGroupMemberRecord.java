/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.records;


import com.silo.backend.database.tables.ApplicationGroupMember;
import com.silo.backend.database.tables.interfaces.IApplicationGroupMember;

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
 * users granted viewer or ownership rights to app groups
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
    name = "application_group_member"
)
public class ApplicationGroupMemberRecord extends TableRecordImpl<ApplicationGroupMemberRecord> implements IApplicationGroupMember {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>application_group_member.group_id</code>. reference to
     * the group this member belongs to
     */
    public ApplicationGroupMemberRecord setGroupId(@Nonnull Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>application_group_member.group_id</code>. reference to
     * the group this member belongs to
     */
    @Column(name = "group_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getGroupId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>application_group_member.user_id</code>. reference to
     * the user id of the group member
     */
    public ApplicationGroupMemberRecord setUserId(@Nonnull String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>application_group_member.user_id</code>. reference to
     * the user id of the group member
     */
    @Column(name = "user_id", nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    @Nonnull
    @Override
    public String getUserId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>application_group_member.role</code>. the role of the
     * user in the group (one of: VIEWER, OWNER)
     */
    public ApplicationGroupMemberRecord setRole(@Nullable String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>application_group_member.role</code>. the role of the
     * user in the group (one of: VIEWER, OWNER)
     */
    @Column(name = "role", length = 64)
    @Size(max = 64)
    @Nullable
    @Override
    public String getRole() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    public void from(IApplicationGroupMember from) {
        setGroupId(from.getGroupId());
        setUserId(from.getUserId());
        setRole(from.getRole());
        resetChangedOnNotNull();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ApplicationGroupMemberRecord
     */
    public ApplicationGroupMemberRecord() {
        super(ApplicationGroupMember.APPLICATION_GROUP_MEMBER);
    }

    /**
     * Create a detached, initialised ApplicationGroupMemberRecord
     */
    @ConstructorProperties({ "groupId", "userId", "role" })
    public ApplicationGroupMemberRecord(@Nonnull Long groupId, @Nonnull String userId, @Nullable String role) {
        super(ApplicationGroupMember.APPLICATION_GROUP_MEMBER);

        setGroupId(groupId);
        setUserId(userId);
        setRole(role);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised ApplicationGroupMemberRecord
     */
    public ApplicationGroupMemberRecord(com.silo.backend.database.tables.pojos.ApplicationGroupMember value) {
        super(ApplicationGroupMember.APPLICATION_GROUP_MEMBER);

        if (value != null) {
            setGroupId(value.groupId());
            setUserId(value.userId());
            setRole(value.role());
            resetChangedOnNotNull();
        }
    }
}
