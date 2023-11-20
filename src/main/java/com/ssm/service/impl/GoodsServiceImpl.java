package com.ssm.service.impl;

import com.ssm.mapper.BrandMapper;
import com.ssm.mapper.CateMapper;
import com.ssm.mapper.GoodsMapper;
import com.ssm.pojo.Brand;
import com.ssm.pojo.Cate;
import com.ssm.pojo.Goods;
import com.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CateMapper cateMapper;
    @Override
    public List<Goods> findGoodsList(HashMap<Object, Object> hashMap) {
        return goodsMapper.findGoodsList(hashMap);
    }

    @Override
    public Integer getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public List<Cate> findCateList() {
        return cateMapper.findCateList();
    }

    @Override
    public List<Brand> findBrands() {
        return brandMapper.findBrands();
    }

    @Override
    public String addGoods(Goods goods) {


        if(goods.getGoodsName() != null && goodsMapper.findGoodsByGoodsName(goods.getGoodsName()) != null){
            //库存加一
           return goodsMapper.UpdateGoodsNum(goods.getGoodsName()) == 1 ? "1" :"3";
        }
        System.out.println(goods);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(new Date());
        goods.setUpTime(time);
        goods.setNum(1);
        System.out.println(goods);
        return goodsMapper.addGoods(goods) == 1 ? "2" :"3";


    }

    @Override
    public Goods findGoodsById(Integer gid) {

        return goodsMapper.findGoodsById(gid);
    }

    @Override
    public String updateGoodsById(Goods goods) {
        return goodsMapper.updateGoodsById(goods) == 1 ? "true":"false";
    }

    @Override
    public String deleteGoodsByIds(String ids) {
        return goodsMapper.deleteGoodsByIds(ids) > 0 ? "true":"false";
    }
}
