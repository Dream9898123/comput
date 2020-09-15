package cn.demo.bean;


public class testbean {
	private int id;
	private double Na;
	private double Ga;
	private double V;
	private double Fe;
	private double S;
	private double shihui;
	private double huifafeng;
	private String conpanyid;
	private String conpanyname;
	private String peibi;
	private double money;
	
	public testbean (){
		
	}
	

	public testbean(int id, double na, double ga, double v, double fe, double s, double shihui, double huifafeng,
			String conpanyid, String conpanyname, String peibi, double money) {
		this.id = id;
		Na = na;
		Ga = ga;
		V = v;
		Fe = fe;
		S = s;
		this.shihui = shihui;
		this.huifafeng = huifafeng;
		this.conpanyid = conpanyid;
		this.conpanyname = conpanyname;
		this.peibi = peibi;
		this.money = money;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getConpanyid() {
		return conpanyid;
	}
	public void setConpanyid(String conpanyid) {
		this.conpanyid = conpanyid;
	}
	


	public String getPeibi() {
		return peibi;
	}
	public void setPeibi(String peibi) {
		this.peibi = peibi;
	}
	
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getConpanyname() {
		return conpanyname;
	}


	public void setConpanyname(String conpanyname) {
		this.conpanyname = conpanyname;
	}


	@Override
	public String toString() {
		return "testbean [id=" + id + ", Na=" + Na + ", Ga=" + Ga + ", V=" + V + ", Fe=" + Fe + ", S=" + S + ", shihui="
				+ shihui + ", huifafeng=" + huifafeng + ", conpanyid=" + conpanyid + ", conpanyname=" + conpanyname
				+ ", peibi=" + peibi + ", money=" + money + "]";
	}


	
	
	

}
