package com.ex.services;

import com.ex.dao.Dao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmployeeServiceImpl implements EmployeeService, ApplicationContextAware,
        BeanNameAware, BeanFactoryAware, InitializingBean, BeanPostProcessor, DisposableBean {

    private Dao dao;

    // this could be used by spring to set this property if
    // the beans are configured to used setter injection
    public void setDao(Dao dao) {
        System.out.println("2. Setting the Dao reference in EmployeeServiceImpl");
        this.dao = dao;
    }

    public EmployeeServiceImpl() {
        System.out.println("1. Creating the instance of EmployeeServiceImpl#EmployeeServiceImp()");
    }

    // this could be used by spring to set this property if
    // the beans are configured to used constructor injection
    public EmployeeServiceImpl(Dao dao) {
        System.out.println("1. Creating the instance of the EmployeeServiceImpl#EmployeeServiceImp(Dao)");
        this.dao = dao;
    }

    @Override
    public void authenticate() {
        System.out.println("EmployeeService#authenticate");
        dao.getEmployeeById();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5. Set ApplicationContext " + applicationContext.toString());

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3. Setting Bean Name: " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4. Set BeanFactory " + beanFactory.toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6. After properties set");
    }

    public void customInit() {
        System.out.println("7. Custom Init");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("8. PreInit");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("9. PostInit");
        System.out.println("Bean ready to use");
        return null;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("10. Bean being destroyed");
    }

    public void customDestroy() {
        System.out.println("11. Custom destroy");
        System.out.println("Bean will be destroyed");
    }
}
