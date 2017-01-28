package com.nexthoughts.tracker.web.controller;


import com.nexthoughts.tracker.classes.LabelCommand;
import com.nexthoughts.tracker.model.Label;
import com.nexthoughts.tracker.services.LabelService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/label")
public class LabelController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(LabelController.class);

    private LabelService labelService;

    @Autowired
    LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView allLabel() {
        List<LabelCommand> labelList = labelService.list();
        for (LabelCommand labelCommand : labelList) {
            System.out.println(labelCommand.getId());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("label/list");
        modelAndView.addObject("labelList", labelList);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createLabelForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("label/createLabel");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView createLabelEditForm(@RequestParam int id) {
        Label label = labelService.read(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("label/editLabel");
        modelAndView.addObject("label", label);
        return modelAndView;
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView updateLabel(LabelCommand labelCommand) {
        labelService.update(labelCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView saveLabel(LabelCommand labelCommand) {

        int labelId = labelService.create(labelCommand);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        modelAndView.addObject("labelCommand", labelCommand);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteLabel(@RequestParam int id) {
        System.out.println("===============ID to delete====================");
        System.out.println(id);
        System.out.println("===================================");
        labelService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");
        return modelAndView;
    }

}
