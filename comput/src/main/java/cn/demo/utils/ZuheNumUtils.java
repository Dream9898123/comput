package cn.demo.utils;

import java.util.HashSet;
import java.util.Set;

public class ZuheNumUtils {
	static Set<String> set = new HashSet<String>();

	public static int n;
	public static int[] num1;
	public static boolean[] bool;

	public static Set<String> zuhe(int[] t, int yq) {
		set = new HashSet<String>();
		num1 = null;
		n = 0;
		num1 = t;
		int[] num = new int[num1.length];
		bool = new boolean[num1.length];
		n = yq;
		f(0, num);
		n = 0;
		num1 = null;
		bool = null;
		return set;
//		

	}

	public static void f(int a, int[] num) {
		if (a == n) {
			String s = "";
			for (int i = 0; i < num.length; i++) {
				s = s + num[i] + ",";
			}
			set.add(s);
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!bool[i]) {
				bool[i] = true;
				num[a] = num1[i];
				f(a + 1, num);
				bool[i] = false;
				num[a] = 0;
			}
		}
	}

}
