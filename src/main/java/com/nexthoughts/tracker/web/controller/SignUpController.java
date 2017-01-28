package com.nexthoughts.tracker.web.controller;



import com.nexthoughts.tracker.classes.UserCommand;
import com.nexthoughts.tracker.services.StudentService;
import com.nexthoughts.tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

        modelAndView.setViewName("user/dashboard");

        return modelAndView;
    }


}

