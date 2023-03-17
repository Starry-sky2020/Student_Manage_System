package com.starry_sky.yang;

import com.starry_sky.yang.controller.IntoSystemControllerImpl;

import java.io.IOException;


public class Main
{
    public static void main( String[] args ) throws IOException {

        IntoSystemControllerImpl intoSystemController = new IntoSystemControllerImpl();
        intoSystemController.MainView();

    }
}
