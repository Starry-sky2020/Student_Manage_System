package com.starry_sky.yang.service;

import java.io.IOException;

public interface CheckPersonService {
    /**
     * 用胡登录界面
     * @return
     * @throws IOException
     */
    Boolean UserLoginView() throws IOException;

    /**
     * 管理员登录界面
     * @throws IOException
     */
    Boolean ManagerLoginView() throws IOException;
}
