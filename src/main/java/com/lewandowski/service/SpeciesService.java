package com.lewandowski.service;

import com.lewandowski.entity.Species;

import java.util.List;

public interface SpeciesService {
    List<Species> findAll();
    Species findById(int id);
}
