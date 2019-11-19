package com.itheima.service;

import cn.itheima.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.domain.PageInfo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo pageFindAll(Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 3;
        }
        PageHelper.startPage(page, pageSize);
        Page<User> page1 = (Page<User>) userMapper.selectByExample(null);
        com.itheima.domain.PageInfo pageInfo = new com.itheima.domain.PageInfo();

        int pages = page1.getPages();
        pageInfo.setPages(pages);

        long total = page1.getTotal();
        pageInfo.setTotal((int) total);

        pageInfo.setNavigateFirstPage(1);

        //最后一页
        pageInfo.setNavigateLastPage(pages);

        //每页多少条
        pageInfo.setPageSize(pageSize);

        //当前页
        pageInfo.setPageNum(page);

        //下一页
        pageInfo.setNextPage(page + 1);

        //上一页
        pageInfo.setPrePage(page-1);

        List<User> result = page1.getResult();
        pageInfo.setList(result);

        return pageInfo;

    }

    @Override
    public User toUpdate(String id) {
       User user = userMapper.selectByPrimaryKey(id);
       return user;
    }
    @Override
    public void  edit(User user){
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
