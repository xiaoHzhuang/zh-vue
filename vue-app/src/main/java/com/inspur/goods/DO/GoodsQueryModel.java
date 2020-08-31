package com.inspur.goods.DO;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhuanghuan
 * Date: 2020/2/15   16:48
 * Description:
 */
public class GoodsQueryModel {
    private String goodsName;

    private String goodsCode;

    private String supplierId;

    public GoodsQueryModel(String goodsName, String goodsCode, String supplierId) {
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
        this.supplierId = supplierId;
    }

    public GoodsQueryModel() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}