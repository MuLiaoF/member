package cn.wandingkeji.member.service.impl;

import cn.wandingkeji.card.api.CardApi;
import cn.wandingkeji.member.service.MermberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MermberService {

    @Autowired
    private CardApi cardApi;


    @Override
    public String index() {
        return cardApi.index();
    }
}
