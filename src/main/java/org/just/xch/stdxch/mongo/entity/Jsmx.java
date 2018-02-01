package org.just.xch.stdxch.mongo.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CK10_JSMX")
public class Jsmx {
    
    @Field
    private String djh;//单据号
    @Field
    private Date jsrq;//结算日期
    @Field
    private Date zhcjrq;//帐户冲减日期
    @Field
    private String jylx;//交易类型
    @Field
    private double zfy;//总费用
    @Field
    private double ybjjzc;//医保基金支出
    @Field
    private double tcjjzc;//统筹基金支出
    @Field
    private double grzhzc;//个人账户支出
    @Field
    private double zlje;//自理金额
    @Field
    private double zfje;//自费金额
    @Field
    private double zfuje;//自付金额
    @Field
    private double xjzf;//现金支付
    @Field
    private double zhzf;//个人帐户支付
    @Field
    private double gbzhzf;//公补帐户支付
    @Field
    private double qbzhzf;//企补帐户支付
    @Field
    private double qtzhzf;//其他账户支付
    @Field
    private double gbzf;//公补支付
    @Field
    private double qbzf;//企补支付
    @Field
    private double qtzf;//其他支付
    @Field
    private double jzjzf;//救助金支付
    @Field
    private String bxbz;//报销标志
    
    public String getDjh() {
        return djh;
    }
    public void setDjh(String djh) {
        this.djh = djh;
    }
    public Date getJsrq() {
        return jsrq;
    }
    public void setJsrq(Date jsrq) {
        this.jsrq = jsrq;
    }
    public Date getZhcjrq() {
        return zhcjrq;
    }
    public void setZhcjrq(Date zhcjrq) {
        this.zhcjrq = zhcjrq;
    }
    public String getJylx() {
        return jylx;
    }
    public void setJylx(String jylx) {
        this.jylx = jylx;
    }
    public double getZfy() {
        return zfy;
    }
    public void setZfy(double zfy) {
        this.zfy = zfy;
    }
    public double getYbjjzc() {
        return ybjjzc;
    }
    public void setYbjjzc(double ybjjzc) {
        this.ybjjzc = ybjjzc;
    }
    public double getTcjjzc() {
        return tcjjzc;
    }
    public void setTcjjzc(double tcjjzc) {
        this.tcjjzc = tcjjzc;
    }
    public double getGrzhzc() {
        return grzhzc;
    }
    public void setGrzhzc(double grzhzc) {
        this.grzhzc = grzhzc;
    }
    public double getZlje() {
        return zlje;
    }
    public void setZlje(double zlje) {
        this.zlje = zlje;
    }
    public double getZfje() {
        return zfje;
    }
    public void setZfje(double zfje) {
        this.zfje = zfje;
    }
    public double getZfuje() {
        return zfuje;
    }
    public void setZfuje(double zfuje) {
        this.zfuje = zfuje;
    }
    public double getXjzf() {
        return xjzf;
    }
    public void setXjzf(double xjzf) {
        this.xjzf = xjzf;
    }
    public double getZhzf() {
        return zhzf;
    }
    public void setZhzf(double zhzf) {
        this.zhzf = zhzf;
    }
    public double getGbzhzf() {
        return gbzhzf;
    }
    public void setGbzhzf(double gbzhzf) {
        this.gbzhzf = gbzhzf;
    }
    public double getQbzhzf() {
        return qbzhzf;
    }
    public void setQbzhzf(double qbzhzf) {
        this.qbzhzf = qbzhzf;
    }
    public double getQtzhzf() {
        return qtzhzf;
    }
    public void setQtzhzf(double qtzhzf) {
        this.qtzhzf = qtzhzf;
    }
    
    public double getGbzf() {
        return gbzf;
    }
    public void setGbzf(double gbzf) {
        this.gbzf = gbzf;
    }
    public double getQbzf() {
        return qbzf;
    }
    public void setQbzf(double qbzf) {
        this.qbzf = qbzf;
    }
    public double getQtzf() {
        return qtzf;
    }
    public void setQtzf(double qtzf) {
        this.qtzf = qtzf;
    }
    public double getJzjzf() {
        return jzjzf;
    }
    public void setJzjzf(double jzjzf) {
        this.jzjzf = jzjzf;
    }
    public String getBxbz() {
        return bxbz;
    }
    public void setBxbz(String bxbz) {
        this.bxbz = bxbz;
    }
    
}
