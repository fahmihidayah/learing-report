/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.conf;

import com.widsons.leport.domain.Role;
import com.widsons.leport.domain.UserAccount;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author fahmi
 */
public class Utils {
    public static Set<SimpleGrantedAuthority> getGrantedAuthority(UserAccount userAccount){
        Set<SimpleGrantedAuthority> authoritys = new HashSet<>();
        for(Role role : userAccount.getRoles()){
            authoritys.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authoritys;
    }
}