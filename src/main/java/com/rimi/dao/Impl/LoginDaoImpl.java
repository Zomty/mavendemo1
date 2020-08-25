package com.rimi.dao.Impl;

import com.rimi.bean.User;
import com.rimi.dao.LoginDao;
import com.rimi.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;

public class LoginDaoImpl implements LoginDao {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public boolean checkLoginInfoDao(HashMap<String, String> param) {
        String sql = "select * from user where phone=? and pass=?";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<>(User.class), param.get("phone"), param.get("pass"));
        if (query.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean RegisterDao(HashMap<String, String> map) {
        String search = "select * from user where phone=? and pass=?";
        List<User> query = template.query(search, new BeanPropertyRowMapper<>(User.class), map.get("phone"), map.get("pass"));
        if (query.size() > 0)
            return  false;
        String insert = "insert into user (phone,pass) values(?,?)";
        int row = template.update(insert, map.get("phone"), map.get("pass"));
        return row > 0;
    }
}
