package com.example.xademo.db118.dao;

import com.example.xademo.db118.model.XA118;
import com.example.xademo.db118.model.XA118Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XA118Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    long countByExample(XA118Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int deleteByExample(XA118Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int insert(XA118 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int insertSelective(XA118 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    List<XA118> selectByExample(XA118Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    XA118 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int updateByExampleSelective(@Param("record") XA118 record, @Param("example") XA118Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int updateByExample(@Param("record") XA118 record, @Param("example") XA118Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int updateByPrimaryKeySelective(XA118 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xa_131
     *
     * @mbg.generated Wed Oct 02 17:01:02 CST 2019
     */
    int updateByPrimaryKey(XA118 record);
}