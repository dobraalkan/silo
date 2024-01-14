package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="complexity_kind", schema="public" )
public class ComplexityKind implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", nullable=false, length=255)
    private String     name ;

    @Column(name="description", length=4000)
    private String     description ;

    @Column(name="external_id", length=200)
    private String     externalId ;

    @Column(name="is_default", nullable=false)
    private Boolean    isDefault ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="complexityKind", targetEntity=Complexity.class)
    private Set<Complexity> listOfComplexity ; 


    public ComplexityKind() {
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

    public void setExternalId( String externalId ) {
        this.externalId = externalId ;
    }
    public String getExternalId() {
        return this.externalId;
    }

    public void setIsDefault( Boolean isDefault ) {
        this.isDefault = isDefault ;
    }
    public Boolean getIsDefault() {
        return this.isDefault;
    }

    //--- GETTERS FOR LINKS
    public Set<Complexity> getListOfComplexity() {
        return this.listOfComplexity;
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
        sb.append(externalId);
        sb.append("|");
        sb.append(isDefault);
        return sb.toString(); 
    } 

}
