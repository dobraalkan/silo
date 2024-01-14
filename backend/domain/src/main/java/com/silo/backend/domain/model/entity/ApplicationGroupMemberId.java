package com.silo.backend.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationGroupMemberId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Long       groupId ;
    
    private String     userId ;
    

    public ApplicationGroupMemberId() {
        super();
    }

    /**
     * Constructor with values
     * @param groupId 
     * @param userId 
     */
    public ApplicationGroupMemberId( Long groupId, String userId ) {
        super();
        this.groupId = groupId ;
        this.userId = userId ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setGroupId( Long value ) {
        this.groupId = value;
    }
    public Long getGroupId() {
        return this.groupId;
    }

    public void setUserId( String value ) {
        this.userId = value;
    }
    public String getUserId() {
        return this.userId;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		ApplicationGroupMemberId other = (ApplicationGroupMemberId) obj; 
		//--- Attribute groupId
		if ( groupId == null ) { 
			if ( other.groupId != null ) 
				return false ; 
		} else if ( ! groupId.equals(other.groupId) ) 
			return false ; 
		//--- Attribute userId
		if ( userId == null ) { 
			if ( other.userId != null ) 
				return false ; 
		} else if ( ! userId.equals(other.userId) ) 
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
		//--- Attribute userId
		result = prime * result + ((userId == null) ? 0 : userId.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(groupId);
        sb.append("|");
        sb.append(userId);
        return sb.toString(); 
    } 

}
