package com.nexthoughts.tracker.web.controller;

import com.nexthoughts.tracker.classes.StudentCommand;
import com.nexthoughts.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("projects",userService.getProjects());
        modelAndView.addObject("issues",userService.getIssues());
        modelAndView.setViewName("dashboard/show");
        return modelAndView;
    }
}
