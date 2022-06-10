package com.youliao.enums;

/**
 * @Author HedianTea
 * @Date 2022/2/15 22:10
 * @Version 1.0
 * @Description
 */
public enum EnumProductIdSummery {
	NBCBZJD001("NBCBZJD001", "直接贷助贷"),
	NBCBZJD003("NBCBZJD001", "直接贷B");


	private String code;
	private String msg;

	EnumProductIdSummery(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
