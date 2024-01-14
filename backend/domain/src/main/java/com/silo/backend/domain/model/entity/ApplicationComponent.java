package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="application_component", schema="public" )
public class ApplicationComponent implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="application_id")
    private Long       applicationId ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="application_id", referencedColumnName="id", insertable=false, updatable=false)
    private Application application ; 


    public ApplicationComponent() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setApplicationId( Long applicationId ) {
        this.applicationId = applicationId ;
    }
    public Long getApplicationId() {
        return this.applicationId;
    }

    //--- GETTERS FOR LINKS
    public Application getApplication() {
        return this.application;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(applicationId);
        return sb.toString(); 
    } 

}
