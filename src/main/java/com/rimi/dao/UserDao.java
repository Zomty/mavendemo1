package com.rimi.dao;

import com.rimi.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserDao {
    List<Student> getUserListDao(HashMap<String, Object> param);

    int getUsersCountWithParamDao(HashMap<String, Object> param);

    void deleteUserWithIdDao(String uid);

    boolean addUserDao(ArrayList<String> datas);
}
