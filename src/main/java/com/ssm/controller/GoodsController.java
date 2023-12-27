package com.ssm.controller;

import com.ssm.pojo.Brand;
import com.ssm.pojo.Cate;
import com.ssm.pojo.Goods;
import com.ssm.service.GoodsService;
import com.ssm.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private PageUtils pageUtils;



    @RequestMapping("/toAdd")

    public String toAdd(Model model){
        //将品牌数据存到域中
        model.addAttribute("brandList",goodsService.findBrands());
        return "add";
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    //注解什么作用
    public String addGoods(Goods goods){ //toAdd
        //将品牌数据存到域中
        return  goodsService.addGoods(goods);
    }

    @RequestMapping("/findGoodsById")
    //注解什么作用
    public String findGoodsById(Integer gid,Model model){ //toAdd
        //将品牌数据存到域中
        Goods goods = goodsService.findGoodsById(gid);
        model.addAttribute("goods",goods);
        model.addAttribute("brandList",goodsService.findBrands());
        return "update";
    }

    @RequestMapping("/updateGoodsById")
    @ResponseBody
    //注解什么作用
    public String updateGoodsById(Goods goods){ //toAdd
        //将品牌数据存到域中

        return  goodsService.updateGoodsById(goods);
    }

    @RequestMapping("/deleteGoodsByIds")
    @ResponseBody
    //注解什么作用
    public String deleteGoodsByIds(String ids){ //toAdd
        //将品牌数据存到域中

        return  goodsService.deleteGoodsByIds(ids);
    }


    @RequestMapping("/list")
    public String findGoodsList(Model model,String currentPage,String likeName,String uptimeBegin,String uptimeEnd){
        //创建hash
        HashMap<Object ,Object> hashMap = new HashMap<>();
        /*将模糊值存到集合中*/
        if (likeName != null && !likeName.equals(""))
        {
            hashMap.put("likeName",likeName.trim());
            model.addAttribute("likeName",likeName);
        }

        if (uptimeBegin != null && !uptimeBegin.isEmpty() && uptimeEnd != null && !uptimeEnd.isEmpty())
        {
            hashMap.put("uptimeBegin",uptimeBegin);
            hashMap.put("uptimeEnd",uptimeEnd);
            model.addAttribute("uptimeBegin",uptimeBegin);
            model.addAttribute("uptimeEnd",uptimeEnd);
        }



        /*调用分页方法*/
        pageUtils.initData(currentPage,goodsService.getGoodsCount(hashMap),5);

        hashMap.put("indexStart",pageUtils.getIndexStart());
        hashMap.put("pageSize",pageUtils.getPageSize());


        /*查询商品数据*/
        List<Goods> goodsList = goodsService.findGoodsList(hashMap);
        /*查询所有品牌数据*/
        List<Brand> brandList = goodsService.findBrands();
        /*查询所有分类数据*/
        List<Cate> cateList = goodsService.findCateList();

        //将数据存放到model中
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("brandList",brandList);
        model.addAttribute("cateList",cateList);

                //将分页工具类的实例存放到域中
        model.addAttribute("pageUtils",pageUtils);
        return "list";
    }

}
