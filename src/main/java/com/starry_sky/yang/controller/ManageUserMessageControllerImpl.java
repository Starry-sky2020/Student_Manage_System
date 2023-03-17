package com.starry_sky.yang.controller;

import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.impl.ManageUserServiceImpl;

import java.io.IOException;
import java.util.List;

public class ManageUserMessageControllerImpl {

    private ManageUserServiceImpl manageUserMessageService = new ManageUserServiceImpl();
//    @Override
//    public void ToUser() throws IOException {
//       manageUserMessageService.ToUser();
//    }

    public List<User> selectAllUser() throws IOException {
        return manageUserMessageService.selectAllUser();
    }

    public void deleteUserById(String id) throws IOException {
        manageUserMessageService.deleteUserById(id);
    }

    public void createManger(Manager manager) throws IOException {
        manageUserMessageService.createManger(manager);
    }
}
