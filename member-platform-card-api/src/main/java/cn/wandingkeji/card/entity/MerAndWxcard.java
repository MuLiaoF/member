package cn.wandingkeji.card.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/*
 * 商户和会员卡关联关系表
 * add by ws
 * 20190627
 */
@Setter
@Getter
@ToString
public class MerAndWxcard {

	private int id;
	private Integer mid;
	private String wx_card_id;
	private String card_name;
	private String is_open;
	private Timestamp create_time;

	
}
