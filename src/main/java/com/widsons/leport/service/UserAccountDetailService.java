/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.domain.UserAccount;
import com.widsons.leport.domain.UserAccountDetail;
import com.widsons.leport.repository.UserAccountDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fahmi
 */
@Service
public class UserAccountDetailService {
    
    @Autowired
    UserAccountDetailRepository userAccountDetailRepository;
    
    public void saveDevaultAccount(UserAccount userAccount){
        UserAccountDetail userAccountDetail = new UserAccountDetail();
        userAccountDetail.setAlamat("");
        userAccountDetail.setJenisKelamin("");
        userAccountDetail.setNama(userAccount.getUserName());
        userAccountDetail.setNomorTelepon("");
        userAccountDetail.setUserAccount(userAccount);
        userAccountDetailRepository.save(userAccountDetail);
    }
}
