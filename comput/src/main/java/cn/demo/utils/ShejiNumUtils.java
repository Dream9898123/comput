package cn.demo.utils;

import cn.demo.bean.ShopBean;
import cn.demo.bean.testbean;

import java.util.*;

public class ShejiNumUtils {
	PeibiNumUtils t3=new PeibiNumUtils();
	ZuheNumUtils t2=new ZuheNumUtils();
	CaifengNumUtils t1=new CaifengNumUtils();
	PaixuNumUtils t=new PaixuNumUtils();
public void main(List<ShopBean> slist,testbean pp, int fenShu) {
	for(int yq=1;yq<=slist.size();yq++) {
	Set<int[]> caifeng=t1.getCaifeng(fenShu, yq);
     Set<ShopBean[]> conpanyId=new HashSet<ShopBean []>();
     conpanyId=t.px(slist, yq);
     for(ShopBean [] k:conpanyId) {
			 for(int[] i:caifeng) {
				    Set<String> zuhe=new HashSet<String>();
		     		zuhe=t2.zuhe(i, yq);
	    			testbean result = new testbean();
		     		for(String str:zuhe) {
		     			String[] getArr = str.split(",");
		    			int[] array = Arrays.asList(getArr).stream().mapToInt(Integer::parseInt).toArray();
		    			List <testbean> peibiList=new ArrayList<>();
		    			for(int o=0;o<array.length&&array.length==k.length;o++){
//		    				System.out.print("id="+k[o].getId()+" X "+array[o]+" : ");
//		    				7种原材料配比数
		    				testbean peibit=t3.PeiBi(k[o],array[o],fenShu);
		    				peibiList.add(peibit);
		    			}
		    			result=t3.resultpeibiList(peibiList);
			     		t3.resultduibi(pp,result);
		     		}
		     	}
	 		}
     	}
	}

public void SheJiPeiBiBiao(List<ShopBean> slist, int fenShu, String peiBiMingZi) {
	for(int yq=1;yq<=slist.size();yq++) {
	Set<int[]> caifeng=t1.getCaifeng(fenShu, yq);
     Set<ShopBean[]> conpanyId=new HashSet<ShopBean []>();
     conpanyId=t.px(slist, yq);
     for(ShopBean [] k:conpanyId) {
			 for(int[] i:caifeng) {
				    Set<String> zuhe=new HashSet<String>();
		     		zuhe=t2.zuhe(i, yq);
	    			testbean result = new testbean();
		     		for(String str:zuhe) {
		     			String[] getArr = str.split(",");
		    			int[] array = Arrays.asList(getArr).stream().mapToInt(Integer::parseInt).toArray();
		    			List <testbean> peibiList=new ArrayList<>();
		    			for(int o=0;o<array.length&&array.length==k.length;o++){
//		    				System.out.print("id="+k[o].getId()+" X "+array[o]+" : ");
//		    				7种原材料配比数
		    				testbean peibit=t3.PeiBi(k[o],array[o],fenShu);
		    				peibiList.add(peibit);
		    			}
		    			result=t3.resultpeibiList(peibiList);
			     		t3.PeiBiChuCun(result , peiBiMingZi);
		     		}
		     	}
	 		}
     	}
	}

}
