package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="database_information", schema="public" )
public class DatabaseInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="database_name", nullable=false, length=255)
    private String     databaseName ;

    @Column(name="instance_name", nullable=false, length=255)
    private String     instanceName ;

    @Column(name="dbms_vendor", nullable=false, length=255)
    private String     dbmsVendor ;

    @Column(name="dbms_name", nullable=false, length=255)
    private String     dbmsName ;

    @Column(name="dbms_version", nullable=false, length=128)
    private String     dbmsVersion ;

    @Column(name="external_id", length=200)
    private String     externalId ;

    @Temporal(TemporalType.DATE)
    @Column(name="end_of_life_date")
    private Date       endOfLifeDate ;

    @Column(name="lifecycle_status", length=64)
    private String     lifecycleStatus ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="databaseInformation", targetEntity=DatabaseUsage.class)
    private Set<DatabaseUsage> listOfDatabaseUsage ; 


    public DatabaseInformation() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setDatabaseName( String databaseName ) {
        this.databaseName = databaseName ;
    }
    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setInstanceName( String instanceName ) {
        this.instanceName = instanceName ;
    }
    public String getInstanceName() {
        return this.instanceName;
    }

    public void setDbmsVendor( String dbmsVendor ) {
        this.dbmsVendor = dbmsVendor ;
    }
    public String getDbmsVendor() {
        return this.dbmsVendor;
    }

    public void setDbmsName( String dbmsName ) {
        this.dbmsName = dbmsName ;
    }
    public String getDbmsName() {
        return this.dbmsName;
    }

    public void setDbmsVersion( String dbmsVersion ) {
        this.dbmsVersion = dbmsVersion ;
    }
    public String getDbmsVersion() {
        return this.dbmsVersion;
    }

    public void setExternalId( String externalId ) {
        this.externalId = externalId ;
    }
    public String getExternalId() {
        return this.externalId;
    }

    public void setEndOfLifeDate( Date endOfLifeDate ) {
        this.endOfLifeDate = endOfLifeDate ;
    }
    public Date getEndOfLifeDate() {
        return this.endOfLifeDate;
    }

    public void setLifecycleStatus( String lifecycleStatus ) {
        this.lifecycleStatus = lifecycleStatus ;
    }
    public String getLifecycleStatus() {
        return this.lifecycleStatus;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    //--- GETTERS FOR LINKS
    public Set<DatabaseUsage> getListOfDatabaseUsage() {
        return this.listOfDatabaseUsage;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(databaseName);
        sb.append("|");
        sb.append(instanceName);
        sb.append("|");
        sb.append(dbmsVendor);
        sb.append("|");
        sb.append(dbmsName);
        sb.append("|");
        sb.append(dbmsVersion);
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(endOfLifeDate);
        sb.append("|");
        sb.append(lifecycleStatus);
        sb.append("|");
        sb.append(provenance);
        return sb.toString(); 
    } 

}
