package com.rimi.web.servlet;

import com.rimi.service.Impl.LoginServiceImpl;
import com.rimi.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----RegisterServlet-----");
        HashMap<String, String> map = new HashMap<>();
        String phone = request.getParameter("phonenumber");
        String pass = request.getParameter("password");
        map.put("phone", phone);
        map.put("pass", pass);
        LoginService loginService = new LoginServiceImpl();
        boolean b = loginService.RegisterService(map);
        if (b) {
            response.setStatus(200);
        } else {
            response.setStatus(403);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
