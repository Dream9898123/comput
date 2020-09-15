package cn.demo.web.controller;

import cn.demo.action.PeibibiaoAction;
import cn.demo.action.Result;
import cn.demo.action.ShopAction;
import cn.demo.bean.PeiBiMuLu;
import cn.demo.bean.ShopBean;
import cn.demo.bean.pbdBean;
import cn.demo.bean.testbean;
import cn.demo.dao.IPbBeanDao;
import cn.demo.utils.GetStringNum;
import cn.demo.utils.SessionFactoryUtils;
import cn.demo.utils.ShejiNumUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//import cn.demo.dao.PbDAOImpl;


@Controller
@RequestMapping("/Demo")
public class demoController {
	ShopAction sa = new ShopAction();
	ShejiNumUtils tt=new ShejiNumUtils();
	Result ra=new Result();
	private SqlSession sqlSession;
	private IPbBeanDao IpbBean;
//	导入action
	// 跳转到登录页面
	@RequestMapping(value = "indexpage")
	public ModelAndView indexpage(HttpServletRequest request) {
		sa.deletepb();
		request.setAttribute("shoplist", sa.findAll());
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		return new ModelAndView("index");
	}
	@RequestMapping(value = "resultpage")
	public ModelAndView resultpage(String fenshu, testbean tb,String idlist,HttpServletRequest request) {

		sa.deletepb();
		request.getSession().setAttribute("yq", tb);
		List<ShopBean>sping=new ArrayList<ShopBean>();
		String[] getArr = idlist.split(",");
		for(int i=0;i<getArr.length;i++){
		 sping.add(sa.findByid(Integer.parseInt(getArr[i])));
		}
		tb.setConpanyid("0");
		tb.setMoney(0);
		tb.setPeibi("");
		String[] getFenShu = fenshu.split(",");
		int fenShu = (int)(10/(Double.parseDouble(getFenShu[0])));
//		int fenShu = Integer.parseInt(getFenShu[0]);
//		将份数一起发送到页面
		request.setAttribute("fenShu", fenShu);
		tt.main(sping,tb,fenShu);
		request.setAttribute("pflist", sa.findAllpf());
		return new ModelAndView("result");
	}
	@RequestMapping(value = "xiangqingpage")
	public ModelAndView xiangqingpage(String id,String fenShu,HttpServletRequest request) {
		int i=Integer.parseInt(id);
		int fenShu_int=(int)(10/(Double.parseDouble(fenShu)));
		List<testbean> tList=ra.findXQ(i,fenShu_int);
		request.getSession().setAttribute("tList", ra.findSb(i));
		request.getSession().setAttribute("result", ra.findresult(tList));
		request.setAttribute("keep", true);
		return new ModelAndView("xiangqing");
	}

	@RequestMapping(value = "shejipeiliangbiaopage")
	public ModelAndView shejipeiliangbiaopage(HttpServletRequest request) {
		request.setAttribute("shoplist", sa.findAll());
		return new ModelAndView("shejipeiliangbiao");
	}

	@RequestMapping(value = "shejipeiliangbiaoaction")
	public ModelAndView shejipeiliangbiaopage(String fenshu,String idlist,HttpServletRequest request) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		sa.deletepb();
		String[] getFenShu = fenshu.split(",");
		int fenShu=(int)(10/(Double.parseDouble(getFenShu[0])));
		List<ShopBean>chooseShopBean = new ArrayList<ShopBean>();
		String[] getArr = idlist.split(",");
		for(int i=0;i<getArr.length;i++){
			chooseShopBean.add(sa.findByid(Integer.parseInt(getArr[i])));
		}
		String peiBiMingZi=getFenShu[0]+"度的配比表";
		PeiBiMuLu PEIBIMULU_NOW =  null;
		PEIBIMULU_NOW = IpbBean.getMuLu(peiBiMingZi);
		if(PEIBIMULU_NOW == null) {
			PeiBiMuLu peiBiMuLu = new PeiBiMuLu();
			peiBiMuLu.setPeiBiMingZi(peiBiMingZi);
			peiBiMuLu.setId(1);
			IpbBean.chaRuBiaoDanMuLu(peiBiMuLu);
			new SessionFactoryUtils().destroyFactory(sqlSession);
			tt.SheJiPeiBiBiao(chooseShopBean,fenShu,peiBiMingZi);
		}
		sa.deletepb();
		request.setAttribute("info","success");
		request.setAttribute("shoplist", sa.findAll());
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		return new ModelAndView("index");
	}
