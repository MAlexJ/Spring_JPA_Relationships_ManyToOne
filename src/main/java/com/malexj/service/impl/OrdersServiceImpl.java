package com.malexj.service.impl;

import com.malexj.model.retrieveHibernateManyToOneBidirectional.Orders;
import com.malexj.repository.OrdersRepository;
import com.malexj.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by malex on 08.02.16.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository repository;

    @Override
    public Orders save(Orders orders) {
        return repository.saveAndFlush(orders);
    }

    @Override
    public Orders update(Orders orders) {
        return repository.saveAndFlush(orders);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Orders findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }
}
