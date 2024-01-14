package com.silo.backend.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationGroupOuEntryId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private Long       groupId ;
    
    private Long       orgUnitId ;
    

    public ApplicationGroupOuEntryId() {
        super();
    }

    /**
     * Constructor with values
     * @param groupId 
     * @param orgUnitId 
     */
    public ApplicationGroupOuEntryId( Long groupId, Long orgUnitId ) {
        super();
        this.groupId = groupId ;
        this.orgUnitId = orgUnitId ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setGroupId( Long value ) {
        this.groupId = value;
    }
    public Long getGroupId() {
        return this.groupId;
    }

    public void setOrgUnitId( Long value ) {
        this.orgUnitId = value;
    }
    public Long getOrgUnitId() {
        return this.orgUnitId;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		ApplicationGroupOuEntryId other = (ApplicationGroupOuEntryId) obj; 
		//--- Attribute groupId
		if ( groupId == null ) { 
			if ( other.groupId != null ) 
				return false ; 
		} else if ( ! groupId.equals(other.groupId) ) 
			return false ; 
		//--- Attribute orgUnitId
		if ( orgUnitId == null ) { 
			if ( other.orgUnitId != null ) 
				return false ; 
		} else if ( ! orgUnitId.equals(other.orgUnitId) ) 
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
		//--- Attribute orgUnitId
		result = prime * result + ((orgUnitId == null) ? 0 : orgUnitId.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(groupId);
        sb.append("|");
        sb.append(orgUnitId);
        return sb.toString(); 
    } 

}
