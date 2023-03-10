package com.starry_sky.yang.pojo;

public class Student {

    private String Id;
    private String name;
    private Integer age;
    private boolean sex;
    private String school;
    private String address;

    public Student(){

    }

    public Student(String id, String name, Integer age, boolean sex, String school, String address) {
        Id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.school = school;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", school='" + school + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
