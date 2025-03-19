package com.greenuniv.greenuniv.dao.mapper;

import com.greenuniv.greenuniv.entity.user.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenericMapperTest {

  @Autowired
  private GenericMapper<UserEntity, String> mapper;

  @Test
  void select_user_success() {

  }
}