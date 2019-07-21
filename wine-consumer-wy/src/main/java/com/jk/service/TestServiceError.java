package com.jk.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("testError")
@Component
public class TestServiceError implements TestService {
    private static final String GET_NEWS_FLAG = "爱的魔力转圈圈";
}
