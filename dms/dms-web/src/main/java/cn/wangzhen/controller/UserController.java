package cn.wangzhen.controller;

import cn.itheima.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.domain.PageInfo;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;
    @RequestMapping("/findAll")
    private ModelAndView findAll(ModelAndView modelAndView,Integer page,Integer pageSize){
        modelAndView.setViewName("/pages/user-list.jsp");
      PageInfo pageInfo = userService.pageFindAll(page,pageSize);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }
    @RequestMapping("/toUpdate")
    private ModelAndView toUpdate(ModelAndView modelAndView,String id){
       User user = userService.toUpdate(id);
       modelAndView.setViewName("/pages/user-edit.jsp");
       modelAndView.addObject("user",user);
       return modelAndView;
    }
    @RequestMapping("/edit")
    private ModelAndView edit(ModelAndView modelAndView,User user){
        userService.edit(user);
        modelAndView.setViewName("/user/findAll.do");
        return modelAndView;
    }
    @RequestMapping("/add")
    private ModelAndView add(ModelAndView modelAndView,User user){
        userService.add(user);
        modelAndView.setViewName("/pages/user-list.jsp");
        return modelAndView;
    }
}
