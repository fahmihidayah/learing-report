/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.CurrentUser;
import com.widsons.leport.domain.Pager;
import com.widsons.leport.domain.Soal;
import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.form.TestForm;
import com.widsons.leport.service.KategoriPelajaranService;
import com.widsons.leport.service.SoalService;
import com.widsons.leport.service.TestService;
import java.security.Principal;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fahmi
 */
@Controller
@RequestMapping("/user/test/")
public class TestController {
    
    @Autowired
    TestService testService;
    
    @Autowired
    KategoriPelajaranService kategoriPelajaranService;
    
    @Autowired
    SoalService soalService;
    
    @RequestMapping("/list")
    public String dashboard(Model model,  @RequestParam("page") Optional<Integer> page, 
            @RequestParam("page_size") Optional<Integer> pageSize, Principal principal){
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<Test> testPage = testService.findByUserDetail(currentUser.getUserAccount().getUserAccountDetail(), page, pageSize);
        Pager pager = new Pager(testPage.getTotalPages(), testPage.getNumber(), Constantas.DEFAULT_PAGE_SHOW);
        model.addAttribute("testPage", testPage);
        model.addAttribute("startPage", pager.getStartPage());
        model.addAttribute("endPage", pager.getEndPage());
        return "test_list";
    }
    
    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("test", new TestForm());
        model.addAttribute("kategories", kategoriPelajaranService.findAll());
        return "test_form";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@ModelAttribute @Valid TestForm test, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "test_form";
        }
        testService.save(test);
        return "redirect:/user/dashboard";
    }
    
    
    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id){
        Test test = testService.findById(id);
        if(test == null) {
           throw new NullPointerException();
        }
        model.addAttribute("test", new TestForm(test));
        model.addAttribute("kategories", kategoriPelajaranService.findAll());
        return "test_form";
    }
    
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute @Valid TestForm test, BindingResult bindingResult, @PathVariable("id") long id){
        if(bindingResult.hasErrors()){
            return "test_form";
        }
        testService.update(test, id);
        return "redirect:/user/dashboard";
    }
    
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") long id, @RequestParam("page_size") Optional<Integer> pageSize){
        Test test = testService.findById(id);
        System.out.println("nama test is " + test.getNama());
        Page<Soal> soalPage = soalService.findByUserDetail(test, pageSize, pageSize);
        model.addAttribute("test", test);
        Pager pager = new Pager(soalPage.getTotalPages(), soalPage.getNumber(), Constantas.DEFAULT_PAGE_SHOW);
        model.addAttribute("pageData", soalPage);
        model.addAttribute("startPage", pager.getStartPage());
        model.addAttribute("endPage", pager.getEndPage());
        return "test_detail";
    }
    
}
