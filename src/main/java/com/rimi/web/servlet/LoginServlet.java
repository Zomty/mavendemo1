package com.rimi.web.servlet;

import com.rimi.service.Impl.LoginServiceImpl;
import com.rimi.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("phonenumber");
        String password = req.getParameter("password");
        HashMap<String, String> param = new HashMap<>();
        param.put("phone", username);
        param.put("pass", password);

        LoginService loginService = new LoginServiceImpl();
        boolean logincheck = loginService.checkLoginInfoService(param);
        if (logincheck) {
            resp.setStatus(200);
        } else {
            resp.setStatus(403);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
