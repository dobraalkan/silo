package com.silo.backend.domain.model.entity;


import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="user_preference", schema="public" )
@IdClass(UserPreferenceId.class)
public class UserPreference implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="key", nullable=false, length=120)
    private String     key ;

    @Id
    @Column(name="user_name", nullable=false, length=128)
    private String     userName ;

    //--- ENTITY DATA FIELDS 
    @Column(name="value", nullable=false, length=2048)
    private String     value ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="user_name", referencedColumnName="user_name", insertable=false, updatable=false)
    private User       user ; 


    public UserPreference() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setKey( String key ) {
        this.key = key ;
    }
    public String getKey() {
        return this.key;
    }

    public void setUserName( String userName ) {
        this.userName = userName ;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setValue( String value ) {
        this.value = value ;
    }
    public String getValue() {
        return this.value;
    }

    //--- GETTERS FOR LINKS
    public User getUser() {
        return this.user;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(key);
        sb.append("|");
        sb.append(userName);
        sb.append("|");
        sb.append(value);
        return sb.toString(); 
    } 

}
