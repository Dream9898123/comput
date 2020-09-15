package cn.demo.bean;


import java.io.Serializable;

public class ShopBean implements Serializable {
	private int id;
	private String companyName;
	private double Na;
	private double Ga;
	private double V;
	private double Fe;
	private double S;
	private double shihui;
	private double huifafeng;
	private double money;

	public ShopBean() {
	}

	public ShopBean(int id, String companyName, double na, double ga, double v, double fe, double s, double shihui, double huifafeng, double money) {
		this.id = id;
		this.companyName = companyName;
		Na = na;
		Ga = ga;
		V = v;
		Fe = fe;
		S = s;
		this.shihui = shihui;
		this.huifafeng = huifafeng;
		this.money = money;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getNa() {
		return Na;
	}
	public void setNa(double na) {
		Na = na;
	}
	public double getGa() {
		return Ga;
	}
	public void setGa(double ga) {
		Ga = ga;
	}
	public double getV() {
		return V;
	}
	public void setV(double v) {
		V = v;
	}
	public double getFe() {
		return Fe;
	}
	public void setFe(double fe) {
		Fe = fe;
	}
	public double getS() {
		return S;
	}
	public void setS(double s) {
		S = s;
	}
	public double getShihui() {
		return shihui;
	}
	public void setShihui(double shihui) {
		this.shihui = shihui;
	}
	public double getHuifafeng() {
		return huifafeng;
	}
	public void setHuifafeng(double huifafeng) {
		this.huifafeng = huifafeng;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "ShopBean{" +
				"id=" + id +
				", companyName='" + companyName + '\'' +
				", Na=" + Na +
				", Ga=" + Ga +
				", V=" + V +
				", Fe=" + Fe +
				", S=" + S +
				", shihui=" + shihui +
				", huifafeng=" + huifafeng +
				", money=" + money +
				'}';
	}
}
