package com.mista.petroz.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;

/** @author mista */
@ApiModel(description="All details of a user")
//Making it an entity
@Entity
public class User {
    
    @Id
    @GeneratedValue
    @javax.persistence.Id
    @ApiModelProperty(notes="Unique identifier of a user")
    private Integer id;
    
    @Size(min = 2, message="Name should have at least 2 characters")
    @ApiModelProperty(notes="Name should have at least 2 characters")
    private String name;
    
    @Past
    @ApiModelProperty(notes="Birthdate must be in the past")
    private Date dob;
    
    @JsonIgnore
    @ApiModelProperty(notes="User Authorization Password Hidden")
    private String password;
    
    @ApiModelProperty(notes="Posts linkage")
    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Post> posts;

    protected User() {
    }
    
    public User(String name, Date dob) {
        super();
        this.name = name;
        this.dob = dob;
        this.password = "ChangeMeL8ter";
    }
    public User(int uid, String name, Date dob) {
        super();
        this.id = uid;
        this.name = name;
        this.dob = dob;
        this.password = "ChangeMeL8ter";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + id + ", name=" + name + ", dob=" + dob + '}';
    }
    
}
