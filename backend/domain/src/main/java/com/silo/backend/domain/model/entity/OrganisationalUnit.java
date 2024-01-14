package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="organisational_unit", schema="public" )
public class OrganisationalUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", length=255)
    private String     name ;

    @Column(name="description", length=4000)
    private String     description ;

    @Column(name="parent_id")
    private Long       parentId ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    private Date       createdAt ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false)
    private Date       updatedAt ;

    @Column(name="external_id", length=200)
    private String     externalId ;

    @Column(name="created_by", nullable=false, length=255)
    private String     createdBy ;

    @Column(name="updated_by", nullable=false, length=255)
    private String     updatedBy ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="id", referencedColumnName="organisational_unit_id", insertable=false, updatable=false)
    private Person     person ; 

    @OneToMany(mappedBy="organisationalUnit", targetEntity=ApplicationGroupOuEntry.class)
    private Set<ApplicationGroupOuEntry> listOfApplicationGroupOuEntry ; 


    public OrganisationalUnit() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setName( String name ) {
        this.name = name ;
    }
    public String getName() {
        return this.name;
    }

    public void setDescription( String description ) {
        this.description = description ;
    }
    public String getDescription() {
        return this.description;
    }

    public void setParentId( Long parentId ) {
        this.parentId = parentId ;
    }
    public Long getParentId() {
        return this.parentId;
    }

    public void setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt ;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setUpdatedAt( Date updatedAt ) {
        this.updatedAt = updatedAt ;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setExternalId( String externalId ) {
        this.externalId = externalId ;
    }
    public String getExternalId() {
        return this.externalId;
    }

    public void setCreatedBy( String createdBy ) {
        this.createdBy = createdBy ;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy ;
    }
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    //--- GETTERS FOR LINKS
    public Person getPerson() {
        return this.person;
    } 

    public Set<ApplicationGroupOuEntry> getListOfApplicationGroupOuEntry() {
        return this.listOfApplicationGroupOuEntry;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(parentId);
        sb.append("|");
        sb.append(createdAt);
        sb.append("|");
        sb.append(updatedAt);
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(createdBy);
        sb.append("|");
        sb.append(updatedBy);
        sb.append("|");
        sb.append(provenance);
        return sb.toString(); 
    } 

}
