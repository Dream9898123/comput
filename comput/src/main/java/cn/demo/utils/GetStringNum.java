package cn.demo.utils;

public class GetStringNum {

	public double QuShuZi(String str) {
		str = str.trim();
		String str2 = "";
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str2 += str.charAt(i);
				}
			}

		}
		return (10/(Double.parseDouble(str2)));
//				Integer.parseInt(str2);
	}

}