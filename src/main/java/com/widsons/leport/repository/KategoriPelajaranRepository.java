/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.repository;

import com.widsons.leport.domain.KategoriPelajaran;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fahmi
 */
@Repository
public interface KategoriPelajaranRepository extends PagingAndSortingRepository<KategoriPelajaran, Long> {
    
    public Page<KategoriPelajaran> findByNameLike(String name,  Pageable pageable);
    
}
