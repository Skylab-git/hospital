package com.imooc.hospital.service.impl;

import com.imooc.hospital.dao.UserDao;
import com.imooc.hospital.entity.User;
import com.imooc.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
        List<User> userList = userDao.selectAllUser();
        return userList;
    }

}
