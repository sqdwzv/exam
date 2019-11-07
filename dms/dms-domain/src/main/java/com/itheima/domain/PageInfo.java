package com.itheima.domain;

import org.springframework.security.core.parameters.P;

import java.io.Serializable;
import java.util.List;

public class PageInfo implements Serializable {

    //总页数
    private Integer pages;
    //总数量
    private Integer total;
    //第一页
    private Integer navigateFirstPage;
    //最后一页
    private Integer navigateLastPage;
    //每页的条数
    private Integer pageSize;
    //当前页
    private Integer pageNum;
    //下一页
    private Integer nextPage;
    //上一页
    private Integer prePage;
    //每页数据
    private List<User> list;

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(Integer navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public Integer getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(Integer navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}


