package com.nexthoughts.tracker.web.controller;

import com.nexthoughts.tracker.classes.StudentCommand;
import com.nexthoughts.tracker.model.Student;
import com.nexthoughts.tracker.model.User;
import com.nexthoughts.tracker.services.StudentService;
import com.nexthoughts.tracker.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView allStudents() {
        List<StudentCommand> studentList = studentService.list();
        for (StudentCommand studentCommand : studentList) {
            System.out.println(studentCommand.getId());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/list");
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createStudentForm() {
        logger.info("Executing GET method for /student/create");
        logger.info("==========================================");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/createStudent");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView createStudentEditForm(@RequestParam int id) {
        logger.info("Executing GET method for /student/edit");
        logger.info("==========================================");
        Student student = studentService.read(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/editStudent");
        modelAndView.addObject("student", student);
        return modelAndView;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateStudent(StudentCommand studentCommand) {
        logger.info("Executing POST method for /student/edit");
        logger.info("==========================================");
        studentService.update(studentCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView saveStudent(StudentCommand studentCommand) {
        logger.info("Executing POST method for /student/create");
        logger.info("==========================================");
        int studentId = studentService.create(studentCommand);
        logger.info("================Student Saved with Id - " + studentId + " ==========================");
        logger.info("==========================================");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("studentCommand", studentCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@RequestParam int id) {
        System.out.println("===============ID to delete====================");
        System.out.println(id);
        System.out.println("===================================");
        studentService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }
}
