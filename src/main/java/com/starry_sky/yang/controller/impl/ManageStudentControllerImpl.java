package com.starry_sky.yang.controller.impl;

import com.starry_sky.yang.File.impl.ReadFileImpl;
import com.starry_sky.yang.controller.ManageStudentController;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.service.impl.ManageStudentServiceImpl;

import java.io.*;
import java.util.*;

public class ManageStudentControllerImpl implements ManageStudentController {

    private ManageStudentServiceImpl manageStudentService = new ManageStudentServiceImpl();

    /**
     * 查询所有学生
     * @return
     * @throws IOException
     */
    @Override
    public List<Student> selectAllStudent() throws IOException {
        return manageStudentService.selectAllStudent();
    }

    /**
     * 根据学号查询学生信息
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public Student selectStudetById(String id) throws IOException {
       return manageStudentService.selectStudetById(id);
    }

    /**
     * 更新学生信息
     * @param id
     * @param name
     * @param age
     * @param sex
     * @param school
     * @param address
     * @throws IOException
     */
    @Override
    public void UpdateStudentById(String id, String name, Integer age, Boolean sex, String school, String address)
            throws IOException {
        manageStudentService.UpdateStudentById(id,name,age,sex,school,address);
    }

    /**
     * 根据学生Id排序
     * 冒泡排序
     * @return
     * @throws IOException
     */
    @Override
    public List<Student> SortByStudetId() throws IOException {
       return manageStudentService.SortByStudetId();
    }

    /**
     * 导入数据
     * 将新数据导入到原始文件中
     * @param path
     * @throws IOException
     */
    @Override
    public void ImportStudentMessage(String path) throws IOException {
        manageStudentService.ImportStudentMessage(path);

    }

    /**
     * 插入学生信息
     * 根据Student参数，获取插入文件的信息
     * 将信息直接写（追加方式）到文件中
     * @param student
     * @throws IOException
     */
    @Override
    public void InsertStudentMessage(Student student) throws IOException {
        manageStudentService.InsertStudentMessage(student);
    }

    /**
     * 在列表中将元素删除
     * 重新写入到文件中
     * @param id
     * @throws IOException
     */
    @Override
    public void DeleteStudentById(String id) throws IOException {
       manageStudentService.DeleteStudentById(id);
    }

    /**
     * 退出系统
     */
    @Override
    public void BackwardSystem() {
        manageStudentService.BackwardSystem();
    }
}
