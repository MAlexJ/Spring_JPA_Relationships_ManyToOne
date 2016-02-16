package com.malexj.service;


import com.malexj.configuration.AppConfigTest;
import com.malexj.model.retrieveHibernateManyToOneBidirectional.Orders;
import com.malexj.model.retrieveHibernateManyToOneBidirectional.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
@WebAppConfiguration
public class RetrieveHibernateManyToOneBidirectional extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    @Test
    @Rollback
    public void testCreateUserWithoutOrders() {
        //given
        User user_01 = new User("Max", "3806623548");
        User user_02 = new User("Alex", "050852331");
        User user_03 = new User("Anna", "0663258455");

        //when
        User actualUser_01 = userService.save(user_01);
        User actualUser_02 = userService.save(user_02);
        User actualUser_03 = userService.save(user_03);

        // then
        assertEquals(user_01, actualUser_01);
        assertEquals(user_02, actualUser_02);
        assertEquals(user_03, actualUser_03);
    }

    @Test(expected = DataIntegrityViolationException.class)
    @Rollback
    public void testCreateOrdersWithoutUser() {
        //given
        Orders order = new Orders();
        order.setTitle("Товары для дома");
        order.setListGoods("Лопата, нож, вилка, ложка");

        //when
        ordersService.save(order);

        // then
        //Expect  - > DataIntegrityViolationException
    }

    @Test
    @Rollback
    public void testCreateUserOrder() {
        //given
        User user = new User("Max", "3806623548");
        User actualUser = userService.save(user);

        //when
        Orders order = new Orders();
        order.setTitle("Товары для дома");
        order.setListGoods("Лопата, нож, вилка, ложка");
        order.setUser(actualUser);

        Orders actualOrder = ordersService.save(order);
        // then
        assertEquals(user, actualUser);
        assertEquals(order, actualOrder);
    }

    @Test
    @Rollback
    public void testCreateUserOrders() {
        //given
        User user = new User("Max", "3806623548");
        User actualUser_01 = userService.save(user);

        // Orders #1.
        Orders order_01 = new Orders();
        order_01.setTitle("Товары для дома");
        order_01.setListGoods("Лопата, нож, вилка, ложка");
        order_01.setUser(actualUser_01);
        Orders actualOrder_01 = ordersService.save(order_01);

        // Orders #2.
        Orders order_02 = new Orders();
        order_02.setTitle("Товары для дома");
        order_02.setListGoods("Лопата, нож, вилка, ложка");
        order_02.setUser(actualUser_01);
        Orders actualOrder_02 = ordersService.save(order_02);

        // Orders #3.
        Orders order_03 = new Orders();
        order_03.setTitle("Товары для дома");
        order_03.setListGoods("Лопата, нож, вилка, ложка");
        order_03.setUser(actualUser_01);
        Orders actualOrder_03 = ordersService.save(order_03);

        //when
        List<Orders> expectOrders = new ArrayList<>();
        expectOrders.add(actualOrder_01);
        expectOrders.add(actualOrder_02);
        expectOrders.add(actualOrder_03);

        User actualUser = userService.findById(actualUser_01.getId());
        List<Orders> actualOrders = ordersService.findAll();
        // then
        assertEquals(user, actualUser);
        assertTrue(actualUser.getOrders()==null);  // TODO получить у пользователя лист Ордеров не возможно!!! null
        assertEquals(expectOrders, actualOrders);
    }

    @Test
    @Rollback
    public void testDeleteOrderToUser() {
        //given
        User user = new User("Max", "3806623548");
        User actualUser = userService.save(user);

        Orders order = new Orders();
        order.setTitle("Товары для дома");
        order.setListGoods("Лопата, нож, вилка, ложка");
        order.setUser(actualUser);
        Orders actualOrder = ordersService.save(order);

        //when
        ordersService.delete(actualOrder.getId());

        // then
        assertEquals(user, actualUser);
        assertEquals(userService.findAll().size(), 1);
    }


    @Test
    @Rollback
    public void testDeleteOrderToUser_01() {
        //given
        User user = new User("Max", "3806623548");
        User actualUser = userService.save(user);

        Orders order = new Orders();
        order.setTitle("Товары для дома");
        order.setListGoods("Лопата, нож, вилка, ложка");
        order.setUser(actualUser);
        Orders actualOrder = ordersService.save(order);

        Orders order_2 = new Orders();
        order_2.setTitle("Товары для дома");
        order_2.setListGoods("Лопата, нож, вилка, ложка");
        order_2.setUser(actualUser);
        Orders actualOrder_02 = ordersService.save(order_2);

        //when
        ordersService.delete(actualOrder.getId());

        // then
        assertEquals(user, actualUser);
        assertEquals(userService.findAll().size(), 1);
        assertEquals(ordersService.findAll().size(), 1);
        assertTrue(ordersService.findAll().contains(actualOrder_02));
    }

    @Test
    @Rollback
    public void testUpdateOrderToUser() {
        //given
        User user = new User("Max", "3806623548");
        User actualUser = userService.save(user);

        Orders order = new Orders();
        order.setTitle("Товары для дома");
        order.setListGoods("Лопата, нож, вилка, ложка");
        order.setUser(actualUser);
        Orders actualOrder = ordersService.save(order);

        Orders order_2 = new Orders();
        order_2.setTitle("Товары для дома");
        order_2.setListGoods("Лопата, нож, вилка, ложка");
        order_2.setUser(actualUser);
        Orders actualOrder_02 = ordersService.save(order_2);
        System.err.println(actualOrder_02.getId());

        //when
        ordersService.delete(actualOrder.getId());

        Orders updateOrder = ordersService.findById(actualOrder_02.getId());
        updateOrder.setTitle("New title");
        updateOrder.setListGoods("телефон");
        Orders actualUpdateOrder = ordersService.update(updateOrder);
        System.err.println(actualUpdateOrder.getId());

        // then
        assertEquals(user, actualUser);
        assertEquals(userService.findAll().size(), 1);
        assertEquals(ordersService.findAll().size(), 1);
        assertTrue(ordersService.findAll().contains(actualUpdateOrder));
    }


}
