/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.CurrentUser;
import com.widsons.leport.domain.Pager;
import com.widsons.leport.domain.Test;
import com.widsons.leport.service.TestService;
import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fahmi
 */
@Controller
@RequestMapping("/user/")
public class UserAccountDetailController {
    
    @Autowired
    TestService testService;
    
    @RequestMapping("dashboard")
    public String dashboard(Model model,  @RequestParam("page") Optional<Integer> page, 
            @RequestParam("page_size") Optional<Integer> pageSize, Principal principal){
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<Test> testPage = testService.findByUserDetail(currentUser.getUserAccount().getUserAccountDetail(), page, pageSize);
        Pager pager = new Pager(testPage.getTotalPages(), testPage.getNumber(), Constantas.DEFAULT_PAGE_SHOW);
        model.addAttribute("testPage", testPage);
        model.addAttribute("startPage", pager.getStartPage());
        model.addAttribute("endPage", pager.getEndPage());
        return "dashboard";
    }
}
