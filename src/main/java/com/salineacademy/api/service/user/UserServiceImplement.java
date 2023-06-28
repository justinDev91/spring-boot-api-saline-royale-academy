package com.salineacademy.api.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.salineacademy.api.dto.SignupDTO;
import com.salineacademy.api.dto.UserDTO;
import com.salineacademy.api.entities.User;
import com.salineacademy.api.repository.UserRepository;



@Service
public class UserServiceImplement implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO createUser(SignupDTO signupDTO) {

    User user = new User();
    
    user.setName(signupDTO.getName());
    user.setEmail(signupDTO.getEmail());
    user.setUserRole(UserRole.USER);
    user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
    
    User createdUser = userRepository.save(user);

    UserDTO userDTO = new UserDTO();
    
    userDTO.setId(createdUser.getId());
    userDTO.setName(createdUser.getName());
    userDTO.setEmail(createdUser.getEmail());
    userDTO.setUserRole(createdUser.getUserRole());
    return userDTO;
  }

  @Override
  public boolean hasUserWithEmail(String email) {
    if (email == null)
      throw new UnsupportedOperationException("Username email no found", null);
    return userRepository.findFirstByEmail(email) != null;
  }

}