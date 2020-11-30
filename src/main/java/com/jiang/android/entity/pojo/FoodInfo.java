package com.jiang.android.entity.pojo;

import java.io.Serializable;

/**
 * @description: 食物详情
 * @author: jiang
 * @create: 2020-11-30 17:27
 */
public class FoodInfo implements Serializable {

    /**
     * id 自增主键
     */
    private long id;

    /**
     * 图片连接
     */
    private String imgUrl;

    /**
     * 菜名
     */
    private String name;

    /**
     * 简介
     */
    private String content;

    public FoodInfo() {
    }

    public FoodInfo(String imgUrl, String name, String content) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FoodInfo{");
        sb.append("id=").append(id);
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
