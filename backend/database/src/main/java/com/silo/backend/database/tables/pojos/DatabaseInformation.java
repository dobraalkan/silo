/*
 * This file is generated by jOOQ.
 */
package com.silo.backend.database.tables.pojos;


import com.silo.backend.database.tables.interfaces.IDatabaseInformation;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

import javax.annotation.processing.Generated;


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
    name = "database_information"
)
public record DatabaseInformation(
    @Nullable Long id,
    @Nullable String databaseName,
    @Nullable String instanceName,
    @Nonnull String dbmsVendor,
    @Nonnull String dbmsName,
    @Nonnull String dbmsVersion,
    @Nullable String externalId,
    @Nullable Date endOfLifeDate,
    @Nullable String lifecycleStatus,
    @Nullable String provenance
) implements IDatabaseInformation {

    private static final long serialVersionUID = 1L;


    /**
     * Getter for <code>database_information.id</code>.
     */
    @Column(name = "id")
    @Nullable
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>database_information.database_name</code>.
     */
    @Column(name = "database_name", length = 255)
    @Size(max = 255)
    @Nullable
    @Override
    public String getDatabaseName() {
        return this.databaseName;
    }

    /**
     * Getter for <code>database_information.instance_name</code>.
     */
    @Column(name = "instance_name", length = 255)
    @Size(max = 255)
    @Nullable
    @Override
    public String getInstanceName() {
        return this.instanceName;
    }

    /**
     * Getter for <code>database_information.dbms_vendor</code>.
     */
    @Column(name = "dbms_vendor", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getDbmsVendor() {
        return this.dbmsVendor;
    }

    /**
     * Getter for <code>database_information.dbms_name</code>.
     */
    @Column(name = "dbms_name", nullable = false, length = 255)
    @NotNull
    @Size(max = 255)
    @Nonnull
    @Override
    public String getDbmsName() {
        return this.dbmsName;
    }

    /**
     * Getter for <code>database_information.dbms_version</code>.
     */
    @Column(name = "dbms_version", nullable = false, length = 128)
    @NotNull
    @Size(max = 128)
    @Nonnull
    @Override
    public String getDbmsVersion() {
        return this.dbmsVersion;
    }

    /**
     * Getter for <code>database_information.external_id</code>.
     */
    @Column(name = "external_id", length = 200)
    @Size(max = 200)
    @Nullable
    @Override
    public String getExternalId() {
        return this.externalId;
    }

    /**
     * Getter for <code>database_information.end_of_life_date</code>.
     */
    @Column(name = "end_of_life_date")
    @Nullable
    @Override
    public Date getEndOfLifeDate() {
        return this.endOfLifeDate;
    }

    /**
     * Getter for <code>database_information.lifecycle_status</code>.
     */
    @Column(name = "lifecycle_status", length = 64)
    @Size(max = 64)
    @Nullable
    @Override
    public String getLifecycleStatus() {
        return this.lifecycleStatus;
    }

    /**
     * Getter for <code>database_information.provenance</code>.
     */
    @Column(name = "provenance", length = 64)
    @Size(max = 64)
    @Nullable
    @Override
    public String getProvenance() {
        return this.provenance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DatabaseInformation other = (DatabaseInformation) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.databaseName == null) {
            if (other.databaseName != null)
                return false;
        }
        else if (!this.databaseName.equals(other.databaseName))
            return false;
        if (this.instanceName == null) {
            if (other.instanceName != null)
                return false;
        }
        else if (!this.instanceName.equals(other.instanceName))
            return false;
        if (this.dbmsVendor == null) {
            if (other.dbmsVendor != null)
                return false;
        }
        else if (!this.dbmsVendor.equals(other.dbmsVendor))
            return false;
        if (this.dbmsName == null) {
            if (other.dbmsName != null)
                return false;
        }
        else if (!this.dbmsName.equals(other.dbmsName))
            return false;
        if (this.dbmsVersion == null) {
            if (other.dbmsVersion != null)
                return false;
        }
        else if (!this.dbmsVersion.equals(other.dbmsVersion))
            return false;
        if (this.externalId == null) {
            if (other.externalId != null)
                return false;
        }
        else if (!this.externalId.equals(other.externalId))
            return false;
        if (this.endOfLifeDate == null) {
            if (other.endOfLifeDate != null)
                return false;
        }
        else if (!this.endOfLifeDate.equals(other.endOfLifeDate))
            return false;
        if (this.lifecycleStatus == null) {
            if (other.lifecycleStatus != null)
                return false;
        }
        else if (!this.lifecycleStatus.equals(other.lifecycleStatus))
            return false;
        if (this.provenance == null) {
            if (other.provenance != null)
                return false;
        }
        else if (!this.provenance.equals(other.provenance))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.databaseName == null) ? 0 : this.databaseName.hashCode());
        result = prime * result + ((this.instanceName == null) ? 0 : this.instanceName.hashCode());
        result = prime * result + ((this.dbmsVendor == null) ? 0 : this.dbmsVendor.hashCode());
        result = prime * result + ((this.dbmsName == null) ? 0 : this.dbmsName.hashCode());
        result = prime * result + ((this.dbmsVersion == null) ? 0 : this.dbmsVersion.hashCode());
        result = prime * result + ((this.externalId == null) ? 0 : this.externalId.hashCode());
        result = prime * result + ((this.endOfLifeDate == null) ? 0 : this.endOfLifeDate.hashCode());
        result = prime * result + ((this.lifecycleStatus == null) ? 0 : this.lifecycleStatus.hashCode());
        result = prime * result + ((this.provenance == null) ? 0 : this.provenance.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DatabaseInformation (");

        sb.append(id);
        sb.append(", ").append(databaseName);
        sb.append(", ").append(instanceName);
        sb.append(", ").append(dbmsVendor);
        sb.append(", ").append(dbmsName);
        sb.append(", ").append(dbmsVersion);
        sb.append(", ").append(externalId);
        sb.append(", ").append(endOfLifeDate);
        sb.append(", ").append(lifecycleStatus);
        sb.append(", ").append(provenance);

        sb.append(")");
        return sb.toString();
    }
}
