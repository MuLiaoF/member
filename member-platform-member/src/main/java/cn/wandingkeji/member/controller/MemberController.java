package cn.wandingkeji.member.controller;

import cn.wandingkeji.common.system.config.controller.AbstractRestController;
import com.weupay.core.common.base.AbstractRestController;
import com.weupay.core.common.base.RestApiResult;
import com.weupay.member.mall.common.group.BussinessException;
import com.weupay.member.mall.controller.card.co.*;
import com.weupay.member.mall.service.card.MemberServiceI;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController extends AbstractRestController {

    @Autowired
    private IMemberService memberService;

    /**
     * 台卡会员消费
     *
     * @param response
     * @param storeId
     * @param empId
     * @param model
     * @return
     */
    @GetMapping("/authorize/code/{storeId}/{empId}/{state}")
    public String authorizeRedirectUri(HttpServletRequest request, HttpServletResponse response, @PathVariable("storeId") String storeId, @PathVariable("empId") String empId, @PathVariable("state") String state, Model model) {
        try {
            GetAgentType getAgentType = new GetAgentType(request).invoke();
            if (getAgentType.is()) {
                return "";
            }
            String userAgentType = getAgentType.getUserAgentType();
            String url = memberService.authorizeRedirectUri(storeId, empId, userAgentType, state);
            model.addAttribute("getCodeUrl", url);
            return "choosePayWay";
        } catch (BussinessException e) {
            log.error("会员授权异常！storeId:{},empId:{},ex:{}", storeId, empId, ExceptionUtils.getStackTrace(e));
            return "";
        }
    }


    /**
     * 会员消费获取公众号openiD及支付openId
     *
     * @param request
     * @param response
     * @param tempId
     * @param empId
     * @param flag     flag =1 tempId 为商户id,flag=0，tempId 为门店id
     * @param code
     * @param state    当state=0，为默认款台，只为获取支付的openId，state=1 为配置的门店，表示台牌，
     * @param model
     * @return
     */
    @GetMapping("/authorize/open/{tempId}/{empId}/{flag}")
    public String authorizePayOpenIdRedirectUri(HttpServletRequest request, HttpServletResponse response, @PathVariable("tempId") String tempId, @PathVariable("empId") String empId,
                                                @PathVariable("flag") String flag, @RequestParam(value = "code", required = false, defaultValue = "") String code, @RequestParam(value = "state", required = false, defaultValue = "0") String state, @RequestParam(value = "type", required = false, defaultValue = "1") String type,
                                                @RequestParam(value = "encrypt_code", required = false, defaultValue = "") String encrypt_code, @RequestParam(value = "card_id", required = false, defaultValue = "") String card_id, @RequestParam(value = "openid", required = false, defaultValue = "") String openid, @RequestParam(value = "outer_str", required = false, defaultValue = "") String outer_str, Model model) {
        try {
            CardTicketCO cardTicketCO = null;
            if (StringUtils.isNotBlank(encrypt_code) && StringUtils.isNotBlank(card_id) && StringUtils.isNotBlank(openid)) {
                cardTicketCO = new CardTicketCO();
                cardTicketCO.setCard_id(card_id);
                cardTicketCO.setEncrypt_code(encrypt_code);
                cardTicketCO.setOpenid(openid);
                cardTicketCO.setOuter_str(outer_str);
            } else {
                log.info("会员授权获取code,open！请求参数tempId={}，empId={}，flag={}，type={}，code={}，state={},card_id={},encrypt_code={},openid={},outer_str", tempId, empId, flag, type, code, state, card_id, encrypt_code, openid, outer_str);

            }
            GetAgentType getAgentType = new GetAgentType(request).invoke();
            if (getAgentType.is()) {
                return "";
            }
            String userAgentType = getAgentType.getUserAgentType();

            String url = memberService.authorizePayOpenIdRedirectUri(tempId, empId, flag, type, userAgentType, code, state, cardTicketCO);
            model.addAttribute("getCodeUrl", url);
            return "choosePayWay";
        } catch (BussinessException e) {
            log.error("会员授权获取公众号openId，支付openId异常！tempId={}，empId={}，flag={},code={}，state={} ex:", tempId, empId, flag, code, state, ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    /**
     * 快速买单
     *
     * @param response
     * @param mid
     * @param empId
     * @param model
     * @return
     */
    @GetMapping("/authorize/mcode/{mid}/{empId}")
    public String mAuthorizeRedirectUri(HttpServletResponse response, @PathVariable("mid") String mid, @PathVariable("empId") String empId,
                                        @RequestParam("encrypt_code") String encrypt_code, @RequestParam("card_id") String card_id, @RequestParam("openid") String openid, @RequestParam("outer_str") String outer_str, Model model) {
        try {
            CardTicketCO cardTicketCO = new CardTicketCO();
            cardTicketCO.setCard_id(card_id);
            cardTicketCO.setEncrypt_code(encrypt_code);
            cardTicketCO.setOpenid(openid);
            cardTicketCO.setOuter_str(outer_str);
            log.error("快速买单会员授权！请求参数mid:{},empId:{},cardTicketCO:{}", mid, empId, cardTicketCO);
            String url = memberService.mAuthorizeRedirectUri(mid, empId, cardTicketCO);
            model.addAttribute("getCodeUrl", url);
            return "choosePayWay";
        } catch (BussinessException e) {
            log.error("快速买单会员授权异常！storeId:{},empId:{},ex:{}", mid, empId, ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    @GetMapping("/mchnt/{mid}")
    public @ResponseBody
    RestApiResult<List<StoreCO>> initStore(HttpServletResponse response, @PathVariable("mid") Integer mid) {
        try {
            List<StoreCO> storeCOS = memberService.listStore(mid);
            return success(storeCOS);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return failure(e.getMessage());
        }
    }

    @GetMapping("/store/{sid}")
    public @ResponseBody
    RestApiResult<List<EmployeeCO>> initStoreList(HttpServletResponse response, @PathVariable("sid") Integer sid) {
        try {
            log.info("通过门店查询款台，条件sid={}", sid);
            List<EmployeeCO> employeeCOS = memberService.listEmp(sid);
            return success(employeeCOS);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return failure(e.getMessage());
        }
    }

    @GetMapping("/emp/list/{storeId}/{empId}/{code}")
    public @ResponseBody
    RestApiResult<MemberInitInfoCO> init(HttpServletResponse response, @PathVariable("code") String code, @PathVariable("storeId") String storeId, @PathVariable("empId") String empId) {
        try {
            MemberInitInfoCO memberInitInfoCOS = memberService.init(storeId, empId, code);
            return success(memberInitInfoCOS);
        } catch (BussinessException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return failure(e.getMessage());
        }
    }

    /**
     * 微信支付宝,会员消费预下单
     */
    @PostMapping("/emp/{empId}/preOrder")
    public @ResponseBody
    RestApiResult<PreOrderInfoCO> preOrder(HttpServletRequest request, HttpServletResponse response, @PathVariable("empId") String empId, @RequestBody MemberPreOrderCO memberPreOrderCO) {
        try {
            PreOrderInfoCO preOrderInfoCO = memberService.preOrder(request.getRemoteAddr(), empId, memberPreOrderCO);
            return success(preOrderInfoCO);
        } catch (BussinessException e) {
            log.error(ExceptionUtils.getStackTrace(e));
            return failure(e.getMessage());
        }
    }

    /**
     * 会员支付
     */
    @PostMapping("/emp/memPay")
    public @ResponseBody
    RestApiResult<MemberPayOrderInfoCO> memPay(HttpServletRequest request, @RequestBody MemberPayOrderCO memberPayOrderCO) {
        try {
            log.info("----------会员支付---------->"+memberPayOrderCO.toString());
            String auth = request.getHeader("ack");
            MemberPayOrderInfoCO memberPayOrderInfoCO = memberService.memPay(request.getRemoteAddr(), memberPayOrderCO);
            return success(memberPayOrderInfoCO);
        } catch (Exception e) {
            return failure(e.getMessage());
        }
    }

    /**
     * 领取 卡券
     */
    @PostMapping("/card/coupon")
    public @ResponseBody
    RestApiResult<MemberPayCardCouponCO> memCardCoupon(HttpServletRequest request, @RequestBody String requestParam) {
        try {
            MemberPayCardCouponCO memberPayCardCouponCO = memberService.memCardCoupon(requestParam);
            return success(memberPayCardCouponCO);
        } catch (Exception e) {
            return failure(e.getMessage());
        }
    }


    private class GetAgentType {
        private boolean myResult;
        private HttpServletRequest request;
        private String userAgentType;

        public GetAgentType(HttpServletRequest request) {
            this.request = request;
        }

        boolean is() {
            return myResult;
        }

        public String getUserAgentType() {
            return userAgentType;
        }

        public GetAgentType invoke() {
            userAgentType = "";
            String userAgentHeader = request.getHeader("User-Agent");
            if (StringUtils.isNotBlank(userAgentHeader)) {
                if (userAgentHeader.toLowerCase().indexOf("micromessenger") > 0) {
                    //微信
                    userAgentType = "1";
                } else if (userAgentHeader.toLowerCase().indexOf("alipayclient") > 0) {
                    //支付宝
                    userAgentType = "2";
                } else {
                    log.error("暂不支持该应用扫描二维码！userAgentHeader={}", userAgentHeader);
                    myResult = true;
                    return this;
                }
            } else {
                log.error("暂不支持该应用扫描二维码！userAgentHeader={}", userAgentHeader);
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }
}
