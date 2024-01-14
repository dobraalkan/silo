package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="application_relationship", schema="public" )
public class ApplicationRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="relation_kind")
    private Long       relationKind ;


    //--- ENTITY LINKS ( RELATIONSHIP )

    public ApplicationRelationship() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setRelationKind( Long relationKind ) {
        this.relationKind = relationKind ;
    }
    public Long getRelationKind() {
        return this.relationKind;
    }

    //--- GETTERS FOR LINKS
    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(relationKind);
        return sb.toString(); 
    } 

}
