package com.salineacademy.api.authentification;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.el.parser.Token;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.salineacademy.api.dto.AuthenticationRequestDTO;
import com.salineacademy.api.entities.User;
import com.salineacademy.api.service.user.UserService;
import com.salineacademy.api.utils.JwtUtil;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AuthentificationController {

  @Autowired
  private UserService userService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService userDetailsService;

  // @Autowired
  // private UserRepository userRepository;

  @Autowired
  private JwtUtil jwtUtil;

  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";

   // creating a logger
   Logger logger = LoggerFactory.getLogger(AuthentificationController.class);

  @PostMapping("/login")
  public void createAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationRequest,
      HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException,
      IOException, JSONException, ServletException {

        logger.debug("test login: " + authenticationRequest);

      try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
            authenticationRequest.getPassword()));
      } catch (BadCredentialsException e) {
        throw new BadCredentialsException("Incorrect username or password.");
      } catch (DisabledException disabledException) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
        return;
      }

      final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
      // User user = userRepository.findFirstByEmail(userDetails.getUsername());
      final String jwt = jwtUtil.generateToken(userDetails.getUsername());

      response.getWriter().write(new JSONObject()
          .put("userId", 737)
          .toString());
      response.addHeader("Access-Control-Expose-Headers", "Authorization");
      response.addHeader("Access-Control-Allow-Headers",
          "Authorization, X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");
      response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
    }
  
}