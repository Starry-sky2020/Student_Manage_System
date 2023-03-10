package com.starry_sky.yang.pojo;


import lombok.Data;

@Data
public class User {

    private String id;
    private String UserName;
    private String userPassword;
    private Integer age;
    private boolean sex;
    private String address;

}
