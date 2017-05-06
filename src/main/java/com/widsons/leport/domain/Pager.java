/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widsons.leport.domain;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author fahmi
 */
public class Pager{
    // misal total page = 50
    // jumlah button yang ditampilkan di bawah
    private int buttonsToShow = 5;
    // nilai awal page yang nanti akan di tampilkan
    private int startPage;
    // nilai akhir page yang nanti akan di tampilkan
    private int endPage;

    private int totalPages;
    
    private int currentPage;
    
    public Pager(int totalPages, int currentPage, int buttonsToShow) {
        // mengecek agar button yang di tampilkan selalu ganjil. default 5
       this.totalPages = totalPages;
       this.currentPage = currentPage;
        setButtonsToShow(buttonsToShow);
        // nilai 1/2 button yang di tampilkan. default 2
        int halfPagesToShow = getButtonsToShow() / 2;

        // jika total page 50, apakah 50 <= 5, tidak
        // jila total page 4 ya. maka gambar sbb:
        // <prev *1 | 2 | 3 | 4  next>
        if (totalPages <= getButtonsToShow()) {
            setStartPage(1);
            setEndPage(totalPages == 0 ? 1 : totalPages);
        } 
        // jika page sekarang - 1/2 page <= 0, page sekarang = 1, 1 - 2 <= 0, ya
        // maka gambar 
        // <prev *1 | 2 | 3 | 4 ... 50  next>
        else if (currentPage - halfPagesToShow <= 0) {
            setStartPage(1);
            setEndPage(getButtonsToShow());
            
        } 
        // jika currentPage + halfpagesToShow == totalPages
        // di loop dari posisi sebelum terakhis sampai terakhir
        else if (currentPage + halfPagesToShow == totalPages) {
            setStartPage(currentPage - halfPagesToShow);
            setEndPage(totalPages);

        } else if (currentPage + halfPagesToShow > totalPages) {
            setStartPage(totalPages - getButtonsToShow() + 1);
            setEndPage(totalPages);

        } else {
            setStartPage(currentPage - halfPagesToShow);
            setEndPage(currentPage + halfPagesToShow);
        }

    }

    public int getButtonsToShow() {
        return buttonsToShow;
    }

    public void setButtonsToShow(int buttonsToShow) {
        if (buttonsToShow % 2 != 0) {
            this.buttonsToShow = buttonsToShow;
        } else {
            throw new IllegalArgumentException("Must be an odd value!");
        }
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "Pager [startPage=" + startPage + ", endPage=" + endPage + "]";
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    
}
