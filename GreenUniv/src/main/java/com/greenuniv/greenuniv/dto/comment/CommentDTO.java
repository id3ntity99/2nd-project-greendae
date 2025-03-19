package com.greenuniv.greenuniv.dto.comment;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

  private int id;
  private UserDTO user;
  private ArticleDTO article;
  private String content;
  private String registerDate;
}
