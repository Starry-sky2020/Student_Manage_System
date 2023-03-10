package com.starry_sky.yang.File;

import com.starry_sky.yang.pojo.Manager;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.pojo.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ReadFile {

    List<Student> selectStudentMessage() throws IOException;
    List<Manager> selectManagerMessage() throws IOException;
    List<User> selectUserMessage() throws IOException;

}
