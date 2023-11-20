package com.ssm.mapper;

import com.ssm.pojo.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {
    /**
     * 查询所有品牌
     *
     * @return
     */
    List<Brand> findBrands();

}