//	现有配比表寻找
	@RequestMapping(value = "xianyoupeiliangbiaopage")
	public ModelAndView xianyoupeiliangbiaopage(String PEILIANGID,HttpServletRequest request) {
		request.setAttribute("PEILIANGID", PEILIANGID);
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		return new ModelAndView("xianyoupeiliangbiao");
	}

	@RequestMapping(value = "xianyoupeiliangbiaoaction")
	public ModelAndView xianyoupeiliangbiaoaction(String PEILIANGID, testbean testBean, HttpServletRequest request) {
//	    获取session
		sqlSession = new SessionFactoryUtils().initFactory();
//		代理对象
		IpbBean = sqlSession.getMapper(IPbBeanDao.class);
//		逻辑处理
		request.getSession().setAttribute("yq", testBean);
		request.setAttribute("pflist", sa.findAllPeibiBiao(testBean, PEILIANGID));
//		查询配比目录
		PeiBiMuLu PEIBIMULU_NOW = IpbBean.getPeiBiMuLuById(Integer.parseInt(PEILIANGID));
		GetStringNum gsn = new GetStringNum();
		double fenShu = gsn.QuShuZi(PEIBIMULU_NOW.getPeiBiMingZi());
//		将份数一起发送到页面
		request.setAttribute("fenShu", fenShu);
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		new SessionFactoryUtils().destroyFactory(sqlSession);
		return new ModelAndView("result");
	}
	/**
	 * 删除配量表
	 */
	@RequestMapping(value = "deletexianyoupeiliangbiao")
	public ModelAndView deletexianyoupeiliangbiao(int PEILIANGID, HttpServletRequest request) {
//		1.调用peiliaobiaoaction
		boolean flag = new PeibibiaoAction().deletexianyoupeiliangbiao(PEILIANGID);
//		2.根据返回值判断删除是否成功,发送信息
		if (flag){
			request.setAttribute("info", "success");
		}else{
			request.setAttribute("info", "false");
		}
//		3.页面数据
		request.setAttribute("shoplist", sa.findAll());
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		return new ModelAndView("index");
	}
	/**
	 * 上传shop
	 */
	@RequestMapping(value = "upshoppage")
	public ModelAndView upshoppage(ShopBean shopBean, HttpServletRequest request) {
		System.out.println("shopBeanId"+shopBean.getCompanyName() != null);
//		1.判断shopbean是否为空，为空直接返回
		if (shopBean.getCompanyName() != null && shopBean.getCompanyName().length()>0){
//		2.调用shopAction储存shopbean
			boolean flag = false;
//			根据id判断是否为新增
			if (shopBean.getId()==-1)
				flag = new ShopAction().upShop(shopBean);
			else
				System.out.println(shopBean.toString());
				flag = new ShopAction().updateShop(shopBean);
//		3.判断是否保存成功，并返回页面
			if (flag){
				request.setAttribute("info","success");
			} else {
				request.setAttribute("info","false");
			}
		}else {
			request.setAttribute("shopflag",0);
			ShopBean oldshop = new ShopBean(-1,"",0,0,0,0,0,0,0,0);
			request.setAttribute("oldshop",oldshop);
//			request.setAttribute("flag","save");
		}
		return new ModelAndView("upshop");
	}
	@RequestMapping(value = "updateshoppage")
	public ModelAndView updateshoppage(int shopId,int update,HttpServletRequest request) {
		System.out.println("flag："+update);
//		调用shopAction
		ShopAction sa = new ShopAction();
//		判断修改还是删除
		if (update == 1){
			System.out.println("修改操作");
//			修改操作
//			根据shopId，获得oldshop
			ShopBean oldshop = sa.findByid(shopId);
//			发送oldshop到upshop.jsp前端
			request.setAttribute("oldshop",oldshop);
			return new ModelAndView("upshop");
		}else if (update == 0){
//		调用删除工具
//		判断是否删除成功
			if (sa.deleteShop(shopId)){
//		返回信息
				request.setAttribute("info","success");
			} else {
				request.setAttribute("info","false");
			}
		}
//		传输shop和shop目录数据
		request.setAttribute("shoplist", sa.findAll());
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		return new ModelAndView("updateshop");
	}

	@RequestMapping(value = "keeppeibidianaction")
	public ModelAndView keeppeibidianaction(String pbdname,HttpServletRequest request) {
//		获取变量
		testbean yq = (testbean)request.getSession().getAttribute("yq");
		List<testbean> tlist = (List<testbean>) request.getSession().getAttribute("tList");
		testbean result = (testbean)request.getSession().getAttribute("result");
//		判断是否为空
		if (yq != null && tlist != null && result!=null){
//		调用PeibibiaoAction方法，并判断是否成功
			if(new PeibibiaoAction().keeppeibidian(tlist,result,yq,pbdname)){
//		根据返回结果显示不同信息
				request.setAttribute("info","success");
			} else {
				request.setAttribute("info","false");
			}
		}
		return new ModelAndView("xiangqing");
	}
	@RequestMapping(value = "peibidanlistpage")
	public ModelAndView peibidanlistpage(String pbdName,HttpServletRequest request) {
		request.setAttribute("peibimulu", sa.findAllPeiBiMuLu());
		if (pbdName.length() == 0) {
			List<pbdBean> pbdBeanList = new PeibibiaoAction().findAllPbd_resulta();
			for (pbdBean pbd:pbdBeanList) System.out.println("pbdList："+pbd);
			request.setAttribute("pbdlist", pbdBeanList);
			return new ModelAndView("peibidanlist");
		}else {
//		获取变量
			PeibibiaoAction pba = new PeibibiaoAction();
			request.getSession().setAttribute("yq",pba.findPbd_yqByPbdName(pbdName));
			request.getSession().setAttribute("tList", pba.findPbd_tlistByPbdName(pbdName));
			request.getSession().setAttribute("result", pba.findPbd_resultByPbdName(pbdName));
			return new ModelAndView("xiangqing");
		}
	}
	@RequestMapping(value = "deletepeibidan")
	public ModelAndView deletepeibidan(String pbdName, HttpServletRequest request) {
//		1.调用peiliaobiaoaction
		boolean flag = new PeibibiaoAction().deletePbdByPbdName(pbdName);
//		2.根据返回值判断删除是否成功,发送信息
		if (flag){
			request.setAttribute("info", "success");
		}else{
			request.setAttribute("info", "false");
		}
		return new ModelAndView("redirect:peibidanlistpage?pbdName=");
	}

}
