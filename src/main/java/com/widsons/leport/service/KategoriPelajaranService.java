/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.service;

import com.widsons.leport.conf.Constantas;
import com.widsons.leport.domain.KategoriPelajaran;
import com.widsons.leport.repository.KategoriPelajaranRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fahmi
 */
@Service
@Transactional
public class KategoriPelajaranService {
    
    @Autowired
    KategoriPelajaranRepository kategoriPelajaranRepository;
    
    public void save(KategoriPelajaran kategoriPelajaran){
        kategoriPelajaranRepository.save(kategoriPelajaran);
    }
    
    public void delete(long id){
        kategoriPelajaranRepository.delete(id);
    }
    
    public Page<KategoriPelajaran> findAll(Optional<Integer> page, Optional<Integer> pageSize){
        int pageSizeResult = pageSize.orElse(Constantas.DEFAULT_PAGE_SIZE);
        int pageResult = (page.orElse(Constantas.DEFAULT_PAGE) < 1) ? 0 : page.get() - 1;
        return kategoriPelajaranRepository.findAll(new PageRequest(pageResult, pageSizeResult));
    
    }
    
    public void update(KategoriPelajaran kategoriPelajaran, long id){
        kategoriPelajaran.setId(id);
        save(kategoriPelajaran);
    }
    
    public Page<KategoriPelajaran> search(String keyword, Optional<Integer> page, Optional<Integer> pageSize){
        int pageSizeResult = pageSize.orElse(Constantas.DEFAULT_PAGE_SIZE);
        int pageResult = (page.orElse(Constantas.DEFAULT_PAGE) < 1) ? 0 : page.get() - 1;
        return kategoriPelajaranRepository.findByNameLike(keyword, new PageRequest(pageResult, pageSizeResult));
    }
    
    public Iterable<KategoriPelajaran> findAll(){
        return kategoriPelajaranRepository.findAll();
    }
}
