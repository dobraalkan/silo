package com.silo.backend.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPreferenceId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     key ;
    
    private String     userName ;
    

    public UserPreferenceId() {
        super();
    }

    /**
     * Constructor with values
     * @param key 
     * @param userName 
     */
    public UserPreferenceId( String key, String userName ) {
        super();
        this.key = key ;
        this.userName = userName ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setKey( String value ) {
        this.key = value;
    }
    public String getKey() {
        return this.key;
    }

    public void setUserName( String value ) {
        this.userName = value;
    }
    public String getUserName() {
        return this.userName;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		UserPreferenceId other = (UserPreferenceId) obj; 
		//--- Attribute key
		if ( key == null ) { 
			if ( other.key != null ) 
				return false ; 
		} else if ( ! key.equals(other.key) ) 
			return false ; 
		//--- Attribute userName
		if ( userName == null ) { 
			if ( other.userName != null ) 
				return false ; 
		} else if ( ! userName.equals(other.userName) ) 
			return false ; 
		return true; 
	} 

    //--- hashCode METHOD
	@Override
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute key
		result = prime * result + ((key == null) ? 0 : key.hashCode() ) ; 
		//--- Attribute userName
		result = prime * result + ((userName == null) ? 0 : userName.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(key);
        sb.append("|");
        sb.append(userName);
        return sb.toString(); 
    } 

}
