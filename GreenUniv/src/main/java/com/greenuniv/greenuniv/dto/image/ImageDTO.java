package com.greenuniv.greenuniv.dto.image;

import java.io.File;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {

  private int id;
  private File location;
  private File thumbnailLocation;

}
