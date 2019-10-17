package com.ex;

import com.ex.services.EmployeeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
         * Spring creates a BeanFactory or ApplicationContext
         * maintain the beans it will control
         *
         * BeanFactory is the original iteration of the container
         *   -- Lazy initializes beans
         *   -- Older
         *
         * ApplicationContext is the current iteration of the counter
         *  -- newer
         *  -- Eager bean initialization
         *  -- supports the newer modules (AOP, I18N, Cloud, ...)

         * ApplicationContext can be configured 3 ways throught XML
         *  -- ClassPathXmlApplicationContext - local project
         *  -- FileSystemXmlApplicationContext - local file system
         *  -- XmlWebApplicationContext - elsewhere
         * * */

        // Create a Classpath AC
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");

        // get the bean from the AC.
        // this bean is automatically created by the AC
        EmployeeService empService = (EmployeeService) applicationContext.getBean("employeeService");

        empService.authenticate();

        applicationContext.close();
    }
}
