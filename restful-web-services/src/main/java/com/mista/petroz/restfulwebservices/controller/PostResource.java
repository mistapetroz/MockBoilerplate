package com.mista.petroz.restfulwebservices.controller;

import com.mista.petroz.restfulwebservices.model.PostDaoService;
import com.mista.petroz.restfulwebservices.model.Post;
import com.mista.petroz.restfulwebservices.exception.PostNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** @author mista */
@RestController
public class PostResource{

    @Autowired
    private PostDaoService postservice;
    
    @GetMapping(path="/users/{uid}/posts")
    public List<Post> retrieveAllPosts(@PathVariable int uid){
        List<Post> posts = postservice.AllUserPosts(uid);
        if (posts.isEmpty()){
            throw new PostNotFoundException("User has no posts.");
        }
        return posts;
    } 
    
    @PostMapping(path="/users/{uid}/posts")
    public Post createPost(@PathVariable int uid,@RequestBody Post post){
        List<Post> posts = postservice.AllUserPosts(uid);
        if(posts.isEmpty()){
            throw new PostNotFoundException("Post not found");
        }
        return postservice.Save(post);
        
    }
    
    @DeleteMapping(path="/users/{uid}/posts")
    public void deletePostById(@PathVariable int uid){
        Post post = postservice.deleteByUser(uid);
        if (post == null){
            throw new PostNotFoundException("Posts not found");
        }
    }
    
    @DeleteMapping(path="/users/{uid}/posts/{pid}")
    public void deletePosts(@PathVariable int uid, @PathVariable int pid){
        Post post = postservice.deleteById(pid);
        if(post == null){
            throw new PostNotFoundException("Post not found");
        }
    }
}
