package com.greenuniv.greenuniv.dto;

/*
 * 작성자: id3ntity99(이현민)
 * 설명 : DTO 생성 및 메서드 유닛 테스트
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.greenuniv.greenuniv.dto.lecture.LectureDTO;
import com.greenuniv.greenuniv.dto.lecture.LectureDayDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DtoTests {

  @Test
  void createLectureDayDTO_withBuilder_success() {
    LectureDayDTO dto = LectureDayDTO.builder()
        .id(1)
        .day(LectureDayDTO.MONDAY)
        .lecture(new LectureDTO())
        .build();
    assertEquals(1, dto.getId());
    assertEquals(LectureDayDTO.MONDAY, dto.getDay());
    assertNotNull(dto.getLecture());
  }

  @Test
  void createLectureDayDTO_withIllegalWeekDay_fail() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      LectureDayDTO.builder()
          .id(1)
          .day("sunday")
          .lecture(new LectureDTO())
          .build();
    });
  }
}
