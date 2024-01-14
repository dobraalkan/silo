package com.silo.backend.domain.model.entity;


import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="application_group_member", schema="public" )
@IdClass(ApplicationGroupMemberId.class)
public class ApplicationGroupMember implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @Column(name="group_id", nullable=false)
    private Long       groupId ;

    @Id
    @Column(name="user_id", nullable=false, length=128)
    private String     userId ;

    //--- ENTITY DATA FIELDS 
    @Column(name="role", nullable=false, length=64)
    private String     role ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @ManyToOne
    @JoinColumn(name="group_id", referencedColumnName="id", insertable=false, updatable=false)
    private ApplicationGroup applicationGroup ; 


    public ApplicationGroupMember() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setGroupId( Long groupId ) {
        this.groupId = groupId ;
    }
    public Long getGroupId() {
        return this.groupId;
    }

    public void setUserId( String userId ) {
        this.userId = userId ;
    }
    public String getUserId() {
        return this.userId;
    }

    public void setRole( String role ) {
        this.role = role ;
    }
    public String getRole() {
        return this.role;
    }

    //--- GETTERS FOR LINKS
    public ApplicationGroup getApplicationGroup() {
        return this.applicationGroup;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(groupId);
        sb.append("|");
        sb.append(userId);
        sb.append("|");
        sb.append(role);
        return sb.toString(); 
    } 

}
