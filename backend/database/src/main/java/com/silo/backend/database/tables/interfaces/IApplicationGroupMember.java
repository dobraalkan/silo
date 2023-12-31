/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.interfaces;


import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

import javax.annotation.processing.Generated;


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
public interface IApplicationGroupMember extends Serializable {

    /**
     * Getter for <code>application_group_member.group_id</code>. reference to
     * the group this member belongs to
     */
    @Column(name = "group_id", nullable = false)
    @NotNull
    @Nonnull
    public Long getGroupId();

    /**
     * Getter for <code>application_group_member.user_id</code>. reference to
     * the user id of the group member
     */
    @Column(name = "user_id", nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    @Nonnull
    public String getUserId();

    /**
     * Getter for <code>application_group_member.role</code>. the role of the
     * user in the group (one of: VIEWER, OWNER)
     */
    @Column(name = "role", length = 64)
    @Size(max = 64)
    @Nullable
    public String getRole();
}
