package com.sit.cloudnative.services.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(
    value = "/users",
    method = RequestMethod.GET
  )
  public ResponseEntity<List<User>> getUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }

  @RequestMapping(
    value = "/user",
    method = RequestMethod.POST
  )
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User user_object = userService.create(user);
    return new ResponseEntity<User>(user_object, HttpStatus.OK);
  }

   @RequestMapping(
     value = "/user/{user_id}",
     method = RequestMethod.GET
   )
   public ResponseEntity<User> getUser(@PathVariable("user_id") int id) {
     User user = userService.getUserById(id);
     return new ResponseEntity<User>(user, HttpStatus.OK);
   }
}