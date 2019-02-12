package cn.ly.userservice.service;

import cn.ly.userservice.mapper.UserMapper;
import cn.ly.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class UserService {

    @Autowired
    public  UserMapper userMapper;
    public User queryById(Long id) throws InterruptedException {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        Thread.sleep(new Random().nextInt(2000));
        return (User) this.userMapper.selectByPrimaryKey(id);
    }
}
