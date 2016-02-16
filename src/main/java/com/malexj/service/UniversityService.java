package com.malexj.service;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.University;

import java.util.List;

/**
 * Created by malex on 08.02.16.
 */
public interface UniversityService {

    University save(University university);

    University update(University university);

    void delete(Long id);

    University findById(Long id);

    List<University> findAll();

}
