package com.epam.conferences.service;

import org.fed333.servletboot.web.data.page.Page;
import org.fed333.servletboot.web.data.page.impl.PageImpl;
import org.fed333.servletboot.web.data.pageable.Pageable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ServiceUtils<T> {
    static <T> Page<T> toPage(List<T> list, Pageable pageable){
        if(pageable.getPageNumber()*pageable.getPageSize() > list.size()){
            pageable = pageable.withPage(0);
        }
        int start = (int)pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), list.size());
        if (start > end){
            return new PageImpl<>(Collections.emptyList(), pageable, list.size());
        }
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }
    public static java.sql.Date convertDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }
}
