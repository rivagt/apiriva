package com.flutter.apiriva.serviceImpl;

import java.util.List;

import com.flutter.apiriva.entity.Escuela;
import com.flutter.apiriva.repository.EscuelaRepository;
import com.flutter.apiriva.service.InterfaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscuelaImpl implements InterfaceService<Escuela>{
    @Autowired
    private EscuelaRepository er;

    @Override
    public List<Escuela> readAll() {
        return er.findAll();
    }

    @Override
    public Escuela create(Escuela t) {
        return er.save(t);
    }

    @Override
    public Escuela update(Escuela t) {
        return er.save(t);
    }

    @Override
    public Escuela read(int id) {
        return er.findById(id).get();
    }

    @Override
    public void delete(int id) {
        er.deleteById(id);
    }
}
