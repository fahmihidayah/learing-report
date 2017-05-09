/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.repository;

import com.widsons.leport.domain.Test;
import com.widsons.leport.domain.UserAccountDetail;
import java.util.List;
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
public interface TestRepository extends PagingAndSortingRepository<Test, Long>{
    
    public Page<Test> findAll(Pageable pageable);
    
    public Page<Test> findByUserAccountDetail(UserAccountDetail userAccountDetail, Pageable pageable);
    
}
