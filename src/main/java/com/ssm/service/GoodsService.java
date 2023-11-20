package com.ssm.service;

import com.ssm.pojo.Brand;
import com.ssm.pojo.Cate;
import com.ssm.pojo.Goods;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {

    /**
     * 查询商品列表
     * @return
     */
    List<Goods> findGoodsList(HashMap<Object,Object> hashMap);

    /**
     * 查询商品总个数
     * @return
     */
    Integer getGoodsCount();

    /**
     * 查询所有分类
     * @return
     */
    List<Cate> findCateList();

    /**
     * 查询所有品牌
     *
     * @return
     */
    List<Brand> findBrands();

    /**
     * 添加商品
     * @param goods
     * @return
     */
    String addGoods(Goods goods);

    Goods findGoodsById(Integer gid);

    String updateGoodsById(Goods goods);

    String deleteGoodsByIds(String ids);
}
