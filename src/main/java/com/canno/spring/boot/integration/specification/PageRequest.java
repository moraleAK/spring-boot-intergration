package com.canno.spring.boot.integration.specification;

import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * User: Rolandz
 * Date: 7/12/16
 * Time: 8:40 AM
 */
public class PageRequest {
    @SpecificationIgnore
    private int rows = 15;

    @SpecificationIgnore
    private int page = 1;

    @SpecificationIgnore
    private String sortProperty = "id";

    @SpecificationIgnore
    private Sort.Direction sortDirection = Sort.Direction.DESC;


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public  org.springframework.data.domain.PageRequest toPageable(){
        if(this.rows <= 0){
            this.rows = 15;
        }

        if(this.page <= 0){
            this.page = 1;
        }

        if(StringUtils.isEmpty(this.sortProperty)){
            this.sortProperty = "id";
            this.sortDirection = Sort.Direction.DESC;
        }
        return org.springframework.data.domain.PageRequest.of(this.page - 1 , this.rows, this.sortDirection, this.sortProperty);
    }
}
