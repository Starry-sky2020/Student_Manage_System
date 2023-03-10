package com.starry_sky.yang.controller.impl;

import com.starry_sky.yang.controller.IntoSystemController;
import com.starry_sky.yang.service.impl.IntoSystemServiceImpl;

import java.io.IOException;

public class IntoSystemControllerImpl implements IntoSystemController {

    private IntoSystemServiceImpl intoSystemService = new IntoSystemServiceImpl();
    @Override
    public void MainView() throws IOException {
        intoSystemService.MainView();
    }
}
