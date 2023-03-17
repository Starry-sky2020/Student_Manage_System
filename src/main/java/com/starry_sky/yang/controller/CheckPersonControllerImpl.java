package com.starry_sky.yang.controller;

import com.starry_sky.yang.service.impl.CheckPersonServiceImpl;

import java.io.IOException;
import java.util.Map;

public class CheckPersonControllerImpl {

    private CheckPersonServiceImpl checkPersonServiceImpl = new CheckPersonServiceImpl();

    public Boolean UserLoginView(Map<String,String> map) throws IOException {
        return checkPersonServiceImpl.UserLoginView(map);
    }

    public Boolean ManagerLoginView(Map<String,String> map) throws IOException {
        return checkPersonServiceImpl.ManagerLoginView(map);
    }
}
