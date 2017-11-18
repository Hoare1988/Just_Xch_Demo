package org.just.xch.stdxch.mongo.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class Cfmx {
    
    @Field
    private String xmdm;
    @Field
    private String xmmc;
    @Field
    private String yyxmdm;
    @Field
    private String yyxmmc;
    @Field
    private String xmlb;// 项目类别
    @Field
    private String sflb;// 收费类别
    @Field
    private String ypdj;// 项目等级
    @Field
    private String ksid;// 科室ID
    @Field
    private String ksdm;// 科室代码
    @Field
    private String ksmc;// 科室名称
    @Field
    private String ysid;// 医生ID
    @Field
    private String ysdm;// 医生代码
    @Field
    private String ysmc;// 医生名称
    @Field
    private String cfh;// 处方号
    @Field
    private String cflsh;// 处方流水号
    @Field
    private Date cfrq;// 处方日期
    @Field
    private double sl;// 数量
    @Field
    private double dj;// 单价
    @Field
    private double je;// 金额
    @Field
    private String gg;// 规格
    @Field
    private String jx;// 剂型
    @Field
    private String yl;// 用量
    @Field
    private String pc;// 频次
    @Field
    private String yf;// 用法
    @Field
    private String dw;// 单位
    @Field
    private double yyts;// 用药天数
    @Field
    private double ylts;// 用量天数
    @Field
    private double zlje;// 自理金额
    @Field
    private double zfje;// 自费金额
    @Field
    private double zfbl;// 自付比例
    @Field
    private String jylx;// 交易类型
    @Field
    private String bxbz; // 报销标志
    @Field
    private Date jsrq; // 结算日期时间
    @Field
    private String cxyscflsh;  // //被撤销的处方的原始流水号
    
    @Field
    private String gzy_mc; // 规则用_名称
    @Field
    private String gzy_jx; // 规则用_剂型
    @Field
    private String gzy_gzdm; // 规则用_规则代码
    @Field
    private String xgd;// 相关度
    
    
    public String getXmdm() {
        return xmdm;
    }
    public void setXmdm(String xmdm) {
        this.xmdm = xmdm;
    }
    public String getXmmc() {
        return xmmc;
    }
    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }
    public String getYyxmdm() {
        return yyxmdm;
    }
    public void setYyxmdm(String yyxmdm) {
        this.yyxmdm = yyxmdm;
    }
    public String getYyxmmc() {
        return yyxmmc;
    }
    public void setYyxmmc(String yyxmmc) {
        this.yyxmmc = yyxmmc;
    }
    public String getXmlb() {
        return xmlb;
    }
    public void setXmlb(String xmlb) {
        this.xmlb = xmlb;
    }
    public String getSflb() {
        return sflb;
    }
    public void setSflb(String sflb) {
        this.sflb = sflb;
    }
    public String getYpdj() {
        return ypdj;
    }
    public void setYpdj(String ypdj) {
        this.ypdj = ypdj;
    }
    public String getKsid() {
        return ksid;
    }
    public void setKsid(String ksid) {
        this.ksid = ksid;
    }
    public String getKsdm() {
        return ksdm;
    }
    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }
    public String getKsmc() {
        return ksmc;
    }
    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }
    public String getYsid() {
        return ysid;
    }
    public void setYsid(String ysid) {
        this.ysid = ysid;
    }
    public String getYsdm() {
        return ysdm;
    }
    public void setYsdm(String ysdm) {
        this.ysdm = ysdm;
    }
    public String getYsmc() {
        return ysmc;
    }
    public void setYsmc(String ysmc) {
        this.ysmc = ysmc;
    }
    public String getCfh() {
        return cfh;
    }
    public void setCfh(String cfh) {
        this.cfh = cfh;
    }
    public String getCflsh() {
        return cflsh;
    }
    public void setCflsh(String cflsh) {
        this.cflsh = cflsh;
    }
    public Date getCfrq() {
        return cfrq;
    }
    public void setCfrq(Date cfrq) {
        this.cfrq = cfrq;
    }
    public double getSl() {
        return sl;
    }
    public void setSl(double sl) {
        this.sl = sl;
    }
    public double getDj() {
        return dj;
    }
    public void setDj(double dj) {
        this.dj = dj;
    }
    public double getJe() {
        return je;
    }
    public void setJe(double je) {
        this.je = je;
    }
    public String getGg() {
        return gg;
    }
    public void setGg(String gg) {
        this.gg = gg;
    }
    public String getJx() {
        return jx;
    }
    public void setJx(String jx) {
        this.jx = jx;
    }
    public String getYl() {
        return yl;
    }
    public void setYl(String yl) {
        this.yl = yl;
    }
    public String getPc() {
        return pc;
    }
    public void setPc(String pc) {
        this.pc = pc;
    }
    public String getYf() {
        return yf;
    }
    public void setYf(String yf) {
        this.yf = yf;
    }
    public String getDw() {
        return dw;
    }
    public void setDw(String dw) {
        this.dw = dw;
    }
    public double getYyts() {
        return yyts;
    }
    public void setYyts(double yyts) {
        this.yyts = yyts;
    }
    public double getYlts() {
        return ylts;
    }
    public void setYlts(double ylts) {
        this.ylts = ylts;
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
    public double getZfbl() {
        return zfbl;
    }
    public void setZfbl(double zfbl) {
        this.zfbl = zfbl;
    }
    public String getJylx() {
        return jylx;
    }
    public void setJylx(String jylx) {
        this.jylx = jylx;
    }
    public String getBxbz() {
        return bxbz;
    }
    public void setBxbz(String bxbz) {
        this.bxbz = bxbz;
    }
    public Date getJsrq() {
        return jsrq;
    }
    public void setJsrq(Date jsrq) {
        this.jsrq = jsrq;
    }
    public String getCxyscflsh() {
        return cxyscflsh;
    }
    public void setCxyscflsh(String cxyscflsh) {
        this.cxyscflsh = cxyscflsh;
    }
    public String getGzy_mc() {
        return gzy_mc;
    }
    public void setGzy_mc(String gzy_mc) {
        this.gzy_mc = gzy_mc;
    }
    public String getGzy_jx() {
        return gzy_jx;
    }
    public void setGzy_jx(String gzy_jx) {
        this.gzy_jx = gzy_jx;
    }
    public String getGzy_gzdm() {
        return gzy_gzdm;
    }
    public void setGzy_gzdm(String gzy_gzdm) {
        this.gzy_gzdm = gzy_gzdm;
    }
    public String getXgd() {
        return xgd;
    }
    public void setXgd(String xgd) {
        this.xgd = xgd;
    }
    
    

}
