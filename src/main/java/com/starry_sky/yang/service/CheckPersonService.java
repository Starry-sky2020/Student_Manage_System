package com.starry_sky.yang.service;

import java.io.IOException;
import java.util.Map;

public interface CheckPersonService {
    /**
     * 用胡登录界面
     * @return
     * @throws IOException
     */
    Boolean UserLoginView(Map<String,String> map) throws IOException;

    /**
     * 管理员登录界面
     * @throws IOException
     */
    Boolean ManagerLoginView(Map<String,String> map) throws IOException;
}
