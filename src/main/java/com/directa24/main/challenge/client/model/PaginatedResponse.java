package com.directa24.main.challenge.client.model;

import java.util.List;

public class PaginatedResponse<T> {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<T> data;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<T> getData() {
        return data;
    }
}
