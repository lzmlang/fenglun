package com.saul.boot.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.saul.boot.business.entity.CoreUserDTO;
import com.saul.boot.business.entity.CoreUserVO;
import com.saul.boot.business.entity.page.PageQuery;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author luozm
 * @since 2020-06-30
 */
@Mapper
public interface UserMapper extends BaseMapper<CoreUserVO> {
    PageQuery<CoreUserVO> getPageList(PageQuery<CoreUserDTO> query);


}
