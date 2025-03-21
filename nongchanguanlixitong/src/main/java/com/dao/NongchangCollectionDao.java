package com.dao;

import com.entity.NongchangCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchangCollectionView;

/**
 * 农场收藏 Dao 接口
 *
 * @author 
 */
public interface NongchangCollectionDao extends BaseMapper<NongchangCollectionEntity> {

   List<NongchangCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
