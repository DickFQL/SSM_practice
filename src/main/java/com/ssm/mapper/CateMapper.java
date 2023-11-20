package com.ssm.mapper;

import com.ssm.pojo.Cate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CateMapper {

    /**
     * 查询所有分类
     * @return
     */
    List<Cate> findCateList();
}
