package com.starry_sky.yang.utils;

public class Tools {

    public static boolean checkInt(String str){
        boolean flg = true;
        try {
            Integer.parseInt(str);
        } catch (Exception e){
            flg = false;
        }
        return flg;
    }
}
