package com.rimi.web.servlet;

import com.alibaba.fastjson.JSON;
import com.rimi.bean.ResultVO;
import com.rimi.bean.Student;
import com.rimi.service.Impl.UserServiceImpl;
import com.rimi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HashMap<String, Object> param = new HashMap<>();
        int limit = Integer.parseInt(req.getParameter("limit"));
        int page = (Integer.parseInt(req.getParameter("page"))-1) * limit;

        param.put("page", page);
        param.put("limit", limit);

        List<Student> userlist = userService.getUserListService(param);

        int count = userService.getUsersCountWithParamService(param);
        // 将数据返回，返回的数据必须要安装layui要求的数据格式返回，并且是json格式
        ResultVO resultVO = new ResultVO(0, "", count, userlist);
        // 转换为json格式
        String json = JSON.toJSONString(resultVO);

        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
