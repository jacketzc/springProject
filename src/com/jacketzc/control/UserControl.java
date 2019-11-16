package com.jacketzc.control;

import com.jacketzc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControl {
    @Autowired
    private UserService service;
    public void add(){
        service.add();
    }
}
