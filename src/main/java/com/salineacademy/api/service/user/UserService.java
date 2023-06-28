package com.salineacademy.api.service.user;

import com.salineacademy.api.dto.SignupDTO;
import com.salineacademy.api.dto.UserDTO;


/**
 * Defines the contract for user services.
 * This interface specifies the operations and functionality related to user management.
 */
public interface UserService {
  
  /**
   * Creates a new user based on the provided signup information.
   *
   * @param signupDTO the DTO containing the user signup information
   * @return the created user DTO
   */
  UserDTO createUser(SignupDTO signupDTO);
  
  /**
   * Checks if a user with the specified email already exists.
   *
   * @param email the email to check
   * @return true if a user with the email exists, false otherwise
   */
  boolean hasUserWithEmail(String email);
}
