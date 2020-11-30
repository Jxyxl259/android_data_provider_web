package com.jiang.android.dao;

import com.jiang.android.entity.pojo.FoodInfo;

import java.util.List;

/**
 * @description:
 * @author: jiang
 * @create: 2020-11-30 18:23
 */
public interface FoodDao {

    List<FoodInfo> selectFoodList();

}
