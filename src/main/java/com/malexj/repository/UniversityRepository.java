package com.malexj.repository;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.University;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by malex on 08.02.16.
 */
public interface UniversityRepository extends JpaRepository<University, Long> {
}
