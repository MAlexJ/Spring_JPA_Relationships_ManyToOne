package com.malexj.service;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.Orders;

import java.util.List;

/**
 * Created by malex on 08.02.16.
 */
public interface OrdersService {

    Orders save(Orders orders);

    Orders update(Orders orders);

    void delete(Long id);

    Orders findById(Long id);

    List<Orders> findAll();

}
