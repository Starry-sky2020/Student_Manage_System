package com.starry_sky.yang.service.impl;

import com.starry_sky.yang.File.ReadFile;
import com.starry_sky.yang.pojo.CheckStudentFormatResult;
import com.starry_sky.yang.pojo.ImportResult;
import com.starry_sky.yang.pojo.Student;
import com.starry_sky.yang.service.ManageStudentService;

import java.io.*;
import java.util.*;

public class ManageStudentServiceImpl implements ManageStudentService {
    private ReadFile readFile = new ReadFile();
    private List<Student> studentList;
    public ManageStudentServiceImpl() {
        try {
            studentList = readFile.selectStudentMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有学生
     * @return
     * @throws IOException
     */
    @Override
    public List<Student> selectAllStudent() throws IOException {
        return studentList;
    }

    /**
     * 根据学号查询学生信息
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public Student selectStudetById(String id) throws IOException {
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getId().equals(id)){
                return studentList.get(i);
            }
        }
        return null;
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
        Student student = selectStudetById(id);
        DeleteStudentById(id);

        if (name != null)
            student.setName(name);
        if (age != null)
            student.setAge(age);
        if (sex != null)
            student.setSex(sex);
        if (school != null)
            student.setSchool(school);
        if (address != null)
            student.setAddress(address);

        InsertStudentMessage(student);
    }

    /**
     * 根据学生Id排序
     * 冒泡排序
     * @return
     * @throws IOException
     */
    @Override
    public List<Student> SortByStudetId() throws IOException {
        for (int i = 0; i < studentList.size(); i++){
            for (int j = i + 1; j < studentList.size();j++){
                if (studentList.get(i).getId().compareTo(studentList.get(j).getId()) > 0 ){
                    //交换对象
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getId().compareTo(o2.getId());
                        }
                    });
                }
            }
        }

        return studentList;
    }

    /**
     * 导入数据
     * 将新数据导入到原始文件中
     * @param path
     * @throws IOException
     */
    @Override
    public ImportResult ImportStudentMessage(String path) throws IOException {

        ImportResult importResult = new ImportResult();

        //文件名为空
        if (path == null || path.equals("")){
            importResult.setResult(false);
            importResult.setCode(ImportResult.CODE_1);
            importResult.setMessage("文件名为空");
            return importResult;
        }

        //文件不存在
        if (!new File(path).exists()){
            importResult.setResult(false);
            importResult.setCode(ImportResult.CODE_2);
            importResult.setMessage("文件名不存在");
            return importResult;
        }

        //文件内容格式检查
        CheckStudentFormatResult checkStudentFormatResult = readFile.checkStudentFormat(path);
        if (checkStudentFormatResult.getFailCode().size() != 0){
            importResult.setResult(false);
            importResult.setCode(ImportResult.CODE_3);
            importResult.setMessage("文件内容格式不正确");
            return importResult;
        }

        List<Student> data = readFile.selectStudentMessage(path);

        for (int i = 0; i < data.size(); i++){
            /**
             * selectStudetById查询系统文件内的学生
             * 检验导入的学生是否已经存在在系统文件
             */
            if (selectStudetById(data.get(i).getId()) == null){
                importResult.getSuccessData().add(data.get(i));
            } else {
                importResult.getExistData().add(data.get(i));
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/student.txt",true));
        for (Student student : data){

            String sex;
            if (student.isSex()) sex = "男";
            else sex = "女";
            String message = student.getId()+" "+student.getName()+" "+String.valueOf(student.getAge())+" "
                    +sex+" "+student.getSchool()+" "+student.getAddress();

            bufferedWriter.write(message);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        importResult.setResult(true);
        importResult.setCode(0);
        importResult.setMessage("导入成功");

        return importResult;

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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/student.txt",true));
        String sex;
        if (student.isSex()) sex = "男";
        else sex = "女";
        String message = student.getId()+" "+student.getName()+" "+String.valueOf(student.getAge())+" "
                +sex+" "+student.getSchool()+" "+student.getAddress();
        bufferedWriter.write(message);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    /**
     * 在列表中将元素删除
     * 重新写入到文件中
     * @param id
     * @throws IOException
     */
    @Override
    public void DeleteStudentById(String id) throws IOException {
        List<Student> studentList = selectAllStudent();

        Student re_stu=null;
        for (Student student : studentList){
            if (student.getId().equals(id)){
                re_stu = student;
            }

        }
        studentList.remove(re_stu);


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/student.txt",false));
        bufferedWriter.write("学号 姓名 年龄 性别 学校 地址");
        bufferedWriter.newLine();
        for (Student student : studentList){

            String sex;
            if (student.isSex()) sex = "男";
            else sex = "女";
            String message = student.getId()+" "+student.getName()+" "+String.valueOf(student.getAge())+" "
                    +sex+" "+student.getSchool()+" "+student.getAddress();

            bufferedWriter.write(message);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    /**
     * 退出系统
     */
    @Override
    public void BackwardSystem() {
        System.exit(0);
    }
}
