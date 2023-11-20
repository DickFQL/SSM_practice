package com.ssm.utils;

/*    -      首页 1
            -下一页 当前页的基础上 + 1 nextPage
            -上一页 当前页基础上 - 1 prevPage
            -尾页 总页数 lastPage
            -分页单位 多少条记录为一页 pageSize
            -总记录条数 当前数据库中的数据记录一共为多少页 count
            -当前页 当前的页码值 currentPage
            -起始索引位置 = （当前页 - 1）* 分页单位
            -分页sql
            select * from tb_emp limit 起始索引位置,分页单位*/

import org.springframework.stereotype.Component;

@Component
public class PageUtils {

    //当前页
    private String currentPage;

    //上一页
    private Integer prevPage;

    //下一页
    private Integer nextPage;

    //总记录条数
    private Integer count;

    //尾页
    private Integer lastPage;

    //分页单位
    private Integer pageSize;

    //起始索引位置
    private Integer indexStart;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIndexStart() {
        return indexStart;
    }

    public void setIndexStart(Integer indexStart) {
        this.indexStart = indexStart;
    }

    //计算上一页
    private void initPrevPage(){

       this.prevPage = this.currentPage.equals("1") ? Integer.parseInt(this.currentPage) : Integer.parseInt(this.currentPage) - 1;

    }

    //计算尾页
    private void initLastPage(){

        this.lastPage = this.count % this.pageSize == 0 ? this.count / this.pageSize : (this.count / this.pageSize) + 1;

    }

    //计算下一页
    private void initNextPage(){

        this.nextPage = this.currentPage.equals(this.lastPage+"") ? this.lastPage : Integer.parseInt(this.currentPage) + 1;

    }

    //起始索引位置
    private void initIndexStart(){

        this.indexStart = (Integer.parseInt(this.currentPage) - 1) * this.pageSize;

    }

    //初始化数据
    public void initData(String currentPage,Integer count,Integer pageSize){

        if (currentPage == null || currentPage.equals("")){

            this.currentPage = "1";

        }else {

            this.currentPage = currentPage;
        }

        this.count = count;
        this.pageSize = pageSize;
        this.initPrevPage();
        this.initLastPage();
        this.initNextPage();
        this.initIndexStart();
    }
}
