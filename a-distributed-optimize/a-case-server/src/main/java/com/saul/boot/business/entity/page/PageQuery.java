package com.saul.boot.business.entity.page;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import javax.validation.Valid;
import java.util.List;

/**
 * <b>Description:</b><br>
 * 分页条件查询对象，自动封装 wrapper
 *
 * @author Abe
 * @version 1.0
 * <br><b>Date:</b> 2019/7/18 10:53
 */
public class PageQuery<T> extends Page<T> {

    @Valid
    private T queryData;

    private Object origin;

    public PageQuery() {
        super(1, 10);
    }

    private PageQuery(T queryData) {
        this();
        setQueryData(queryData);
    }

    @ApiModelProperty(value = "当前页码(默认为1)", example = "1", position = 10)
    public long getPageNum() {
        return getCurrent();
    }

    @ApiModelProperty(value = "每页行数(默认为10)", example = "10", position = 20)
    public long getPageSize() {
        return getSize();
    }

    @ApiModelProperty(value = "条件对象", position = 30)
    public T getQueryData() {
        return queryData;
    }

    public void setPageNum(int pageNum) {
        setCurrent(pageNum);
    }

    public void setPageSize(int pageSize) {
        setSize(pageSize);
    }

    public void setQueryData(T queryData) {
        this.queryData = queryData;
        if (origin == null) {
            origin = queryData;
        }
    }

    /**
     * 将 PageQuery 转换为目标泛型
     */
    public <U> PageQuery<U> toOther(Class<U> clz) {
        PageQuery<U> other = new PageQuery<>();
        try {
            U u = clz.newInstance();
            BeanUtils.copyProperties(this, other, "queryData", "origin");
            other.setQueryData(u);
            other.origin = origin;
            return other;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <U> PageInfo<U> toPageInfo(Class<U> clz) {
        return PageInfo.build(this, clz);
    }

    public <T> PageInfo<T> toPageInfo() {
        return (PageInfo<T>) PageInfo.build(this);
    }

    @JsonIgnore
    @Override
    public List<T> getRecords() {
        return super.getRecords();
    }

    @JsonIgnore
    @Override
    public long getTotal() {
        return super.getTotal();
    }

    @JsonIgnore
    @Override
    public long getSize() {
        return super.getSize();
    }

    @JsonIgnore
    @Override
    public long getCurrent() {
        return super.getCurrent();
    }

    @JsonIgnore
    @Override
    public List<OrderItem> getOrders() {
        return super.getOrders();
    }

    @JsonIgnore
    @Override
    public boolean optimizeCountSql() {
        return super.optimizeCountSql();
    }

    @JsonIgnore
    @Override
    public Page<T> setOptimizeCountSql(boolean optimizeCountSql) {
        return super.setOptimizeCountSql(optimizeCountSql);
    }

    @JsonIgnore
    @Override
    public long getPages() {
        return super.getPages();
    }

    @JsonIgnore
    @Override
    public boolean isSearchCount() {
        return super.isSearchCount();
    }
}
