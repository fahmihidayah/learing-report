/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.repository;

import com.widsons.leport.domain.Nilai;
import com.widsons.leport.domain.Soal;
import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.UserAccountDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fahmi
 */
@Repository
public interface SoalRepository extends PagingAndSortingRepository<Soal, Long>{
 
    public Page<Soal> findByTest(Test test, Pageable pageable);

}