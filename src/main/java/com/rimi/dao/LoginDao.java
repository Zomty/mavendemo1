package com.rimi.dao;

import java.util.HashMap;

public interface LoginDao {
    boolean checkLoginInfoDao(HashMap<String, String> param);

    boolean RegisterDao(HashMap<String, String> map);
}
