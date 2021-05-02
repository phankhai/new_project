package com.example.demo.common.rest;

import com.example.demo.constants.PaginationConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nha.luong-cong on 23/02/2021.
 */
@Getter
@Setter
public class PageableDTO<T> implements Serializable {

    private List<T> items = new ArrayList<>();
    private int page;
    private int size;
    private int totalItems;
    private int totalPages;
    private long totalElements;
    private boolean hasNext;
    private boolean hasPrevious;

    public static <T> PageableDTO<T> empty() {
        PageableDTO<T> page = new PageableDTO<>();

        page.setItems(new ArrayList<>());
        page.setPage(PaginationConstant.DEFAULT_PAGE);
        page.setSize(PaginationConstant.DEFAULT_PAGE_SIZE);
        page.setTotalElements(0);
        page.setTotalPages(0);
        page.setHasPrevious(false);
        page.setHasNext(false);

        return page;
    }

    /**
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PageableDTO<T> wrap(Page<T> page) {
        if (page == null) {
            return empty();
        }

        PageableDTO<T> res = new PageableDTO<>();

        res.setItems(page.getContent());
        res.setTotalItems(page.getContent().size());//search
        res.setPage(page.getTotalPages() > 0 ? page.getNumber() + 1 : PaginationConstant.DEFAULT_PAGE);
        res.setSize(page.getSize());
        res.setTotalElements(page.getTotalElements());
        res.setTotalPages(page.getTotalPages());
        res.setHasPrevious(page.getTotalPages() > 0 && page.hasPrevious());
        res.setHasNext(page.getTotalPages() > 0 && page.hasNext());

        return res;
    }

}
