package com.rimi.web.servlet;

import com.rimi.service.Impl.UserServiceImpl;
import com.rimi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.function.Consumer;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String classname = request.getParameter("classname");
        String score = request.getParameter("score");
        ArrayList<String> datas = new ArrayList<>();
        Collections.addAll(datas, sname, gender,score, classname);

        UserService userService = new UserServiceImpl();
        boolean b = userService.addUserService(datas);
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
