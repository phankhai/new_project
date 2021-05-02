package com.example.demo.utils;

import com.example.demo.common.rest.PageableDTO;
import com.example.demo.constants.PaginationConstant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PaginationUtils {

    public PaginationUtils() {
    }

    public static <T> HttpHeaders generatePaginationHttpHeaders(Page<T> page, String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if (page.getNumber() + 1 < page.getTotalPages()) {
            link = "<" + generateUri(baseUrl, page.getNumber() + 1, page.getSize()) + ">; rel=\"next\",";
        }

        if (page.getNumber() > 0) {
            link = link + "<" + generateUri(baseUrl, page.getNumber() - 1, page.getSize()) + ">; rel=\"prev\",";
        }

        int lastPage = 0;
        if (page.getTotalPages() > 0) {
            lastPage = page.getTotalPages() - 1;
        }

        link = link + "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">; rel=\"last\",";
        link = link + "<" + generateUri(baseUrl, 0, page.getSize()) + ">; rel=\"first\"";
        headers.add("Link", link);
        return headers;
    }

    private static String generateUri(String baseUrl, int page, int size) {
        return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", new Object[]{page}).queryParam("size", new Object[]{size}).toUriString();
    }
    /**
     * @param items
     * @param requestedPage
     * @param requestedPageSize
     * @param <T>
     * @return
     */
    public static <T> PageableDTO<T> asPage(List<T> items, int requestedPage, int requestedPageSize) {
        PageableDTO<T> page = new PageableDTO<>();

        if (items == null || items.isEmpty()) {
            return PageableDTO.empty();
        }

        page.setPage(requestedPage);
        page.setSize(requestedPageSize);

        page.setItems(subList(items, requestedPage - 1, requestedPageSize));

        int totalPages = (int) Math.ceil((double) items.size() / requestedPageSize);

        page.setTotalPages(totalPages);
        page.setTotalElements(items.size());

        page.setHasNext(requestedPage < totalPages);
        page.setHasPrevious(totalPages > 1 && requestedPage > PaginationConstant.DEFAULT_PAGE);

        return page;
    }

    /**
     * @param lst
     * @param page
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> List<T> subList(List<T> lst, int page, int pageSize) {
        if (lst == null) {
            return null;
        }

        int from = page * pageSize;
        int to = from + pageSize;

        int actualFrom = Math.max(from, 0);
        int actualTo = Math.min(lst.size(), to);

        if (lst.isEmpty() || lst.size() <= actualFrom) {
            return new ArrayList<>();
        }

        return lst.subList(actualFrom, actualTo);
    }

    /**
     * @param src
     * @param convert
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Page<R> from(Page<T> src, Function<List<T>, List<R>> convert) {
        List<R> items = convert.apply(src.getContent());

        return new PageImpl<>(items, src.getPageable(), src.getTotalElements());
    }

    /**
     * @param ePage
     * @param mapper
     * @param <E>
     * @param <D>
     * @param <M>
     * @return null if search error
     */
    public static <E, D, M extends EntityMapper<D, E>> Page<D> toDto(Page<E> ePage, M mapper) {
        if (ePage != null) {
            List<D> dtos = mapper.toDto(ePage.getContent());
            return new PageImpl<>(dtos, ePage.getPageable(), ePage.getTotalElements());
        }
        return null;
    }

    /**
     * @param list
     * @param pageable
     * @param <T>
     * @return null if search error
     */
    public static <T> Page<T> toPage(List<T> list, Pageable pageable) {
        if (list == null) {
            throw new IllegalArgumentException("To create a Page, the list mustn't be null!");
        }
        return new PageImpl<T>(list, pageable, list.size());
    }


}
