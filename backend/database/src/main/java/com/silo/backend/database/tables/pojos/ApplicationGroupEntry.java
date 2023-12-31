/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.pojos;


import com.silo.backend.database.tables.interfaces.IApplicationGroupEntry;

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
 * a reference to a specific application in a group
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
    name = "application_group_entry"
)
public record ApplicationGroupEntry(
    @Nonnull Long groupId,
    @Nonnull Long applicationId,
    @Nullable Boolean isReadonly,
    @Nullable String provenance,
    @Nullable Timestamp createdAt
) implements IApplicationGroupEntry {

    private static final long serialVersionUID = 1L;


    /**
     * Getter for <code>application_group_entry.group_id</code>. reference to
     * the group this entry belongs to
     */
    @Column(name = "group_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getGroupId() {
        return this.groupId;
    }

    /**
     * Getter for <code>application_group_entry.application_id</code>. reference
     * to the application this entry refers to
     */
    @Column(name = "application_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getApplicationId() {
        return this.applicationId;
    }

    /**
     * Getter for <code>application_group_entry.is_readonly</code>. flag to
     * indicate that the value is readonly.  Typically set if group entries are
     * added by external jobs
     */
    @Column(name = "is_readonly")
    @Nullable
    @Override
    public Boolean getIsReadonly() {
        return this.isReadonly;
    }

    /**
     * Getter for <code>application_group_entry.provenance</code>. indicates
     * where this record originated. Will be 'waltz' if created via the UI
     */
    @Column(name = "provenance", length = 64)
    @Size(max = 64)
    @Nullable
    @Override
    public String getProvenance() {
        return this.provenance;
    }

    /**
     * Getter for <code>application_group_entry.created_at</code>. the date this
     * entry was created, sometimes used to 'age' entries out the group, i.e. in
     * exception lists
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
        final ApplicationGroupEntry other = (ApplicationGroupEntry) obj;
        if (this.groupId == null) {
            if (other.groupId != null)
                return false;
        }
        else if (!this.groupId.equals(other.groupId))
            return false;
        if (this.applicationId == null) {
            if (other.applicationId != null)
                return false;
        }
        else if (!this.applicationId.equals(other.applicationId))
            return false;
        if (this.isReadonly == null) {
            if (other.isReadonly != null)
                return false;
        }
        else if (!this.isReadonly.equals(other.isReadonly))
            return false;
        if (this.provenance == null) {
            if (other.provenance != null)
                return false;
        }
        else if (!this.provenance.equals(other.provenance))
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
        result = prime * result + ((this.groupId == null) ? 0 : this.groupId.hashCode());
        result = prime * result + ((this.applicationId == null) ? 0 : this.applicationId.hashCode());
        result = prime * result + ((this.isReadonly == null) ? 0 : this.isReadonly.hashCode());
        result = prime * result + ((this.provenance == null) ? 0 : this.provenance.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ApplicationGroupEntry (");

        sb.append(groupId);
        sb.append(", ").append(applicationId);
        sb.append(", ").append(isReadonly);
        sb.append(", ").append(provenance);
        sb.append(", ").append(createdAt);

        sb.append(")");
        return sb.toString();
    }
}
