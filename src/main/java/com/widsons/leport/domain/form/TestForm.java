/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain.form;

import com.widsons.leport.domain.Test;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author fahmi
 */
public class TestForm {
    @NotEmpty
    private String name;
    @NotEmpty
    private String keterangan;
    private long kategoriPelajaranId;

    public TestForm() {
    }
    
    public TestForm(Test test) {
        name = test.getNama();
        keterangan = test.getKeteranganTest();
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public long getKategoriPelajaranId() {
        return kategoriPelajaranId;
    }

    public void setKategoriPelajaranId(long kategoriPelajaranId) {
        this.kategoriPelajaranId = kategoriPelajaranId;
    }
    
    public Test toTest(){
        Test test = new Test();
        test.setNama(name);
        test.setKeteranganTest(keterangan);
        return test;
    }
    
}
