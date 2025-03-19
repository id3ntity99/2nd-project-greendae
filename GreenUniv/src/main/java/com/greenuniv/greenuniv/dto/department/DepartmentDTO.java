package com.greenuniv.greenuniv.dto.department;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements BaseDTO {

  private int id;
  private String name;
  private String contact;

  @Override
  public DepartmentEntity toEntity() {
    return DepartmentEntity.builder()
        .id(id)
        .name(name)
        .contact(contact)
        .build();
  }
}
