package com.oracle.xiaomi.service;

import com.oracle.xiaomi.pojo.ProductType;

import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductTypeService
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/6   11:01
 */
public interface ProductTypeService {
    //查询所有的商品种类
    public List<ProductType> getAll();
    //修改商品种类
    public int update(ProductType productType);
    //增加商品种类
    public int insert(ProductType productType);
    //删除商品种类
    public int delete(Integer type_id);
}
