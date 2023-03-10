package com.starry_sky.yang.service;

import java.io.IOException;
import java.util.Map;

public interface UserSubmitService {

    /**
     * 用户注册服务
     * @param map
     */
    void userSubmit(Map<String, String> map) throws IOException;
}
