package com.starry_sky.yang;

import com.starry_sky.yang.controller.impl.IntoSystemControllerImpl;

import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException {

        IntoSystemControllerImpl intoSystemController = new IntoSystemControllerImpl();
        intoSystemController.MainView();

    }
}
