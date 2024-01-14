package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="user_agent_info", schema="public" )
public class UserAgentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="user_name", nullable=false, length=128)
    private String     userName ;

    @Column(name="user_agent", nullable=false, length=500)
    private String     userAgent ;

    @Column(name="resolution", nullable=false, length=128)
    private String     resolution ;

    @Column(name="operating_system", nullable=false, length=128)
    private String     operatingSystem ;

    @Column(name="ip_address", nullable=false, length=128)
    private String     ipAddress ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="login_timestamp", nullable=false)
    private Date       loginTimestamp ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="user_name", referencedColumnName="user_name", insertable=false, updatable=false)
    private User       user ; 


    public UserAgentInfo() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    public void setUserName( String userName ) {
        this.userName = userName ;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserAgent( String userAgent ) {
        this.userAgent = userAgent ;
    }
    public String getUserAgent() {
        return this.userAgent;
    }

    public void setResolution( String resolution ) {
        this.resolution = resolution ;
    }
    public String getResolution() {
        return this.resolution;
    }

    public void setOperatingSystem( String operatingSystem ) {
        this.operatingSystem = operatingSystem ;
    }
    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setIpAddress( String ipAddress ) {
        this.ipAddress = ipAddress ;
    }
    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setLoginTimestamp( Date loginTimestamp ) {
        this.loginTimestamp = loginTimestamp ;
    }
    public Date getLoginTimestamp() {
        return this.loginTimestamp;
    }

    //--- GETTERS FOR LINKS
    public User getUser() {
        return this.user;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(userName);
        sb.append("|");
        sb.append(userAgent);
        sb.append("|");
        sb.append(resolution);
        sb.append("|");
        sb.append(operatingSystem);
        sb.append("|");
        sb.append(ipAddress);
        sb.append("|");
        sb.append(loginTimestamp);
        return sb.toString(); 
    } 

}
