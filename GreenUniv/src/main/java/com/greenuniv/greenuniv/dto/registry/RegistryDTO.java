package com.greenuniv.greenuniv.dto.registry;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.student.StudentDTO;
import com.greenuniv.greenuniv.entity.registry.RegistryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistryDTO implements BaseDTO {

  private StudentDTO student;
  private RegistryLectureDTO registryLecture;

  @Override
  public RegistryEntity toEntity() {
    return RegistryEntity.builder()
        .student(student.toEntity())
        .registryLecture(registryLecture.toEntity())
        .build();
  }
}
