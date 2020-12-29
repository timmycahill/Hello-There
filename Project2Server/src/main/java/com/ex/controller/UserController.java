package com.ex.controller;

import com.ex.Models.SignUpData;
import com.ex.Models.User;
import com.ex.persistence.UserRepo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this class is a Bean that handles incoming requests for Friend information from the client side of the project
 */
@RestController
@RequestMapping(path="/user", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {


    @Autowired
    private UserRepo user;

//    /**
//     * This method gets all user records from the database
//     * @return returns a list of User Objects
//     */
//    @PostMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<List<User>> getAllUser() {
//        return new ResponseEntity<>(user.getAll(), HttpStatus.OK);
//    }

    @PostMapping(path="/create")
    public void createUser(@RequestBody String request) {
        ObjectMapper om = new ObjectMapper();
        SignUpData userData = null;
        try {
            userData = om.readValue(request, SignUpData.class);
            user.signUp(userData.getEmail(), userData.getUsername(), userData.getDisplayName(), userData.getPassword());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to see if a user has an existing account in the database
     * @param request this is the http request parameters being sent to the server
     * @return Returns the existing Account information if the user does exist and returns
     * an empty list if a user doesnt exist
     * @throws JsonProcessingException
     */
    @PostMapping(path="/login", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<User>> login(@RequestBody String request) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();

        SignUpData credentials = null;
        credentials = om.readValue(request, SignUpData.class);

        //returns a list containing an object
        return new ResponseEntity<>(user.checkUser(credentials.getUsername(), credentials.getPassword()), HttpStatus.OK);

    }

//    @PostMapping(path = "/update")
//    public void updateInfo(@RequestBody String request) throws JsonProcessingException {
//        ObjectMapper om = new ObjectMapper();
//
//        User credentials = null;
//        credentials = om.readValue(request, User.class);
//        user.updateInfo(credentials.getId(),credentials.getEmail(),credentials.getUsername(), credentials.getDisplayName(), credentials.getPassword());
//    }


}
