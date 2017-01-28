package com.nexthoughts.tracker.web.controller;

import com.nexthoughts.tracker.classes.Enums.MilestoneCommand;
import com.nexthoughts.tracker.model.Milestone;
import com.nexthoughts.tracker.services.MilestoneService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/milestone")
public class MilestoneController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(MilestoneController.class);

    private MilestoneService milestoneService;

    @Autowired
    MilestoneController(MilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView allMilestone() {
        List<MilestoneCommand> milestoneList = milestoneService.list();
        for (MilestoneCommand milestoneCommand : milestoneList) {
            System.out.println(milestoneCommand.getId());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("milestone/list");
        modelAndView.addObject("milestoneList", milestoneList);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createMilestoneForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("milestone/createMilestone");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView createMilestoneEditForm(@RequestParam() int id) {


        Milestone milestone = milestoneService.read(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("milestone/editMilestone");


        modelAndView.addObject("milestone", milestone);

        return modelAndView;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateMilestone(MilestoneCommand milestoneCommand) {

        milestoneService.update(milestoneCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView saveMilestone(MilestoneCommand milestoneCommand) {

        int milestoneId = milestoneService.create(milestoneCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("milestoneCommand", milestoneCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteMilestone(@RequestParam int id) {
        System.out.println("===============ID to delete====================");
        System.out.println(id);
        System.out.println("===================================");
        milestoneService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

}
