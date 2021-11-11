package com.flutter.apiriva.serviceImpl;

import java.util.List;

import com.flutter.apiriva.entity.Alumno;
import com.flutter.apiriva.repository.AlumnoRepository;
import com.flutter.apiriva.service.InterfaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoImpl implements InterfaceService<Alumno>{
    @Autowired
    private AlumnoRepository alnrp;

    @Override
    public List<Alumno> readAll() {
        return alnrp.findAll();
    }

    @Override
    public Alumno create(Alumno t) {
        return alnrp.save(t);
    }

    @Override
    public Alumno update(Alumno t) {
        return alnrp.save(t);
    }

    @Override
    public Alumno read(int id) {
        return alnrp.findById(id).get();
    }

    @Override
    public void delete(int id) {
        alnrp.deleteById(id);
    }
}
