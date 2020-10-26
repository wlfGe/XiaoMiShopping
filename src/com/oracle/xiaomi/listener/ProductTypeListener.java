package com.oracle.xiaomi.listener;

import com.oracle.xiaomi.pojo.ProductType;
import com.oracle.xiaomi.service.ProductTypeService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author 王龙飞
 * @version 1.0
 * @title: ProductTypeListener
 * @projectName XiaoMi_sxnd
 * @description:
 * @date 2020/1/6   11:06
 */
@WebListener
public class ProductTypeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //取出所有商品类型，并且放入全局作用域中，供项目在任何地方使用商品类型集合
        //监听器无法使用spring的依赖注入的功能，手动取出ProductTypeService对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
        //从bean工厂取出商品类型的业务实现类
        ProductTypeService productTypeService = (ProductTypeService)context.getBean("productTypeServiceImpl");
        //调用商品类型的service，取出所有集合
        List<ProductType> list = productTypeService.getAll();
        //取出全局作用域，将商品类型集合放入
        servletContextEvent.getServletContext().setAttribute("ptlist",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
