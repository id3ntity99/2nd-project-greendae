package com.greenuniv.greenuniv.dto.user;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements BaseDTO {

  private String id;
  private String password;
  private String name;
  private String socialNumber;
  private String email;
  private String contact;
  private String role;
  private boolean agreed;

  @Override
  public UserEntity toEntity() {
    return UserEntity.builder()
        .id(id)
        .password(password)
        .name(name)
        .socialNumber(socialNumber)
        .email(email)
        .contact(contact)
        .role(role)
        .build();
  }
}
