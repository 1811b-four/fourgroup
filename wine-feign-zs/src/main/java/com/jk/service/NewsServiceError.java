package com.jk.service;

<<<<<<< HEAD
import com.jk.utils.MenuTree;
=======
import com.jk.model.WineImg;
>>>>>>> e2e918422d16336b0724d5db9e6013a108ab0a07
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> e2e918422d16336b0724d5db9e6013a108ab0a07

@RequestMapping("/error")
@Component
public class NewsServiceError implements ServiceFeign {

    @Override
<<<<<<< HEAD
    public List<MenuTree> getTreeAll() {
        return null;
    }

    @Override
    public HashMap<String, Object> findxinwen(Integer start, Integer pageSize) {
        return null;
    }



/*    public String book(){
       String bk="网络错误，请重试。";
       return bk;
    }*/





=======
    public void addNews2(WineImg jiu) {

    }


>>>>>>> e2e918422d16336b0724d5db9e6013a108ab0a07
}
