package com.oracle.xiaomi.service.impl;

import com.oracle.xiaomi.mapper.ProductTypeMapper;
import com.oracle.xiaomi.pojo.ProductType;
import com.oracle.xiaomi.pojo.ProductTypeExample;
import com.oracle.xiaomi.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductTypeServiceImpl
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/6   11:02
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    //添加ProductType的mapper对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    //获取全部商品种类
    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }

    //修改商品种类
    @Override
    public int update(ProductType productType) {
        return productTypeMapper.updateByPrimaryKey(productType);
    }

    //增加商品种类
    @Override
    public int insert(ProductType productType) {
        return productTypeMapper.insert(productType);
    }

    //删除商品种类
    @Override
    public int delete(Integer type_id) {
        return 0;
    }
}
