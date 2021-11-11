package com.flutter.apiriva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "escuelas")
public class Escuela implements Serializable{
    private static final long serialVersionUID = -1457358047095434318L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idescuela")
    private int id;

    @Column(name ="nombre")
    private String nombre; //Ingenieria de Sistemas

    @Column(name = "facultad")
    private String facultad; //Facultad de Ingenieria y Arquitectura    
}
