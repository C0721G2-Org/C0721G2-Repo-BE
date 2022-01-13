package com.c0721g2srsrealestatebe.service.realestatenews.impl;

import com.c0721g2srsrealestatebe.model.realestatenews.Direction;
import com.c0721g2srsrealestatebe.repository.realestatenews.IDirectionRepository;
import com.c0721g2srsrealestatebe.service.realestatenews.IDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements IDirectionService {
    @Autowired
    IDirectionRepository iDirectionRepository;


    @Override
    public List<Direction> directionList() {
        return iDirectionRepository.findAll();
    }
}