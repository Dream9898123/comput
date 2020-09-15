package cn.demo.utils;

import java.util.HashSet;
import java.util.Set;


public class CaifengNumUtils {
    /** 
     * 正整数加法不同的分解法 
     * @param sum：和 
     * @param max：最大值 
     * @param data：记录不同的加法形式 
     * @param index：加法分解数的最大个数 
     * @return 分解个数 
     */  
	static Set<int[]> caifeng = new HashSet<int[]>();
    public static Set<int[]> getCaifeng(int fenShu,int yq) {
    	caifeng = new HashSet<int[]>();
        int[] data = new int[fenShu];  
    	splitInteger(fenShu,fenShu,data,0,yq);
		return caifeng;
	}


	public static int  splitInteger(int sum, int max, int[] data, int index, int yq) {  
        if (max > sum) max = sum;  
        if (sum < 1 || max < 1) return 0;  
        if (sum == 1 || max == 1) {  
            if (sum == 1) {  
                data[index] = sum;  
                print(data, index+1, yq);  
            } else {  
                for (int i = 0; i < sum; i++) {  
                    data[index++] = max;  
                }  
                print(data, index, yq);  
            }  
            return 1;  
        }  
        if (sum == max) {  
            data[index] = max;  
            print(data, index+1, yq);  
            return 1 + splitInteger(sum, max-1, data, index, yq);  
        } else if (sum > max) {  
            data[index] = max;  
            //一定注意这里的先后顺序  
            return splitInteger(sum-max, max, data, index+1, yq) + splitInteger(sum, max-1, data, index, yq);             
        } else {   
            //sum < max  
            return splitInteger(sum, sum, data, index, yq);  
        }  
    }  
      
    //打印数组  
    public static void print(int[] data, int index, int yq) {
    	ZuheNumUtils t=new ZuheNumUtils();
    	if(index==yq) {
    		int [] result=new int[yq];
        for (int i = 0; i <= index -1; i++) {
        	result[i]=data[i];
        } 
        caifeng.add(result);
    	}
    }  
    /** 
     * 正整数加法不同分解的个数:最大值为max，和为sum的加法个数 
     * 递归形式： f(sum, max) = f(sum-max, max) + f(sum, max-1);  
     * @param sum 
     * @param max 
     * @return 
     */  
    public static int count(int sum, int max) {  
        if (sum < 1 || max < 1) return 0;  
        else if (sum == 1 || max == 1){   
            return 1;  
        } else if (sum < max) {  
            return count(sum,sum);  
        } else if (sum == max) {  
            return 1+count(sum, sum-1);  
        } else {  
            return count(sum, max-1)+count(sum-max,max);  
        }  
    }  
}