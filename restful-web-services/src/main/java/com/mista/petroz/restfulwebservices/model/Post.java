package com.mista.petroz.restfulwebservices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

/**
 * @author mista
 */
@ApiModel(description="all details concerning a users post")
@Entity
public class Post {

    @ApiModelProperty(notes="Unique identifier of a post")
    @Id
    @GeneratedValue
    @javax.persistence.Id
    private int pid;
    
    @ApiModelProperty(notes="The Identifier of the User the post belongs to")
    @ManyToOne(fetch=FetchType.LAZY)
    private User user;
    @ApiModelProperty(notes="Brief overview")
    private String title;
    @ApiModelProperty(notes="Actual Post Content")
    private String content;

    public Post(){
        super();
    }
    
    public Post(int pid, String title, String content) {
        this.pid = pid;
        this.title = title;
        this.content = content;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" + "pid=" + pid + ", title=" + title + ", content=" + content + '}';
    }

}
