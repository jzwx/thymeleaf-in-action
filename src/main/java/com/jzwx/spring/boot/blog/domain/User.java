package com.jzwx.spring.boot.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User 实体类
 *
 * @author jzwx
 * @version $ Id: User, v 0.1 2018/1/28 14:13 jzwx Exp $
 */
@Entity //实体
public class User {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//数据库自增策略
    private Long   id;    // 实体唯一标识

    private String name;  //用户名

    private String email; //邮箱

    protected User() { //无参构造函数;设置为protected防止直接使用
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d,name='%s',email='%s']",id,name,email);
    }
}
