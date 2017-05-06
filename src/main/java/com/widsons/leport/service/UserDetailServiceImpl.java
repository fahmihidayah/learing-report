/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.domain.CurrentUser;
import com.widsons.leport.domain.Role;
import com.widsons.leport.domain.UserAccount;
import com.widsons.leport.repository.UserAccountRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author fahmi
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService{
    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String string) {
        UserAccount userAccount = userAccountRepository.findByUserName(string);
        if(userAccount == null){
            userAccount = userAccountRepository.findByEmail(string);
        }
        System.out.println("user name is " + userAccount.getUserName());
        CurrentUser user = new CurrentUser(userAccount);
        return user;
    }
    
}
