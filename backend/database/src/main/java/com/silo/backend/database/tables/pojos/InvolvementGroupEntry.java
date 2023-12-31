/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.pojos;


import com.silo.backend.database.tables.interfaces.IInvolvementGroupEntry;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;


/**
 * describes the association of an involvement kind to an involvement group
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
    name = "involvement_group_entry"
)
public record InvolvementGroupEntry(
    @Nonnull Long involvementGroupId,
    @Nonnull Long involvementKindId
) implements IInvolvementGroupEntry {

    private static final long serialVersionUID = 1L;


    /**
     * Getter for <code>involvement_group_entry.involvement_group_id</code>.
     * identifier of the group this involvement kind is included in
     */
    @Column(name = "involvement_group_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getInvolvementGroupId() {
        return this.involvementGroupId;
    }

    /**
     * Getter for <code>involvement_group_entry.involvement_kind_id</code>.
     * identifier of the involvement kind this entry refers to
     */
    @Column(name = "involvement_kind_id", nullable = false)
    @NotNull
    @Nonnull
    @Override
    public Long getInvolvementKindId() {
        return this.involvementKindId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final InvolvementGroupEntry other = (InvolvementGroupEntry) obj;
        if (this.involvementGroupId == null) {
            if (other.involvementGroupId != null)
                return false;
        }
        else if (!this.involvementGroupId.equals(other.involvementGroupId))
            return false;
        if (this.involvementKindId == null) {
            if (other.involvementKindId != null)
                return false;
        }
        else if (!this.involvementKindId.equals(other.involvementKindId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.involvementGroupId == null) ? 0 : this.involvementGroupId.hashCode());
        result = prime * result + ((this.involvementKindId == null) ? 0 : this.involvementKindId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("InvolvementGroupEntry (");

        sb.append(involvementGroupId);
        sb.append(", ").append(involvementKindId);

        sb.append(")");
        return sb.toString();
    }
}
