package com.starry_sky.yang.controller.impl;

import com.starry_sky.yang.View.impl.SystemViewImpl;
import com.starry_sky.yang.controller.CheckPersonController;
import com.starry_sky.yang.service.impl.CheckPersonServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class CheckPersonControllerImpl implements CheckPersonController {

    private CheckPersonServiceImpl checkPersonServiceImpl = new CheckPersonServiceImpl();
    @Override
    public Boolean UserLoginView() throws IOException {
        return checkPersonServiceImpl.UserLoginView();
    }

    @Override
    public void ManagerLoginView() throws IOException {
        checkPersonServiceImpl.ManagerLoginView();
    }
}
