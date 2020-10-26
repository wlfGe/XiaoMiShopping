package com.oracle.xiaomi.service;

import com.github.pagehelper.PageInfo;
import com.oracle.xiaomi.pojo.ProductInfo;
import com.oracle.xiaomi.pojo.vo.ProductInfoVO;

import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductInfoService
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/5   11:13
 */
//查询全部商品信息
public interface ProductInfoService {
    //查询全部商品信息
    public List<ProductInfo> getAll();
    //实现分页处理
    public PageInfo splitPage(int page, int pageSize);
    //商品增加
    public int save(ProductInfo info);
    //根据主键查商品
    public ProductInfo getById(Integer pid);
    //更新商品
    public int update(ProductInfo info);
    //删除商品
    public int delete(Integer pid);
    //多条件查询分页
    public PageInfo<ProductInfo> splitPageVO(ProductInfoVO vo,int pageSize);
}
