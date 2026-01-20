package com.swipenow.swipenow.controller;

import com.swipenow.swipenow.entity.Friends;
import com.swipenow.swipenow.entity.User;
import com.swipenow.swipenow.service.UserService;
//import com.swipenow.swipenow.service.friendService;
import com.swipenow.swipenow.service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class endpoints {
    @Autowired
    private UserService userService;
    @Autowired
    private friendService friendService;


    @GetMapping("/profile/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        User user= userService.getUser(username);
        return ResponseEntity.ok(user);
    }


   @PostMapping("/update")
   public ResponseEntity<User> updateUser( @RequestBody User user){
       User users= userService.updateUser(user);
        return ResponseEntity.ok(users);
   }

   @PostMapping("/Register-User")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
   }



   @PostMapping("/Login-User")
    public User loginUser(@RequestBody User user) {

        return userService.loginUser(user);
   }

   @GetMapping("/All-User")
    public List<User> getAllUser(){
        return userService.getAllUser();
   }

    @PostMapping("/add-friends")
    public ResponseEntity<Friends> addFriends(@RequestBody Friends dto) {
        Friends saved = friendService.addFriends(dto);
        return ResponseEntity.ok(saved);
    }

//    @PostMapping("/remove-friends")
//    public ResponseEntity<Friends> removeFriends(@RequestBody Friends dto) {
//        Friends saved = friendService.removeFriends(dto);
//        return ResponseEntity.ok(saved);
//    }

    @GetMapping("/friends/check")
    public ResponseEntity<Boolean> checkFriendship(
            @RequestParam String username1,
            @RequestParam String username2) {
        boolean exists = friendService.areFriends(username1, username2);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/view_friends/{username}")
    public ResponseEntity<List<Friends>> getAllFriends(@PathVariable String username) {
        return ResponseEntity.ok(friendService.getAllFriends(username));
    }


}
