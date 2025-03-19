package com.greenuniv.greenuniv.dto.article;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.article.ArticleCategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleCategoryDTO implements BaseDTO {

  public static final String NOTICE = "notice";
  public static final String NEWS = "news";
  public static final String COLUMN = "column";
  public static final String EMPLOYMENT = "employment";
  public static final String BULLETIN = "bulletin";
  public static final String QNA = "qna";

  private String category;

  @Override
  public ArticleCategoryEntity toEntity() {
    return ArticleCategoryEntity.builder()
        .category(category)
        .build();
  }
}
