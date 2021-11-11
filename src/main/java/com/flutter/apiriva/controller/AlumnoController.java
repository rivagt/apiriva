package com.flutter.apiriva.controller;

import java.util.ArrayList;
import java.util.List;

import com.flutter.apiriva.entity.Alumno;
import com.flutter.apiriva.service.InterfaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private InterfaceService<Alumno> al;

    @GetMapping("/all")
    public ResponseEntity<List<Alumno>> getAlumno(){
        try {
            List<Alumno> ls = new ArrayList<>();
            ls = al.readAll();
            if (ls.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(ls, HttpStatus.OK);
            }
        } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
	public ResponseEntity<Alumno> save(@Validated @RequestBody Alumno a){
		try {
			Alumno alumno = al.create(a);
			return new ResponseEntity<>(alumno, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getalumno(@PathVariable("id") int id){
		Alumno alumno = al.read(id);
			if(alumno.getId()>0) {
				return new ResponseEntity<>(alumno, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			al.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Alumno> update(@RequestBody Alumno a, @PathVariable("id") int id){
		try {
			Alumno alumno = al.read(id);
			if(alumno.getId()>0) {
			    alumno.setNombres(a.getNombres());
				alumno.setApellidos(a.getApellidos());
				alumno.setCodigo(a.getCodigo());
				alumno.setIdescuela(a.getIdescuela());
				return new ResponseEntity<>(al.create(alumno),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
