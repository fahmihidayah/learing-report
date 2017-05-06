/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.domain.Role;
import com.widsons.leport.domain.UserAccount;
import com.widsons.leport.domain.form.UserAccountForm;
import com.widsons.leport.repository.RoleRepository;
import com.widsons.leport.repository.UserAccountRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fahmi
 */
@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    UserAccountRepository userAccountRepository;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    UserAccountDetailService userAccountDetailService;
    
    @Override
    public void save(UserAccountForm userAccountForm) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userAccountForm.getUserName());
        userAccount.setEmail(userAccountForm.getEmail());
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccountForm.getPassword()));
//        userAccount.setRoles(new HashSet<Role>());
        Role role = roleRepository.findOne((long)2);
        userAccount.getRoles().add(role);
        userAccountRepository.save(userAccount);
        System.out.println("user id is " + userAccount.getId());
        userAccountDetailService.saveDevaultAccount(userAccount);
        
    }

    @Override
    public UserAccount findByUserAccount(String userName) {
        return userAccountRepository.findByUserName(userName);
    }
    
    
    
}
