package com.starry_sky.yang.controller;

import java.io.IOException;
import java.util.Map;

public interface UserSubmitController {

    void userSubmit(Map<String,String> map) throws IOException;
}
