package com.ssm.mapper;

import com.ssm.pojo.Goods;

import java.util.HashMap;
import java.util.List;

public interface GoodsMapper {
    /**
     * 查询商品列表
     * @return
     */
    List<Goods> findGoodsList(HashMap<Object,Object> hashMap);

    Integer getGoodsCount();

    /**
     * 根据商品名称判断商品是否存在
     * @param goodsName
     * @return
     */
    Goods findGoodsByGoodsName(String goodsName);

    /**
     * 修改库存，库存加一
     * @param goodsName
     * @return
     */
    int UpdateGoodsNum(String goodsName);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 根据商品id查询商品信息
     * @param gid
     * @return
     */
    Goods findGoodsById(Integer gid);

    /**
     * 根据id修改商品信息
     * @param goods
     * @return
     */
    Integer updateGoodsById(Goods goods);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Integer deleteGoodsByIds(String ids);
}
