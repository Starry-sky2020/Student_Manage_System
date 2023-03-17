package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.View.impl.SystemViewImpl;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.CheckPersonService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CheckPersonServiceImpl implements CheckPersonService {

    private ReadFile readFile = new ReadFile();
    /**
     * 用户登录信息验证
     * @throws IOException
     */
    public Boolean UserLoginView(Map<String,String> map) throws IOException {
        List<User> userList = readFile.selectUserMessage();
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getUserName().equals(map.get("username"))){
                if (userList.get(i).getUserPassword().equals(map.get("password"))){
                    System.out.println("登录成功");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 管理员登录信息验证
     * @throws IOException
     */
    public Boolean ManagerLoginView(Map<String,String> map) throws IOException {
        List<Manager> managerList = readFile.selectManagerMessage();
        for (int i = 0; i < managerList.size(); i++){

            if (managerList.get(i).getManageName().equals(map.get("managername"))){
                if (managerList.get(i).getManagePassword().equals(map.get("password"))){
                    System.out.println("管理员登录成功");
                    return true;
                }
            }
        }
        return false;
    }

}
