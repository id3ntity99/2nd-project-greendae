package com.greenuniv.greenuniv.dto.registry;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.entity.registry.RegistryLectureEntity;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistryLectureDTO implements BaseDTO {

  private LectureDTO lecture;
  private int registeredNumber;
  private int maxRegistered;
  @CreationTimestamp
  private LocalDate registerDate;

  @Override
  public RegistryLectureEntity toEntity() {
    return RegistryLectureEntity.builder()
        .lecture(lecture.toEntity())
        .registeredNumber(registeredNumber)
        .maxRegistered(maxRegistered)
        .registerDate(registerDate)
        .build();
  }
}
