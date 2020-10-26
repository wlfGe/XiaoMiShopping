package com.oracle.xiaomi.controller;

import com.oracle.xiaomi.pojo.ProductType;
import com.oracle.xiaomi.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductTypeController
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/8   22:07
 */
@Controller
@RequestMapping("/prodty")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping("/edit")
    public String edit(){

        productTypeService.update(new ProductType());
        return "";
    }

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<ProductType> list = productTypeService.getAll();
        model.addAttribute("list",list);
        return "prodtype";
    }
}

