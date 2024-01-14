package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="application", schema="public" )
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", length=255)
    private String     name ;

    @Column(name="description", length=4000)
    private String     description ;

    @Column(name="asset_code", length=255)
    private String     assetCode ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false)
    private Date       createdAt ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false)
    private Date       updatedAt ;

    @Column(name="organisational_unit_id", nullable=false)
    private Long       organisationalUnitId ;

    @Column(name="kind", nullable=false, length=128)
    private String     kind ;

    @Column(name="lifecycle_phase", nullable=false, length=128)
    private String     lifecyclePhase ;

    @Column(name="parent_asset_code", length=255)
    private String     parentAssetCode ;

    @Column(name="overall_rating", nullable=false, length=1)
    private String     overallRating ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;

    @Column(name="business_criticality", nullable=false, length=128)
    private String     businessCriticality ;

    @Column(name="is_removed", nullable=false)
    private Boolean    isRemoved ;

    @Column(name="entity_lifecycle_status", nullable=false, length=64)
    private String     entityLifecycleStatus ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="planned_retirement_date")
    private Date       plannedRetirementDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="actual_retirement_date")
    private Date       actualRetirementDate ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="commission_date")
    private Date       commissionDate ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="application", targetEntity=ApplicationGroupEntry.class)
    private Set<ApplicationGroupEntry> listOfApplicationGroupEntry ; 

    @OneToMany(mappedBy="application", targetEntity=ApplicationComponent.class)
    private Set<ApplicationComponent> listOfApplicationComponent ; 


    public Application() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
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

    public void setAssetCode( String assetCode ) {
        this.assetCode = assetCode ;
    }
    public String getAssetCode() {
        return this.assetCode;
    }

    public void setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt ;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setUpdatedAt( Date updatedAt ) {
        this.updatedAt = updatedAt ;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setOrganisationalUnitId( Long organisationalUnitId ) {
        this.organisationalUnitId = organisationalUnitId ;
    }
    public Long getOrganisationalUnitId() {
        return this.organisationalUnitId;
    }

    public void setKind( String kind ) {
        this.kind = kind ;
    }
    public String getKind() {
        return this.kind;
    }

    public void setLifecyclePhase( String lifecyclePhase ) {
        this.lifecyclePhase = lifecyclePhase ;
    }
    public String getLifecyclePhase() {
        return this.lifecyclePhase;
    }

    public void setParentAssetCode( String parentAssetCode ) {
        this.parentAssetCode = parentAssetCode ;
    }
    public String getParentAssetCode() {
        return this.parentAssetCode;
    }

    public void setOverallRating( String overallRating ) {
        this.overallRating = overallRating ;
    }
    public String getOverallRating() {
        return this.overallRating;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    public void setBusinessCriticality( String businessCriticality ) {
        this.businessCriticality = businessCriticality ;
    }
    public String getBusinessCriticality() {
        return this.businessCriticality;
    }

    public void setIsRemoved( Boolean isRemoved ) {
        this.isRemoved = isRemoved ;
    }
    public Boolean getIsRemoved() {
        return this.isRemoved;
    }

    public void setEntityLifecycleStatus( String entityLifecycleStatus ) {
        this.entityLifecycleStatus = entityLifecycleStatus ;
    }
    public String getEntityLifecycleStatus() {
        return this.entityLifecycleStatus;
    }

    public void setPlannedRetirementDate( Date plannedRetirementDate ) {
        this.plannedRetirementDate = plannedRetirementDate ;
    }
    public Date getPlannedRetirementDate() {
        return this.plannedRetirementDate;
    }

    public void setActualRetirementDate( Date actualRetirementDate ) {
        this.actualRetirementDate = actualRetirementDate ;
    }
    public Date getActualRetirementDate() {
        return this.actualRetirementDate;
    }

    public void setCommissionDate( Date commissionDate ) {
        this.commissionDate = commissionDate ;
    }
    public Date getCommissionDate() {
        return this.commissionDate;
    }

    //--- GETTERS FOR LINKS
    public Set<ApplicationGroupEntry> getListOfApplicationGroupEntry() {
        return this.listOfApplicationGroupEntry;
    } 

    public Set<ApplicationComponent> getListOfApplicationComponent() {
        return this.listOfApplicationComponent;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(assetCode);
        sb.append("|");
        sb.append(createdAt);
        sb.append("|");
        sb.append(updatedAt);
        sb.append("|");
        sb.append(organisationalUnitId);
        sb.append("|");
        sb.append(kind);
        sb.append("|");
        sb.append(lifecyclePhase);
        sb.append("|");
        sb.append(parentAssetCode);
        sb.append("|");
        sb.append(overallRating);
        sb.append("|");
        sb.append(provenance);
        sb.append("|");
        sb.append(businessCriticality);
        sb.append("|");
        sb.append(isRemoved);
        sb.append("|");
        sb.append(entityLifecycleStatus);
        sb.append("|");
        sb.append(plannedRetirementDate);
        sb.append("|");
        sb.append(actualRetirementDate);
        sb.append("|");
        sb.append(commissionDate);
        return sb.toString(); 
    } 

}
