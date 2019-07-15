package com.jk.service;

import org.springframework.web.bind.annotation.GetMapping;

public interface OrderServiceApi {

   @GetMapping("add")
   void add();
}
