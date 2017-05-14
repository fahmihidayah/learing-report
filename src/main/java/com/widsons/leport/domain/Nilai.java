/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fahmi
 */
@Table(name = "nilai")
@Entity
public class Nilai {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private long hasil;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private UserAccountDetail userAccountDetail;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Test test;
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getHasil() {
        return hasil;
    }

    public void setHasil(long hasil) {
        this.hasil = hasil;
    }

    public UserAccountDetail getUserAccountDetail() {
        return userAccountDetail;
    }

    public void setUserAccountDetail(UserAccountDetail userAccountDetail) {
        this.userAccountDetail = userAccountDetail;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    
    

}
