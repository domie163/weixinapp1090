package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 农场信息
 *
 * @author 
 * @email
 */
@TableName("nongchang")
public class NongchangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public NongchangEntity() {

	}

	public NongchangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 农场名称
     */
    @ColumnInfo(comment="农场名称",type="varchar(200)")
    @TableField(value = "nongchang_name")

    private String nongchangName;


    /**
     * 农场封面
     */
    @ColumnInfo(comment="农场封面",type="varchar(200)")
    @TableField(value = "nongchang_photo")

    private String nongchangPhoto;


    /**
     * 演示视频
     */
    @ColumnInfo(comment="演示视频",type="varchar(200)")
    @TableField(value = "nongchang_video")

    private String nongchangVideo;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 农场类型
     */
    @ColumnInfo(comment="农场类型",type="int(11)")
    @TableField(value = "nongchang_types")

    private Integer nongchangTypes;


    /**
     * 农场地址
     */
    @ColumnInfo(comment="农场地址 ",type="varchar(200)")
    @TableField(value = "nongchang_biaoqian")

    private String nongchangBiaoqian;


    /**
     * 预警湿度
     */
    @ColumnInfo(comment="预警湿度",type="int(11)")
    @TableField(value = "nongchang_tr")

    private Integer nongchangTr;


    /**
     * 土壤温湿度
     */
    @ColumnInfo(comment="土壤温湿度",type="int(11)")
    @TableField(value = "nongchang_turang")

    private Integer nongchangTurang;


    /**
     * 预警湿湿度
     */
    @ColumnInfo(comment="预警湿湿度",type="int(11)")
    @TableField(value = "nongchang_wsd")

    private Integer nongchangWsd;


    /**
     * 空气温湿度
     */
    @ColumnInfo(comment="空气温湿度",type="int(11)")
    @TableField(value = "nongchang_wenshidu")

    private Integer nongchangWenshidu;


    /**
     * 预警风速风向
     */
    @ColumnInfo(comment="预警风速风向",type="int(11)")
    @TableField(value = "nongchang_fs")

    private Integer nongchangFs;


    /**
     * 风速风向
     */
    @ColumnInfo(comment="风速风向",type="int(11)")
    @TableField(value = "nongchang_fengshu")

    private Integer nongchangFengshu;


    /**
     * 热度
     */
    @ColumnInfo(comment="热度",type="int(11)")
    @TableField(value = "nongchang_clicknum")

    private Integer nongchangClicknum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 农场详情
     */
    @ColumnInfo(comment="农场详情",type="longtext")
    @TableField(value = "nongchang_content")

    private String nongchangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "nongchang_delete")

    private Integer nongchangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Nongchang{" +
            ", id=" + id +
            ", nongchangName=" + nongchangName +
            ", nongchangPhoto=" + nongchangPhoto +
            ", nongchangVideo=" + nongchangVideo +
            ", yonghuId=" + yonghuId +
            ", nongchangTypes=" + nongchangTypes +
            ", nongchangBiaoqian=" + nongchangBiaoqian +
            ", nongchangTr=" + nongchangTr +
            ", nongchangTurang=" + nongchangTurang +
            ", nongchangWsd=" + nongchangWsd +
            ", nongchangWenshidu=" + nongchangWenshidu +
            ", nongchangFs=" + nongchangFs +
            ", nongchangFengshu=" + nongchangFengshu +
            ", nongchangClicknum=" + nongchangClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", nongchangContent=" + nongchangContent +
            ", nongchangDelete=" + nongchangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
