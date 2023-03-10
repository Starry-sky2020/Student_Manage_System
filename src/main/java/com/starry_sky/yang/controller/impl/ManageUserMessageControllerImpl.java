package com.starry_sky.yang.controller.impl;

import com.starry_sky.yang.controller.ManageUserMessageController;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.impl.ManageUserServiceImpl;

import java.io.IOException;
import java.util.List;

public class ManageUserMessageControllerImpl implements ManageUserMessageController {

    private ManageUserServiceImpl manageUserMessageService = new ManageUserServiceImpl();
//    @Override
//    public void ToUser() throws IOException {
//       manageUserMessageService.ToUser();
//    }

    @Override
    public List<User> selectAllUser() throws IOException {
        return manageUserMessageService.selectAllUser();
    }

    @Override
    public void deleteUserById(String id) throws IOException {
        manageUserMessageService.deleteUserById(id);
    }

    @Override
    public void createManger(Manager manager) throws IOException {
        manageUserMessageService.createManger(manager);
    }
}
