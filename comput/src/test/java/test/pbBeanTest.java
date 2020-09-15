package test;

import cn.demo.bean.PeiBiMuLu;
import cn.demo.bean.PeibiBiao;
import cn.demo.bean.pbBean;
import cn.demo.bean.testbean;
import cn.demo.dao.IPbBeanDao;
import cn.demo.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class pbBeanTest {
    private SqlSession sqlSession;
    private IPbBeanDao IpbBeanDao;

    /**
     * 测试查询所有
     */
    @Test
    public void getAllList(){
        sqlSession = new SessionFactoryUtils().initFactory();
        IpbBeanDao = sqlSession.getMapper(IPbBeanDao.class);
        //5.执行查询所有方法
        List<pbBean> pbBeans = IpbBeanDao.getAllList();
        for(pbBean s : pbBeans){
            System.out.println(s);
        }
        new SessionFactoryUtils().destroyFactory(sqlSession);

    }

    @Test
    public void testSave(){
        sqlSession = new SessionFactoryUtils().initFactory();
        IpbBeanDao = sqlSession.getMapper(IPbBeanDao.class);
        pbBean user = new pbBean();
        user.setPeibi("modify User property");
        user.setConpanyid("北京市顺义区");
        user.setConpanyname("男");
        user.setSummoney(222);
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        IpbBeanDao.insert(user);
        System.out.println("保存操作之后："+user);
        new SessionFactoryUtils().destroyFactory(sqlSession);
    }

    @Test
    public void testSave1(){
        sqlSession = new SessionFactoryUtils().initFactory();
        IpbBeanDao = sqlSession.getMapper(IPbBeanDao.class);
        PeiBiMuLu user = new PeiBiMuLu();
        user.setId(1);
        user.setPeiBiMingZi("北京市顺义区");
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        IpbBeanDao.chaRuBiaoDanMuLu(user);
        System.out.println("保存操作之后："+user);
        new SessionFactoryUtils().destroyFactory(sqlSession);
    }

    @Test
    public void getMuLulist(){
        sqlSession = new SessionFactoryUtils().initFactory();
        IpbBeanDao = sqlSession.getMapper(IPbBeanDao.class);
        //5.执行查询所有方法
        List<PeiBiMuLu> pbBeans = IpbBeanDao.getMuLulist();
        for(PeiBiMuLu s : pbBeans){
            System.out.println(s);
        }
        new SessionFactoryUtils().destroyFactory(sqlSession);
    }

    @Test
    public void getPeiBiBiao(){
        sqlSession = new SessionFactoryUtils().initFactory();
        IpbBeanDao = sqlSession.getMapper(IPbBeanDao.class);
        testbean testbean = new testbean(1,9,9,9,9,9,9,9,"AAA","BBB","CCC",999);
        //5.执行查询所有方法
        List<PeibiBiao> pbBeans = IpbBeanDao.getPeiBiBiao(testbean,"3");
        for(PeibiBiao s : pbBeans){
            System.out.println(s);
        }
        new SessionFactoryUtils().destroyFactory(sqlSession);
    }
}
