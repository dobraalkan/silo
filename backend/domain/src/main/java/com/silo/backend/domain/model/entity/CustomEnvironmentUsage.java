package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="custom_environment_usage", schema="public" )
public class CustomEnvironmentUsage implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="custom_environment_id", nullable=false)
    private Long       customEnvironmentId ;

    @Column(name="entity_id", nullable=false)
    private Long       entityId ;

    @Column(name="entity_kind", nullable=false, length=64)
    private String     entityKind ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    private Date       createdAt ;

    @Column(name="created_by", nullable=false, length=255)
    private String     createdBy ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="custom_environment_id", referencedColumnName="id", insertable=false, updatable=false)
    private CustomEnvironment customEnvironment ; 


    public CustomEnvironmentUsage() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setCustomEnvironmentId( Long customEnvironmentId ) {
        this.customEnvironmentId = customEnvironmentId ;
    }
    public Long getCustomEnvironmentId() {
        return this.customEnvironmentId;
    }

    public void setEntityId( Long entityId ) {
        this.entityId = entityId ;
    }
    public Long getEntityId() {
        return this.entityId;
    }

    public void setEntityKind( String entityKind ) {
        this.entityKind = entityKind ;
    }
    public String getEntityKind() {
        return this.entityKind;
    }

    public void setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt ;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedBy( String createdBy ) {
        this.createdBy = createdBy ;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    //--- GETTERS FOR LINKS
    public CustomEnvironment getCustomEnvironment() {
        return this.customEnvironment;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(customEnvironmentId);
        sb.append("|");
        sb.append(entityId);
        sb.append("|");
        sb.append(entityKind);
        sb.append("|");
        sb.append(createdAt);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(provenance);
        return sb.toString(); 
    } 

}
