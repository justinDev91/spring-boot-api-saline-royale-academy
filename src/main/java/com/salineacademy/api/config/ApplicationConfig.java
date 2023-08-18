// package com.salineacademy.api.config;

// import lombok.RequiredArgsConstructor;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.salineacademy.api.user.UserRepository;

// /**
//  * Configuration class for application settings.
//  */
// @Configuration
// @RequiredArgsConstructor
// public class ApplicationConfig {
  
//   private final UserRepository repository;

//   /**
//    * Creates an instance of the UserDetailsService to load user-specific data during authentication.
//    *
//    * @return the UserDetailsService bean
//    */
//   @Bean
//   public UserDetailsService userDetailsService() {
//     return username -> repository.findByEmail(username)
//         .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//   }

//   /**
//    * Creates an instance of the AuthenticationProvider for authentication.
//    *
//    * @return the AuthenticationProvider bean
//    */
//   @Bean
//   public AuthenticationProvider authenticationProvider() {
//     DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//     authProvider.setUserDetailsService(userDetailsService());
//     authProvider.setPasswordEncoder(passwordEncoder());
//     return authProvider;
//   }

//   /**
//    * Creates an instance of the AuthenticationManager for authentication management.
//    *
//    * @param config the AuthenticationConfiguration
//    * @return the AuthenticationManager bean
//    * @throws Exception if an error occurs while creating the AuthenticationManager
//    */
//   @Bean
//   public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//     return config.getAuthenticationManager();
//   }

//   /**
//    * Creates an instance of the PasswordEncoder for encoding and decoding passwords.
//    *
//    * @return the PasswordEncoder bean
//    */
//   @Bean
//   public PasswordEncoder passwordEncoder() {
//     return new BCryptPasswordEncoder();
//   }

// }
