package com.greenuniv.greenuniv.entity.department;

import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity implements BaseEntity {

  @Id
  private int id;

  @ManyToOne
  @JoinColumn(name = "college_id")
  private CollegeEntity college;

  @Column(name = "name")
  private String name;

  @Column(name = "contact")
  private String contact;

  @Override
  public DepartmentDTO toDTO() {
    return DepartmentDTO.builder()
        .id(id)
        .college(college.toDTO())
        .name(name)
        .contact(contact)
        .build();
  }
}
