package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="custom_environment", schema="public" )
public class CustomEnvironment implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="owning_entity_id", nullable=false)
    private Long       owningEntityId ;

    @Column(name="owning_entity_kind", nullable=false, length=64)
    private String     owningEntityKind ;

    @Column(name="name", nullable=false, length=255)
    private String     name ;

    @Column(name="description", length=4000)
    private String     description ;

    @Column(name="external_id", nullable=false, length=200)
    private String     externalId ;

    @Column(name="group_name", nullable=false, length=255)
    private String     groupName ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="customEnvironment", targetEntity=CustomEnvironmentUsage.class)
    private Set<CustomEnvironmentUsage> listOfCustomEnvironmentUsage ; 


    public CustomEnvironment() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setOwningEntityId( Long owningEntityId ) {
        this.owningEntityId = owningEntityId ;
    }
    public Long getOwningEntityId() {
        return this.owningEntityId;
    }

    public void setOwningEntityKind( String owningEntityKind ) {
        this.owningEntityKind = owningEntityKind ;
    }
    public String getOwningEntityKind() {
        return this.owningEntityKind;
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

    public void setExternalId( String externalId ) {
        this.externalId = externalId ;
    }
    public String getExternalId() {
        return this.externalId;
    }

    public void setGroupName( String groupName ) {
        this.groupName = groupName ;
    }
    public String getGroupName() {
        return this.groupName;
    }

    //--- GETTERS FOR LINKS
    public Set<CustomEnvironmentUsage> getListOfCustomEnvironmentUsage() {
        return this.listOfCustomEnvironmentUsage;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(owningEntityId);
        sb.append("|");
        sb.append(owningEntityKind);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(groupName);
        return sb.toString(); 
    } 

}
