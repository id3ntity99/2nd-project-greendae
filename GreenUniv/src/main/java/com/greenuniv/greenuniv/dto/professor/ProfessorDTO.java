package com.greenuniv.greenuniv.dto.professor;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO implements BaseDTO {

  private String id;
  private UserDTO user;
  private DepartmentDTO department;
  private boolean isChief;

  @Override
  public ProfessorEntity toEntity() {
    return ProfessorEntity.builder()
        .id(id)
        .user(user.toEntity())
        .department(department.toEntity())
        .isChief(isChief)
        .build();
  }
}
