package com.nexthoughts.tracker.web.controller;

import com.nexthoughts.tracker.classes.IssueCommand;
import com.nexthoughts.tracker.model.Issue;
import com.nexthoughts.tracker.model.User;
import com.nexthoughts.tracker.services.IssueService;
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
@RequestMapping(value = "/issue")
public class IssueController {

    private final Logger logger = LoggerFactory.getLogger(IssueController.class);

    private IssueService issueService;

    @Autowired
    IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView allIssue() {
        List<IssueCommand> issueList = issueService.list();
        for (IssueCommand issueCommand : issueList) {
            System.out.println(issueCommand.getId());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("issue/list");
        modelAndView.addObject("issueList", issueList);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createIssueForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("issue/createIssue");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView createIssueEditForm(@RequestParam int id) {
        Issue issue = issueService.read(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("issue/editIssue");
        modelAndView.addObject("issue", issue);
        return modelAndView;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateIssue(IssueCommand issueCommand) {
        issueService.update(issueCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView saveIssue(IssueCommand issueCommand) {

        int issueId = issueService.create(issueCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("issueCommand", issueCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteIssue(@RequestParam int id) {
        System.out.println("===============ID to delete====================");
        System.out.println(id);
        System.out.println("===================================");
        issueService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

}
