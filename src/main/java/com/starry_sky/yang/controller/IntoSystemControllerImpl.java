package com.starry_sky.yang.controller;

import com.starry_sky.yang.service.impl.IntoSystemServiceImpl;

import java.io.IOException;

public class IntoSystemControllerImpl{

    private IntoSystemServiceImpl intoSystemService = new IntoSystemServiceImpl();

    public void MainView() throws IOException {
        intoSystemService.MainView();
    }
}
