package com.oracle.xiaomi.pojo.vo;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductInfoVO
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/7   15:33
 */
public class ProductInfoVO {
    //查询的商品名称
    private String pname;
    //查询的商品类型ID
    private Integer typeid;
    //查询的最低价格
    private Integer lprice;
    //查询的最高价格
    private Integer hprice;
    //封装当前页数
    private Integer page=1;

    public ProductInfoVO() {
    }

    public ProductInfoVO(String pname, Integer typeid, Integer lprice, Integer hprice, Integer page) {
        this.pname = pname;
        this.typeid = typeid;
        this.lprice = lprice;
        this.hprice = hprice;
        this.page = page;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getLprice() {
        return lprice;
    }

    public void setLprice(Integer lprice) {
        this.lprice = lprice;
    }

    public Integer getHprice() {
        return hprice;
    }

    public void setHprice(Integer hprice) {
        this.hprice = hprice;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ProductInfoVO{" +
                "pname='" + pname + '\'' +
                ", typeid=" + typeid +
                ", lprice=" + lprice +
                ", hprice=" + hprice +
                ", page=" + page +
                '}';
    }
}
