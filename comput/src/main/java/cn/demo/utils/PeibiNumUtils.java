package cn.demo.utils;

import cn.demo.bean.*;
import cn.demo.dao.IPbBeanDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PeibiNumUtils {
	QuzhengUtils qz = new QuzhengUtils();
//	xxxxx qi = new xxxxx();
	private SqlSession sqlSession;
	private IPbBeanDao IpbBean;

//  配比shop计算
	public testbean PeiBi(ShopBean shop, int i, int fenShu) {
		testbean st = new testbean();
		st.setNa(((shop.getNa() * i) / fenShu));
		st.setGa(((shop.getGa() * i) / fenShu));
		st.setFe(((shop.getFe() * i) / fenShu));
		st.setV(((shop.getV() * i) / fenShu));
		st.setShihui(((shop.getShihui() * i) / fenShu));
		st.setHuifafeng(((shop.getHuifafeng() * i) / fenShu));
		st.setS(((shop.getS() * i) / fenShu));
		st.setConpanyid(shop.getId() + "");
		st.setConpanyname(shop.getCompanyName() + "");
		st.setPeibi(i + "");
		st.setMoney(((shop.getMoney() * i)));
//  System.out.println("新st："+st);
		return st;
	}

//配比shop列表计算
	public testbean resultpeibiList(List<testbean> peibiList) {
		testbean result = new testbean();
		result.setConpanyid("");
		result.setPeibi("");
		result.setConpanyname("");
		for (testbean t : peibiList) {
			result.setNa((qz.SplitAndRound(result.getNa() + t.getNa())));
			result.setGa((qz.SplitAndRound(result.getGa() + t.getGa())));
			result.setFe((qz.SplitAndRound(result.getFe() + t.getFe())));
			result.setV((qz.SplitAndRound(result.getV() + t.getV())));
			result.setS((qz.SplitAndRound(result.getS() + t.getS())));
			result.setShihui((qz.SplitAndRound(result.getShihui() + t.getShihui())));
			result.setHuifafeng((qz.SplitAndRound(result.getHuifafeng() + t.getHuifafeng())));
			result.setConpanyid(result.getConpanyid() + t.getConpanyid() + ",");
			result.setConpanyname(result.getConpanyname() + t.getConpanyname() + ":");
			result.setPeibi(result.getPeibi() + t.getPeibi() + ":");
			result.setMoney(qz.SplitAndRound(result.getMoney() + t.getMoney()));
		}
		return result;
	}

	public void resultduibi(testbean pp, testbean result) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		boolean flag = false;
		if (pp.getNa() >= result.getNa()) {
			if (pp.getFe() >= result.getFe()) {
				if (pp.getV() >= result.getV()) {
					if (pp.getS() >= result.getS()) {
						if (pp.getShihui() >= result.getShihui()) {
							if (pp.getHuifafeng() >= result.getHuifafeng()) {
								if (pp.getGa() >= result.getGa()) {
									flag = true;
								}
							}
						}
					}
				}
			}
		} else {
			flag = false;
		}
		if (flag) {
			pbBean p = new pbBean(1, result.getConpanyid(), result.getConpanyname(), result.getPeibi(),
					result.getMoney());
			IpbBean.insert(p);
		} else {
			System.out.println("不合适！！！");
		}
		new SessionFactoryUtils().destroyFactory(sqlSession);
		// TODO Auto-generated method stub

	}

	public boolean PeiBiChuCun(testbean result, String peiBiMingZi) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		PeiBiMuLu PEIBIMULU_NOW = IpbBean.getMuLu(peiBiMingZi);
//		处理，和：
		result.setConpanyid(result.getConpanyid().substring(0,result.getConpanyid().length() - 1));
		result.setPeibi(result.getPeibi().substring(0,result.getPeibi().length() - 1));
		result.setConpanyname(result.getConpanyname().substring(0,result.getConpanyname().length() - 1));
		
		PeibiBiao peiBiBiao = new PeibiBiao(1, result.getConpanyid(), result.getConpanyname(), result.getPeibi(),
				result.getMoney(), result.getNa(), result.getGa(), result.getV(), result.getFe(), result.getS(),
				result.getShihui(), result.getHuifafeng(), PEIBIMULU_NOW.getId() + "");
		boolean flag = IpbBean.chaRuPeiBiBiao(peiBiBiao);
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return flag;
	}

}
