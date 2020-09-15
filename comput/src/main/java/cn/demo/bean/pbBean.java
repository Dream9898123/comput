package cn.demo.bean;

public class pbBean {
private int id;
private String conpanyid;
private String conpanyname;
private String peibi;
private double summoney;
public pbBean() {
	
}






public pbBean(int id, String conpanyid, String conpanyname, String peibi, double summoney) {
	this.id = id;
	this.conpanyid = conpanyid;
	this.conpanyname = conpanyname;
	this.peibi = peibi;
	this.summoney = summoney;
}






public String getConpanyname() {
	return conpanyname;
}






public void setConpanyname(String conpanyname) {
	this.conpanyname = conpanyname;
}






public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public double getSummoney() {
	return summoney;
}
public void setSummoney(double summoney) {
	this.summoney = summoney;
}






@Override
public String toString() {
	return "pbBean [id=" + id + ", conpanyid=" + conpanyid + ", conpanyname=" + conpanyname + ", peibi=" + peibi
			+ ", summoney=" + summoney + "]";
}







}
