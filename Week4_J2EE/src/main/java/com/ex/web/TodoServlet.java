package com.ex.web;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class TodoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Calling service");
//        if (req.getMethod().equals("GET")){
//            //this just sends a plain text response
//            resp.getWriter().write("Here are your todos");
//            resp.setContentType("text/plain");
//            resp.setStatus(200);
//        }else if (req.getMethod().equals("POST")){
//            resp.getWriter().write("Creating your todo");
//            resp.setContentType("text/plain");
//            resp.setStatus(200);
//        }
    }

    @Override
    public void destroy() {
        System.out.println("Calling destroy");
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Calling init");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }
}
