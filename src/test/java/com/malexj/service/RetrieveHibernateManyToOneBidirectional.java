package com.malexj.service;


import com.malexj.configuration.AppConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertEquals;

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
    public void testCreateUniversityWithStudent() {
        /**
         * - Создание University
         * - добавление 3х Student
         * - запись University в бД
         * */

        //given


        //when

        // then

    }





}
