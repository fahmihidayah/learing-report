/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fahmi
 */
@Table(name = "soal")
@Entity
public class Soal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private String teksSoal;
    
    @OneToMany(mappedBy = "soal", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Jawaban> jawabans = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Test test;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeksSoal() {
        return teksSoal;
    }

    public void setTeksSoal(String teksSoal) {
        this.teksSoal = teksSoal;
    }
    
    public List<Jawaban> getJawabans() {
        return jawabans;
    }

    public void setJawabans(List<Jawaban> jawabans) {
        this.jawabans = jawabans;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
    
    
}
