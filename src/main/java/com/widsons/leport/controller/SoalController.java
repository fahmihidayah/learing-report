/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.conf.Utils;
import com.widsons.leport.domain.Jawaban;
import com.widsons.leport.domain.Soal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @GetMapping("/create")
    public String create(Model model, @RequestParam("test_id") long testId){
        model.addAttribute("soal", Utils.createSoalForm());
        return "soal_form";
    }
    
    
    @PostMapping("/create")
    public String save(Model model, @ModelAttribute Soal soal){
        System.out.println("---------------------------------------------------------------");
        System.out.println("soal is " + soal.getTeksSoal());
        for(Jawaban jawaban : soal.getJawabans()){
            System.out.println("jawabans is " + jawaban.getTeksJawaban() + " " + jawaban.isIsJawabanBenar());
        }
        System.out.println("---------------------------------------------------------------");
        return "soal_form";
    }
}
