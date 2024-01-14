package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="server_information", schema="public" )
public class ServerInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="hostname", nullable=false, length=255)
    private String     hostname ;

    @Column(name="operating_system", nullable=false, length=128)
    private String     operatingSystem ;

    @Column(name="location", nullable=false, length=128)
    private String     location ;

    @Column(name="operating_system_version", nullable=false, length=128)
    private String     operatingSystemVersion ;

    @Column(name="country", nullable=false, length=128)
    private String     country ;

    @Column(name="is_virtual")
    private Boolean    isVirtual ;

    @Column(name="provenance", nullable=false, length=64)
    private String     provenance ;

    @Temporal(TemporalType.DATE)
    @Column(name="os_end_of_life_date")
    private Date       osEndOfLifeDate ;

    @Temporal(TemporalType.DATE)
    @Column(name="hw_end_of_life_date")
    private Date       hwEndOfLifeDate ;

    @Column(name="lifecycle_status", nullable=false, length=64)
    private String     lifecycleStatus ;

    @Column(name="external_id", length=200)
    private String     externalId ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="serverInformation", targetEntity=ServerUsage.class)
    private Set<ServerUsage> listOfServerUsage ; 


    public ServerInformation() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setHostname( String hostname ) {
        this.hostname = hostname ;
    }
    public String getHostname() {
        return this.hostname;
    }

    public void setOperatingSystem( String operatingSystem ) {
        this.operatingSystem = operatingSystem ;
    }
    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setLocation( String location ) {
        this.location = location ;
    }
    public String getLocation() {
        return this.location;
    }

    public void setOperatingSystemVersion( String operatingSystemVersion ) {
        this.operatingSystemVersion = operatingSystemVersion ;
    }
    public String getOperatingSystemVersion() {
        return this.operatingSystemVersion;
    }

    public void setCountry( String country ) {
        this.country = country ;
    }
    public String getCountry() {
        return this.country;
    }

    public void setIsVirtual( Boolean isVirtual ) {
        this.isVirtual = isVirtual ;
    }
    public Boolean getIsVirtual() {
        return this.isVirtual;
    }

    public void setProvenance( String provenance ) {
        this.provenance = provenance ;
    }
    public String getProvenance() {
        return this.provenance;
    }

    public void setOsEndOfLifeDate( Date osEndOfLifeDate ) {
        this.osEndOfLifeDate = osEndOfLifeDate ;
    }
    public Date getOsEndOfLifeDate() {
        return this.osEndOfLifeDate;
    }

    public void setHwEndOfLifeDate( Date hwEndOfLifeDate ) {
        this.hwEndOfLifeDate = hwEndOfLifeDate ;
    }
    public Date getHwEndOfLifeDate() {
        return this.hwEndOfLifeDate;
    }

    public void setLifecycleStatus( String lifecycleStatus ) {
        this.lifecycleStatus = lifecycleStatus ;
    }
    public String getLifecycleStatus() {
        return this.lifecycleStatus;
    }

    public void setExternalId( String externalId ) {
        this.externalId = externalId ;
    }
    public String getExternalId() {
        return this.externalId;
    }

    //--- GETTERS FOR LINKS
    public Set<ServerUsage> getListOfServerUsage() {
        return this.listOfServerUsage;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(hostname);
        sb.append("|");
        sb.append(operatingSystem);
        sb.append("|");
        sb.append(location);
        sb.append("|");
        sb.append(operatingSystemVersion);
        sb.append("|");
        sb.append(country);
        sb.append("|");
        sb.append(isVirtual);
        sb.append("|");
        sb.append(provenance);
        sb.append("|");
        sb.append(osEndOfLifeDate);
        sb.append("|");
        sb.append(hwEndOfLifeDate);
        sb.append("|");
        sb.append(lifecycleStatus);
        sb.append("|");
        sb.append(externalId);
        return sb.toString(); 
    } 

}
