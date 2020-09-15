package cn.demo.dao;

import cn.demo.bean.pbdBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPbdBeanDao {

    @Insert("insert into pbdbean(id,na,ga,v,fe,s,shihui,huifafeng,conpanyid,conpanyname,peibi,money,flag,pbdname)values(#{id},#{Na},#{Ga},#{V},#{Fe},#{S},#{shihui},#{huifafeng},#{conpanyid},#{conpanyname},#{peibi},#{money},#{flag},#{pbdName})")
    boolean savePbdBean(pbdBean pbdBean);


    @Select("select * from pbdbean where flag = 'result'")
    List<pbdBean> findAllPbd_resulta();

    @Select("select * from pbdbean where flag = 'yq' and pbdname = #{pbdName}")
    pbdBean findPbd_yqByPbdName(String pbdName);

    @Select("select * from pbdbean where flag = 'tlist' and pbdname = #{pbdName}")
    List<pbdBean> findPbd_tlistByPbdName(String pbdName);

    @Select("select * from pbdbean where flag = 'result' and pbdname = #{pbdName}")
    pbdBean findPbd_resultByPbdName(String pbdName);

    @Delete("delete from pbdbean where pbdname = #{pbdName}")
    boolean deletePbdByPbdName(String pbdName);
}
