package com.salineacademy.api.dto;

import com.salineacademy.api.service.user.enums.UserRole;
import lombok.Data;

@Data
public class SignupDTO {

  private String name;

  private String email;

  private String password;

  private UserRole userRole;
}