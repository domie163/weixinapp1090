package com.entity.model;

import com.entity.NongchangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 农场信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NongchangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 农场名称
     */
    private String nongchangName;


    /**
     * 农场封面
     */
    private String nongchangPhoto;


    /**
     * 演示视频
     */
    private String nongchangVideo;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 农场类型
     */
    private Integer nongchangTypes;


    /**
     * 农场地址
     */
    private String nongchangBiaoqian;


    /**
     * 预警湿度
     */
    private Integer nongchangTr;


    /**
     * 土壤温湿度
     */
    private Integer nongchangTurang;


    /**
     * 预警湿湿度
     */
    private Integer nongchangWsd;


    /**
     * 空气温湿度
     */
    private Integer nongchangWenshidu;


    /**
     * 预警风速风向
     */
    private Integer nongchangFs;


    /**
     * 风速风向
     */
    private Integer nongchangFengshu;


    /**
     * 热度
     */
    private Integer nongchangClicknum;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 农场详情
     */
    private String nongchangContent;


    /**
     * 逻辑删除
     */
    private Integer nongchangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：农场名称
	 */
    public String getNongchangName() {
        return nongchangName;
    }


    /**
	 * 设置：农场名称
	 */
    public void setNongchangName(String nongchangName) {
        this.nongchangName = nongchangName;
    }
    /**
	 * 获取：农场封面
	 */
    public String getNongchangPhoto() {
        return nongchangPhoto;
    }


    /**
	 * 设置：农场封面
	 */
    public void setNongchangPhoto(String nongchangPhoto) {
        this.nongchangPhoto = nongchangPhoto;
    }
    /**
	 * 获取：演示视频
	 */
    public String getNongchangVideo() {
        return nongchangVideo;
    }


    /**
	 * 设置：演示视频
	 */
    public void setNongchangVideo(String nongchangVideo) {
        this.nongchangVideo = nongchangVideo;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：农场类型
	 */
    public Integer getNongchangTypes() {
        return nongchangTypes;
    }


    /**
	 * 设置：农场类型
	 */
    public void setNongchangTypes(Integer nongchangTypes) {
        this.nongchangTypes = nongchangTypes;
    }
    /**
	 * 获取：农场地址
	 */
    public String getNongchangBiaoqian() {
        return nongchangBiaoqian;
    }


    /**
	 * 设置：农场地址
	 */
    public void setNongchangBiaoqian(String nongchangBiaoqian) {
        this.nongchangBiaoqian = nongchangBiaoqian;
    }
    /**
	 * 获取：预警湿度
	 */
    public Integer getNongchangTr() {
        return nongchangTr;
    }


    /**
	 * 设置：预警湿度
	 */
    public void setNongchangTr(Integer nongchangTr) {
        this.nongchangTr = nongchangTr;
    }
    /**
	 * 获取：土壤温湿度
	 */
    public Integer getNongchangTurang() {
        return nongchangTurang;
    }


    /**
	 * 设置：土壤温湿度
	 */
    public void setNongchangTurang(Integer nongchangTurang) {
        this.nongchangTurang = nongchangTurang;
    }
    /**
	 * 获取：预警湿湿度
	 */
    public Integer getNongchangWsd() {
        return nongchangWsd;
    }


    /**
	 * 设置：预警湿湿度
	 */
    public void setNongchangWsd(Integer nongchangWsd) {
        this.nongchangWsd = nongchangWsd;
    }
    /**
	 * 获取：空气温湿度
	 */
    public Integer getNongchangWenshidu() {
        return nongchangWenshidu;
    }


    /**
	 * 设置：空气温湿度
	 */
    public void setNongchangWenshidu(Integer nongchangWenshidu) {
        this.nongchangWenshidu = nongchangWenshidu;
    }
    /**
	 * 获取：预警风速风向
	 */
    public Integer getNongchangFs() {
        return nongchangFs;
    }


    /**
	 * 设置：预警风速风向
	 */
    public void setNongchangFs(Integer nongchangFs) {
        this.nongchangFs = nongchangFs;
    }
    /**
	 * 获取：风速风向
	 */
    public Integer getNongchangFengshu() {
        return nongchangFengshu;
    }


    /**
	 * 设置：风速风向
	 */
    public void setNongchangFengshu(Integer nongchangFengshu) {
        this.nongchangFengshu = nongchangFengshu;
    }
    /**
	 * 获取：热度
	 */
    public Integer getNongchangClicknum() {
        return nongchangClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setNongchangClicknum(Integer nongchangClicknum) {
        this.nongchangClicknum = nongchangClicknum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：农场详情
	 */
    public String getNongchangContent() {
        return nongchangContent;
    }


    /**
	 * 设置：农场详情
	 */
    public void setNongchangContent(String nongchangContent) {
        this.nongchangContent = nongchangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getNongchangDelete() {
        return nongchangDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setNongchangDelete(Integer nongchangDelete) {
        this.nongchangDelete = nongchangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
