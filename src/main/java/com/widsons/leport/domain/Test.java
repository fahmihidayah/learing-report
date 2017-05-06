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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author fahmi
 */
@Table(name = "test")
@Entity
public class Test {
    @Id
    @GeneratedValue
    private long id;
   
    @NotEmpty
    @Column
    private String nama;
    
    @NotEmpty
    @Column
    private String keteranganTest;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private List<Soal> soals = new ArrayList<>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    private KategoriPelajaran kategoriPelajaran;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAccountDetail userAccountDetail;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private List<Nilai> nilais = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKeteranganTest() {
        return keteranganTest;
    }

    public void setKeteranganTest(String keteranganTest) {
        this.keteranganTest = keteranganTest;
    }

    public List<Soal> getSoals() {
        return soals;
    }

    public void setSoals(List<Soal> soals) {
        this.soals = soals;
    }

    public KategoriPelajaran getKategoriPelajaran() {
        return kategoriPelajaran;
    }

    public void setKategoriPelajaran(KategoriPelajaran kategoriPelajaran) {
        this.kategoriPelajaran = kategoriPelajaran;
    }

    public UserAccountDetail getUserAccountDetail() {
        return userAccountDetail;
    }

    public void setUserAccountDetail(UserAccountDetail userAccountDetail) {
        this.userAccountDetail = userAccountDetail;
    }

    public List<Nilai> getNilais() {
        return nilais;
    }

    public void setNilais(List<Nilai> nilais) {
        this.nilais = nilais;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
    
}
