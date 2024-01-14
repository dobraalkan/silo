package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="role", schema="public" )
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="key", nullable=false, length=255)
    private String     key ;

    //--- ENTITY DATA FIELDS 
    @Column(name="is_custom", nullable=false)
    private Boolean    isCustom ;

    @Column(name="name", nullable=false, length=255)
    private String     name ;

    @Column(name="description", nullable=false, length=4000)
    private String     description ;

    @Column(name="user_selectable", nullable=false)
    private Boolean    userSelectable ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToMany(targetEntity=User.class)
    @JoinTable(name="user_role", 
      joinColumns=@JoinColumn(name="role", referencedColumnName="key"),
      inverseJoinColumns=@JoinColumn(name="user_name", referencedColumnName="user_name")
     )
    private Set<User>  listOfUser ; 


    public Role() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setKey( String key ) {
        this.key = key ;
    }
    public String getKey() {
        return this.key;
    }

    public void setIsCustom( Boolean isCustom ) {
        this.isCustom = isCustom ;
    }
    public Boolean getIsCustom() {
        return this.isCustom;
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

    public void setUserSelectable( Boolean userSelectable ) {
        this.userSelectable = userSelectable ;
    }
    public Boolean getUserSelectable() {
        return this.userSelectable;
    }

    //--- GETTERS FOR LINKS
    public Set<User> getListOfUser() {
        return this.listOfUser;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(key);
        sb.append("|");
        sb.append(isCustom);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(userSelectable);
        return sb.toString(); 
    } 

}
