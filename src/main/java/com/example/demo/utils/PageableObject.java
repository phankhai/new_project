package com.example.demo.utils;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageableObject<T> {
    private List<T> items;
    private Long totalElements;
    private int totalPages;

    public PageableObject(Page<T> page) {
        this.items = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }

    public List<T> getItems() {
        return this.items;
    }

    public Long getTotalElements() {
        return this.totalElements;
    }

    public int getTotalPages() {
        return this.totalPages;
    }
}
