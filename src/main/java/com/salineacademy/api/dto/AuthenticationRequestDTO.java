package com.salineacademy.api.dto;

import lombok.Data;

//@Data Generates getters for all fields
@Data
public class AuthenticationRequestDTO {

  private String name;

  private String password;

}