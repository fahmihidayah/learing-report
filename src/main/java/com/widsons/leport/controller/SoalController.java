/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.conf.Utils;
import com.widsons.leport.domain.Jawaban;
import com.widsons.leport.domain.Soal;
import com.widsons.leport.service.SoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fahmi
 */
@Controller
@RequestMapping("/user/soal/")
public class SoalController {
    
    @Autowired
    SoalService soalService;
    
    @GetMapping("/create")
    public String create(Model model, @RequestParam("test_id") long testId){
        model.addAttribute("soal", Utils.createSoalForm());
        model.addAttribute("test_id", testId);
        return "soal_form";
    }
    
    
    @PostMapping("/create")
    public String save(Model model, @ModelAttribute Soal soal, @RequestParam("test_id") long testId){
        soalService.save(testId, soal);
        return "redirect:/user/test/detail/" + testId;
    }
    
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id){
        Soal soal = soalService.findById(id);
        model.addAttribute("soal", soal);
        model.addAttribute("test_id", soal.getTest().getId());
        return "soal_form";
    }
    
    @PostMapping("/edit/{id}")
    public String update(Model model, @ModelAttribute Soal soal, @PathVariable("id") long id){
        soalService.update(id, soal);
        soal = soalService.findById(id);
        return "redirect:/user/test/detail/" + soal.getTest().getId();
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        Soal soal = soalService.findById(id);
        soalService.delete(id);
        return "redirect:/user/test/detail/" + soal.getTest().getId();
    }
}
