package com.oracle.xiaomi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.xiaomi.mapper.ProductInfoMapper;
import com.oracle.xiaomi.pojo.ProductInfo;
import com.oracle.xiaomi.pojo.ProductInfoExample;
import com.oracle.xiaomi.pojo.vo.ProductInfoVO;
import com.oracle.xiaomi.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductInfoServiceImpl
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/5   11:40
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //添加关于商品的mapper对象
    @Autowired
    ProductInfoMapper productInfoMapper;

    //获取全部商品信息
    @Override
    public List<ProductInfo> getAll() {
        //不管是否有查询条件，都需要有条件类完成查询
        ProductInfoExample productInfoExample = new ProductInfoExample();
        return productInfoMapper.selectByExample(productInfoExample);
    }

    //进行分页的实现
    @Override
    public PageInfo splitPage(int page, int pageSize) {
        //实例化查询条件类
        ProductInfoExample productInfoExample = new ProductInfoExample();
        //为了在最前面显示最新显示新上线的商品，在这里进行排序操作，指定数据库中表的列名排序：倒序
        productInfoExample.setOrderByClause("p_id desc");
        //使用分页插件设置数据，要注意：在提取集合之前，一定要使用分页工具设置当前页和每页的记录数
        PageHelper.startPage(page,pageSize);
        List<ProductInfo> list = productInfoMapper.selectByExample(productInfoExample);
        //将查到的数据放到pageInfo工具类
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int save(ProductInfo info) {
        return productInfoMapper.insert(info);
    }

    @Override
    public ProductInfo getById(Integer pid) {
        return productInfoMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int update(ProductInfo info) {
        return productInfoMapper.updateByPrimaryKey(info);
    }

    @Override
    public int delete(Integer pid) {
        int num = -1;
        try {
            //如果删除成功，返回的num为受影响的数目
            num = productInfoMapper.deleteByPrimaryKey(pid);
        } catch (Exception e) {
            e.printStackTrace();
            //num= 0；
        }
        return num;
    }

    @Override
    public PageInfo<ProductInfo> splitPageVO(ProductInfoVO vo, int pageSize) {
        PageHelper.startPage(vo.getPage(),pageSize);
        List<ProductInfo> list = productInfoMapper.getAllByVO(vo);
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
