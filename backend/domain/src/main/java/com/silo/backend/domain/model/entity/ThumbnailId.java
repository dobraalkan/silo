package com.silo.backend.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ThumbnailId implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY KEY ATTRIBUTES 
    private String     parentEntityKind ;
    
    private Long       parentEntityId ;
    

    public ThumbnailId() {
        super();
    }

    /**
     * Constructor with values
     * @param parentEntityKind 
     * @param parentEntityId 
     */
    public ThumbnailId( String parentEntityKind, Long parentEntityId ) {
        super();
        this.parentEntityKind = parentEntityKind ;
        this.parentEntityId = parentEntityId ;
    }
    
    //--- GETTERS & SETTERS FOR KEY FIELDS
    public void setParentEntityKind( String value ) {
        this.parentEntityKind = value;
    }
    public String getParentEntityKind() {
        return this.parentEntityKind;
    }

    public void setParentEntityId( Long value ) {
        this.parentEntityId = value;
    }
    public Long getParentEntityId() {
        return this.parentEntityId;
    }


    //--- equals METHOD
	@Override
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		ThumbnailId other = (ThumbnailId) obj; 
		//--- Attribute parentEntityKind
		if ( parentEntityKind == null ) { 
			if ( other.parentEntityKind != null ) 
				return false ; 
		} else if ( ! parentEntityKind.equals(other.parentEntityKind) ) 
			return false ; 
		//--- Attribute parentEntityId
		if ( parentEntityId == null ) { 
			if ( other.parentEntityId != null ) 
				return false ; 
		} else if ( ! parentEntityId.equals(other.parentEntityId) ) 
			return false ; 
		return true; 
	} 

    //--- hashCode METHOD
	@Override
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute parentEntityKind
		result = prime * result + ((parentEntityKind == null) ? 0 : parentEntityKind.hashCode() ) ; 
		//--- Attribute parentEntityId
		result = prime * result + ((parentEntityId == null) ? 0 : parentEntityId.hashCode() ) ; 
		
		return result; 
	} 

    //--- toString METHOD
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(parentEntityKind);
        sb.append("|");
        sb.append(parentEntityId);
        return sb.toString(); 
    } 

}
