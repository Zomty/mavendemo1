package com.rimi.service.Impl;

import com.rimi.bean.Student;
import com.rimi.dao.Impl.UserDaoImpl;
import com.rimi.dao.UserDao;
import com.rimi.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<Student> getUserListService(HashMap<String, Object> param) {
        return userDao.getUserListDao(param);
    }

    @Override
    public int getUsersCountWithParamService(HashMap<String, Object> param) {
        return userDao.getUsersCountWithParamDao(param);
    }

    @Override
    public void deleteUserWithId(String uid) {
        userDao.deleteUserWithIdDao(uid);
    }

    @Override
    public boolean addUserService(ArrayList<String> datas) {
        return userDao.addUserDao(datas);
    }
}
