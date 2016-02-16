package com.malexj.service.impl;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.University;
import com.malexj.repository.UniversityRepository;
import com.malexj.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 08.02.16.
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository repository;

    @Override
    public University save(University university) {
        return repository.saveAndFlush(university);
    }

    @Override
    public University update(University university) {
        return repository.saveAndFlush(university);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public University findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<University> findAll() {
        return repository.findAll();
    }
}
