package com.rimi.service;

import java.util.HashMap;

public interface LoginService {
    boolean checkLoginInfoService(HashMap<String, String> param);

    boolean RegisterService(HashMap<String, String> map);
}
