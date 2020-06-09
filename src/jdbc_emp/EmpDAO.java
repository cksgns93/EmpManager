package jdbc_emp;
import java.sql.*;
import java.util.*;

/*DAO ==> Data Access Object
 * CRUD기능을 수행 
 */
public class EmpDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/*사원들이 소속되어 있는 부서명과 부서번호 가져오기
	 * */
	
	//사원 정보를 등록하는 메소드 - INSERT 문을 수행
	public boolean insertEmp(EmpVO e){
		try {
			con = DBUtil.getCon();
			String sql = "insert into emp2(empno, ename, job, deptno, sal, comm, mgr, hiredate)";
			sql+=" values(emp2_seq.nextval,?,?,?,?,?,?,sysdate)";
			ps=con.prepareStatement(sql);
			ps.setString(1, e.getEname());
			ps.setString(2, e.getJob());
			ps.setInt(3, e.getDeptno());
			ps.setInt(4, e.getSal());
			ps.setInt(5, e.getComm());
			ps.setInt(6, e.getMgr());
			int n = ps.executeUpdate();
			boolean b=(n>0) ? true:false;
			return b;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		} finally {
			close();
		}
	}
	//모든 사원정보를 db에서 가져오는 메소드
	public ArrayList<EmpVO> selectEmpAll(){
		try {
			con = DBUtil.getCon();
			//String sql ="SELECT * FROM EMP2 ORDER BY EMPNO ASC";
			String sql="select d.deptno , d.dname, empno, ename, job, mgr,sal,comm,hiredate\r\n" + 
					"from emp2 e right outer join dept2 d \r\n" + 
					"on e.deptno = d.deptno order by e.deptno asc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			ArrayList<EmpVO> arr = makeList(rs);
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	//사원명으로 사원정보를 검색하는 메소드
	public ArrayList<EmpVO>	selectByEname(String ename){
		try {
			con=DBUtil.getCon();
			String sql="SELECT * FROM EMP2 WHERE ENAME=upper(?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, ename);
			rs=ps.executeQuery();
			ArrayList<EmpVO> arr = makeList(rs);
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	public ArrayList<EmpVO> selectByEname(int empno) {
		try {
			con=DBUtil.getCon();
			String sql="SELECT * FROM EMP2 WHERE EMPNO=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, empno);
			rs=ps.executeQuery();
			ArrayList<EmpVO> arr = makeList(rs);
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	private ArrayList<EmpVO> makeList(ResultSet rs) throws SQLException{
		ArrayList<EmpVO> arr= new ArrayList<>();
		while(rs.next()) {
			int empno=rs.getInt("empno");
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			int mgr=rs.getInt("mgr");
			java.sql.Date hdate=rs.getDate("hiredate");
			int sal=rs.getInt("sal");
			int comm=rs.getInt("comm");
			int deptno=rs.getInt("deptno");
			String dname=rs.getString("dname");
			EmpVO emp=new EmpVO(empno,ename,job,mgr,hdate,sal,comm,deptno,dname);
			arr.add(emp);
		}
		return arr;
	}
	//DB연결 자원을 반납하는 메소드
	public void close() {
		try {
			if(rs!=null)	rs.close();
			if(ps!=null)	ps.close();
			if(con!=null)	con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
