/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.Soal;
import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.UserAccountDetail;
import com.widsons.leport.repository.SoalRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author fahmi
 */
@Service
public class SoalService {
    
    @Autowired
    SoalRepository soalRepository;
    
    public Page<Soal> findByUserDetail(Test test, Optional<Integer> page, Optional<Integer> pageSize){
        int pageSizeResult = pageSize.orElse(Constantas.DEFAULT_PAGE_SIZE);
        int pageResult = (page.orElse(Constantas.DEFAULT_PAGE) < 1) ? 0 : page.get() - 1;
        return soalRepository.findByTest(test, new PageRequest(pageResult, pageSizeResult));
    }
    
}
