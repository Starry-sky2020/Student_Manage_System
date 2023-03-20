package com.starry_sky.yang;

import static org.junit.Assert.assertTrue;

import com.starry_sky.yang.View.impl.IntoSystem;
import com.starry_sky.yang.controller.ManageStudentControllerImpl;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.service.UserSubmitService;
import com.starry_sky.yang.service.impl.UserSubmitServiceImpl;
import com.starry_sky.yang.utils.Tools;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /**
     * 排序方法测试
     * @throws IOException
     */
    @Test
    public void testSort() throws IOException {
        ManageStudentControllerImpl manageStudentController = new ManageStudentControllerImpl();
        List<Student> studentList = manageStudentController.SortByStudetId();
        System.out.println(studentList);

    }

    /**
     * 导入学生信息查询
     * @throws IOException
     */
    @Test
    public void testimportStudentMeassage() throws IOException {
        ManageStudentControllerImpl manageStudentController = new ManageStudentControllerImpl();
        manageStudentController.ImportStudentMessage("src/main/resources/test.txt");
    }

    /**
     * 测试删除信息
     * @throws IOException
     */
    @Test
    public void testDeleteStudentMessage() throws IOException {
        ManageStudentControllerImpl manageStudentController = new ManageStudentControllerImpl();
        manageStudentController.DeleteStudentById("200860223");
    }

    @Test
    public void testTool(){
        Tools.checkInt("A");
    }

    @Test
    public void testUserSubmit(){
        UserSubmitServiceImpl submitService = new UserSubmitServiceImpl();
        Map<String,String> map = new HashMap<>();
        map.put("username","杨帅领");
        map.put("password","20222022");
        try {
            System.out.println(submitService.userSubmit(map));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
