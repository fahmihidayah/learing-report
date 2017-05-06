/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.UserAccountDetail;
import com.widsons.leport.domain.form.TestForm;
import com.widsons.leport.repository.KategoriPelajaranRepository;
import com.widsons.leport.repository.TestRepository;
import com.widsons.leport.repository.UserAccountDetailRepository;
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
public class TestService {
    
    @Autowired
    TestRepository testRepository;
    
    @Autowired
    KategoriPelajaranRepository kategoriPelajaranRepository;
    
    @Autowired
    UserAccountDetailRepository userAccountDetailRepository;
    
    public Page<Test> findByUserDetail(UserAccountDetail userAccountDetail,Optional<Integer> page, Optional<Integer> pageSize){
        int pageSizeResult = pageSize.orElse(Constantas.DEFAULT_PAGE_SIZE);
        int pageResult = (page.orElse(Constantas.DEFAULT_PAGE) < 1) ? 0 : page.get() - 1;
        return testRepository.findByUserAccountDetail(userAccountDetail, new PageRequest(pageResult, pageSizeResult));
    }
    
    
    public void save(UserAccountDetail userAccountDetail, TestForm testForm){
        Test test = testForm.toTest();
        
        UserAccountDetail userAccountDetail1 = userAccountDetailRepository.findOne(userAccountDetail.getId());
        test.setUserAccountDetail(userAccountDetail1);
        testRepository.save(test);
    }
    
    public Test findById(long id){
        return testRepository.findOne(id);
    }
    
    public void update(Test test, long id){
        test.setId(id);
        testRepository.save(test);
    }
}
