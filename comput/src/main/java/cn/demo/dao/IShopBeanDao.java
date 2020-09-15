package cn.demo.dao;

import cn.demo.bean.ShopBean;

import java.util.List;

public interface IShopBeanDao {
	 boolean deleteShopBean(int id);
	 List<ShopBean> getAllList();
	 ShopBean getShopById (int id);
    boolean upshop(ShopBean shopBean);
	boolean updateShop(ShopBean shopBean);
}
