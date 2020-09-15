package cn.demo.dao;

import cn.demo.bean.PeiBiMuLu;
import cn.demo.bean.PeibiBiao;
import cn.demo.bean.pbBean;
import cn.demo.bean.testbean;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IPbBeanDao {
	 boolean insert(pbBean shop);
	 boolean update(pbBean shop);
	 void truncateTable();
	 boolean delete();
	 List<pbBean> getAllList();
	 pbBean getPbById (int id);
//	写入表单目录
	 boolean chaRuBiaoDanMuLu(PeiBiMuLu peiBiMuLu);
//	按名称查找表单目录
	 PeiBiMuLu getMuLu(String peiBiMingZi);
//	按id查找表单目录
	 PeiBiMuLu getPeiBiMuLuById(int id);
//	查找表单全部信息
	 List<PeiBiMuLu> getMuLulist();
//	写入现有表单
	 boolean chaRuPeiBiBiao(PeibiBiao peiBiBiao);
//	在现有表单中寻找适量值
	 List<PeibiBiao> getPeiBiBiao(@Param("testbean")testbean testBean,@Param("biaoDan_id")String biaoDan_id);
//	现有表单按id查找
	 PeibiBiao getPeiBiBiaoById(int id);
//	 删除peibimulu通过id
	boolean deletePeiBiMuLuById(int id);
//	删除peibibiao通过fenshid
	boolean deletePeibiBiaoByfenshuId(String fenShuId);
}
