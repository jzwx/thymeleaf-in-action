package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UserRepositoryImpl 类
 *
 * @author jzwx
 * @version $ Id: UserRepositoryImpl, v 0.1 2018/1/31 19:00 jzwx Exp $
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    /**
     * 计数id
     */
    private static AtomicLong counter=new AtomicLong();

    /**
     * 存储用户信息map
     */
    private final ConcurrentMap<Long,User> userMap=new ConcurrentHashMap<>();

    /**
     * 创建或编辑用户
     * @param user
     * @return
     */
    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id == null){
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public List<User> listUsers() {
        return new ArrayList<User>(this.userMap.values());
    }
}
