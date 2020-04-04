package com.sumansaurabh.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Users 
{
    private List<User> userList;
    
    public List<User> getUserList() {
        if(userList == null) {
            userList = new ArrayList<>();
        }
        return userList;
    }
 
    public void setUserList(List<User> employeeList) {
        this.userList = employeeList;
    }
}
