package com.greenuniv.greenuniv.entity.article;

import com.greenuniv.greenuniv.dto.article.ArticleCategoryDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class ArticleCategoryEntity implements BaseEntity {

  @Id
  private String category;

  @Override
  public ArticleCategoryDTO toDTO() {
    return ArticleCategoryDTO.builder()
        .category(category)
        .build();
  }
}
