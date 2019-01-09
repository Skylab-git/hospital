package com.imooc.hospital.dao;

import com.imooc.hospital.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from users")
    List<User> selectAllUser();
}
