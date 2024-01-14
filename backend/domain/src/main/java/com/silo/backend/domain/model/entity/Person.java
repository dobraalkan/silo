package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="person", schema="public" )
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="employee_id", length=128)
    private String     employeeId ;

    @Column(name="display_name", nullable=false, length=255)
    private String     displayName ;

    @Column(name="email", nullable=false, length=255)
    private String     email ;

    @Column(name="user_principal_name", length=255)
    private String     userPrincipalName ;

    @Column(name="department_name", length=255)
    private String     departmentName ;

    @Column(name="kind", nullable=false, length=255)
    private String     kind ;

    @Column(name="manager_employee_id", length=128)
    private String     managerEmployeeId ;

    @Column(name="title", length=255)
    private String     title ;

    @Column(name="office_phone", length=128)
    private String     officePhone ;

    @Column(name="mobile_phone", length=128)
    private String     mobilePhone ;

    @Column(name="organisational_unit_id")
    private Long       organisationalUnitId ;

    @Column(name="is_removed", nullable=false)
    private Boolean    isRemoved ;


    //--- ENTITY LINKS ( RELATIONSHIP )
    @OneToMany(mappedBy="person", targetEntity=OrganisationalUnit.class)
    private Set<OrganisationalUnit> listOfOrganisationalUnit ; 


    public Person() {
		super();
    }
    
    //--- GETTERS & SETTERS FOR FIELDS
    public void setId( Long id ) {
        this.id = id ;
    }
    public Long getId() {
        return this.id;
    }

    public void setEmployeeId( String employeeId ) {
        this.employeeId = employeeId ;
    }
    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setDisplayName( String displayName ) {
        this.displayName = displayName ;
    }
    public String getDisplayName() {
        return this.displayName;
    }

    public void setEmail( String email ) {
        this.email = email ;
    }
    public String getEmail() {
        return this.email;
    }

    public void setUserPrincipalName( String userPrincipalName ) {
        this.userPrincipalName = userPrincipalName ;
    }
    public String getUserPrincipalName() {
        return this.userPrincipalName;
    }

    public void setDepartmentName( String departmentName ) {
        this.departmentName = departmentName ;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setKind( String kind ) {
        this.kind = kind ;
    }
    public String getKind() {
        return this.kind;
    }

    public void setManagerEmployeeId( String managerEmployeeId ) {
        this.managerEmployeeId = managerEmployeeId ;
    }
    public String getManagerEmployeeId() {
        return this.managerEmployeeId;
    }

    public void setTitle( String title ) {
        this.title = title ;
    }
    public String getTitle() {
        return this.title;
    }

    public void setOfficePhone( String officePhone ) {
        this.officePhone = officePhone ;
    }
    public String getOfficePhone() {
        return this.officePhone;
    }

    public void setMobilePhone( String mobilePhone ) {
        this.mobilePhone = mobilePhone ;
    }
    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setOrganisationalUnitId( Long organisationalUnitId ) {
        this.organisationalUnitId = organisationalUnitId ;
    }
    public Long getOrganisationalUnitId() {
        return this.organisationalUnitId;
    }

    public void setIsRemoved( Boolean isRemoved ) {
        this.isRemoved = isRemoved ;
    }
    public Boolean getIsRemoved() {
        return this.isRemoved;
    }

    //--- GETTERS FOR LINKS
    public Set<OrganisationalUnit> getListOfOrganisationalUnit() {
        return this.listOfOrganisationalUnit;
    } 

    //--- toString specific method
	@Override
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        sb.append(id);
        sb.append("|");
        sb.append(employeeId);
        sb.append("|");
        sb.append(displayName);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(userPrincipalName);
        sb.append("|");
        sb.append(departmentName);
        sb.append("|");
        sb.append(kind);
        sb.append("|");
        sb.append(managerEmployeeId);
        sb.append("|");
        sb.append(title);
        sb.append("|");
        sb.append(officePhone);
        sb.append("|");
        sb.append(mobilePhone);
        sb.append("|");
        sb.append(organisationalUnitId);
        sb.append("|");
        sb.append(isRemoved);
        return sb.toString(); 
    } 

}
