package com.starry_sky.yang.service;

import com.starry_sky.yang.pojo.SubmitResult;

import java.io.IOException;
import java.util.Map;

public interface UserSubmitService {

    /**
     * 用户注册
     * @param map
     * @return
     * @throws IOException
     */
    SubmitResult userSubmit(Map<String, String> map) throws IOException;
}
