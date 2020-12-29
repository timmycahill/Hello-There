package com.ex.controller;

import com.ex.Models.Comment;
import com.ex.Models.Like;
import com.ex.Models.Post;
import com.ex.Models.SignUpData;
import com.ex.persistence.CommentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@RestController
@RequestMapping(path="/comment", method = { RequestMethod.GET, RequestMethod.POST })
public class CommentController {

    @Autowired
    private CommentRepo comment;

    @PostMapping(path = "/create")
    public void createComment(@RequestBody String request){
        ObjectMapper om = new ObjectMapper();
        Comment data = null;
        try {
            data = om.readValue(request, Comment.class);
            comment.createComment(data.getAssociatedPost(), data.getAuthor(), data.getContent(),Date.valueOf(LocalDate.now()), Time.valueOf(LocalTime.now()));
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> getPostComments(@RequestParam String postId) throws JsonProcessingException {

        return new ResponseEntity<>(comment.getPostComments(postId), HttpStatus.OK);
    }



}
