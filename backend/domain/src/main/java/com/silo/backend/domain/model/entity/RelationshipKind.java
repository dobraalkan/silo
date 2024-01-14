package com.silo.backend.domain.model.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="relationship_kind", schema="public" )
public class RelationshipKind implements Serializable {

    private static final long serialVersionUID = 1L;

    //--- ENTITY PRIMARY KEY 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long       id ;

    //--- ENTITY DATA FIELDS 
    @Column(name="name", nullable=false, length=255)
    private String     name ;

    @Column(name="description", length=4000)
    private String     description ;

    @Column(name="kind_a", nullable=false, length=128)
    private String     kindA ;

    @Column(name="kind_b", nullable=false, length=128)
    private String     kindB ;

    @Column(name="category_a")
    private Long       categoryA ;

    @Column(name="category_b")
    private Long       categoryB ;

    @Column(name="is_readonly", nullable=false)
    private Boolean    isReadonly ;

    @Column(name="code", nullable=false, length=128)
    private String     code ;

    @Column(name="position", nullable=false)
    private Integer    position ;

    @Column(name="reverse_name", nullable=false, length=255)
    private String     reverseName ;


    //--- ENTITY LINKS ( RELATIONSHIP )

    public RelationshipKind() {
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

    public void setKindA( String kindA ) {
        this.kindA = kindA ;
    }
    public String getKindA() {
        return this.kindA;
    }

    public void setKindB( String kindB ) {
        this.kindB = kindB ;
    }
    public String getKindB() {
        return this.kindB;
    }

    public void setCategoryA( Long categoryA ) {
        this.categoryA = categoryA ;
    }
    public Long getCategoryA() {
        return this.categoryA;
    }

    public void setCategoryB( Long categoryB ) {
        this.categoryB = categoryB ;
    }
    public Long getCategoryB() {
        return this.categoryB;
    }

    public void setIsReadonly( Boolean isReadonly ) {
        this.isReadonly = isReadonly ;
    }
    public Boolean getIsReadonly() {
        return this.isReadonly;
    }

    public void setCode( String code ) {
        this.code = code ;
    }
    public String getCode() {
        return this.code;
    }

    public void setPosition( Integer position ) {
        this.position = position ;
    }
    public Integer getPosition() {
        return this.position;
    }

    public void setReverseName( String reverseName ) {
        this.reverseName = reverseName ;
    }
    public String getReverseName() {
        return this.reverseName;
    }

    //--- GETTERS FOR LINKS
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
        sb.append(kindA);
        sb.append("|");
        sb.append(kindB);
        sb.append("|");
        sb.append(categoryA);
        sb.append("|");
        sb.append(categoryB);
        sb.append("|");
        sb.append(isReadonly);
        sb.append("|");
        sb.append(code);
        sb.append("|");
        sb.append(position);
        sb.append("|");
        sb.append(reverseName);
        return sb.toString(); 
    } 

}
