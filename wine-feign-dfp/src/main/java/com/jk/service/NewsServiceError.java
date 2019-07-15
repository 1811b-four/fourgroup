package com.jk.service;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@RequestMapping("/error")
@Component
public class NewsServiceError implements DsService {

    private static final String GET_NEWS_FLAG = "网络异常";


    @Override
    public HashMap<String, Object> findchuizi(Integer start, Integer pageSize) {
        return null;
    }
}
