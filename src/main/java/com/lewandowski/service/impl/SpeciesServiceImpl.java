package com.lewandowski.service.impl;

import com.lewandowski.entity.Species;
import com.lewandowski.repository.SpeciesRepository;
import com.lewandowski.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    @Autowired
    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    @Transactional
    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    @Override
    @Transactional
    public Species findById(int id) {
        return speciesRepository.findById(id);
    }
}
