package com.ex.controller;

import com.ex.Models.Post;
import com.ex.Models.User;
import com.ex.persistence.PostRepo;
import com.ex.persistence.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * this class is a Bean that handles incoming requests for information about Posts from the client side of the project
 */
@RestController
@RequestMapping(path="/post", method = { RequestMethod.GET, RequestMethod.POST })
public class PostController {

    @Autowired
    private PostRepo post;

    /**
     * This is a method that creates a post record in the database
     * @param request this is the http request parameters being sent to the server
     */
    @PostMapping(path = "/create")
    public void createPost(@RequestBody String request){
        ObjectMapper om = new ObjectMapper();
        Post userData = null;


//        person.setId(1);
//        person.setEmail("p@gmail.com");
//        person.setUsername("rr2");
//        person.setDisplayName("Pandas");
//        person.setPassword(0);
//        person.setAdmin(false);
//
//        post.createPost(person,"Hello", Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()),"Chipley", false);

        try{
            userData = om.readValue(request, Post.class);
            post.createPost(userData.getAuthor(), userData.getContent(), Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()), userData.getLocation(), userData.isFlagged());
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }

    }

    /**
     * This method gets all posts that exist within the database
     * @return All posts that exists within the database
     */
    @GetMapping(path ="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Post>> getPosts(){
        return new ResponseEntity<>(post.getAllPosts(), HttpStatus.OK);
    }



    /**
     * This method gets all posts made by a certain user.
     * @param request this is the http request parameters being sent to the server
     * @return returns all posts made by a certain user.
     * @throws JsonProcessingException
     */

    //@RequestParam needs to match what tim is giving you
    @GetMapping(path="/userPosts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Post>> getUPosts(@RequestParam String username) throws JsonProcessingException {

        System.out.println("Request: " + username);

        return new ResponseEntity<>(post.getUserPosts(username), HttpStatus.OK);

    }

    @PostMapping(path = "/update")
    public void updatePost(@RequestBody String request){

        ObjectMapper om = new ObjectMapper();
        Post userData = null;

        post.updatePost(3,"Die by the hands of Johnny Silverhand");

    }

    @PostMapping(path = "/flag")
    public void flagPost(){

        post.flag(3);

    }
}
