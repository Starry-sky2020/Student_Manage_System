package com.starry_sky.yang.controller;

import com.starry_sky.yang.service.impl.CheckPersonServiceImpl;

import java.io.IOException;

public class CheckPersonControllerImpl {

    private CheckPersonServiceImpl checkPersonServiceImpl = new CheckPersonServiceImpl();

    public Boolean UserLoginView() throws IOException {
        return checkPersonServiceImpl.UserLoginView();
    }

    public void ManagerLoginView() throws IOException {
        checkPersonServiceImpl.ManagerLoginView();
    }
}
