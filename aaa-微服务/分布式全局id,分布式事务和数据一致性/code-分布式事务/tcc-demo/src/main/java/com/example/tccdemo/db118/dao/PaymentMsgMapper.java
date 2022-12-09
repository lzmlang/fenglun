package com.example.tccdemo.db118.dao;

import com.example.tccdemo.db118.model.PaymentMsg;
import com.example.tccdemo.db118.model.PaymentMsgExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentMsgMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    long countByExample(PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int deleteByExample(PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int insert(PaymentMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int insertSelective(PaymentMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    List<PaymentMsg> selectByExample(PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    PaymentMsg selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int updateByExampleSelective(@Param("record") PaymentMsg record, @Param("example") PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int updateByExample(@Param("record") PaymentMsg record, @Param("example") PaymentMsgExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int updateByPrimaryKeySelective(PaymentMsg record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_msg
     *
     * @mbg.generated Sat Oct 05 16:53:18 CST 2019
     */
    int updateByPrimaryKey(PaymentMsg record);
}