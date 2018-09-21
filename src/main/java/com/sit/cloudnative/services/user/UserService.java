package com.sit.cloudnative.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // public User getUserById(Long user_id) {
  //   User user = userRepository.findById(user_id);
  //   return user;
  // }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
  
  public User getUserById(long userId) {
    return userRepository.findByUserId(userId);
  }

  public User create(User user) {
    return userRepository.save(user);
  }
}