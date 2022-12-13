package com.saul.design_model.aaatemplate.hook;

/**
 * @author 枫伦
 * @DESCRIPTION 运单号导入错误信息
 * @create 2021/5/27 2:47 下午
 */
public class TradeImporOutsidMsg {
    /**
     * 序号
     */
    private String columnNo;
    /**
     * 错误项
     */
    private String errorItem;
    /**
     * 导入内容
     */
    private String columnContent;
    /**
     * 错误说明
     */
    private String errorExplain;

    public String getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(String columnNo) {
        this.columnNo = columnNo;
    }

    public String getErrorItem() {
        return errorItem;
    }

    public void setErrorItem(String errorItem) {
        this.errorItem = errorItem;
    }

    public String getColumnContent() {
        return columnContent;
    }

    public void setColumnContent(String columnContent) {
        this.columnContent = columnContent;
    }

    public String getErrorExplain() {
        return errorExplain;
    }

    public void setErrorExplain(String errorExplain) {
        this.errorExplain = errorExplain;
    }
}
