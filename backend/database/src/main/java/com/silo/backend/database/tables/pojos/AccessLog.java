/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.pojos;


import com.silo.backend.database.tables.interfaces.IAccessLog;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

import javax.annotation.processing.Generated;


/**
 * logs user page and section views
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
    name = "access_log"
)
public record AccessLog(
    @Nullable Integer id,
    @Nonnull String userId,
    @Nonnull String state,
    @Nullable String params,
    @Nullable Timestamp createdAt
) implements IAccessLog {

    private static final long serialVersionUID = 1L;


    /**
     * Getter for <code>access_log.id</code>.
     */
    @Column(name = "id")
    @Nullable
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * Getter for <code>access_log.user_id</code>. identifier of the user
     * accessing the page or section
     */
    @Column(name = "user_id", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getUserId() {
        return this.userId;
    }

    /**
     * Getter for <code>access_log.state</code>. identifier of the page  plus
     * optionally a section identifier (format: state|section)
     */
    @Column(name = "state", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getState() {
        return this.state;
    }

    /**
     * Getter for <code>access_log.params</code>. additional params provided to
     * page/section
     */
    @Column(name = "params", length = 1024)
    @Size(max = 1024)
    @Nullable
    @Override
    public String getParams() {
        return this.params;
    }

    /**
     * Getter for <code>access_log.created_at</code>.
     */
    @Column(name = "created_at", precision = 6)
    @Nullable
    @Override
    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AccessLog other = (AccessLog) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.state == null) {
            if (other.state != null)
                return false;
        }
        else if (!this.state.equals(other.state))
            return false;
        if (this.params == null) {
            if (other.params != null)
                return false;
        }
        else if (!this.params.equals(other.params))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.state == null) ? 0 : this.state.hashCode());
        result = prime * result + ((this.params == null) ? 0 : this.params.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AccessLog (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(state);
        sb.append(", ").append(params);
        sb.append(", ").append(createdAt);

        sb.append(")");
        return sb.toString();
    }
}
