package com.rimi.service.Impl;

import com.rimi.dao.Impl.LoginDaoImpl;
import com.rimi.dao.LoginDao;
import com.rimi.service.LoginService;

import java.util.HashMap;

public class LoginServiceImpl implements LoginService {
    private LoginDao loginDao = new LoginDaoImpl();
    @Override
    public boolean checkLoginInfoService(HashMap<String, String> param) {
        return loginDao.checkLoginInfoDao(param);
    }

    @Override
    public boolean RegisterService(HashMap<String, String> map) {
        return loginDao.RegisterDao(map);
    }
}
