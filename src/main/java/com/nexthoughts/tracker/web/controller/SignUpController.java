package com.nexthoughts.tracker.web.controller;


import com.nexthoughts.tracker.classes.UserCommand;
import com.nexthoughts.tracker.model.User;
import com.nexthoughts.tracker.services.StudentService;
import com.nexthoughts.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/register")
public class SignUpController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createUser(UserCommand userCommand) {

        ModelAndView modelAndView = new ModelAndView();
        userService.create(userCommand);

        modelAndView.setViewName("redirect:/dashboard/show");
        modelAndView.addObject("welcomeMessage", "You have successfully Registered. Your verification is pending. Please check your inbox");


        return modelAndView;
    }

    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public ModelAndView verification(HttpServletRequest request) {

        String uuid = request.getParameter("uuid");
//        userService.enableAccount(uuid);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/dashboard/show");

//        modelAndView.addObject("welcomeMessage", "You are successfully Verified and your account is activated.");

        return modelAndView;
    }


}

