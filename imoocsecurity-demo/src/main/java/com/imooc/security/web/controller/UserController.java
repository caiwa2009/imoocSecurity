package com.imooc.security.web.controller;

import com.imooc.security.dto.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class UserController {
    @GetMapping(value ="/user")
//    Pageable指的是分页查询
//    @PageableDefault是默认分页注解
    public List<User> queryUser(@RequestParam(required = false) String username, @PageableDefault(size = 10,page = 5,sort = "username,asc") Pageable pageable){
        List<User> list=new ArrayList<>();
        list.add(new User());
        list.add(new User());
        System.out.println("---------------------------------------------");
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        return list;
    }
}
