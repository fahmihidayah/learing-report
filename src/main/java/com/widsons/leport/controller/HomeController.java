/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.Role;
import com.widsons.leport.domain.form.UserAccountForm;
import com.widsons.leport.repository.RoleRepository;
import com.widsons.leport.service.SecurityServiceImpl;
import com.widsons.leport.service.UserAccountService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author fahmi
 */
@Controller
public class HomeController {
    
    @Autowired
    UserAccountService userAccountService;
    
    @Autowired
    SecurityServiceImpl securityServiceImpl;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    
    @RequestMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("userForm", new UserAccountForm());
        return "signup";
    }
    
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUpPost(@ModelAttribute("userForm") @Valid UserAccountForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup";
        }
        userAccountService.save(userForm);
        securityServiceImpl.autologin(userForm.getUserName(), userForm.getPassword());
        return "redirect:/user/dashboard";
    }
    
    
}
