package cn.demo.action;

//import cn.demo.utils.findFastFive;
//import cn.demo.utils.findLastFive;

import cn.demo.bean.*;
import cn.demo.dao.IPbBeanDao;
import cn.demo.dao.IShopBeanDao;
import cn.demo.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ShopAction {
    private SqlSession sqlSession;
		private IShopBeanDao IshopBean;
		private IPbBeanDao IpbBean;
		public List<ShopBean> findAll(){
			//	    获取session
			sqlSession = new SessionFactoryUtils().initFactory();
			//		代理对象
			IshopBean = sqlSession.getMapper(IShopBeanDao.class);
        List<ShopBean> shopBeans = IshopBean.getAllList();
        new SessionFactoryUtils().destroyFactory(sqlSession);
		return shopBeans;
	}
	public ShopBean findByid(int id) {
        //	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
        //		代理对象
        IshopBean = sqlSession.getMapper(IShopBeanDao.class);
        ShopBean shopBean = IshopBean.getShopById(id);
        new SessionFactoryUtils().destroyFactory(sqlSession);
        return shopBean;
	}

	public Object findAllpf() {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		List<pbBean> pblist=IpbBean.getAllList();
		for(pbBean p:pblist) {
			p.setConpanyname(p.getConpanyname().substring(0,p.getConpanyname().length() - 1));
			p.setPeibi(p.getPeibi().substring(0,p.getPeibi().length() - 1));
		}
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return pblist;
	}
	public void deletepb() {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		IpbBean.truncateTable();
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
	}
//寻找配比表代码
	public List<PeiBiMuLu> findAllPeiBiMuLu(){
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		List<PeiBiMuLu> peiBiMuLus = IpbBean.getMuLulist();
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return peiBiMuLus;
	}

	public List<PeibiBiao> findAllPeibiBiao(testbean tb, String biaoDan_id){
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		List<PeibiBiao> peibiBiaos = IpbBean.getPeiBiBiao(tb,biaoDan_id);
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return peibiBiaos;
	}


	public boolean upShop(ShopBean shopBean) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IshopBean = sqlSession.getMapper(IShopBeanDao.class);
//		逻辑处理
		boolean flag = IshopBean.upshop(shopBean);
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return flag;
	}

    public boolean deleteShop(int shopId) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IshopBean = sqlSession.getMapper(IShopBeanDao.class);
//		逻辑处理
		boolean flag = IshopBean.deleteShopBean(shopId);
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return flag;
    }

	public boolean updateShop(ShopBean shopBean) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IshopBean = sqlSession.getMapper(IShopBeanDao.class);
//		逻辑处理
		boolean flag = IshopBean.updateShop(shopBean);
//		关闭session
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return flag;
	}
}
