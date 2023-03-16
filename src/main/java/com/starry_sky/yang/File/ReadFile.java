package com.starry_sky.yang.File;

import com.starry_sky.yang.pojo.CheckStudentFormatResult;
import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.pojo.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ReadFile {

    /**
     * 查询学生信息
     * @return
     * @throws IOException
     */
    List<Student> selectStudentMessage() throws IOException;

    /**
     * 查询管理员信息
     * @return
     * @throws IOException
     */
    List<Manager> selectManagerMessage() throws IOException;

    /**
     * 查询用户信息
     * @return
     * @throws IOException
     */
    List<User> selectUserMessage() throws IOException;

    /**
     * 外部文件（用户自定义输入文件）
     * 查询学生信息
     * @param filePath
     * @return
     * @throws IOException
     */
    List<Student> selectStudentMessage(String filePath) throws IOException;

    /**
     * 检查文件内容是否符合格式要求
     * @return
     */
    CheckStudentFormatResult checkStudentFormat(String filePath);
}
