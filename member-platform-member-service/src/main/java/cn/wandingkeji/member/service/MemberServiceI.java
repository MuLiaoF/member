package cn.wandingkeji.member.service;

import com.weupay.member.mall.common.group.BussinessException;
import com.weupay.member.mall.controller.card.co.*;
import com.weupay.member.mall.controller.card.co.MemberPayCardCouponCO;

import java.util.List;


public interface MemberServiceI {

    MemberInitInfoCO init(String storeId, String empId, String code) throws BussinessException;

    PreOrderInfoCO preOrder(String remoteAddr, String empId, MemberPreOrderCO memberPreOrderCO) throws BussinessException;

    String authorizeRedirectUri(String storeId, String empId, String userAgentType, String state) throws BussinessException;

    MemberPayOrderInfoCO memPay(String remoteAddr, MemberPayOrderCO memberPayOrderCO) throws BussinessException;

    List<StoreCO> listStore(Integer mid);

    List<EmployeeCO> listEmp(Integer sid);

    String authorizePayOpenIdRedirectUri(String tempId, String empId, String flag, String type, String userAgentType, String code, String state, CardTicketCO cardTicketCO) throws BussinessException;

    String mAuthorizeRedirectUri(String mid, String empId, CardTicketCO cardTicketCO) throws BussinessException;

    MemberPayCardCouponCO memCardCoupon(String requestParam);
}
