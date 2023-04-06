package com.parsa.recipe.common;

import java.util.List;

public class PagingData <T> {

    private Integer totalPage;
    private Integer currentPage;
    private List<T> data;
}