package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="user", schema="public" )
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="user_name", nullable=false, length=128)
    private String     userName ;

    //--- ENTITY DATA FIELDS 
    @Column(name="password", nullable=false, length=255)
    private String     password ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="user", targetEntity=UserPreference.class)
    private Set<UserPreference> listOfUserPreference ; 

    @OneToMany(mappedBy="user", targetEntity=AccessLog.class)
    private Set<AccessLog> listOfAccessLog ; 

    @ManyToMany(mappedBy="listOfUser", targetEntity=Role.class)
    private Set<Role>  listOfRole ; 

    @OneToMany(mappedBy="user", targetEntity=UserAgentInfo.class)
    private Set<UserAgentInfo> listOfUserAgentInfo ; 


    public User() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setUserName( String userName ) {
        this.userName = userName ;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setPassword( String password ) {
        this.password = password ;
    }
    public String getPassword() {
        return this.password;
    }

    //--- GETTERS FOR LINKS
    public Set<UserPreference> getListOfUserPreference() {
        return this.listOfUserPreference;
    } 

    public Set<AccessLog> getListOfAccessLog() {
        return this.listOfAccessLog;
    } 

    public Set<Role> getListOfRole() {
        return this.listOfRole;
    } 

    public Set<UserAgentInfo> getListOfUserAgentInfo() {
        return this.listOfUserAgentInfo;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(userName);
        sb.append("|");
        sb.append(password);
        return sb.toString(); 
    } 

}
