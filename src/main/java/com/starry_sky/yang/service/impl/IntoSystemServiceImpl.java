package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.View.impl.SystemViewImpl;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.service.IntoSystemService;
import com.starry_sky.yang.service.ManageUserService;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class IntoSystemServiceImpl implements IntoSystemService {

    private SystemViewImpl systemViewImpl = new SystemViewImpl();
    private CheckPersonServiceImpl systemViewService = new CheckPersonServiceImpl();
    private UserSubmitServiceImpl service = new UserSubmitServiceImpl();
    private ManageUserService manageUserMessageService = new ManageUserServiceImpl();


        /**
         * 进入系统
         */
        @Override
        public void MainView() throws IOException {
            int choice = systemViewImpl.MainUI();
            if (choice == 1){
                Integer identity = systemViewImpl.LoginUI();
                if (identity == 2){
                    // 用户登录进行信息验证
                    if (systemViewService.UserLoginView()){
                        Integer manageStudentSystem = systemViewImpl.ManageStudentSystemView();

                        while (manageStudentSystem > 8 && manageStudentSystem < 0){
                            System.out.println("输入编号有误，请重新输入：");
                            Scanner scanner = new Scanner(System.in);
                            manageStudentSystem = scanner.nextInt();
                        }
                        //数据直接传到视图
                        systemViewImpl.ManageStudentMessage(manageStudentSystem);
                    }
                } else if (identity == 1) {
                    // 管理员登录进行信息验证
                    if (systemViewService.ManagerLoginView()) {
                        Integer manageUserMessageView = systemViewImpl.ManageUserView();
                        while (manageUserMessageView > 4 && manageUserMessageView < 0){
                            System.out.println("输入编号有误，请重新输入：");
                            Scanner scanner = new Scanner(System.in);
                            manageUserMessageView = scanner.nextInt();
                        }

                        if (manageUserMessageView == 1){
                            Integer view = systemViewImpl.ManageStudentSystemView();
                            systemViewImpl.ManageStudentMessage(view);
                        } else if (manageUserMessageView == 2){
                            Integer manageUserMessageView1 = systemViewImpl.ManageUserMessageView();
                            systemViewImpl.ManageUserMessage(manageUserMessageView1);
                        } else if (manageUserMessageView == 3) {
                            Manager manager = systemViewImpl.createManager();
                            manageUserMessageService.createManger(manager);
                        } else if (manageUserMessageView == 4){
                            System.exit(0);
                        }
                    }


                }
            } else if (choice == 2) {
                Map<String, String> map = systemViewImpl.UserSubmit();
                service.userSubmit(map);

            } else if (choice == 3) {
                System.out.println("正在退出系统。。。");
                System.exit(0);
            }

        }

}
