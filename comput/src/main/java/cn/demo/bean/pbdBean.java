package cn.demo.bean;

public class pbdBean extends testbean{
    private int pbdId;
    private String flag;
    private String pbdName;

    public pbdBean() {

    }

    public pbdBean(int id, double na, double ga, double v, double fe, double s, double shihui, double huifafeng, String conpanyid, String conpanyname, String peibi, double money, int pbdId, String flag, String pbdName) {
        super(id, na, ga, v, fe, s, shihui, huifafeng, conpanyid, conpanyname, peibi, money);
        this.pbdId = pbdId;
        this.flag = flag;
        this.pbdName = pbdName;
    }

    public pbdBean(int pbdId, String flag, String pbdName) {
        this.pbdId = pbdId;
        this.flag = flag;
        this.pbdName = pbdName;
    }

    public int getPbdId() {
        return pbdId;
    }

    public void setPbdId(int pbdId) {
        this.pbdId = pbdId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPbdName() {
        return pbdName;
    }

    public void setPbdName(String pbdName) {
        this.pbdName = pbdName;
    }

    @Override
    public String toString() {
        return "pbdBean{" +
                "pbdId=" + pbdId +
                ", flag='" + flag + '\'' +
                ", pbdName='" + pbdName + '\'' +
                '}';
    }
}
