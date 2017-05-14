/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain.form;

import java.util.List;

/**
 *
 * @author fahmi
 */
public class SoalForm {
    private long testId;
    private String soal;
    private List<JawabanForm> jawabanForms;

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public List<JawabanForm> getJawabanForms() {
        return jawabanForms;
    }

    public void setJawabanForms(List<JawabanForm> jawabanForms) {
        this.jawabanForms = jawabanForms;
    }
    
    
    
    
}
