/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.domain.UserAccount;
import com.widsons.leport.domain.form.UserAccountForm;


/**
 *
 * @author fahmi
 */
public interface UserAccountService {
    
    public void save(UserAccountForm userAccountForm);
    
    public UserAccount findByUserAccount(String userName);
    
}
