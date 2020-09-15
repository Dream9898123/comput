package cn.demo.action;

import cn.demo.bean.*;
import cn.demo.dao.IPbBeanDao;
import cn.demo.dao.IShopBeanDao;
import cn.demo.utils.SessionFactoryUtils;
import cn.demo.utils.PeibiNumUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private SqlSession sqlSession;
    private IShopBeanDao IshopBean;
    private IPbBeanDao IpbBean;
	PeibiNumUtils t3=new PeibiNumUtils();
	public List<testbean> findXQ(int id,int fenShu){
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IshopBean = sqlSession.getMapper(IShopBeanDao.class);
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		List <testbean> tList=new ArrayList<testbean>();
		pbBean p = new pbBean();
		if(IpbBean.getPbById(id)==null) {
			PeibiBiao pb = IpbBean.getPeiBiBiaoById(id);
			p.setId(pb.getId());
			p.setConpanyid(pb.getConpanyid());
			p.setConpanyname(pb.getConpanyname());
			p.setPeibi(pb.getPeibi());
			p.setSummoney(pb.getSummoney());
		} else {
			p=IpbBean.getPbById(id);
		}
		p.setConpanyid(p.getConpanyid().substring(0,p.getConpanyid().length() - 1));
		p.setPeibi(p.getPeibi().substring(0,p.getPeibi().length() - 1));

		String[] getArr = p.getConpanyid().split(",");
		int[] array = Arrays.asList(getArr).stream().mapToInt(Integer::parseInt).toArray();

		String[] getPb = p.getPeibi().split(":");
		int[] arrayPb = Arrays.asList(getPb).stream().mapToInt(Integer::parseInt).toArray();

		for(int i=0;i<array.length;i++) {
			ShopBean sb=IshopBean.getShopById(array[i]);
			String strid=sb.getId()+"";
			testbean t=t3.PeiBi(sb, arrayPb[i],fenShu);
			tList.add(t);
		}
//		关闭session
        new SessionFactoryUtils().destroyFactory(sqlSession);
		return tList;
	}

	public List<testbean> findSb(int id){
        //	    获取session
        sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
        IshopBean = sqlSession.getMapper(IShopBeanDao.class);
        IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//      逻辑处理
		List <testbean> tList=new ArrayList<testbean>();
		pbBean p = new pbBean();
		if(IpbBean.getPbById(id)==null) {
			PeibiBiao pb = IpbBean.getPeiBiBiaoById(id);
			p.setId(pb.getId());
			p.setConpanyid(pb.getConpanyid());
			p.setConpanyname(pb.getConpanyname());
			p.setPeibi(pb.getPeibi());
			p.setSummoney(pb.getSummoney());
		} else {
			p=IpbBean.getPbById(id);
		}

		p.setConpanyid(p.getConpanyid().substring(0,p.getConpanyid().length() - 1));
		p.setPeibi(p.getPeibi().substring(0,p.getPeibi().length() - 1));

		String[] getArr = p.getConpanyid().split(",");
		int[] array = Arrays.asList(getArr).stream().mapToInt(Integer::parseInt).toArray();

		String[] getPb = p.getPeibi().split(":");

		for(int i=0;i<array.length;i++) {
			ShopBean sb=IshopBean.getShopById(array[i]);
			String strid=sb.getId()+"";
			testbean t=new testbean(1,sb.getNa(),sb.getGa(),sb.getV(),sb.getFe(),sb.getS(),sb.getShihui(),sb.getHuifafeng(),strid,sb.getCompanyName(),getPb[i],sb.getMoney());
			tList.add(t);
		}
        //		关闭session
        new SessionFactoryUtils().destroyFactory(sqlSession);
		return tList;
	}

	public testbean findresult(List<testbean> tList) {
		return t3.resultpeibiList(tList);
	}

}
