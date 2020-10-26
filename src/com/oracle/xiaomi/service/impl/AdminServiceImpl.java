package com.oracle.xiaomi.service.impl;

import com.oracle.xiaomi.mapper.AdminMapper;
import com.oracle.xiaomi.pojo.Admin;
import com.oracle.xiaomi.pojo.AdminExample;
import com.oracle.xiaomi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: AdminServiceImpl
 * @projectName XiaoMi_sxnd
 * @description:登录业务的实现类
 * @date 2020/1/5   9:54
 */
//加@service的目的是为了让spring接管此类的对象的创建，并依赖注入给控制器
@Service
public class AdminServiceImpl implements AdminService {
    //注意；要有mapper接口对象，此对象由spring创建并注入
    @Autowired
    AdminMapper adminMapper;

    //判断登录是否成功
    @Override
    public boolean login(String name, String pwd) {
        boolean flag=false;
        //传入用户名，查到admin对象，取出对象中的密码与传来的密码进行比较，判断登录是否成功
        //创建一个封装条件的对象AdminExample
        AdminExample adminExample = new AdminExample();
        //添加用户名作为查找条件
        adminExample.createCriteria().andANameEqualTo(name);
        List<Admin> list =adminMapper.selectByExample(adminExample);
        if(list.size()>0){//当符合查询条件的列表中有对象时
            Admin admin = list.get(0);//获取列表中第一个元素
            if(admin.getaPass().equals(pwd)){//校验密码
                flag = true;
            }
        }
        return flag;
    }
}
