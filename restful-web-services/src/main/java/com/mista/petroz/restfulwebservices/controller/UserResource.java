package com.mista.petroz.restfulwebservices.controller;

import com.mista.petroz.restfulwebservices.model.UserDaoService;
import com.mista.petroz.restfulwebservices.model.User;
import com.mista.petroz.restfulwebservices.exception.UserNotFoundException;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/**
 * @author mista
 */
@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    //GET /users
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //GET /users/id
    @GetMapping(path = "/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id -" + id);
        }
        
        //HATEOAS
        //"all-users", SERVER_PATH + "/users"
        //retrieveAllUsers & deleteUser
        Resource<User> resource = new Resource<User>(user);
        resource.add(linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users"));
        //resource.add(linkTo(methodOn(this.getClass()).deleteUser(id)).withRel("delete-user"));
        
        return resource;
    }

    //POST /users
    // in - user details
    // out - CREATED & response uri
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.Save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping(path = "/users/{id}")
    public User deleteUser(@PathVariable int id){
        User user = service.deleteUser(id);
        if (user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
