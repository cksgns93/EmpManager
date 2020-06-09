package jdbc_emp;

import java.sql.Date;
//Domain��ü -> ���� ����ִ� ��ü.(Value Object)
public class EmpVO 
{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	
	
	public EmpVO() {
		this(0,"",null,0,null,0,0,0,null);
	}
	public EmpVO(int empno, String ename, String job, int mgr,
			Date hdate, int sal, int comm, int deptno, String dname) {
		this.setEmpno(empno); this.setEname(ename); this.setJob(job);
		this.setMgr(mgr); setHiredate(hdate); this.setSal(sal);
		this.setComm(comm); this.setDeptno(deptno); this.dname=dname;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
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
}
