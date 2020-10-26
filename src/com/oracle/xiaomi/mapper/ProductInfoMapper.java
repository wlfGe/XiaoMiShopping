package com.oracle.xiaomi.mapper;

import com.oracle.xiaomi.pojo.ProductInfo;
import com.oracle.xiaomi.pojo.ProductInfoExample;
import com.oracle.xiaomi.pojo.ProductType;
import com.oracle.xiaomi.pojo.vo.ProductInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductInfoMapper {
    int countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    int updateByExample(@Param("record") ProductInfo record, @Param("example") ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    public List<ProductInfo> getAllByVO(ProductInfoVO vo);
}