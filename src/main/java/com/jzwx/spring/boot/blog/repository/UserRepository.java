package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.User;

import java.util.List;

/**
 * UserRepository 接口
 *
 * @author jzwx
 * @version $ Id: UserRepository, v 0.1 2018/1/31 18:51 jzwx Exp $
 */
public interface UserRepository {
    /**
     * 创建或编辑用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Long id);

    /**
     * 根据id查询单个用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> listUsers();
}
