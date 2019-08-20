package com.canno.spring.boot.integration.specification;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * User: Rolandz Date: 7/12/16 Time: 8:44 AM
 */
public class PaginationResult<T, R> {
    private long total;
    private int totalPages;
    private List<R> rows;

    PaginationResult of(Page<T> page, Function<T, R> transferData) {
        this.rows = page.getContent().stream().map(transferData).collect(Collectors.toList());
        this.total = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        return this;
    }

    public long getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<R> getRows() {
        return rows;
    }
}
