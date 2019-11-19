package cn.itheima;

import com.itheima.domain.PageInfo;
import com.itheima.domain.User;

public interface UserService {
     PageInfo pageFindAll(Integer page, Integer pageSize);

    User toUpdate(String id);

    void edit(User user);

    void add(User user);
}
