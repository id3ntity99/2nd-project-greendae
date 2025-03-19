package com.greenuniv.greenuniv.entity.user;

import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements BaseEntity {

  @Id
  private String id;

  @Column(name = "password")
  private String password;

  @Column(name = "name")
  private String name;

  @Column(name = "social_number")
  private String socialNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "contact")
  private String contact;

  @Column(name = "role")
  private String role;
  private boolean agreedTerms;

  @Column(name = "register_date")
  @CreationTimestamp
  private LocalDateTime registerDate;

  @Column(name = "leave_date")
  private LocalDateTime leaveDate;

  @Override
  public UserDTO toDTO() {
    return UserDTO.builder()
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
