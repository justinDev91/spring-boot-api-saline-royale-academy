package com.salineacademy.api.service.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.salineacademy.api.entities.User;
import com.salineacademy.api.repository.UserRepository;
import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findFirstByEmail(username);
    if (user == null)
      throw new UsernameNotFoundException("Username not found", null);
    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
        new ArrayList<>());
  }

}
