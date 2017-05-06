/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.KategoriPelajaran;
import com.widsons.leport.domain.Pager;
import com.widsons.leport.domain.Test;
import com.widsons.leport.service.KategoriPelajaranService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
@RequestMapping(value = "/kategori_pelajaran")
public class KategoriController {
    
    @Autowired
    KategoriPelajaranService kategoriPelajaranService;
    
    @GetMapping("/list")
    public String list(Model model,  @RequestParam("page") Optional<Integer> page, 
            @RequestParam("page_size") Optional<Integer> pageSize){
        Page<KategoriPelajaran> testPage = kategoriPelajaranService.findAll(page, pageSize);
        Pager pager = new Pager(testPage.getTotalPages(), testPage.getNumber(), Constantas.DEFAULT_PAGE_SHOW);
        model.addAttribute("kategoriPage", testPage);
        model.addAttribute("startPage", pager.getStartPage());
        model.addAttribute("endPage", pager.getEndPage());
        return "kategori_pelajaran_list";
    }
    
    
    @GetMapping("/create")
    public String form(Model model){
        model.addAttribute("kategoriPelajaran", new KategoriPelajaran());
        return "kategori_pelajaran_form";
    }
    
    @PostMapping("/create")
    public String save(@ModelAttribute @Valid KategoriPelajaran kategoriPelajaran, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "kategori_pelajaran_list";
        }
        kategoriPelajaranService.save(kategoriPelajaran);
        return "redirect:kategori_pelajaran/list";
    }
}
