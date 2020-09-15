package cn.demo.bean;

public class PeiBiMuLu {
	private int id;
	private String PeiBiMingZi;
	public PeiBiMuLu() {
		
	}
	public PeiBiMuLu(int id, String peiBiMingZi) {
		this.id = id;
		PeiBiMingZi = peiBiMingZi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPeiBiMingZi() {
		return PeiBiMingZi;
	}
	public void setPeiBiMingZi(String peiBiMingZi) {
		PeiBiMingZi = peiBiMingZi;
	}
	@Override
	public String toString() {
		return "PeiBiMuLu [id=" + id + ", PeiBiMingZi=" + PeiBiMingZi + "]";
	}
	
	
}
