package com.mista.petroz.restfulwebservices.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/** @author mista */
@Component
public class PostDaoService {
    
    private static final List<Post> posts = new ArrayList<>();
    
    static {
        posts.add(new Post(1,"The Example One","This is definitely the first example of a post"));
        posts.add(new Post(2,"The Example Two","This is definitely the second example of a post"));
        posts.add(new Post(3,"Three, Again","This is just another one i wonder why this posts lack characters"));
    }
    
    public List<Post> AllUserPosts(int uid){
        List<Post> userposts = new ArrayList<>();
//        for (Post post : posts){
//            if (post.getUserId() == uid){
//                userposts.add(post);
//            }
//        }
        return userposts;
    }
    
    public Post findOnePost(int uid, int pid){
//        for (Post post : posts){
//            if (post.getUserId() == uid && post.getPid() == pid){
//                return post;
//            }
//        }
        return null;
    }
    
    public Post Save(Post post){
        post.setPid(posts.size()+1);
        posts.add(post);
        return post;
    }
    
    public Post deleteByUser(int uid) {
        // Iterator<Post> iterator = posts.iterator();
        Post last_post = null;
//        while(iterator.hasNext()){
//            Post post = iterator.next();
//            if(post.getUserId()== uid){
//                iterator.remove();
//                last_post = post;
//            }
//        }
        return last_post;
    }

    public Post deleteById(int pid) {
//        Iterator<Post> iterator = posts.iterator();
//        while(iterator.hasNext()){
//            Post post = iterator.next();
//            if(post.getPid() == pid){
//                iterator.remove();
//                return post;
//            }
//        }
        return null;
    }
}
