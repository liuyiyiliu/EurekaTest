package cn.ly.userservice.service;

import cn.ly.userservice.mapper.UserMapper;
import cn.ly.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    public  UserMapper userMapper;
    public User queryById(Long id){
        return (User) this.userMapper.selectByPrimaryKey(id);
    }
}
