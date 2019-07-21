package com.jk.controller;

import com.jk.pojo.ElasticBean;
import com.jk.utils.PageModel;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Classname 曹龙启
 * @Description TODO
 * @Date 2019/7/21 16:28
 * @Created by ${jmh}
 */
@RestController
public class ElasticController {




        @Autowired
        private ElasticsearchTemplate elasticsearchTemplate;


       @GetMapping("queryAllWines")
       public  HashMap<String,Object>  queryAllNews(ElasticBean es, PageModel pageModel){

           //获取到当前es的客户端 相当于jdbc加载驱动创建连接
           Client client = elasticsearchTemplate.getClient();
           //创建es查询对象 相当于jdbc中创建preparestatement类似
           SearchRequestBuilder searchRequestBuilder = client.prepareSearch("wine").setTypes("wineInfo");


           if (es.getWinename() != null && !"".equals(es.getWinename())) {
               //为当前查询添加where条件
               //matchQuery 第一个参数为要查询的字段 第二个为查询条件的值
               searchRequestBuilder.setQuery(QueryBuilders.matchQuery("winename", es.getWinename()));
               //创建一个高亮对象
               HighlightBuilder highlightBuilder = new HighlightBuilder();
               highlightBuilder.field("winename");
               highlightBuilder.preTags("<span style='color:red'>");
               highlightBuilder.postTags("</span>");
               //为searchRequestBuilder设置高亮对象
               searchRequestBuilder.highlighter(highlightBuilder);
           }


           searchRequestBuilder.setFrom((pageModel.getPageNow()-1)*pageModel.getPageCount()).setSize(pageModel.getPageCount());

           searchRequestBuilder.addSort("winejiage", SortOrder.DESC);

           //执行当前查询命令 获取到查询结果
           SearchResponse searchResponse = searchRequestBuilder.get();

           //获取到查询命中结果集
           SearchHits hits = searchResponse.getHits();

           //获取总条数
           long total = hits.getTotalHits();

           //获取到结果集迭代器 对结果集遍历输出
           Iterator<SearchHit> iterator = hits.iterator();

           List dataList = new ArrayList();

           //判断集合中有无下一个元素
           while (iterator.hasNext()){

               SearchHit next = iterator.next();

               //把返回结果转成一个map集合
               Map<String, Object> sourceAsMap = next.getSourceAsMap();
               //获取到所有高亮字段转为一个map集合 key高亮的字段 值为高亮之后的结果
               Map<String, HighlightField> highlightFields = next.getHighlightFields();
               if (highlightFields.size() != 0) {
                   //获取到高亮显示之后的内容
                   HighlightField userName = highlightFields.get("winename");
                   //拿到高亮内容 获取到的是一个数组 取下标为0的
                   Text[] fragments = userName.getFragments();
                   //获取到结果集的json字符串
                   //next.getSourceAsString();
                   //使用高亮内容 替换非高亮内容
                   sourceAsMap.put("winename", String.valueOf(fragments[0]));
               }
               dataList.add(sourceAsMap);
           }

           Integer sum = Math.toIntExact(hits.getTotalHits());

           PageModel page = new PageModel(sum, pageModel.getPageNow(), pageModel.getPageCount());

           HashMap<String,Object> map = new HashMap<>();

           map.put("goodswine",dataList);

           map.put("gwp",page);


           return map;

       }










}
