/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain;

import com.widsons.leport.conf.Utils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author fahmi
 */
public class CurrentUser extends User{
    
    UserAccount userAccount;
    
    public CurrentUser(UserAccount userAccount) {
        super(userAccount.getUserName(), userAccount.getPassword(), Utils.getGrantedAuthority(userAccount));
        this.userAccount = userAccount;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
    
    public long getId(){
        return userAccount.getId();
    }
    
}
