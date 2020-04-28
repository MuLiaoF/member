package cn.wandingkeji.common.system.config.dataApi;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 7594090481518888604L;

	protected String id;
	protected Date gmtCreate;
	protected Date gmtModified;
	protected String creator;
	protected String modifier;
	protected String isDeleted;
	protected String bizCode;
}
