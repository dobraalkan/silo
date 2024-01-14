package com.silo.backend.domain.model.entity;


import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="thumbnail", schema="public" )
@IdClass(ThumbnailId.class)
public class Thumbnail implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="parent_entity_kind", nullable=false, length=64)
    private String     parentEntityKind ;

    @Id
    @Column(name="parent_entity_id", nullable=false)
    private Long       parentEntityId ;

    //--- ENTITY DATA FIELDS 
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false)
    private Date       updatedAt ;

    @Column(name="updated_by", nullable=false, length=255)
    private String     updatedBy ;

    @Column(name="mime_type", nullable=false, length=255)
    private String     mimeType ;

    @Lob
    @Column(name="blob", nullable=false)
    private byte[]     blob ;

    @Column(name="external_id", length=200)
    private String     externalId ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;


    //--- ENTITY LINKS ( RELATIONSHIP )

    public Thumbnail() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setParentEntityKind( String parentEntityKind ) {
        this.parentEntityKind = parentEntityKind ;
    }
    public String getParentEntityKind() {
        return this.parentEntityKind;
    }

    public void setParentEntityId( Long parentEntityId ) {
        this.parentEntityId = parentEntityId ;
    }
    public Long getParentEntityId() {
        return this.parentEntityId;
    }

    public void setUpdatedAt( Date updatedAt ) {
        this.updatedAt = updatedAt ;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy ;
    }
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setMimeType( String mimeType ) {
        this.mimeType = mimeType ;
    }
    public String getMimeType() {
        return this.mimeType;
    }

    public void setBlob( byte[] blob ) {
        this.blob = blob ;
    }
    public byte[] getBlob() {
        return this.blob;
    }

    public void setExternalId( String externalId ) {
        this.externalId = externalId ;
    }
    public String getExternalId() {
        return this.externalId;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    //--- GETTERS FOR LINKS
    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(parentEntityKind);
        sb.append("|");
        sb.append(parentEntityId);
        sb.append("|");
        sb.append(updatedAt);
        sb.append("|");
        sb.append(updatedBy);
        sb.append("|");
        sb.append(mimeType);
        // attribute 'blob' not usable (type = byte[])
        sb.append("|");
        sb.append(externalId);
        sb.append("|");
        sb.append(provenance);
        return sb.toString(); 
    } 

}
