package com.ex.revature.web;

import com.ex.revature.entities.Department;
import com.ex.revature.entities.EmployeeBean;
import com.ex.revature.entities.Role;
import com.ex.revature.entities.dto.EmployeeLoginDTO;
import com.ex.revature.entities.dto.EmployeeProfileDTO;
import com.ex.revature.services.JWTServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;

// Controllers will receive requests from the dispatcherservlet
// By default Controllers are used to map to serverside view like
// JSPs or JSFs
// Controller methods typically return a string that refers to a view name
// ("index" --> index.html, index.jsp, ...)
// Or Controller methods will return a ModelAndView which is the view name
// and view data encapsulated.
// Alternatively the Controller or method can be annotated with @ResponseBody
// which allows you to write directly to the response without being resolved to
// a view.
// A better annotation for this would be @RestController which include @Controller
// and @ResponseBody
@Controller
@ResponseBody
@RequestMapping("/user")
// /api/user
public class UserController {

    private JWTServices jwtServices;

    @Autowired
    public void setJwtServices(JWTServices jwtServices) {
        this.jwtServices = jwtServices;
    }

    // /api/user/
    // Controller methods are mapped to a 'path', one or more request 'method's, one or more
    // content-types ('consumes') and will 'produces' whatever is declared.
    // Controller (annotated with @ResponseBody) methods can return any type of object
    // and Spring will convert the object to the format declared by 'produces' that matches
    // the accepts header of the Request or will set the status to 415 (Unsupported Media Type)
    @RequestMapping(path="", method= {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeProfileDTO getCurrentUser() {
        EmployeeProfileDTO profile = new EmployeeProfileDTO();
        profile.setDepartment(Department.TRAINING);
        profile.setEmail("august.duet@revature.com");
        profile.setFirstName("August");
        profile.setLastName("Duet");

        return profile;
    }


    // /api/user/login
    // Spring sets the context for the controller method
    // any object in context can be injected into a controller method
    // PoJos, Services, HttpServletRequest, HttpServletResponse, HttpSession, ...
    @PostMapping(path="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void loginUser(@RequestBody EmployeeLoginDTO employee, HttpServletResponse resp) {
        // we would go through an authentication workflow and if everything was good,
        // we then use the jwtservice to create out token
        EmployeeBean emp = new EmployeeBean();
        emp.setId(1);
        emp.setEmail("august.duet@revature.com");
        emp.setFirstName("August");
        emp.setLastName("Duet");
        emp.setDept(Department.TRAINING);

        Role trainerRole = new Role();
        trainerRole.setId(2);
        trainerRole.setName("lead-trainer");
        emp.setRoles(new HashSet<Role>(Arrays.asList(new Role[]{trainerRole})));

        String token = jwtServices.build(emp);
        System.out.println(token);

        //create and add the cookie to the response
        Cookie userCookie = new Cookie("user", token);
        userCookie.setHttpOnly(true);

        resp.addCookie(userCookie);
    }

}
