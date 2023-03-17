package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.pojo.SubmitResult;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.UserSubmitService;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSubmitServiceImpl implements UserSubmitService {

    private ReadFile readFile = new ReadFile();
    private SubmitResult submitResult = new SubmitResult();
    /**
     * 用户注册服务
     * @param map
     */
    @Override
    public SubmitResult userSubmit(Map<String, String> map) throws IOException {
        List<User> userList = readFile.selectUserMessage();

        //正则验证用户名是否合法
        String regName = "^([\u4e00-\u9fa5a-zA-Z0-9]{2,12}$|([a-zA-Z]{2,16})$)";
        Pattern pattern = Pattern.compile(regName);
        Matcher matcher = pattern.matcher(map.get("username"));
        if (!matcher.find()){
            submitResult.setResult(false);
            submitResult.setMessage("用户名不合法，请重新输入");
            submitResult.setCode(SubmitResult.ERROR_CODE_1);
            return submitResult;
        }

        //正则验证用户密码是否合法
        String regPassword = "^(?=.*[0-9])|(?=.*[a-z])|(?=.*[A-Z])|(?=.*[@#$%^&+=])|(?=\\S+$).{4,20}$";
        pattern = Pattern.compile(regPassword);
        matcher = pattern.matcher(map.get("password"));
        if (!matcher.find()){
            submitResult.setResult(false);
            submitResult.setMessage("密码设置不合法，请重新输入");
            submitResult.setCode(SubmitResult.ERROR_CODE_2);
            return submitResult;
        }

        //用户名重复检测
        for (int i = 0; i < userList.size(); i++){
            if (map.get("username").equals(userList.get(i).getUserName())){
                submitResult.setResult(false);
                submitResult.setMessage("用户名已存在，请重新输入注册信息");
                submitResult.setCode(SubmitResult.ERROR_CODE_3);
                return submitResult;
            }
        }

        User user = new User();
        user.setUserName(map.get("username"));
        user.setUserPassword(map.get("password"));
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\Starry Sky\\Desktop\\User.txt"),"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Starry Sky\\Desktop\\User.txt",true));
        bufferedWriter.newLine();
        bufferedWriter.write(UUID.randomUUID() +" "+user.getUserName()+" "+user.getUserPassword()+" "+user.isSex()+" "+0+" "+"默认");
        bufferedReader.close();
        bufferedWriter.close();

        submitResult.setResult(true);
        submitResult.setMessage("用户注册成功");
        submitResult.setCode(SubmitResult.ERROR_CODE_4);

        return submitResult;
    }
}
