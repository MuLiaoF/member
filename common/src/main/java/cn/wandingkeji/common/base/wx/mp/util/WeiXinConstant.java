package cn.wandingkeji.common.base.wx.mp.util;

public class WeiXinConstant {

	public WeiXinConstant(){}
	
	public static final String WX_CREAT_CARD="https://api.weixin.qq.com/card/create?access_token=";//创建卡
	public static final String WX_ONEBUTTON_ACTIVATION_CARD="https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=";//一键激活会员卡
	public static final String WX_ACTIVATION_CARD="https://api.weixin.qq.com/card/membercard/activate?access_token=";//激活接口
	public static final String WX_GET_USERINFO="https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=";//拉取会员信息接口
	public static final String WX_GET_STOREINFO="https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=";//查询门店列表
	public static final String WX_GET_CARD_STATUS="https://api.weixin.qq.com/card/get?access_token=";//查看卡券详情
	public static final String WX_UPLOAD_LOG="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";//上传log,背景图
	public static final String WX_CREATE_QRCODE="https://api.weixin.qq.com/card/qrcode/create?access_token=";//创建二维码接口
	public static final String WX_GET_QRCODE_BY_TICKET="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";//下载官方二维码提醒：TICKET记得进行UrlEncode
	public static final String WX_TEST_WHITE="https://api.weixin.qq.com/card/testwhitelist/set?access_token=";//设置测试白名单
	public static final String WX_UPDATE_USER="https://api.weixin.qq.com/card/membercard/updateuser?access_token=";//更新会员信息
	
	/**
	 * add by fjr code接口
	 */
	public static final String WX_DEPOSIT_CODE="http://api.weixin.qq.com/card/code/deposit?access_token=";//批量导入code接口
	public static final String WX_GET_CODE_COUNT="http://api.weixin.qq.com/card/code/getdepositcount?access_token=";//查询导入code数目接口
	public static final String WX_CHECK_CODE="http://api.weixin.qq.com/card/code/checkcode?access_token=";//核查code接口
	public static final String WX_MODIFYSTOCK="https://api.weixin.qq.com/card/modifystock?access_token=";//修改库存接口
	
	//add by ws 
	public static final String WX_PAY_GIFT_CARD="https://api.weixin.qq.com/card/paygiftcard/add?access_token=";//支付即会员接口
	public static final String WX_UNAVAILABLE="https://api.weixin.qq.com/card/code/unavailable?access_token=";//设置卡券失效接口
	public static final String WX_DELETE_CARD="https://api.weixin.qq.com/card/delete?access_token=";//删除卡券接口
	public static final String WX_DELETE_PAY_GIFT="https://api.weixin.qq.com/card/paygiftcard/delete?access_token=";// 删除支付后投放卡券规则接口

	public static final String WX_QUERY_CODE="https://api.weixin.qq.com/card/code/get?access_token=";//查询Code接口
	public static final String WX_CONSUME_CODE="https://api.weixin.qq.com/card/code/consume?access_token=";//核销Code接口

	public static final String WX_DECRYPT_CODE="https://api.weixin.qq.com/card/code/decrypt?access_token=";// 解密code接口
	
	public static final String WX_SELF_CONSUM="https://api.weixin.qq.com/card/selfconsumecell/set?access_token=";//设置自助核销接口
	
	public static final String WX_UPDATE_CARD_INFO="https://api.weixin.qq.com/card/update?access_token=";//更改会员卡信息接口
	public static final String WX_GET_STORE_LIST="https://api.weixin.qq.com/wxa/get_store_list?access_token=";//获取门店信息列表(门店小程序)
	
	//add fjr 
	public static final String API_COMPONENT_TOKEN="https://api.weixin.qq.com/cgi-bin/component/api_component_token";//第三方平台component_access_token
	public static final String WX_QUERY_AUTH="https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";//使用授权码换取公众号或小程序的接口调用凭据和授权信息
	public static final String AUTHORIZER_REFRESH_TOKEN="https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=";//获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
	public static final String GET_AUTHORIZER_INFO="https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=";//获取授权方的帐号基本信息
	public static final String CREATE_PREAUTHCODE="https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";//获取授权方的帐号基本信息
	public static final String ACCESSBYCODE_COMP="https://api.weixin.qq.com/sns/oauth2/component/access_token?appid=%s&code=%s&grant_type=authorization_code&component_appid=%s&component_access_token=%s";//通过code换取access_token
	//ADD WS
	public static final String ACTIVATE_GETURL= "https://api.weixin.qq.com/card/membercard/activate/geturl?access_token=";//小程序获取开卡插件参数
	public static final String GET_ACTIVE_INFO= "https://api.weixin.qq.com/card/membercard/activatetempinfo/get?access_token=";
	//小程序第三方平台相关地址
	public static final String MODIFY_DOMAIN= "https://api.weixin.qq.com/wxa/modify_domain?access_token=";//将域名登记到第三方平台的小程序服务器域名中
	public static final String WEBVIEWDOMAIN = "https://api.weixin.qq.com/wxa/setwebviewdomain?access_token=";//设置小程序业务域名（仅供第三方代小程序调用）
	public static final String BIND_TESTER= "https://api.weixin.qq.com/wxa/bind_tester?access_token=";//绑定微信用户为小程序体验者
	public static final String UNBIND_TESTER= "https://api.weixin.qq.com/wxa/unbind_tester?access_token=";//解除绑定小程序的体验者
	public static final String COMMIT_MINI_PROGRAM = "https://api.weixin.qq.com/wxa/commit?access_token=";//为授权的小程序帐号上传小程序代码
	public static final String SUBMIT_AUDIT = "https://api.weixin.qq.com/wxa/submit_audit?access_token=";//将第三方提交的代码包提交审核
	
	//add by wjl(2018-01-10)
	public static final String GET_QRCODE = "https://api.weixin.qq.com/wxa/get_qrcode?access_token=";//获取小程序的体验二维码
	public static final String GET_CATEGORY = "https://api.weixin.qq.com/wxa/get_category?access_token=";//获取授权小程序帐号的可选类目
	public static final String GET_PAGE= "https://api.weixin.qq.com/wxa/get_page?access_token=";//获取小程序的第三方提交代码的页面配置
	public static final String GET_LATEST_AUDITSTATUS = "https://api.weixin.qq.com/wxa/get_latest_auditstatus?access_token=";//查询最新一次提交的审核状态
	public static final String RELEASE = "https://api.weixin.qq.com/wxa/release?access_token=";//发布已通过审核的小程序
	public static final String GET_AUDIT_STATUS = "https://api.weixin.qq.com/wxa/get_auditstatus?access_token=";//查询某个指定版本的审核状态（仅供第三方代小程序调用）
}
