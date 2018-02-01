package com.jzwx.spring.boot.blog.repository;

import com.jzwx.spring.boot.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * UserRepository 接口
 *
 * @author jzwx
 * @version $ Id: UserRepository, v 0.1 2018/1/31 18:51 jzwx Exp $
 */
public interface UserRepository extends CrudRepository<User,Long>{
}
