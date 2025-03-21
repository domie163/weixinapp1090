package com.entity.vo;

import com.entity.NongchangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 农场信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("nongchang")
public class NongchangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 农场名称
     */

    @TableField(value = "nongchang_name")
    private String nongchangName;


    /**
     * 农场封面
     */

    @TableField(value = "nongchang_photo")
    private String nongchangPhoto;


    /**
     * 演示视频
     */

    @TableField(value = "nongchang_video")
    private String nongchangVideo;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 农场类型
     */

    @TableField(value = "nongchang_types")
    private Integer nongchangTypes;


    /**
     * 农场地址
     */

    @TableField(value = "nongchang_biaoqian")
    private String nongchangBiaoqian;


    /**
     * 预警湿度
     */

    @TableField(value = "nongchang_tr")
    private Integer nongchangTr;


    /**
     * 土壤温湿度
     */

    @TableField(value = "nongchang_turang")
    private Integer nongchangTurang;


    /**
     * 预警湿湿度
     */

    @TableField(value = "nongchang_wsd")
    private Integer nongchangWsd;


    /**
     * 空气温湿度
     */

    @TableField(value = "nongchang_wenshidu")
    private Integer nongchangWenshidu;


    /**
     * 预警风速风向
     */

    @TableField(value = "nongchang_fs")
    private Integer nongchangFs;


    /**
     * 风速风向
     */

    @TableField(value = "nongchang_fengshu")
    private Integer nongchangFengshu;


    /**
     * 热度
     */

    @TableField(value = "nongchang_clicknum")
    private Integer nongchangClicknum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 农场详情
     */

    @TableField(value = "nongchang_content")
    private String nongchangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "nongchang_delete")
    private Integer nongchangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：农场名称
	 */
    public String getNongchangName() {
        return nongchangName;
    }


    /**
	 * 获取：农场名称
	 */

    public void setNongchangName(String nongchangName) {
        this.nongchangName = nongchangName;
    }
    /**
	 * 设置：农场封面
	 */
    public String getNongchangPhoto() {
        return nongchangPhoto;
    }


    /**
	 * 获取：农场封面
	 */

    public void setNongchangPhoto(String nongchangPhoto) {
        this.nongchangPhoto = nongchangPhoto;
    }
    /**
	 * 设置：演示视频
	 */
    public String getNongchangVideo() {
        return nongchangVideo;
    }


    /**
	 * 获取：演示视频
	 */

    public void setNongchangVideo(String nongchangVideo) {
        this.nongchangVideo = nongchangVideo;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：农场类型
	 */
    public Integer getNongchangTypes() {
        return nongchangTypes;
    }


    /**
	 * 获取：农场类型
	 */

    public void setNongchangTypes(Integer nongchangTypes) {
        this.nongchangTypes = nongchangTypes;
    }
    /**
	 * 设置：农场地址
	 */
    public String getNongchangBiaoqian() {
        return nongchangBiaoqian;
    }


    /**
	 * 获取：农场地址
	 */

    public void setNongchangBiaoqian(String nongchangBiaoqian) {
        this.nongchangBiaoqian = nongchangBiaoqian;
    }
    /**
	 * 设置：预警湿度
	 */
    public Integer getNongchangTr() {
        return nongchangTr;
    }


    /**
	 * 获取：预警湿度
	 */

    public void setNongchangTr(Integer nongchangTr) {
        this.nongchangTr = nongchangTr;
    }
    /**
	 * 设置：土壤温湿度
	 */
    public Integer getNongchangTurang() {
        return nongchangTurang;
    }


    /**
	 * 获取：土壤温湿度
	 */

    public void setNongchangTurang(Integer nongchangTurang) {
        this.nongchangTurang = nongchangTurang;
    }
    /**
	 * 设置：预警湿湿度
	 */
    public Integer getNongchangWsd() {
        return nongchangWsd;
    }


    /**
	 * 获取：预警湿湿度
	 */

    public void setNongchangWsd(Integer nongchangWsd) {
        this.nongchangWsd = nongchangWsd;
    }
    /**
	 * 设置：空气温湿度
	 */
    public Integer getNongchangWenshidu() {
        return nongchangWenshidu;
    }


    /**
	 * 获取：空气温湿度
	 */

    public void setNongchangWenshidu(Integer nongchangWenshidu) {
        this.nongchangWenshidu = nongchangWenshidu;
    }
    /**
	 * 设置：预警风速风向
	 */
    public Integer getNongchangFs() {
        return nongchangFs;
    }


    /**
	 * 获取：预警风速风向
	 */

    public void setNongchangFs(Integer nongchangFs) {
        this.nongchangFs = nongchangFs;
    }
    /**
	 * 设置：风速风向
	 */
    public Integer getNongchangFengshu() {
        return nongchangFengshu;
    }


    /**
	 * 获取：风速风向
	 */

    public void setNongchangFengshu(Integer nongchangFengshu) {
        this.nongchangFengshu = nongchangFengshu;
    }
    /**
	 * 设置：热度
	 */
    public Integer getNongchangClicknum() {
        return nongchangClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setNongchangClicknum(Integer nongchangClicknum) {
        this.nongchangClicknum = nongchangClicknum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：农场详情
	 */
    public String getNongchangContent() {
        return nongchangContent;
    }


    /**
	 * 获取：农场详情
	 */

    public void setNongchangContent(String nongchangContent) {
        this.nongchangContent = nongchangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getNongchangDelete() {
        return nongchangDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setNongchangDelete(Integer nongchangDelete) {
        this.nongchangDelete = nongchangDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
