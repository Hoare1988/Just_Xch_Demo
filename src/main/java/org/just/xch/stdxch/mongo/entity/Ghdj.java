package org.just.xch.stdxch.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CK10_GHDJ")
public class Ghdj {

    @Field("_id")
    private Object _id;

    @Field("id")
    private String id;

    @Field
    private String jgid;
    @Field
    private String tcqdm;
    @Field
    private String jzlsh;
    @Field
    private String grid;
    @Field
    private String zjhm;
    @Field
    private String hzkh;
    @Field
    private String grmc;
    @Field
    private String hznl;
    @Field
    private String hzxb;

    @Field
    private String jzlx;
    @Field
    private String yllb;
    @Field
    private String ryzddm;
    @Field
    private String ryzdmc;
    @Field
    private String cyzddm;
    @Field
    private String cyzdmc;

    public Object get_id() {
        return _id;
    }

    public void set_id(Object _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJgid() {
        return jgid;
    }

    public void setJgid(String jgid) {
        this.jgid = jgid;
    }

    public String getTcqdm() {
        return tcqdm;
    }

    public void setTcqdm(String tcqdm) {
        this.tcqdm = tcqdm;
    }

    public String getJzlsh() {
        return jzlsh;
    }

    public void setJzlsh(String jzlsh) {
        this.jzlsh = jzlsh;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public String getHzkh() {
        return hzkh;
    }

    public void setHzkh(String hzkh) {
        this.hzkh = hzkh;
    }

    public String getGrmc() {
        return grmc;
    }

    public void setGrmc(String grmc) {
        this.grmc = grmc;
    }

    public String getHznl() {
        return hznl;
    }

    public void setHznl(String hznl) {
        this.hznl = hznl;
    }

    public String getHzxb() {
        return hzxb;
    }

    public void setHzxb(String hzxb) {
        this.hzxb = hzxb;
    }

    public String getJzlx() {
        return jzlx;
    }

    public void setJzlx(String jzlx) {
        this.jzlx = jzlx;
    }

    public String getYllb() {
        return yllb;
    }

    public void setYllb(String yllb) {
        this.yllb = yllb;
    }

    public String getRyzddm() {
        return ryzddm;
    }

    public void setRyzddm(String ryzddm) {
        this.ryzddm = ryzddm;
    }

    public String getRyzdmc() {
        return ryzdmc;
    }

    public void setRyzdmc(String ryzdmc) {
        this.ryzdmc = ryzdmc;
    }

    public String getCyzddm() {
        return cyzddm;
    }

    public void setCyzddm(String cyzddm) {
        this.cyzddm = cyzddm;
    }

    public String getCyzdmc() {
        return cyzdmc;
    }

    public void setCyzdmc(String cyzdmc) {
        this.cyzdmc = cyzdmc;
    }

}
