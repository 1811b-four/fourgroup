package com.jk.service;

import com.jk.model.WineImg;
import com.jk.utils.MenuTree;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/error")
@Component
public class NewsServiceError implements ServiceFeign {



    @Override
    public List<MenuTree> getTreeAll() {
        return null;
    }

    @Override
    public HashMap<String, Object> findxinwen(Integer start, Integer pageSize) {
        return null;
    }

    @Override
    public void del(Integer id) {

    }

}
