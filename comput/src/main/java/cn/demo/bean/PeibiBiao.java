package cn.demo.bean;
public class PeibiBiao implements java.io.Serializable {
		private int id;
		private String conpanyid;
		private String conpanyname;
		private String peibi;
		private double summoney;
		private double na;
		private double ga;
		private double v;
		private double fe;
		private double s;
		private double shihui;
		private double huifafeng;
		private String fenShuId;
		public PeibiBiao() {
			
		}
		public PeibiBiao(int id, String conpanyid, String conpanyname, String peibi, double summoney, double na,
				double ga, double v, double fe, double s, double shihui, double huifafeng, String fenShuId) {
			
			this.id = id;
			this.conpanyid = conpanyid;
			this.conpanyname = conpanyname;
			this.peibi = peibi;
			this.summoney = summoney;
			this.na = na;
			this.ga = ga;
			this.v = v;
			this.fe = fe;
			this.s = s;
			this.shihui = shihui;
			this.huifafeng = huifafeng;
			this.fenShuId = fenShuId;
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
		public String getConpanyname() {
			return conpanyname;
		}
		public void setConpanyname(String conpanyname) {
			this.conpanyname = conpanyname;
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
		public double getNa() {
			return na;
		}
		public void setNa(double na) {
			this.na = na;
		}
		public double getGa() {
			return ga;
		}
		public void setGa(double ga) {
			this.ga = ga;
		}
		public double getV() {
			return v;
		}
		public void setV(double v) {
			this.v = v;
		}
		public double getFe() {
			return fe;
		}
		public void setFe(double fe) {
			this.fe = fe;
		}
		public double getS() {
			return s;
		}
		public void setS(double s) {
			this.s = s;
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
		public String getFenShuId() {
			return fenShuId;
		}
		public void setFenShuId(String fenShuId) {
			this.fenShuId = fenShuId;
		}
		@Override
		public String toString() {
			return "PeibiBiao [id=" + id + ", conpanyid=" + conpanyid + ", conpanyname=" + conpanyname + ", peibi="
					+ peibi + ", summoney=" + summoney + ", na=" + na + ", ga=" + ga + ", v=" + v + ", fe=" + fe
					+ ", s=" + s + ", shihui=" + shihui + ", huifafeng=" + huifafeng + ", fenShuId=" + fenShuId + "]";
		}
		
}
