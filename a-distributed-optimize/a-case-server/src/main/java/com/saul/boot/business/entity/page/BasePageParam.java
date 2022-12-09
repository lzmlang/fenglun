package com.saul.boot.business.entity.page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * <br>
 *
 * @author luo_zm
 * @create 2019/10/15 23:21
 */
@JsonIgnoreProperties(
    ignoreUnknown = true
)
public class BasePageParam implements Serializable {
    private static final long serialVersionUID = 7586201228025373078L;
    /**
     * 页码
     */
    private int pageIndex = 1;

    /**
     * 页大小
     */
    private int pageSize = 10;
    /**
     * 分页查询起始记录数
     */
    private int startIndex;

    public BasePageParam(int pageIndex, int pageSize) {
        if (pageIndex > 0 && pageSize > 0) {
            this.pageIndex = pageIndex;
            this.pageSize = pageSize;
        }
        this.startIndex = (this.pageIndex - 1) * this.pageSize;
    }

    public BasePageParam(int pageIndex, int pageSize, int startIndex) {
        if (pageIndex > 0 && pageSize > 0) {
            this.pageIndex = pageIndex;
            this.pageSize = pageSize;
        }
        this.startIndex = (this.pageIndex - 1) * this.pageSize;
    }

    public BasePageParam() {
        this.startIndex = (this.pageIndex - 1) * this.pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return (this.pageIndex - 1) * this.pageSize;
    }

}
