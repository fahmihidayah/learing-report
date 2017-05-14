/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.Jawaban;
import com.widsons.leport.domain.Soal;
import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.UserAccountDetail;
import com.widsons.leport.repository.JawabanRepository;
import com.widsons.leport.repository.SoalRepository;
import com.widsons.leport.repository.TestRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fahmi
 */
@Service
@Transactional
public class SoalService {
    
    @Autowired
    SoalRepository soalRepository;
    
    @Autowired
    JawabanService jawabanService;
    
    @Autowired
    TestRepository testRepository;
    
    public Page<Soal> findByUserDetail(Test test, Optional<Integer> page, Optional<Integer> pageSize){
        int pageSizeResult = pageSize.orElse(Constantas.DEFAULT_PAGE_SIZE);
        int pageResult = (page.orElse(Constantas.DEFAULT_PAGE) < 1) ? 0 : page.get() - 1;
        return soalRepository.findByTest(test, new PageRequest(pageResult, pageSizeResult));
    }
    
    public void save(long testId, Soal soal){
        Test test = testRepository.findOne(testId);
        Soal soalNew = new Soal();
        soalNew.setTest(test);
        soalNew.setTeksSoal(soal.getTeksSoal());
        List<Jawaban> jawabans = soal.getJawabans();
        soalRepository.save(soalNew);
        jawabanService.save(soalNew, jawabans);
    }
    
    public Soal findById(long soalId){
        return soalRepository.findOne(soalId);
    }
    
    public void update(long soalId, Soal soal){
        soal.setId(soalId);
        soalRepository.save(soal);
    }
    
}
