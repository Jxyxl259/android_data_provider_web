package com.jiang.android.service.food;

import com.jiang.android.dao.FoodDao;
import com.jiang.android.entity.FoodInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: jiang
 * @create: 2020-11-30 18:20
 */
@Service("foodService")
public class FoodService {

    @Autowired
    private FoodDao foodDao;


    public List<FoodInfo> queryFoodList() {
        return foodDao.selectFoodList();
    }
}
