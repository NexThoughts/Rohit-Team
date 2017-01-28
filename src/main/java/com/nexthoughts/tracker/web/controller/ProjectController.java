package com.nexthoughts.tracker.web.controller;

import com.nexthoughts.tracker.classes.IssueCommand;
import com.nexthoughts.tracker.classes.ProjectCommand;
import com.nexthoughts.tracker.model.Project;
import com.nexthoughts.tracker.model.User;
import com.nexthoughts.tracker.services.IssueService;
import com.nexthoughts.tracker.services.ProjectService;
import com.nexthoughts.tracker.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @Autowired
    ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView allProject() {


        List<ProjectCommand> projectCommandList = projectService.list();
        for (ProjectCommand projectCommand : projectCommandList) {
            System.out.println(projectCommand.getId());
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/list");
        modelAndView.addObject("projectList", projectCommandList);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createProjectForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/createProject");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView createProjectEditForm(@RequestParam int id) {
        Project project = projectService.read(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/editProject");
        modelAndView.addObject("project", project);
        return modelAndView;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateProject(ProjectCommand projectCommand) {
        projectService.update(projectCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView saveProject(ProjectCommand projectCommand) {

        int projectId = projectService.create(projectCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("projectCommand", projectCommand);


        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteProject(@RequestParam int id) {
        System.out.println("===============ID to delete====================");
        System.out.println(id);
        System.out.println("===================================");
        projectService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public ModelAndView addUserView(@RequestParam int id) {
        Set<User> users = projectService.users(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/addUser");
        modelAndView.addObject("users", users);
        return modelAndView;
    }


    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public ModelAndView searchUser(@RequestParam int id, @RequestParam("username") String username) {
        List<User> users = userService.searchUser(username);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project/searchResult");
        modelAndView.addObject("users", users);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView addUser(@RequestParam int id, @RequestParam("userId") String userId) {
        projectService.addUser((Integer) id, Long.parseLong(userId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:searchUser");
        modelAndView.addObject("id", id);
        return modelAndView;
    }
}
