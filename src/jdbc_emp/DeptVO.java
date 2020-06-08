package jdbc_emp;

public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptVO() {
		this(0,null,null);
	}
	public DeptVO(int dno, String dname, String loc) {
		this.setDeptno(dno);
		this.setDname(dname);
		this.setLoc(loc);
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
