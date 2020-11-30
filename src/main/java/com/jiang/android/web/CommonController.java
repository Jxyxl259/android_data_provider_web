package com.jiang.android.web;

import com.jiang.android.entity.RemoteResult;
import com.jiang.android.entity.pojo.FoodInfo;
import com.jiang.android.service.food.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.jiang.android.utils.consts.ResultEnum.SUCCESS;

/**
 * @description:
 * @author: jiang
 * @create: 2020-11-30 17:25
 */
@RestController("/food")
public class CommonController {

    private static Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private FoodService foodService;

    @PostMapping("/foodlist")
    public RemoteResult fetchFoodList(){
        RemoteResult<List<FoodInfo>> res = new RemoteResult<>(false);
        log.info("fetchFoodList");
        List<FoodInfo> foods = foodService.queryFoodList();
        res.setSuccess(true);
        res.setT(foods);
        res.setResultCode(SUCCESS.code);
        log.info("fetchFoodList return:{}", res);
        return res;
    }



}
