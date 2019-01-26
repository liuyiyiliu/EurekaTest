package cn.ly.userconsumer.Dao;


import cn.ly.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private RestTemplate restTemplate;

   // @Autowired
   // private DiscoveryClient client;
    public User queryByid(Long id){
       // List<ServiceInstance> instances = client.getInstances("user-service");
        //如果是一个服务名称 多个tomcat 使用逻辑算方法(随机数和取余)
       // ServiceInstance serviceInstance = instances.get(0);

        //String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
        String url = "http://user-service/user/" + id;
        return this.restTemplate.getForObject(url,User.class);
    }
}
