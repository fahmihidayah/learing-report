/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fahmi
 */
@RestController
@RequestMapping(value = "/test")
public class ApiController {
    
    @RequestMapping("/api")
    public String test(){
        return "hello";
    }
    
}
