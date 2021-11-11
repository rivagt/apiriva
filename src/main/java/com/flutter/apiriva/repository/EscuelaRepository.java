package com.flutter.apiriva.repository;

import com.flutter.apiriva.entity.Escuela;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Integer>{
    
}
