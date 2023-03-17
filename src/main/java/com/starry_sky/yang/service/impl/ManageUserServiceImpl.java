package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.ManageUserService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ManageUserServiceImpl implements ManageUserService {

//    private SystemViewImpl systemView = new SystemViewImpl();
    private ReadFile readFile = new ReadFile();

    /**
     * 管理员管理学生信息
     * 与用户功能重合
     */
//    @Override
//    public void ToUser() throws IOException {
//        Integer integer = systemView.ManageStudentSystemView();
//        systemView.ManageStudentMessage(integer);
//    }

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
    public void createManger(Manager manager) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Starry Sky\\Desktop\\Manager.txt",true));
        String message = manager.getId()+" "+manager.getManageName()+" "+manager.getManagePassword();
        bufferedWriter.write(message);
    }


}
