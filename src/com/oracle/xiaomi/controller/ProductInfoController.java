package com.oracle.xiaomi.controller;

import com.github.pagehelper.PageInfo;
import com.oracle.xiaomi.pojo.ProductInfo;
import com.oracle.xiaomi.pojo.vo.ProductInfoVO;
import com.oracle.xiaomi.service.ProductInfoService;

import com.oracle.xiaomi.service.ProductTypeService;
import com.oracle.xiaomi.utils.FileNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductInfoController
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/5   11:15
 */
@Controller
@RequestMapping("/prod")
public class ProductInfoController {
    //设置页面大小
    public static final int PAGE_SIZE = 5;
    //将上传来的图片的名称，存到全局变量中，在增加商品时使用
    String saveFileName = "";
    //添加service对象
    @Autowired
    ProductInfoService productInfoService;

    //获取全部商品信息
    @RequestMapping("/getAll")
    public String getAll(Model model){
        //从业务层获取数据访问层中的商品信息
        List<ProductInfo> list = productInfoService.getAll();
        //将商品列表放入到model容器中
        model.addAttribute("plist",list);
        return "product";
    }

    //进行分页操作：打开商品管理和增加了商品进行分页
    @RequestMapping("/split")
    public String split(ProductInfoVO vo,Integer currentPage, Model model){
        if(currentPage!=null)
            vo.setPage(currentPage);
        PageInfo info = productInfoService.splitPageVO(vo,PAGE_SIZE);
        //将商品列表放入到model容器中
        model.addAttribute("info",info);
        return "product";
    }

    //文件上传：将商品图片上传到product.jsp页面上，实现异步刷新
    @ResponseBody
    @RequestMapping("/ajaxImg")
    public String ajaxImg(@RequestParam MultipartFile pimage, HttpServletRequest request){
        //创建存储的文件名
        saveFileName = FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
        System.out.println(saveFileName);
        //找到存储的路径
        String path = request.getServletContext().getRealPath("/image_big");
        System.out.println(path);
        //转存
        try {
            //File.separator
            pimage.transferTo(new File(path+File.separator+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saveFileName;
    }

    //增加新用户
    @RequestMapping("/save")
    public String save(ProductInfo info){
        info.setpDate(new Date());
        info.setpImage(saveFileName);
        productInfoService.save(info);
        saveFileName = "";
        //然后重定向到分页的页面，即对新的商品列表进行分页
        return "redirect:/prod/split.action";
    }

    @RequestMapping("/edit")
    public String edit(Integer pid,Integer currentPage,Model model){
        ProductInfo productInfo = productInfoService.getById(pid);
        model.addAttribute("prod",productInfo);
        model.addAttribute("currentPage",currentPage);
        return "update";
    }

    @RequestMapping("/update")
    public String update(ProductInfo info,Integer currentPage){
        info.setpDate(new Date());
        //更新时图片的判断
        if(!saveFileName.equals("")){
            info.setpImage(saveFileName);
        }
        productInfoService.update(info);
        return "redirect:/prod/split.action?currentPage="+currentPage;
    }

    @RequestMapping("/delete")
    public String delete(Integer pid,Integer currentPage,Model model){
        int num = productInfoService.delete(pid);
        if(num>0){
            //删除成功
            model.addAttribute("delmessage","删除成功！");
            return "forward:/prod/split.action?currentPage="+currentPage;
        }else {
            model.addAttribute("delmessage","删除失败！");
            return "forward:/prod/split.action?currentPage="+currentPage;
        }
    }

}
