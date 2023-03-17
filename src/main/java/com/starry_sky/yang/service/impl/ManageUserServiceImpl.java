package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.SubmitResult;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.ManageUserService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageUserServiceImpl implements ManageUserService {

    private ReadFile readFile = new ReadFile();

    @Override
    public List<User> selectAllUser() throws IOException {
        return readFile.selectUserMessage();
    }

    @Override
    public void deleteUserById(String id) throws IOException {
        List<User> userList = selectAllUser();

        User user = new User();

        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).getId().equals(id)){
                user = userList.get(i);
            }
        }
        userList.remove(user);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Starry Sky\\Desktop\\User.txt",false));
        bufferedWriter.write("id 姓名 密码 性别 年龄 地址");
        bufferedWriter.newLine();
        for (User user1 : userList){

            String sex;
            if (user1.isSex()) sex = "男";
            else sex = "女";
            String message = user1.getId()+" "+user1.getUserName()+" "+user1.getUserPassword()+" "+String.valueOf(user1.getAge())+" "
                    +sex+" "+user1.getAddress();

            bufferedWriter.write(message);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    @Override
    public SubmitResult createManger(Manager manager) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Starry Sky\\Desktop\\Manager.txt",true));
        SubmitResult submitResult = new SubmitResult();
        String message = manager.getId()+" "+manager.getManageName()+" "+manager.getManagePassword();
        //正则验证用户名是否合法
        String regName = "^([\u4e00-\u9fa5a-zA-Z0-9]{2,12}$|([a-zA-Z]{2,16})$)";
        Pattern pattern = Pattern.compile(regName);
        Matcher matcher = pattern.matcher(manager.getManageName());
        if (!matcher.find()){
            submitResult.setResult(false);
            submitResult.setMessage("用户名不合法，请重新输入");
            submitResult.setCode(SubmitResult.ERROR_CODE_1);
            return submitResult;
        }

        //正则验证用户密码是否合法
        String regPassword = "^(?=.*[0-9])|(?=.*[a-z])|(?=.*[A-Z])|(?=.*[@#$%^&+=])|(?=\\S+$).{4,20}$";
        pattern = Pattern.compile(regPassword);
        matcher = pattern.matcher(manager.getManagePassword());
        if (!matcher.find()){
            submitResult.setResult(false);
            submitResult.setMessage("密码设置不合法，请重新输入");
            submitResult.setCode(SubmitResult.ERROR_CODE_2);
            return submitResult;
        }

        List<Manager> managerList = readFile.selectManagerMessage();
        for (int i = 0; i < managerList.size(); i++){
            if (manager.getManageName().equals(managerList.get(i).getManageName())){
                submitResult.setResult(false);
                submitResult.setMessage("管理员已存在，请重新输入创建信息");
                submitResult.setCode(SubmitResult.ERROR_CODE_3);
                return submitResult;
            }
        }

        submitResult.setResult(true);
        submitResult.setMessage("创建管理员成功");
        submitResult.setCode(SubmitResult.ERROR_CODE_4);
        bufferedWriter.write(message);

        return submitResult;
    }
}
