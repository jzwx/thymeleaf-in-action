package com.jzwx.spring.boot.blog.domain;

/**
 * User 实体类
 *
 * @author jzwx
 * @version $ Id: User, v 0.1 2018/1/28 14:13 jzwx Exp $
 */
public class User {

    private Long   id;    // 实体唯一标识

    private String name;  //用户名

    private String email; //邮箱

    public User() { //无参构造函数
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

}
