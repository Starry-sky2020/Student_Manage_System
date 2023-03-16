package com.starry_sky.yang.controller;

import com.starry_sky.yang.pojo.ImportResult;
import com.starry_sky.yang.pojo.Student;

import java.io.IOException;
import java.util.List;

public interface ManageStudentController {

    /**
     * 查询所有学生信息
     * @return
     */
    List<Student> selectAllStudent() throws IOException;

    /**
     * 根据学生学号查询学生信息
     * @param id
     * @return
     */
    Student selectStudetById(String id) throws IOException;

    /**
     * 修改学生信息
     */
    void UpdateStudentById(String id, String name, Integer age, Boolean sex, String school, String address)
            throws IOException;

    /**
     * 根据学号进行排序
     */
    List<Student> SortByStudetId() throws IOException;

    /**
     * 导入学生信息
     */
    ImportResult ImportStudentMessage(String path) throws IOException;

    /**
     *  插入学生信息
     */
    void InsertStudentMessage(Student student) throws IOException;

    /**
     * 根据学号删除学生信息
     * 并在文件中删除特定行
     * @param id
     */
    void DeleteStudentById(String id) throws IOException;

    /**
     * 退出学生系统
     */
    void BackwardSystem();
}
