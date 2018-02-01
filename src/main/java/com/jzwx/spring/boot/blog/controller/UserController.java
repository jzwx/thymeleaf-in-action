package com.jzwx.spring.boot.blog.controller;

import com.jzwx.spring.boot.blog.domain.User;
import com.jzwx.spring.boot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController 类
 *
 * @author jzwx
 * @version $ Id: UserController, v 0.1 2018/1/31 19:30 jzwx Exp $
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 查询用户详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户详情");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null,null,null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 保存或者修改用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:/users");//重定向到list页面
    }

    /**
     * 珊瑚用户信息页面
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return new ModelAndView("redirect:/users");//重定向到list页面
    }

    /**
     * 获取修改用户页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
