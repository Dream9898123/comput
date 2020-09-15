package cn.demo.utils;

import cn.demo.bean.ShopBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaixuNumUtils {
	static Set<ShopBean []> conpanyId = new HashSet<ShopBean []>();
	static Set<String> conpany = new HashSet<String>();
      /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     */
    private static long factorial(int n) {
        long sum = 1;
        while( n > 0 ) {
            sum = sum * n--;
        }
        return sum;
    }
      /**
     * 排列计算公式A = n!/(n - m)!
     */
    public static long arrangement(int m, int n) {
        return m <= n ? factorial(n) / factorial(n - m) : 0;
    }
    /**
     * 组合计算公式C<sup>m</sup><sub>n</sub> = n! / (m! * (n - m)!)
     * @param m
     * @param n
     * @return
     */
    public static long combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
    }

    /**
     * 组合选择（从列表中选择n个组合）
     * @param dataList 待选列表
     * @param n 选择个数
     */
    public static void combinationSelect(ShopBean[] dataList, int n) {
        System.out.println(String.format("C(%d, %d) = %d", dataList.length, n, combination(n, dataList.length)));
        combinationSelect(dataList, 0, new ShopBean[n], 0);
    }

    /**
     * 组合选择
     * @param dataList 待选列表
     * @param dataIndex 待选开始索引
     * @param resultList 前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(ShopBean[] dataList, int dataIndex, ShopBean[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
        	ShopBean [] q=new ShopBean [resultList.length];
        	String s = "";
        	for(int i=0;i<resultList.length;i++) {
        		q[i]=resultList[i];
        		s= s+resultList[i].getId()+",";
        	}
        	conpany.add(s);
        	conpanyId.add(q);
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }
    public Set<ShopBean[]> px(List<ShopBean> tlist,int yq) {
        ShopBean[] array = new ShopBean[tlist.size()];
        tlist.toArray(array);
        conpanyId = new HashSet<ShopBean []>();
            combinationSelect(array, yq);
		return conpanyId;        
    }
}