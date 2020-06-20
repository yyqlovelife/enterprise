package com.scut.blockchaine.Mapper;

import com.scut.blockchain.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询密码
    public String getPassword(String id) throws Exception;

    //获取用户信息
    public User getUser(String id) throws Exception;

    //创建新用户
    public void createUser(User user) throws Exception;
}
