package com.saul.boot.business.entity.page;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * 对象 分页请求和响应实体 TO
 * 
 * @author Administrator 对象业务层封装 提供setter 计算的数据 可以直接提供getter 计算出来
 */
@Slf4j
public class Pagenation<T> implements Serializable {

	private static final long serialVersionUID = -1868112579978738299L;

	private int pageIndex = 1;// 当前页码 每一次请求 来自 web 接受请求
	private int pageSize = 1;// 每页显示记录数 固定不动
	private int totalPage;// 总页码 计算出来 : 总记录数 和 每页显示记录数
	private int beforePage;// 上一页 当前页码 -1
	private int nextPage;// 下一页 当前页码+1
	private int pageBar[];// 每次查询 分页栏每一个显示页码 6----15 计算出来 总页码+当前页码计算出来
	private List<T> list;// 每一次查询 分页记录数 // 数据库查询 select * from xxx limit ?,?
	// 第一个问号 起始记录数 (pageNum-1)*pageSize 0 开始 0,10 第一页数据 10,10 第二页数据 20,10
	private long totalItem;// 总记录数 // 来自数据查询 ...业务层封装
	private int startIndex;// 分页查询的起始记录数

	// private Map<String, String[]> paramMap;// 接受所有请求参数信息 ...给后续 条件分页 查询 准备

	// public Map<String, String[]> getParamMap() {
	// return paramMap;
	// }
	//
	// public void setParamMap(Map<String, String[]> paramMap) {
	// this.paramMap = paramMap;
	// }

	// // 拼接URL字符串 getParamUrl 作用 关乎 后续 分页条件查询 例如 点击下一页 xxxAction_list?${pageNation.paramUrl} =&nm=xx&name=xxx
	// public String getParamUrl() {
	// if (paramMap != null && !paramMap.isEmpty()) {
	// String paramUrl = "";
	// // 遍历map
	// for (Entry<String, String[]> entry : paramMap.entrySet()) {
	// String key = entry.getKey();
	// if (key.equals("pageNum") || key.equals("pageSize")) {
	// continue;
	// }
	// String value = entry.getValue() == null ? null : entry.getValue()[0];
	// paramUrl += "&" + key + "=" + value;
	// }
	// if (paramUrl.startsWith("&")) {
	// return paramUrl.substring(1);
	// } else {
	// return paramUrl;
	// }
	// }
	// return "";
	// }

	public int getStartIndex() {
		this.startIndex = (this.pageIndex - 1) * this.pageSize;
		return this.startIndex;// 计算出分页查询的起始记录数
	}

	public int getPageIndex() {
		if(this.pageIndex < 1){
			pageIndex = 1;
		}
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		if(this.pageSize < 1){
			pageSize = 1;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 总页码
	 * 
	 * @return
	 */
	public int getTotalPage() {
		// 数学计算 总记录数 以及 每页显示记录数
		// 10 120 12 10 119 12 10 121 13
		this.totalPage = ((int) this.totalItem + this.pageSize - 1) / this.pageSize;// 数学公式
		return this.totalPage;
	}

	/**
	 * 上一页
	 * 
	 * @return
	 */
	public int getBeforePage() {
		this.beforePage = this.pageIndex - 1;
		if (this.beforePage <= 0) {
			this.beforePage = 1;
		}
		return this.beforePage;
	}

	// 下一页
	public int getNextPage() {
		this.nextPage = this.pageIndex + 1;
		if (this.nextPage >= this.totalPage) {
			this.nextPage = this.totalPage;
		}
		return this.nextPage;
	}

	/*
	 * 页码栏数值 4----9 ----13
	 */
	public int[] getPageBar() {
		// 由当前页码 总页码 计算 规则 前五后四规则 基于 总页码>10 每次显示10个页码
		// 计算起始页码 数字 以及 末尾 页码数字
		int beginPage;// 起始页码 4
		int endPage;// 末尾数字 13
		// 1: 如果总页码 小于 10
		if (this.totalPage <= 10) {
			// 没有前五后四原则
			beginPage = 1;
			endPage = this.totalPage;
		} else {
			// 总页码大于10 前五后四 4
			beginPage = this.pageIndex - 5;
			endPage = this.pageIndex + 4; // 13 12
			// 排除 小于 0 大于总页码情况
			if (beginPage <= 0) {
				beginPage = 1;
				endPage = beginPage + 9;
			}

			if (endPage >= this.totalPage) {
				endPage = this.totalPage;
				beginPage = this.totalPage - 9;
			}

		}
		// 定好 起始数字 末尾数字 计算 beginPage 4 pageNum 9 endPage = 13
		this.pageBar = new int[endPage - beginPage + 1];
		int index = 0;
		for (int i = beginPage; i <= endPage; i++) {
			this.pageBar[index++] = i;
		}
		// 分页栏页码完成封装了!
		return this.pageBar;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(long totalItem) {
		this.totalItem = totalItem;
	}
//	public HashMap<String, Object> convertToMap() {
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		Field[] fields = FieldUtils.getAllFields(this.getClass());
//		for (int i = 0, len = fields.length; i < len; i++) {
//			String varName = fields[i].getName();
//			if ("log".equals(varName)) {
//				continue;
//			}
//
//			try {
//				fields[i].setAccessible(true);
//				Object o = fields[i].get(this);
//				map.put(varName, o);
//			}catch (Exception e) {
//				log.warn(e.getMessage());
//			}
//		}
//
//		return map;
//	}
}
