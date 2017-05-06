/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.domain.CurrentUser;
import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.form.TestForm;
import com.widsons.leport.service.KategoriPelajaranService;
import com.widsons.leport.service.TestService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author fahmi
 */
@Controller
@RequestMapping("/test/")
public class TestController {
    
    @Autowired
    TestService testService;
    
    @Autowired
    KategoriPelajaranService kategoriPelajaranService;
    
    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("url", "/test/create");
        model.addAttribute("test", new TestForm());
        model.addAttribute("kategories", kategoriPelajaranService.findAll());
        return "test_form";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@ModelAttribute @Valid TestForm test, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "test_form";
        }
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("current user is " + currentUser.getUserAccount().getUserAccountDetail().getId());
        testService.save(currentUser.getUserAccount().getUserAccountDetail(), test);
        return "redirect:/user/dashboard";
    }
    
    
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id){
        Test test = testService.findById(id);
        if(test == null) {
           throw new NullPointerException();
        }
        model.addAttribute("url", "/test/edit/" + id);
        model.addAttribute("test", test);
        model.addAttribute("kategories", kategoriPelajaranService.findAll());
        return "test_form";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute @Valid Test test, BindingResult bindingResult, @PathVariable("id") long id){
        if(bindingResult.hasErrors()){
            return "test_form";
        }
        testService.update(test, id);
        return "redirect:/user/dashboard";
    }
}
