package cn.demo.action;

import cn.demo.bean.pbdBean;
import cn.demo.bean.testbean;
import cn.demo.dao.IPbBeanDao;
import cn.demo.dao.IPbdBeanDao;
import cn.demo.utils.FtoCUtils;
import cn.demo.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PeibibiaoAction {
//    引入变量
    private SqlSession sqlSession;
    private IPbBeanDao IpbBean;
    private IPbdBeanDao iPbdBeanDao;
    public boolean deletexianyoupeiliangbiao(int peiliangid) {
//        初始化工场
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//        建立flag，调用删除表单目录的方法
        boolean flag = IpbBean.deletePeiBiMuLuById(peiliangid);
//        建立flag2，调用删除表单的方法
        boolean flag2 = IpbBean.deletePeibiBiaoByfenshuId(Integer.toString(peiliangid));
//        关闭工厂
        new SessionFactoryUtils().destroyFactory(sqlSession);
//        判断是否删除成功，并返回值
        if(flag && flag2){
            return true;
        }else{
            return false;
        }
    }


    public boolean keeppeibidian(List<testbean> tlist, testbean result, testbean yq,String pbdname) {
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        iPbdBeanDao = sqlSession.getMapper(IPbdBeanDao.class);
        IpbBean = sqlSession.getMapper(IPbBeanDao.class);
        FtoCUtils ftoC = new FtoCUtils();
//		逻辑处理
//        判断数据库中有无此对象
        pbdBean pbd_tmp = iPbdBeanDao.findPbd_resultByPbdName(pbdname);
        if (pbd_tmp == null) {
//        处理要求testbean
            pbdBean pbd_yq = (pbdBean) ftoC.fatherToChild(yq, new pbdBean());
            pbd_yq.setFlag("yq");
            pbd_yq.setPbdName(pbdname);
            boolean f1 = iPbdBeanDao.savePbdBean(pbd_yq);
//        处理result——testbean
            pbdBean pbd_result = (pbdBean) ftoC.fatherToChild(result, new pbdBean());
            pbd_result.setFlag("result");
            pbd_result.setPbdName(pbdname);
//		解决多余的：和，
            pbd_result.setConpanyid(pbd_result.getConpanyid().substring(0,pbd_result.getConpanyid().length() - 1));
            pbd_result.setPeibi(pbd_result.getPeibi().substring(0,pbd_result.getPeibi().length() - 1));
            pbd_result.setConpanyname(pbd_result.getConpanyname().substring(0,pbd_result.getConpanyname().length() - 1));
//            储存pbd_result
            boolean f2 = iPbdBeanDao.savePbdBean(pbd_result);
//        处理tlist
            boolean f3 = false;
            for (testbean t : tlist) {
                pbdBean pbd_t = (pbdBean) ftoC.fatherToChild(t, new pbdBean());
                pbd_t.setFlag("tlist");
                pbd_t.setPbdName(pbdname);
                f3 = iPbdBeanDao.savePbdBean(pbd_t);
            }
//		关闭session
            new SessionFactoryUtils().destroyFactory(sqlSession);
            if (f2 && f1 && f3)return true;else return false;
        }else {
//		关闭session
            new SessionFactoryUtils().destroyFactory(sqlSession);
            return false;
        }
    }


    public List<pbdBean> findAllPbd_resulta() {
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        iPbdBeanDao = sqlSession.getMapper(IPbdBeanDao.class);
//        逻辑处理
        List<pbdBean> pbdBeanList = iPbdBeanDao.findAllPbd_resulta();
//		关闭session
        new SessionFactoryUtils().destroyFactory(sqlSession);
//		逻辑处理
        return pbdBeanList;
    }

    public pbdBean findPbd_yqByPbdName(String pbdName) {
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        iPbdBeanDao = sqlSession.getMapper(IPbdBeanDao.class);
//        逻辑处理
        pbdBean pbd_yq = iPbdBeanDao.findPbd_yqByPbdName(pbdName);
//		关闭session
        new SessionFactoryUtils().destroyFactory(sqlSession);
//		逻辑处理
        return pbd_yq;
    }

    public List<pbdBean> findPbd_tlistByPbdName(String pbdName) {
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        iPbdBeanDao = sqlSession.getMapper(IPbdBeanDao.class);
//        逻辑处理
        List<pbdBean> pbd_tlist = iPbdBeanDao.findPbd_tlistByPbdName(pbdName);
//		关闭session
        new SessionFactoryUtils().destroyFactory(sqlSession);
//		逻辑处理
        return pbd_tlist;
    }

    public pbdBean findPbd_resultByPbdName(String pbdName) {
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        iPbdBeanDao = sqlSession.getMapper(IPbdBeanDao.class);
//        逻辑处理
        pbdBean pbd_result = iPbdBeanDao.findPbd_resultByPbdName(pbdName);
//		关闭session
        new SessionFactoryUtils().destroyFactory(sqlSession);
//		逻辑处理
        return pbd_result;
    }

    public boolean deletePbdByPbdName(String pbdName) {
//        初始化工场
//	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        iPbdBeanDao = sqlSession.getMapper(IPbdBeanDao.class);
//        建立flag，调用删除表单目录的方法
        boolean flag = iPbdBeanDao.deletePbdByPbdName(pbdName);
//        关闭工厂
        new SessionFactoryUtils().destroyFactory(sqlSession);
//        判断是否删除成功，并返回值
        return flag;
    }
}
