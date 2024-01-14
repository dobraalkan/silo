package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="access_log", schema="public" )
public class AccessLog implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="user_name", nullable=false, length=128)
    private String     userName ;

    @Column(name="state", nullable=false, length=255)
    private String     state ;

    @Column(name="params", length=1024)
    private String     params ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date       createdAt ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="user_name", referencedColumnName="user_name", insertable=false, updatable=false)
    private User       user ; 


    public AccessLog() {
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

    public void setState( String state ) {
        this.state = state ;
    }
    public String getState() {
        return this.state;
    }

    public void setParams( String params ) {
        this.params = params ;
    }
    public String getParams() {
        return this.params;
    }

    public void setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt ;
    }
    public Date getCreatedAt() {
        return this.createdAt;
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
        sb.append(state);
        sb.append("|");
        sb.append(params);
        sb.append("|");
        sb.append(createdAt);
        return sb.toString(); 
    } 

}
