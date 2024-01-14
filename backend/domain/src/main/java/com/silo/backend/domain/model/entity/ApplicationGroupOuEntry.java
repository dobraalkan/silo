package com.silo.backend.domain.model.entity;


import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="application_group_ou_entry", schema="public" )
@IdClass(ApplicationGroupOuEntryId.class)
public class ApplicationGroupOuEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="group_id", nullable=false)
    private Long       groupId ;

    @Id
    @Column(name="org_unit_id", nullable=false)
    private Long       orgUnitId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="is_readonly", nullable=false)
    private Boolean    isReadonly ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    private Date       createdAt ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="group_id", referencedColumnName="id", insertable=false, updatable=false)
    private ApplicationGroup applicationGroup ; 

    @ManyToOne
    @JoinColumn(name="org_unit_id", referencedColumnName="id", insertable=false, updatable=false)
    private OrganisationalUnit organisationalUnit ; 


    public ApplicationGroupOuEntry() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setGroupId( Long groupId ) {
        this.groupId = groupId ;
    }
    public Long getGroupId() {
        return this.groupId;
    }

    public void setOrgUnitId( Long orgUnitId ) {
        this.orgUnitId = orgUnitId ;
    }
    public Long getOrgUnitId() {
        return this.orgUnitId;
    }

    public void setIsReadonly( Boolean isReadonly ) {
        this.isReadonly = isReadonly ;
    }
    public Boolean getIsReadonly() {
        return this.isReadonly;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    public void setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt ;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }

    //--- GETTERS FOR LINKS
    public ApplicationGroup getApplicationGroup() {
        return this.applicationGroup;
    } 

    public OrganisationalUnit getOrganisationalUnit() {
        return this.organisationalUnit;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(groupId);
        sb.append("|");
        sb.append(orgUnitId);
        sb.append("|");
        sb.append(isReadonly);
        sb.append("|");
        sb.append(provenance);
        sb.append("|");
        sb.append(createdAt);
        return sb.toString(); 
    } 

}
