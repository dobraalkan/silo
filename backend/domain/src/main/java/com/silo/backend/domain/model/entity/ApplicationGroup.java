package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="application_group", schema="public" )
public class ApplicationGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", nullable=false, length=255)
    private String     name ;

    @Column(name="kind", nullable=false, length=64)
    private String     kind ;

    @Column(name="description", length=2147483647)
    private String     description ;

    @Column(name="external_id", length=200)
    private String     externalId ;

    @Column(name="is_removed", nullable=false)
    private Boolean    isRemoved ;

    @Column(name="is_favourite_group", nullable=false)
    private Boolean    isFavouriteGroup ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="applicationGroup", targetEntity=ApplicationGroupEntry.class)
    private Set<ApplicationGroupEntry> listOfApplicationGroupEntry ; 

    @OneToMany(mappedBy="applicationGroup", targetEntity=ApplicationGroupMember.class)
    private Set<ApplicationGroupMember> listOfApplicationGroupMember ; 

    @OneToMany(mappedBy="applicationGroup", targetEntity=ApplicationGroupOuEntry.class)
    private Set<ApplicationGroupOuEntry> listOfApplicationGroupOuEntry ; 


    public ApplicationGroup() {
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

    public void setKind( String kind ) {
        this.kind = kind ;
    }
    public String getKind() {
        return this.kind;
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

    public void setIsRemoved( Boolean isRemoved ) {
        this.isRemoved = isRemoved ;
    }
    public Boolean getIsRemoved() {
        return this.isRemoved;
    }

    public void setIsFavouriteGroup( Boolean isFavouriteGroup ) {
        this.isFavouriteGroup = isFavouriteGroup ;
    }
    public Boolean getIsFavouriteGroup() {
        return this.isFavouriteGroup;
    }

    //--- GETTERS FOR LINKS
    public Set<ApplicationGroupEntry> getListOfApplicationGroupEntry() {
        return this.listOfApplicationGroupEntry;
    } 

    public Set<ApplicationGroupMember> getListOfApplicationGroupMember() {
        return this.listOfApplicationGroupMember;
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
        sb.append(kind);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(isRemoved);
        sb.append("|");
        sb.append(isFavouriteGroup);
        return sb.toString(); 
    } 

}
