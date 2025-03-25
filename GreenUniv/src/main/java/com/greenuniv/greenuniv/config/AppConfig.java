package com.greenuniv.greenuniv.config;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.registry.RegistryLectureDTO;
import com.greenuniv.greenuniv.service.DefaultGenericService;
import com.greenuniv.greenuniv.service.GenericService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.greenuniv.greenuniv")
@ComponentScan(basePackages = "com.greenuniv.greenuniv.dao")
public class AppConfig {

  @Bean
  public GenericService<RegistryLectureDTO, String> registryService(
      GenericMapper<RegistryLectureDTO, String> strategy) {
    return new DefaultGenericService<>(strategy);
  }
}
