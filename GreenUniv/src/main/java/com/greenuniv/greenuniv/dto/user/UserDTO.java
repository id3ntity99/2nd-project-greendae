package com.greenuniv.greenuniv.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private String id;
  private String password;
  private String name;
  private String socialNumber;
  private String email;
  private String contact;
  private String role;
  private boolean agreed;
}
