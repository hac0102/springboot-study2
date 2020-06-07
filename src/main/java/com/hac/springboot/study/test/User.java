package com.hac.springboot.study.test;

import lombok.Getter;

public class User {

    private String name;
    private String id;
    private UserDetail2 userDetail;

    @Getter
    public static class UserDetail2 {
        private String height;
        private String weight;
        private String hobby;
    }

    public User(){
        this.userDetail = userDetail;
    }

    public void test(int n){

    }

    public void test(){

    }

    public void test(String s){

    }



}
