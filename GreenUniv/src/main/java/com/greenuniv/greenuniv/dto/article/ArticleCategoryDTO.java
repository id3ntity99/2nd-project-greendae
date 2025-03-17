package com.greenuniv.greenuniv.dto.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleCategoryDTO {

  public static final String NOTICE = "notice";
  public static final String NEWS = "news";
  public static final String COLUMN = "column";
  public static final String EMPLOYMENT = "employment";
  public static final String BULLETIN = "bulletin";
  public static final String QNA = "qna";

  private String category;

}
