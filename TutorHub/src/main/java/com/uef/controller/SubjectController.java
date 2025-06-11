/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uef.controller;

import com.uef.model.Subject;
import com.uef.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author qnhat
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("subject", subjectService.findAll());
        model.addAttribute("body", "/WEB-INF/views/Admin/subjects.jsp");
        return "/layout/admin/main";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("body", "/WEB-INF/views/Admin/form.jsp");
//        return "layout/admin/main";
        return "/Admin/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Subject subject) {
        if (subject.getSubId() == 0) {
            subjectService.add(subject);
        } else {
            subjectService.update(subject);
        }
        return "redirect:/subject";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("subject", subjectService.findById(id));
        model.addAttribute("body", "/WEB-INF/views/Admin/form.jsp");
        return "/Admin/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        subjectService.deleteByid(id);
        return "redirect:/subject";
    }

}
