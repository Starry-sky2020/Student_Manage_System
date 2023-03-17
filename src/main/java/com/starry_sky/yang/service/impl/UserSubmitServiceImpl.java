package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.UserSubmitService;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserSubmitServiceImpl implements UserSubmitService {

    private ReadFile readFile = new ReadFile();
    /**
     * 用户注册服务
     * @param map
     */
    @Override
    public void userSubmit(Map<String, String> map) throws IOException {
        List<User> userList = readFile.selectUserMessage();

        for (int i = 0; i < userList.size(); i++){
            if (map.get("username").equals(userList.get(i).getUserName())){
                System.out.println("用户名已存在，退出系统，重新输入注册信息");
                System.exit(0);
            }
        }

        User user = new User();
        user.setUserName(map.get("username"));
        user.setUserPassword(map.get("password"));
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\Starry Sky\\Desktop\\User.txt"),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Starry Sky\\Desktop\\User.txt",true));
        bufferedWriter.write(UUID.randomUUID() +" "+user.getUserName()+" "+user.getUserPassword()+" "+user.isSex()+" "+user.getAge()+" "+user.getAddress());
        bufferedReader.close();
        bufferedWriter.close();
    }
}
