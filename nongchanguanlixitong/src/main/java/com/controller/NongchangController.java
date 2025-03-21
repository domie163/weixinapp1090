
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 农场信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongchang")
public class NongchangController {
    private static final Logger logger = LoggerFactory.getLogger(NongchangController.class);

    private static final String TABLE_NAME = "nongchang";

    @Autowired
    private NongchangService nongchangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private NongchangCollectionService nongchangCollectionService;//农场收藏
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("nongchangDeleteStart",1);params.put("nongchangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = nongchangService.queryPage(params);

        //字典表数据转换
        List<NongchangView> list =(List<NongchangView>)page.getList();
        for(NongchangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchangEntity nongchang = nongchangService.selectById(id);
        if(nongchang !=null){
            //entity转view
            NongchangView view = new NongchangView();
            BeanUtils.copyProperties( nongchang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(nongchang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NongchangEntity nongchang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongchang:{}",this.getClass().getName(),nongchang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            nongchang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<NongchangEntity> queryWrapper = new EntityWrapper<NongchangEntity>()
            .eq("nongchang_name", nongchang.getNongchangName())
            .eq("nongchang_video", nongchang.getNongchangVideo())
            .eq("yonghu_id", nongchang.getYonghuId())
            .eq("nongchang_types", nongchang.getNongchangTypes())
            .eq("nongchang_biaoqian", nongchang.getNongchangBiaoqian())
            .eq("nongchang_tr", nongchang.getNongchangTr())
            .eq("nongchang_turang", nongchang.getNongchangTurang())
            .eq("nongchang_wsd", nongchang.getNongchangWsd())
            .eq("nongchang_wenshidu", nongchang.getNongchangWenshidu())
            .eq("nongchang_fs", nongchang.getNongchangFs())
            .eq("nongchang_fengshu", nongchang.getNongchangFengshu())
            .eq("zan_number", nongchang.getZanNumber())
            .eq("cai_number", nongchang.getCaiNumber())
            .eq("nongchang_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchangEntity nongchangEntity = nongchangService.selectOne(queryWrapper);
        if(nongchangEntity==null){
            nongchang.setNongchangClicknum(1);
            nongchang.setNongchangDelete(1);
            nongchang.setInsertTime(new Date());
            nongchang.setCreateTime(new Date());
            nongchangService.insert(nongchang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongchangEntity nongchang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongchang:{}",this.getClass().getName(),nongchang.toString());
        NongchangEntity oldNongchangEntity = nongchangService.selectById(nongchang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            nongchang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(nongchang.getNongchangPhoto()) || "null".equals(nongchang.getNongchangPhoto())){
                nongchang.setNongchangPhoto(null);
        }
        if("".equals(nongchang.getNongchangVideo()) || "null".equals(nongchang.getNongchangVideo())){
                nongchang.setNongchangVideo(null);
        }

            nongchangService.updateById(nongchang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongchangEntity> oldNongchangList =nongchangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<NongchangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            NongchangEntity nongchangEntity = new NongchangEntity();
            nongchangEntity.setId(id);
            nongchangEntity.setNongchangDelete(2);
            list.add(nongchangEntity);
        }
        if(list != null && list.size() >0){
            nongchangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<NongchangEntity> nongchangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            NongchangEntity nongchangEntity = new NongchangEntity();
//                            nongchangEntity.setNongchangName(data.get(0));                    //农场名称 要改的
//                            nongchangEntity.setNongchangPhoto("");//详情和图片
//                            nongchangEntity.setNongchangVideo(data.get(0));                    //演示视频 要改的
//                            nongchangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            nongchangEntity.setNongchangTypes(Integer.valueOf(data.get(0)));   //农场类型 要改的
//                            nongchangEntity.setNongchangBiaoqian(data.get(0));                    //农场地址  要改的
//                            nongchangEntity.setNongchangTr(Integer.valueOf(data.get(0)));   //预警湿度 要改的
//                            nongchangEntity.setNongchangTurang(Integer.valueOf(data.get(0)));   //土壤温湿度 要改的
//                            nongchangEntity.setNongchangWsd(Integer.valueOf(data.get(0)));   //预警湿湿度 要改的
//                            nongchangEntity.setNongchangWenshidu(Integer.valueOf(data.get(0)));   //空气温湿度 要改的
//                            nongchangEntity.setNongchangFs(Integer.valueOf(data.get(0)));   //预警风速风向 要改的
//                            nongchangEntity.setNongchangFengshu(Integer.valueOf(data.get(0)));   //风速风向 要改的
//                            nongchangEntity.setNongchangClicknum(Integer.valueOf(data.get(0)));   //热度 要改的
//                            nongchangEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            nongchangEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            nongchangEntity.setNongchangContent("");//详情和图片
//                            nongchangEntity.setNongchangDelete(1);//逻辑删除字段
//                            nongchangEntity.setInsertTime(date);//时间
//                            nongchangEntity.setCreateTime(date);//时间
                            nongchangList.add(nongchangEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        nongchangService.insertBatch(nongchangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<NongchangView> returnNongchangViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("nongchangYesnoTypes",2);
        PageUtils pageUtils = nongchangCollectionService.queryPage(params1);
        List<NongchangCollectionView> collectionViewsList =(List<NongchangCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(NongchangCollectionView collectionView:collectionViewsList){
            Integer nongchangTypes = collectionView.getNongchangTypes();
            if(typeMap.containsKey(nongchangTypes)){
                typeMap.put(nongchangTypes,typeMap.get(nongchangTypes)+1);
            }else{
                typeMap.put(nongchangTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("nongchangTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("nongchangYesnoTypes",2);
            PageUtils pageUtils1 = nongchangService.queryPage(params2);
            List<NongchangView> nongchangViewList =(List<NongchangView>)pageUtils1.getList();
            returnNongchangViewList.addAll(nongchangViewList);
            if(returnNongchangViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("nongchangYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = nongchangService.queryPage(params);
        if(returnNongchangViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnNongchangViewList.size();//要添加的数量
            List<NongchangView> nongchangViewList =(List<NongchangView>)page.getList();
            for(NongchangView nongchangView:nongchangViewList){
                Boolean addFlag = true;
                for(NongchangView returnNongchangView:returnNongchangViewList){
                    if(returnNongchangView.getId().intValue() ==nongchangView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnNongchangViewList.add(nongchangView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnNongchangViewList = returnNongchangViewList.subList(0, limit);
        }

        for(NongchangView c:returnNongchangViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnNongchangViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongchangService.queryPage(params);

        //字典表数据转换
        List<NongchangView> list =(List<NongchangView>)page.getList();
        for(NongchangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchangEntity nongchang = nongchangService.selectById(id);
            if(nongchang !=null){

                //点击数量加1
                nongchang.setNongchangClicknum(nongchang.getNongchangClicknum()+1);
                nongchangService.updateById(nongchang);

                //entity转view
                NongchangView view = new NongchangView();
                BeanUtils.copyProperties( nongchang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(nongchang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody NongchangEntity nongchang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongchang:{}",this.getClass().getName(),nongchang.toString());
        Wrapper<NongchangEntity> queryWrapper = new EntityWrapper<NongchangEntity>()
            .eq("nongchang_name", nongchang.getNongchangName())
            .eq("nongchang_video", nongchang.getNongchangVideo())
            .eq("yonghu_id", nongchang.getYonghuId())
            .eq("nongchang_types", nongchang.getNongchangTypes())
            .eq("nongchang_biaoqian", nongchang.getNongchangBiaoqian())
            .eq("nongchang_tr", nongchang.getNongchangTr())
            .eq("nongchang_turang", nongchang.getNongchangTurang())
            .eq("nongchang_wsd", nongchang.getNongchangWsd())
            .eq("nongchang_wenshidu", nongchang.getNongchangWenshidu())
            .eq("nongchang_fs", nongchang.getNongchangFs())
            .eq("nongchang_fengshu", nongchang.getNongchangFengshu())
            .eq("nongchang_clicknum", nongchang.getNongchangClicknum())
            .eq("zan_number", nongchang.getZanNumber())
            .eq("cai_number", nongchang.getCaiNumber())
            .eq("nongchang_delete", nongchang.getNongchangDelete())
//            .notIn("nongchang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchangEntity nongchangEntity = nongchangService.selectOne(queryWrapper);
        if(nongchangEntity==null){
            nongchang.setNongchangClicknum(1);
                nongchang.setZanNumber(1);
                nongchang.setCaiNumber(1);
            nongchang.setNongchangDelete(1);
            nongchang.setInsertTime(new Date());
            nongchang.setCreateTime(new Date());
        nongchangService.insert(nongchang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

