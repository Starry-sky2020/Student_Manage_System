package com.starry_sky.yang.File.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileImpl implements ReadFile {

    /**
     * 查询学生信息
     */
    public List<Student> selectStudentMessage() throws IOException {


        List<Student> studentList = new ArrayList<>();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\Starry Sky\\Desktop\\student.txt"), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message;
        int lineNum = 0;

        while ((message = bufferedReader.readLine()) != null){
            Student student = new Student();
            String []studentArray = message.split(" ");

            if (lineNum == 0){
                lineNum++;
            } else {
                student.setId(studentArray[0]);
                student.setName(studentArray[1]);
                student.setAge(Integer.valueOf(studentArray[2]));
                if (studentArray[3].equals("男")){
                    student.setSex(true);
                } else student.setSex(false);

                student.setSchool(studentArray[4]);
                student.setAddress(studentArray[5]);
                studentList.add(student);
            }
        }
        bufferedReader.close();

        return studentList;
    }

    /**
     * 查询管理员信息
     * 主要用于账户匹配
     * @return
     * @throws IOException
     */
    @Override
    public List<Manager> selectManagerMessage() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\Starry Sky\\Desktop\\Manager.txt"), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = null;
        int linenum = 0;

        List<Manager> managerList = new ArrayList<>();

        while ((message = bufferedReader.readLine()) != null){
            Manager manager = new Manager();
            String []arrayManager = message.split(" ");

            if (linenum == 0) {
                linenum++;
            } else {
                manager.setId(arrayManager[0]);
                manager.setManageName(arrayManager[1]);
                manager.setManagePassword(arrayManager[2]);

                managerList.add(manager);
            }
        }

        bufferedReader.close();

        return managerList;
    }

    /**
     * 查询用户信息
     * 用于用户登录信息验证
     * @return
     * @throws IOException
     */
    @Override
    public List<User> selectUserMessage() throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("C:\\Users\\Starry Sky\\Desktop\\User.txt"), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = null;
        int lineNum = 0;

        List<User> userList = new ArrayList<>();


        while ((message = bufferedReader.readLine()) != null){
            User user = new User();
            String []arrayUser = message.split(" ");

            if (lineNum == 0){
                lineNum++;
            } else {
                user.setId(arrayUser[0]);
                user.setUserName(arrayUser[1]);
                user.setUserPassword(arrayUser[2]);

                if (arrayUser[3].equals("男")){
                    user.setSex(true);
                } else user.setSex(false);

                user.setAge(Integer.valueOf(arrayUser[4]));
                user.setAddress(arrayUser[5]);

                userList.add(user);
            }
        }
        bufferedReader.close();

        return userList;
    }
}
