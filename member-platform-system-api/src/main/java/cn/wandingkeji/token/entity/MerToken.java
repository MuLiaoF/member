package cn.wandingkeji.token.entity;

import lombok.*;

import java.sql.Timestamp;

/*
 * 商户token关联表
 * add by ws
 * 20190531
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MerToken {

	private int id;
	private int mid;
	private int token_id;
	private String token_type;
	private Timestamp create_time;
	
}
