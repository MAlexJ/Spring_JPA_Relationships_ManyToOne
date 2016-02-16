package com.malexj.service;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.User;

import java.util.List;

/**
 * Created by malex on 08.02.16.
 */
public interface UserService {

    User save(User user);

    User update(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> findAll();

}
