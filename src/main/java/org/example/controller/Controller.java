package org.example.controller;

import org.example.dto.Member;

import java.util.List;

public abstract class Controller {
    protected  static Member loginMember = null;

    public abstract void doAction(String cmd, String actionMethodName);


    public static boolean isLogined(){
        return loginMember != null;
    }

    public void makeTestData(){

    }
}
