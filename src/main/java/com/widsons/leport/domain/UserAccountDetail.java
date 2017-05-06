/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author fahmi
 */
@Table(name = "user_account_detail")
@Entity
public class UserAccountDetail {
    @Id
    @GeneratedValue
    private long id;
    
    @Column
    private String nama;
    
    @Column
    private String alamat;
    
    @Column
    private String nomorTelepon;
    
    @Column
    private String jenisKelamin;
    
    @OneToMany(mappedBy = "userAccountDetail", cascade = CascadeType.ALL)
    private Set<Test> setTest = new HashSet<>();
    
    @OneToMany(mappedBy = "userAccountDetail", cascade = CascadeType.ALL)
    private Set<Nilai> setNilai = new HashSet<>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserAccount userAccount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Set<Test> getSetTest() {
        return setTest;
    }

    public void setSetTest(Set<Test> setTest) {
        this.setTest = setTest;
    }

    public Set<Nilai> getSetNilai() {
        return setNilai;
    }

    public void setSetNilai(Set<Nilai> setNilai) {
        this.setNilai = setNilai;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
}
