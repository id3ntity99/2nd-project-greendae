package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegistryLectureMapperTest {

  @Autowired
  private RegistryLectureMapper mapper;

  @Test
  void testSelectAllRegistryLectures_success() {
    List<RegistryLectureDTO> lecture = mapper.selectAllRegistryLectures();
    for (RegistryLectureDTO lectureDTO : lecture) {
      System.out.println(lectureDTO);
    }
    Assertions.assertEquals(5, lecture.size());
  }
}