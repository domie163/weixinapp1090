package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.NongchangCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 农场收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("nongchang_collection")
public class NongchangCollectionView extends NongchangCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String nongchangCollectionValue;

	//级联表 农场信息
		/**
		* 农场名称
		*/

		@ColumnInfo(comment="农场名称",type="varchar(200)")
		private String nongchangName;
		/**
		* 农场封面
		*/

		@ColumnInfo(comment="农场封面",type="varchar(200)")
		private String nongchangPhoto;
		/**
		* 演示视频
		*/

		@ColumnInfo(comment="演示视频",type="varchar(200)")
		private String nongchangVideo;
					 
		/**
		* 农场信息 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer nongchangYonghuId;
		/**
		* 农场类型
		*/
		@ColumnInfo(comment="农场类型",type="int(11)")
		private Integer nongchangTypes;
			/**
			* 农场类型的值
			*/
			@ColumnInfo(comment="农场类型的字典表值",type="varchar(200)")
			private String nongchangValue;
		/**
		* 农场地址
		*/

		@ColumnInfo(comment="农场地址 ",type="varchar(200)")
		private String nongchangBiaoqian;
		/**
		* 预警湿度
		*/

		@ColumnInfo(comment="预警湿度",type="int(11)")
		private Integer nongchangTr;
		/**
		* 土壤温湿度
		*/

		@ColumnInfo(comment="土壤温湿度",type="int(11)")
		private Integer nongchangTurang;
		/**
		* 预警湿湿度
		*/

		@ColumnInfo(comment="预警湿湿度",type="int(11)")
		private Integer nongchangWsd;
		/**
		* 空气温湿度
		*/

		@ColumnInfo(comment="空气温湿度",type="int(11)")
		private Integer nongchangWenshidu;
		/**
		* 预警风速风向
		*/

		@ColumnInfo(comment="预警风速风向",type="int(11)")
		private Integer nongchangFs;
		/**
		* 风速风向
		*/

		@ColumnInfo(comment="风速风向",type="int(11)")
		private Integer nongchangFengshu;
		/**
		* 热度
		*/

		@ColumnInfo(comment="热度",type="int(11)")
		private Integer nongchangClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 农场详情
		*/

		@ColumnInfo(comment="农场详情",type="longtext")
		private String nongchangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer nongchangDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public NongchangCollectionView() {

	}

	public NongchangCollectionView(NongchangCollectionEntity nongchangCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, nongchangCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getNongchangCollectionValue() {
		return nongchangCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setNongchangCollectionValue(String nongchangCollectionValue) {
		this.nongchangCollectionValue = nongchangCollectionValue;
	}


	//级联表的get和set 农场信息

		/**
		* 获取： 农场名称
		*/
		public String getNongchangName() {
			return nongchangName;
		}
		/**
		* 设置： 农场名称
		*/
		public void setNongchangName(String nongchangName) {
			this.nongchangName = nongchangName;
		}

		/**
		* 获取： 农场封面
		*/
		public String getNongchangPhoto() {
			return nongchangPhoto;
		}
		/**
		* 设置： 农场封面
		*/
		public void setNongchangPhoto(String nongchangPhoto) {
			this.nongchangPhoto = nongchangPhoto;
		}

		/**
		* 获取： 演示视频
		*/
		public String getNongchangVideo() {
			return nongchangVideo;
		}
		/**
		* 设置： 演示视频
		*/
		public void setNongchangVideo(String nongchangVideo) {
			this.nongchangVideo = nongchangVideo;
		}
		/**
		* 获取：农场信息 的 用户
		*/
		public Integer getNongchangYonghuId() {
			return nongchangYonghuId;
		}
		/**
		* 设置：农场信息 的 用户
		*/
		public void setNongchangYonghuId(Integer nongchangYonghuId) {
			this.nongchangYonghuId = nongchangYonghuId;
		}
		/**
		* 获取： 农场类型
		*/
		public Integer getNongchangTypes() {
			return nongchangTypes;
		}
		/**
		* 设置： 农场类型
		*/
		public void setNongchangTypes(Integer nongchangTypes) {
			this.nongchangTypes = nongchangTypes;
		}


			/**
			* 获取： 农场类型的值
			*/
			public String getNongchangValue() {
				return nongchangValue;
			}
			/**
			* 设置： 农场类型的值
			*/
			public void setNongchangValue(String nongchangValue) {
				this.nongchangValue = nongchangValue;
			}

		/**
		* 获取： 农场地址
		*/
		public String getNongchangBiaoqian() {
			return nongchangBiaoqian;
		}
		/**
		* 设置： 农场地址
		*/
		public void setNongchangBiaoqian(String nongchangBiaoqian) {
			this.nongchangBiaoqian = nongchangBiaoqian;
		}

		/**
		* 获取： 预警湿度
		*/
		public Integer getNongchangTr() {
			return nongchangTr;
		}
		/**
		* 设置： 预警湿度
		*/
		public void setNongchangTr(Integer nongchangTr) {
			this.nongchangTr = nongchangTr;
		}

		/**
		* 获取： 土壤温湿度
		*/
		public Integer getNongchangTurang() {
			return nongchangTurang;
		}
		/**
		* 设置： 土壤温湿度
		*/
		public void setNongchangTurang(Integer nongchangTurang) {
			this.nongchangTurang = nongchangTurang;
		}

		/**
		* 获取： 预警湿湿度
		*/
		public Integer getNongchangWsd() {
			return nongchangWsd;
		}
		/**
		* 设置： 预警湿湿度
		*/
		public void setNongchangWsd(Integer nongchangWsd) {
			this.nongchangWsd = nongchangWsd;
		}

		/**
		* 获取： 空气温湿度
		*/
		public Integer getNongchangWenshidu() {
			return nongchangWenshidu;
		}
		/**
		* 设置： 空气温湿度
		*/
		public void setNongchangWenshidu(Integer nongchangWenshidu) {
			this.nongchangWenshidu = nongchangWenshidu;
		}

		/**
		* 获取： 预警风速风向
		*/
		public Integer getNongchangFs() {
			return nongchangFs;
		}
		/**
		* 设置： 预警风速风向
		*/
		public void setNongchangFs(Integer nongchangFs) {
			this.nongchangFs = nongchangFs;
		}

		/**
		* 获取： 风速风向
		*/
		public Integer getNongchangFengshu() {
			return nongchangFengshu;
		}
		/**
		* 设置： 风速风向
		*/
		public void setNongchangFengshu(Integer nongchangFengshu) {
			this.nongchangFengshu = nongchangFengshu;
		}

		/**
		* 获取： 热度
		*/
		public Integer getNongchangClicknum() {
			return nongchangClicknum;
		}
		/**
		* 设置： 热度
		*/
		public void setNongchangClicknum(Integer nongchangClicknum) {
			this.nongchangClicknum = nongchangClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 农场详情
		*/
		public String getNongchangContent() {
			return nongchangContent;
		}
		/**
		* 设置： 农场详情
		*/
		public void setNongchangContent(String nongchangContent) {
			this.nongchangContent = nongchangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getNongchangDelete() {
			return nongchangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setNongchangDelete(Integer nongchangDelete) {
			this.nongchangDelete = nongchangDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "NongchangCollectionView{" +
			", nongchangCollectionValue=" + nongchangCollectionValue +
			", nongchangName=" + nongchangName +
			", nongchangPhoto=" + nongchangPhoto +
			", nongchangVideo=" + nongchangVideo +
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
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
