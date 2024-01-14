package com.silo.backend.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationGroupEntryId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Long       groupId ;
    
    private Long       applicationId ;
    

    public ApplicationGroupEntryId() {
        super();
    }

    /**
     * Constructor with values
     * @param groupId 
     * @param applicationId 
     */
    public ApplicationGroupEntryId( Long groupId, Long applicationId ) {
        super();
        this.groupId = groupId ;
        this.applicationId = applicationId ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setGroupId( Long value ) {
        this.groupId = value;
    }
    public Long getGroupId() {
        return this.groupId;
    }

    public void setApplicationId( Long value ) {
        this.applicationId = value;
    }
    public Long getApplicationId() {
        return this.applicationId;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		ApplicationGroupEntryId other = (ApplicationGroupEntryId) obj; 
		//--- Attribute groupId
		if ( groupId == null ) { 
			if ( other.groupId != null ) 
				return false ; 
		} else if ( ! groupId.equals(other.groupId) ) 
			return false ; 
		//--- Attribute applicationId
		if ( applicationId == null ) { 
			if ( other.applicationId != null ) 
				return false ; 
		} else if ( ! applicationId.equals(other.applicationId) ) 
			return false ; 
		return true; 
	} 

    //--- hashCode METHOD
	@Override
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute groupId
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode() ) ; 
		//--- Attribute applicationId
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(groupId);
        sb.append("|");
        sb.append(applicationId);
        return sb.toString(); 
    } 

}
