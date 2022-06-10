package com.youliao.team.service;
/**
 * 
 * @Description 表示员工的状态
 * @author HedianTea  Email:HedianTea@126.com
 * @version 
 * @date 2020年2月12日上午10:05:39
 *
 */
//public class Status {
//	private final String NAME;
//	private Status(String name){
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//
//}

public enum Status{
	FREE,BUSY,VOCATION;
}
