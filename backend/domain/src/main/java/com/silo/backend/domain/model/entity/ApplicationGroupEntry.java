package com.silo.backend.domain.model.entity;


import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="application_group_entry", schema="public" )
@IdClass(ApplicationGroupEntryId.class)
public class ApplicationGroupEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="group_id", nullable=false)
    private Long       groupId ;

    @Id
    @Column(name="application_id", nullable=false)
    private Long       applicationId ;

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
    @JoinColumn(name="application_id", referencedColumnName="id", insertable=false, updatable=false)
    private Application application ; 


    public ApplicationGroupEntry() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setGroupId( Long groupId ) {
        this.groupId = groupId ;
    }
    public Long getGroupId() {
        return this.groupId;
    }

    public void setApplicationId( Long applicationId ) {
        this.applicationId = applicationId ;
    }
    public Long getApplicationId() {
        return this.applicationId;
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

    public Application getApplication() {
        return this.application;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(groupId);
        sb.append("|");
        sb.append(applicationId);
        sb.append("|");
        sb.append(isReadonly);
        sb.append("|");
        sb.append(provenance);
        sb.append("|");
        sb.append(createdAt);
        return sb.toString(); 
    } 

}
