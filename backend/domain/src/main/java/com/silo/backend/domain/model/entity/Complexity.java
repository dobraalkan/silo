package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="complexity", schema="public" )
public class Complexity implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="complexity_kind_id", nullable=false)
    private Long       complexityKindId ;

    @Column(name="entity_id", nullable=false)
    private Long       entityId ;

    @Column(name="entity_kind", nullable=false, length=64)
    private String     entityKind ;

    @Column(name="score", nullable=false)
    private BigDecimal score ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false)
    private Date       updatedAt ;

    @Column(name="updated_by", nullable=false, length=255)
    private String     updatedBy ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="complexity_kind_id", referencedColumnName="id", insertable=false, updatable=false)
    private ComplexityKind complexityKind ; 


    public Complexity() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setComplexityKindId( Long complexityKindId ) {
        this.complexityKindId = complexityKindId ;
    }
    public Long getComplexityKindId() {
        return this.complexityKindId;
    }

    public void setEntityId( Long entityId ) {
        this.entityId = entityId ;
    }
    public Long getEntityId() {
        return this.entityId;
    }

    public void setEntityKind( String entityKind ) {
        this.entityKind = entityKind ;
    }
    public String getEntityKind() {
        return this.entityKind;
    }

    public void setScore( BigDecimal score ) {
        this.score = score ;
    }
    public BigDecimal getScore() {
        return this.score;
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

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    //--- GETTERS FOR LINKS
    public ComplexityKind getComplexityKind() {
        return this.complexityKind;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(complexityKindId);
        sb.append("|");
        sb.append(entityId);
        sb.append("|");
        sb.append(entityKind);
        sb.append("|");
        sb.append(score);
        sb.append("|");
        sb.append(updatedAt);
        sb.append("|");
        sb.append(updatedBy);
        sb.append("|");
        sb.append(provenance);
        return sb.toString(); 
    } 

}
