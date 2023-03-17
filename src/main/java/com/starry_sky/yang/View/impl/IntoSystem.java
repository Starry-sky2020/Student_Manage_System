package com.starry_sky.yang.View.impl;

import com.starry_sky.yang.controller.CheckPersonControllerImpl;
import com.starry_sky.yang.controller.ManageStudentControllerImpl;
import com.starry_sky.yang.controller.ManageUserMessageControllerImpl;
import com.starry_sky.yang.controller.UserSubmitControllerImpl;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.SubmitResult;

import java.io.IOException;
import java.util.Map;

public class IntoSystem {

    private SystemViewImpl systemView = new SystemViewImpl();
    private ManageUserMessageControllerImpl manageUserMessageController = new ManageUserMessageControllerImpl();
    private CheckPersonControllerImpl personController = new CheckPersonControllerImpl();
    private UserSubmitControllerImpl submitController = new UserSubmitControllerImpl();

    public void IntoSystemView() {
        int choice = systemView.MainUI();
        if (choice == 1){
            Integer identity = systemView.LoginUI();
            if (identity == 1) {
                // 管理员登录进行信息验证
                try {
                    Boolean aBoolean = personController.ManagerLoginView(systemView.ManagerLogin());
                    while (true){
                        if (aBoolean){
                            Integer manageUserView = systemView.ManageUserView();
                            if (manageUserView == 1){  //管理学生信息
                                Integer view = systemView.ManageStudentSystemView();
                                systemView.ManageStudentMessage(view);
                            } else if (manageUserView == 2){ //管理用户信息
                                Integer manageUserMessageView = systemView.ManageUserMessageView();
                                systemView.ManageUserMessage(manageUserMessageView);
                            } else if (manageUserView == 3) { //创建管理员
                                Manager manager = systemView.createManager();
                                manageUserMessageController.createManger(manager);
                            } else if (manageUserView == 4){ //退出系统
                                System.exit(0);
                            }
                            break;
                        } else {
                            System.out.println("管理员账号有误，请重新输入");
                            aBoolean = personController.ManagerLoginView(systemView.ManagerLogin());
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (identity == 2){
                // 用户登录进行信息验证
                try {
                    Boolean aBoolean = personController.UserLoginView(systemView.UserLogin());
                    while (true){
                        if (aBoolean){
                            Integer manageStudentSystem = systemView.ManageStudentSystemView();
                            //数据直接传到视图
                            systemView.ManageStudentMessage(manageStudentSystem);
                            break;
                        } else {
                            System.out.println("输入账号错误，请重新输入");
                            aBoolean = personController.UserLoginView(systemView.UserLogin());
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (choice == 2) {
            Map<String, String> map;
            SubmitResult submitResult = new SubmitResult();
            try {
                do {
                    map = systemView.UserSubmit();
                    submitResult = submitController.userSubmit(map);
                    System.out.println(submitResult);
                } while (submitResult.getCode() != 4);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (choice == 3) {
            System.out.println("正在退出系统...");
            System.exit(0);
        }
    }
}
