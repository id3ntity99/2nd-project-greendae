package com.greenuniv.greenuniv.dto.registry;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.entity.registry.RegistryLectureEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private LectureDTO lecture;
  private int registeredNumber;
  @CreationTimestamp
  private LocalDate registerDate;

  @Override
  public RegistryLectureEntity toEntity() {
    return RegistryLectureEntity.builder()
        .id(id)
        .lecture(lecture.toEntity())
        .registeredNumber(registeredNumber)
        .registerDate(registerDate)
        .build();
  }
}
