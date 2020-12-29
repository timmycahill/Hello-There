package com.ex.controller;

import com.ex.Models.Friend;

import com.ex.Models.User;
import com.ex.persistence.FriendRepo;
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
@RequestMapping(path="/friend", method = { RequestMethod.GET, RequestMethod.POST })
public class FriendController {


    @Autowired
    private FriendRepo friend;


    /**]
     * this is a mapping to a method that creates friend record in the connected database
     */
    @PostMapping(path = "/create")
    public void createFriend(@RequestBody String request) {

        ObjectMapper om = new ObjectMapper();
        Friend friendData = null;
//        User use1 = new User();
//        use1.setId(1);
//        use1.setEmail("p@gmail.com");
//        use1.setUsername("rr2");
//        use1.setDisplayName("Pandas");
//
//        User use2 = new User();
//        use2.setId(2);
//        use2.setEmail("test@email");
//        use2.setUsername("username");
//        use2.setDisplayName("displayName");

        try{
            friendData = om.readValue(request, Friend.class);
            friend.addFriend(friendData.getUser(), friendData.getFriend());
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }


    /**
     * this is a mapping that calls a method that retrieves all of a user's friends from the database
     * @param userId this is the http request parameters being sent to the server
     * @return returns a list of friendship records
     * @throws JsonProcessingException
     */
    @GetMapping(path ="/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Friend>> getAllFriends(@RequestParam String userId) throws JsonProcessingException {

//        ObjectMapper om = new ObjectMapper();
//        User userData = null;
//
//        userData = om.readValue(request, User.class);

//        User user = new User();
//        user.setId(userData.getId());
//        user.setEmail(user.getEmail());
//        user.setUsername(user.getUsername());
//        user.setDisplayName(user.getDisplayName());


        return new ResponseEntity<>(friend.getAllF(userId), HttpStatus.OK);
    }



    }
