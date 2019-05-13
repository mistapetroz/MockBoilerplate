package com.mista.petroz.restfulwebservices.controller;

import com.mista.petroz.restfulwebservices.model.Post;
import com.mista.petroz.restfulwebservices.exception.UserNotFoundException;
import com.mista.petroz.restfulwebservices.model.PostRepository;
import com.mista.petroz.restfulwebservices.model.User;
import com.mista.petroz.restfulwebservices.model.UserRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/** @author mista */
@RestController
public class PostJPAResource{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    
    @GetMapping(path="/jpa/users/{uid}/posts")
    public List<Post> retrieveAllPosts(@PathVariable int uid){
        Optional<User> userOptions = userRepository.findById(uid);
        if (!userOptions.isPresent()){
            throw new UserNotFoundException("Id " + uid);
        }
        return userOptions.get().getPosts();
    } 
    
    @PostMapping(path="/jpa/users/{uid}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int uid, @RequestBody Post post){
        Optional<User> optionalUser = userRepository.findById(uid);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("Id -" + uid);
        }
        User user = optionalUser.get();
        post.setUser(user);
        postRepository.save(post);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getPid()).toUri();
                
        return ResponseEntity.created(location).build();
        
    }
    
//    @DeleteMapping(path="/jpa/users/{uid}/posts")
//    public void deletePostById(@PathVariable int uid){
//        Post post = postservice.deleteByUser(uid);
//        if (post == null){
//            throw new PostNotFoundException("Posts not found");
//        }
//    }
//    
//    @DeleteMapping(path="/jpa/users/{uid}/posts/{pid}")
//    public void deletePosts(@PathVariable int uid, @PathVariable int pid){
//        Post post = postservice.deleteById(pid);
//        if(post == null){
//            throw new PostNotFoundException("Post not found");
//        }
//    }
}
