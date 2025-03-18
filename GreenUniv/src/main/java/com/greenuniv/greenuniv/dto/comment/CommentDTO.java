package com.greenuniv.greenuniv.dto.comment;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import java.io.IOException;
import java.io.InputStream;
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
  private InputStream content;
  private String registerDate;

  public String getContent() throws IOException {
    byte[] buf = content.readAllBytes();
    return new String(buf);
  }
}
