package com.ex.controller;

import com.ex.Models.Like;
import com.ex.Models.Post;
import com.ex.Models.User;
import com.ex.persistence.LikeRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path="/like", method = { RequestMethod.GET, RequestMethod.POST })
public class LikeController {

    @Autowired
    private LikeRepo like;

    @PostMapping(path = "/create")
    public void createLike(@RequestBody String request) {
        ObjectMapper om = new ObjectMapper();
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Like likeData = null;
//        User use1 = new User();
//        use1.setId(2);
//        use1.setEmail("test@email");
//        use1.setUsername("username");
//        use1.setDisplayName("displayName");

        try{
           likeData = om.readValue(request, Like.class);
        like.likePost(likeData.getPost(),likeData.getUser());
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Like>> getAllLikes(@RequestParam String postId){

        return new ResponseEntity<>(like.getLikes(postId), HttpStatus.OK);
    }

    @DeleteMapping(path="/delete")
  public void unlikePost(@RequestParam String userId, @RequestParam String postId){
      like.deleteLike(userId, postId);
    }

}
