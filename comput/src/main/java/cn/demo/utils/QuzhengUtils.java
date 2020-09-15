package cn.demo.utils;

public class QuzhengUtils {
	public double SplitAndRound(double a) {
		a = a * Math.pow(10, 2);
		return (Math.round(a)) / (Math.pow(10, 2));
	}
}
