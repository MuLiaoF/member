package cn.wandingkeji.member.service.impl;

import cn.wandingkeji.member.service.MermberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MermberService {

    @Autowired
    private JedisClusterConnection jedisVersionUtil;

    @Override
    public String getMemberInfo() {
        return "";
    }
}
