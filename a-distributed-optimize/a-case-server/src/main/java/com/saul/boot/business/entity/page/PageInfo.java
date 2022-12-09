package com.saul.boot.business.entity.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PageInfo<T> {

    @ApiModelProperty(value = "当前页", example = "1", position = 10)
    private int pageNum;

    @ApiModelProperty(value = "每页数量", example = "10", position = 20)
    private int pageSize;

    @ApiModelProperty(value = "总记录数", example = "100", position = 30)
    private int total;

    @ApiModelProperty(value = "分页对象", position = 40)
    private List<T> data;

    public PageInfo() {

    }

    private <U> PageInfo(IPage<U> that) {
        this.pageNum = (int) that.getCurrent();
        this.pageSize = (int) that.getSize();
        this.total = (int) that.getTotal();
    }

    public static <T> PageInfo<T> build(IPage<T> page) {
        PageInfo<T> pageInfo = new PageInfo<>(page);
        pageInfo.data = page.getRecords();
        return pageInfo;
    }

    public static <U, T> PageInfo<T> build(IPage<U> page, Class<T> clz) {
        PageInfo<T> pageInfo = new PageInfo<>(page);
        pageInfo.data = page.getRecords().stream().map(u -> {
            try {
                T t = clz.newInstance();
                BeanUtils.copyProperties(u, t);
                return t;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        return pageInfo;
    }
}
