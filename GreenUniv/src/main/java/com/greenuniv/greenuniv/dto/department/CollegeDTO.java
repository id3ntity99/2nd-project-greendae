package com.greenuniv.greenuniv.dto.department;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.department.CollegeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollegeDTO implements BaseDTO {

  private int id;
  private String name;

  @Override
  public CollegeEntity toEntity() {
    return CollegeEntity.builder()
        .id(id)
        .name(name)
        .build();
  }
}
