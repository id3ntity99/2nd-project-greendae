package com.greenuniv.greenuniv.dto.term;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.term.TermEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TermDTO implements BaseDTO {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String title;
  private String content;

  @Override
  public TermEntity toEntity() {
    return TermEntity.builder()
        .id(id)
        .title(title)
        .content(content)
        .build();
  }
}
