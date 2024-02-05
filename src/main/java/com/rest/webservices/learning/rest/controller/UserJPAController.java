package com.rest.webservices.learning.rest.controller;

import com.rest.webservices.learning.rest.Exceptions.UserNotFoundException;
import com.rest.webservices.learning.rest.model.Post;
import com.rest.webservices.learning.rest.model.User;
import com.rest.webservices.learning.rest.repository.PostRepo;
import com.rest.webservices.learning.rest.repository.UserRepo;
import com.rest.webservices.learning.rest.userdao.userComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAController {
    @Autowired
    private PostRepo postrepo;

    @Autowired
    private UserRepo userRepo;

//    public UserController(userComponent usercom) {
//        this.usercom = usercom;
//    }

    @GetMapping("/jpa/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @GetMapping("/jpa/posts")
    public List<Post> getPosts(){
        return postrepo.findAll();
    }
    @GetMapping("/jpa/users/{uid}")
    public User findByuserByid(@PathVariable Integer uid){
        Optional<User> user = userRepo.findById(uid);
        if(user.isEmpty())
            throw new UserNotFoundException("user id not located:"+uid);
        return user.get();

    }
    @GetMapping("/jpa/users/{uid}/posts")
    public List<Post> postsOfAUser(@PathVariable("uid") Integer id){
        Optional<User> user=userRepo.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("user id not located:"+id);

        return user.get().getPost();
    }
//    @GetMapping("/jpa/users/{uid}/posts/{pid}")
//    public List<Post> postOfAUser(@PathVariable("uid") Integer id,@PathVariable("pid") int pid){
//        Optional<User> user=userRepo.findById(id);
//        Optional<Post> post=postrepo.findById(pid);
//        if(user.isEmpty())
//            throw new UserNotFoundException("user id not located:"+id);
//
//        return user.get().getPost().;
//    }

    @PostMapping("/jpa/addusers")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser= userRepo.save(user);
        URI loc= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{uid}")
                .buildAndExpand(savedUser.getUid()).toUri();
        //return ResponseEntity.created(null).build();
        return ResponseEntity.created(loc).build();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id,@RequestBody Post post){
        Optional<User> savedUser= userRepo.findById(id);
        if(savedUser.isEmpty())
            throw new UserNotFoundException("user id not located:"+id);
        post.setUser(savedUser.get());
        Post savedPost = postrepo.save(post);

        URI loc= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{uid}")
                .buildAndExpand(savedPost.getPid()).toUri();
        //return ResponseEntity.created(null).build();
        return ResponseEntity.created(loc).build();
    }

    @DeleteMapping("/jpa/deleteuser/{id}")
    public void deleteByUid(@PathVariable int id){
        userRepo.deleteById(id);

    }
    @PostMapping("/jpa/posts")
    public Post createPost(@RequestBody Post post){
        return postrepo.save(post);
    }
}

