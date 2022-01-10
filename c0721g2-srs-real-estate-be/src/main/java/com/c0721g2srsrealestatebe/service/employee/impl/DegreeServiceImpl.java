package com.c0721g2srsrealestatebe.service.employee.impl;

import com.c0721g2srsrealestatebe.model.employee.Degree;
import com.c0721g2srsrealestatebe.repository.employee.IDegreeRepository;
import com.c0721g2srsrealestatebe.service.employee.IDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DegreeServiceImpl implements IDegreeService {
    @Autowired
    IDegreeRepository iDegreeRepository;


    @Override
    public List<Degree> findAllDegree() {
        return iDegreeRepository.findAll();
    }

    @Override
    public Optional<Degree> findById(Long id) {
        return iDegreeRepository.findById(id);
    }
}
