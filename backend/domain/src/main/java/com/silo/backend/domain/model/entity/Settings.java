package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="settings", schema="public" )
public class Settings implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="name", nullable=false, length=128)
    private String     name ;

    //--- ENTITY DATA FIELDS 
    @Column(name="value", length=4000)
    private String     value ;

    @Column(name="restricted", nullable=false)
    private Boolean    restricted ;

    @Column(name="description", length=4000)
    private String     description ;


    //--- ENTITY LINKS ( RELATIONSHIP )

    public Settings() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setName( String name ) {
        this.name = name ;
    }
    public String getName() {
        return this.name;
    }

    public void setValue( String value ) {
        this.value = value ;
    }
    public String getValue() {
        return this.value;
    }

    public void setRestricted( Boolean restricted ) {
        this.restricted = restricted ;
    }
    public Boolean getRestricted() {
        return this.restricted;
    }

    public void setDescription( String description ) {
        this.description = description ;
    }
    public String getDescription() {
        return this.description;
    }

    //--- GETTERS FOR LINKS
    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(name);
        sb.append("|");
        sb.append(value);
        sb.append("|");
        sb.append(restricted);
        sb.append("|");
        sb.append(description);
        return sb.toString(); 
    } 

}
