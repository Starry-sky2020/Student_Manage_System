package com.starry_sky.yang.controller;

import com.starry_sky.yang.View.impl.IntoSystem;
import com.starry_sky.yang.View.impl.SystemViewImpl;

import java.io.IOException;

public class IntoSystemControllerImpl{

    private IntoSystem intoSystem = new IntoSystem();

    public void MainView() throws IOException {
        intoSystem.IntoSystemView();
    }
}
