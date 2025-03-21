package com.greenuniv.greenuniv.entity.department;

import com.greenuniv.greenuniv.dto.department.CollegeDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@Table(name = "college")
@AllArgsConstructor
@NoArgsConstructor
public class CollegeEntity implements BaseEntity {

  @Id
  private int id;

  @Column(name = "name")
  private String name;

  @Override
  public CollegeDTO toDTO() {
    return CollegeDTO.builder()
        .id(id)
        .name(name)
        .build();
  }
}
