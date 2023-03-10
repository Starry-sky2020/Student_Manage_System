package com.starry_sky.yang.controller;

import java.io.IOException;

public interface CheckPersonController {

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
    void ManagerLoginView() throws IOException;
}
