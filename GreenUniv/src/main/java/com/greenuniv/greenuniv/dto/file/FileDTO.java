package com.greenuniv.greenuniv.dto.file;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.file.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO implements BaseDTO {

  private int id;
  private String location;

  @Override
  public FileEntity toEntity() {
    return FileEntity.builder()
        .id(id)
        .location(location)
        .build();
  }
}
