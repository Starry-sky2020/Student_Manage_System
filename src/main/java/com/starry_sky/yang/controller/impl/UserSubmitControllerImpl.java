package com.starry_sky.yang.controller.impl;

import com.starry_sky.yang.controller.UserSubmitController;
import com.starry_sky.yang.service.impl.UserSubmitServiceImpl;

import java.io.IOException;
import java.util.Map;

public class UserSubmitControllerImpl implements UserSubmitController {

    private UserSubmitServiceImpl service = new UserSubmitServiceImpl();
    @Override
    public void userSubmit(Map<String, String> map) throws IOException {
        service.userSubmit(map);
    }
}
