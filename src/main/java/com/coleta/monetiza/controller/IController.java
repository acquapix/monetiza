package com.coleta.monetiza.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IController<T> {
   ResponseEntity<List<T>> getAll();
   ResponseEntity<Page<T>> getAll(Pageable pageable);
   ResponseEntity<?> get(Long id);
   ResponseEntity<T> post(T obj);
   ResponseEntity<?> put(T obj);
   ResponseEntity<?> patch(T obj);
   ResponseEntity<?> delete(Long id);
}
