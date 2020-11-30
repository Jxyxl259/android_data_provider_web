package com.jiang.android.web;

import com.jiang.android.entity.pojo.FoodInfo;
import com.jiang.android.service.food.FoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @description:
 * @author: jiang
 * @create: 2020-11-30 19:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext-spring.xml"})
public class FoodTest {

    public static Logger log = LoggerFactory.getLogger(FoodTest.class);

    @Autowired
    private FoodService foodService;

    @Test
    public void test_getFoodList(){
        List<FoodInfo> foodInfos = foodService.queryFoodList();
        log.info("all foodInfos:{}", foodInfos);

    }


}
