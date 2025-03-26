package com.greenuniv.greenuniv.service;

import com.greenuniv.greenuniv.dto.BaseDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface GenericService<T extends BaseDTO, K> {

  void insert(T dto);

  List<T> findAll();

  T findById(K id);

  void updateById(T dto);

  void delete(K id);
}
