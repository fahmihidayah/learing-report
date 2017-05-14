/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.repository;

import com.widsons.leport.domain.Jawaban;
import com.widsons.leport.domain.Soal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fahmi
 */
@Repository
public interface JawabanRepository extends JpaRepository<Jawaban, Long>{
    
    public void deleteBySoal(Soal soal);
    
    public void deleteBySoalId(long soalId);
    
}
