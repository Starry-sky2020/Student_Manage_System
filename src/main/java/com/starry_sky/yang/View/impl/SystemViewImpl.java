package com.starry_sky.yang.View.impl;

import com.starry_sky.yang.View.SystemView;
import com.starry_sky.yang.controller.ManageStudentController;
import com.starry_sky.yang.controller.ManageUserMessageController;
import com.starry_sky.yang.controller.impl.ManageStudentControllerImpl;
import com.starry_sky.yang.controller.impl.ManageUserMessageControllerImpl;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.pojo.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SystemViewImpl implements SystemView {

    private ManageStudentController manageStudentController = new ManageStudentControllerImpl();
    private ManageUserMessageControllerImpl manageUserMessageController = new ManageUserMessageControllerImpl();
    public Integer MainUI(){
        System.out.println("***************使用学生管理系统1.0V***************");
        System.out.println("1.登录系统");
        System.out.println("2.注册信息");
        System.out.println("3.退出系统");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        return choice;
    }

    @Override
    public Integer LoginUI() {
        System.out.println("***************使用学生管理系统1.0V***************");
        System.out.println("1.管理员账号登录");
        System.out.println("2.用户账号登录");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * 用户登录数据获取
     * @return
     */
    @Override
    public Map<String,String> UserLogin() {
        System.out.println("***************使用学生管理系统1.0V***************");
        System.out.println("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("请输入用户免密：");
        String password = scanner.nextLine();

        Map<String, String> userMessageMap = new HashMap<>();
        userMessageMap.put("username",username);
        userMessageMap.put("password",password);

        return userMessageMap;
    }

    /**
     * 管理员登录
     * @return
     */
    @Override
    public Map<String, String> ManagerLogin() {

        System.out.println("***************使用学生管理系统1.0V***************");
        System.out.println("请输入管理员姓名：");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("请输入管理员免密：");
        String password = scanner.nextLine();

        Map<String, String> userMessageMap = new HashMap<>();
        userMessageMap.put("managername",username);
        userMessageMap.put("password",password);

        return userMessageMap;
    }

    /**
     * 用户管理学生信息
     * @return
     */
    @Override
    public Integer ManageStudentSystemView() {

        System.out.println("***************使用学生管理系统1.0V***************");
        System.out.println("1.查看所有学生信息");
        System.out.println("2.查询学生信息");
        System.out.println("3.修改学生信息");
        System.out.println("4.根据学号删除学生信息");
        System.out.println("5.按照学号进行学生信息排序");
        System.out.println("6.导入学生信息");
        System.out.println("7.插入学生信息");
        System.out.println("8.退出系统");
        System.out.println("***************使用学生管理系统1.0V***************");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    @Override
    public void ManageStudentMessage(int choice) throws IOException {
        while(true){
            if (choice == 1){
                List<Student> studentList = manageStudentController.selectAllStudent();
                System.out.println(studentList);
            } else if (choice == 2) {
                System.out.println("请输入要查询学生的学号");
                Scanner scanner = new Scanner(System.in);
                String id = scanner.nextLine();
                Student student = manageStudentController.selectStudetById(id);
                System.out.println(student);
            } else if (choice == 3) {
                System.out.println("请输入要修改的学生信息:");
                Scanner scanner = new Scanner(System.in);
                System.out.print("学号：");
                String id = scanner.nextLine();
                System.out.print("姓名：");
                String name = scanner.nextLine();
                System.out.print("年龄：");
                String age = scanner.nextLine();
                System.out.print("性别：");
                String sex = scanner.nextLine();
                System.out.print("学校：");
                String school = scanner.nextLine();
                System.out.print("地址：");
                String address = scanner.nextLine();

                Boolean f = false;
                if (sex.equals("男")){
                    f = true;
                }

                manageStudentController.UpdateStudentById(id,name,Integer.valueOf(age),f,school,address);
            } else if (choice == 4) {
                System.out.println("请输入要删除的学生信息:");
                Scanner scanner = new Scanner(System.in);
                System.out.print("学号：");
                String id = scanner.nextLine();
                manageStudentController.DeleteStudentById(id);
            } else if (choice == 5) {
                List<Student> studentList = manageStudentController.SortByStudetId();
                System.out.println(studentList);
            } else if (choice == 6) {
                System.out.println("导入数据文件的路径:");
                Scanner scanner = new Scanner(System.in);
                String path = scanner.nextLine();

                manageStudentController.ImportStudentMessage(path);
            } else if (choice == 7) {
                System.out.println("请输入要插入的学生信息:");
                Scanner scanner = new Scanner(System.in);
                System.out.print("学号：");
                String id = scanner.nextLine();
                System.out.print("姓名：");
                String name = scanner.nextLine();
                System.out.print("年龄：");
                String age = scanner.nextLine();
                System.out.print("性别：");
                String sex = scanner.nextLine();
                System.out.print("学校：");
                String school = scanner.nextLine();
                System.out.print("地址：");
                String address = scanner.nextLine();

                Boolean f = false;
                if (sex.equals("男")){
                    f = true;
                }

                Student student = new Student(id, name, Integer.valueOf(age), f, school, address);
                manageStudentController.InsertStudentMessage(student);
            } else if (choice == 8) {
                manageStudentController.BackwardSystem();
            }

            System.out.println("请输入选择：");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        }

    }

    /**
     * 用户注册
     */
    @Override
    public Map<String,String> UserSubmit() {
        Map<String, String> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入注册用户的姓名：");
        String username = scanner.nextLine();
        System.out.println("请输入注册用户的密码：");
        String password = scanner.nextLine();

        hashMap.put("username",username);
        hashMap.put("password",password);

        return hashMap;
    }

    @Override
    public Integer ManageUserView() {

        System.out.println("***************学生信息管理系统管理员特权界面1.0V***************");
        System.out.println("1.管理学生信息");
        System.out.println("2.管理用户信息");
        System.out.println("3.创建管理账户");
        System.out.println("4.退出系统");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public Integer ManageUserMessageView() {
        System.out.println("***************学生信息管理系统管理员特权界面1.0V***************");
        System.out.println("1.查询所有用户");
        System.out.println("2.删除用户");
        System.out.println("3.返回上一层");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public void ManageUserMessage(Integer choice) throws IOException {
        while(true){
            if (choice == 1){
                List<User> userList = manageUserMessageController.selectAllUser();
                System.out.println(userList);
            } else if (choice == 2) {
                System.out.println("请输入删除用户Id");
                Scanner scanner = new Scanner(System.in);
                String id = scanner.nextLine();
                manageUserMessageController.deleteUserById(id);
            } else if (choice == 3) {
                ManageUserView();
            }
            System.out.println("请输入选择：");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        }
    }

    @Override
    public Manager createManager() {

        System.out.println("请输入创建的管理员信息");
        Manager manager = new Manager();

        Scanner scanner = new Scanner(System.in);
        String managerName = scanner.nextLine();
        String password = scanner.nextLine();

        return manager;
    }
}
