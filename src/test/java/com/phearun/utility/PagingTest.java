package com.phearun.utility;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PagingTest {

    Paging paging;

    @Before
    public void setUp() throws Exception {
        paging = new Paging();
    }

    @Test
    public void getPage() {
         int currentPage =1;
         paging.setPage(currentPage);
         assertEquals(currentPage, paging.getPage());
    }

    @Test
    public void totalPages() {
        Long totalPages =10L;
        paging.setTotalPages(totalPages);
        assertEquals(totalPages, paging.getTotalPages());
    }

    @Test
    public void offset() {
        int offset =1;
        paging.setOffset(offset);
    }

    @Test
    public void getLimit() {
        int limit =1;
        paging.setLimit(limit);
        assertEquals(limit, paging.getLimit());
    }

    @Test
    public void getTotalCount() {
        Long totalCount = 5L;
        paging.setTotalCount(totalCount);
        assertEquals(totalCount, paging.getTotalCount());
    }

    @Test
    public void getTotalPages() {
        Long totalPages =10L;
        paging.setTotalPages(totalPages);
        assertEquals(totalPages, paging.getTotalPages());
    }

}