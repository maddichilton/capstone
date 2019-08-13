package com.example.capstone.controllers;

import com.example.capstone.models.Assignment;
import com.example.capstone.models.AssignmentData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("assignment")
public class AssignmentController {

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("assignments", AssignmentData.getAll());
        model.addAttribute("title", "Current Assignments");

        return "assignment/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAssignmentForm(Model model) {
        model.addAttribute("title", "Add Assignment");
        model.addAttribute(new Assignment());
        return "assignment/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAssignmentForm(@ModelAttribute @Valid Assignment newAssignment,
                                           Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Assignment");
            return "assignment/add";
        }

        AssignmentData.add(newAssignment);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveAssignmentForm(Model model) {
        model.addAttribute("assignments", AssignmentData.getAll());
        model.addAttribute("title", "Remove Assignment");
        return "assignment/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveAssignmentForm(@RequestParam int[] assignmentIds) {

        for (int assignmentId : assignmentIds) {
            AssignmentData.remove(assignmentId);
        }

        return "redirect:";
    }

}
