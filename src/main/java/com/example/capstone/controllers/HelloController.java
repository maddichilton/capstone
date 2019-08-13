package com.example.capstone.controllers;

import com.example.capstone.models.AssignmentData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value="")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye";
    }

}
