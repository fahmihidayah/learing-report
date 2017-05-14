/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fahmi
 */
@Table(name = "jawaban")
@Entity
public class Jawaban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String teksJawaban;
    @Column
    private boolean isJawabanBenar;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Soal soal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeksJawaban() {
        return teksJawaban;
    }

    public void setTeksJawaban(String teksJawaban) {
        this.teksJawaban = teksJawaban;
    }

    public Soal getSoal() {
        return soal;
    }

    public void setSoal(Soal soal) {
        this.soal = soal;
    }

    public boolean isIsJawabanBenar() {
        return isJawabanBenar;
    }

    public void setIsJawabanBenar(boolean isJawabanBenar) {
        this.isJawabanBenar = isJawabanBenar;
    }
    
    public void setAttribteValue(Jawaban jawaban){
        teksJawaban = jawaban.getTeksJawaban();
        isJawabanBenar = jawaban.isJawabanBenar;
    }
    
}
