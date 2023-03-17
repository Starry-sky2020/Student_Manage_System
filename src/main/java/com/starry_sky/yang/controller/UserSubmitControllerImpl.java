package com.starry_sky.yang.controller;

import com.starry_sky.yang.service.impl.UserSubmitServiceImpl;

import java.io.IOException;
import java.util.Map;

public class UserSubmitControllerImpl {

    private UserSubmitServiceImpl service = new UserSubmitServiceImpl();

    public void userSubmit(Map<String, String> map) throws IOException {
        service.userSubmit(map);
    }
}
