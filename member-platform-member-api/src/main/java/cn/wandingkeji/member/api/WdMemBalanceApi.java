package cn.wandingkeji.member.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("member")
public interface WdMemBalanceApi {
}
