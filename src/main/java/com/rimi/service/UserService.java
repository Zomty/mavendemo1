package com.rimi.service;

import com.rimi.bean.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<Student> getUserListService(HashMap<String, Object> param);

    int getUsersCountWithParamService(HashMap<String, Object> param);

    void deleteUserWithId(String uid);

    boolean addUserService(ArrayList<String> datas);
}
