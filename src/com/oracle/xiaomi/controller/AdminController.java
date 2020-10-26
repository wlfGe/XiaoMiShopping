package com.oracle.xiaomi.controller;

import com.oracle.xiaomi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: AdminController
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/5   10:06
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
//必须有service对象
    @Autowired
    AdminService adminService;
    //完成登录处理
    @RequestMapping("/login")
    public String login(String name, String pwd, Model model){
        boolean flag = adminService.login(name,pwd);
        if(flag){
            //将用户名添加到model对象，方便主页显示用户名
            model.addAttribute("adminName",name);
            return "main";
        }else{
            //将反馈信息添加到model对象，方便返回到登录页显示反馈信息
            model.addAttribute("error","用户名或密码不正确！");
            return "login";
        }
    }
}
