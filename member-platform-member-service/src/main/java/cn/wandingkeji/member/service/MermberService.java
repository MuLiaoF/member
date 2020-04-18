package cn.wandingkeji.member.service;

import cn.wandingkeji.card.api.CardApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "card")
public interface MermberService extends CardApi {


}
