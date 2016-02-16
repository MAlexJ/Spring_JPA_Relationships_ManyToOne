package com.malexj.repository;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by malex on 08.02.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
