package com.flutter.apiriva.controller;

import java.util.ArrayList;
import java.util.List;

import com.flutter.apiriva.entity.Escuela;
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
@RequestMapping("/escuelas")
public class EscuelaController {
    
    @Autowired
    private InterfaceService<Escuela> es;

    @GetMapping("/all")
    public ResponseEntity<List<Escuela>> getEscuela(){
        try {
            List<Escuela> ls = new ArrayList<>();
            ls = es.readAll();
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
	public ResponseEntity<Escuela> save(@Validated @RequestBody Escuela e){
		try {
			Escuela escuela = es.create(e);
			return new ResponseEntity<>(escuela, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Escuela> getEscuela(@PathVariable("id") int id){
		Escuela escuela = es.read(id);
			if(escuela.getId()>0) {
				return new ResponseEntity<>(escuela, HttpStatus.OK);
			}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			es.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Escuela> update(@RequestBody Escuela e, @PathVariable("id") int id){
		try {
			Escuela escuela = es.read(id);
			if(escuela.getId()>0) {
			    escuela.setNombre(e.getNombre());
				escuela.setFacultad(e.getFacultad());
				return new ResponseEntity<>(es.create(escuela),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

