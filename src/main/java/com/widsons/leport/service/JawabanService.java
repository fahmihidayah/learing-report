/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.domain.Jawaban;
import com.widsons.leport.domain.Soal;
import com.widsons.leport.repository.JawabanRepository;
import com.widsons.leport.repository.SoalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fahmi
 */
@Service
@Transactional
public class JawabanService {
    
    @Autowired
    JawabanRepository jawabanRepository;
    
    @Autowired
    SoalRepository soalRepository;
    
    public void save(Soal soal, List<Jawaban> jawabans){
        for(Jawaban jawaban : jawabans){
            Jawaban jawabanNew = new Jawaban();
            jawabanNew.setTeksJawaban(jawaban.getTeksJawaban());
            jawabanNew.setIsJawabanBenar(jawaban.isIsJawabanBenar());
             soal.getJawabans().add(jawabanNew);
            jawabanNew.setSoal(soal);
            System.out.println("jawaban is " + jawabanNew.getTeksJawaban());
            jawabanRepository.save(jawabanNew);
        }
    }
    
    public void deleteBySoal(Soal soal){
        jawabanRepository.deleteBySoal(soal);
    }
    
    public void deleteBySoalId(long soalId){
        jawabanRepository.deleteBySoalId(soalId);
    }
    
    
}
