package com.greenuniv.greenuniv.entity.registry;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import com.greenuniv.greenuniv.entity.lecture.LectureEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegistryLectureEntity implements BaseEntity {

  @Id
  @OneToOne(fetch = FetchType.LAZY)
  private LectureEntity lectureEntity;

  @Column(name = "registered_number")
  private int registeredNumber;

  @Column(name = "max_registered")
  private int maxRegistered;

  @Column(name = "register_date")
  private LocalDate registerDate;

  @Override
  public BaseDTO toDTO() {
    return null;
  }
}
