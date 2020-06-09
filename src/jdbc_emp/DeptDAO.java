package jdbc_emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*부서 정보를 등록, 삭제, 조회하는 
 * biz logic을 담고 있는 클래스
 * */
public class DeptDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	//부서정보를 등록하는 메소드
	public boolean insertDept(DeptVO dvo) {
		try {
			con=DBUtil.getCon();
			String sql = "INSERT INTO DEPT2(deptno, dname, loc) VALUES(dept2_seq.nextval, ?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dvo.getDname());
			ps.setString(2, dvo.getLoc());
			int n = ps.executeUpdate();
			boolean b=(n>0) ? true : false;
			return b;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			close();
		}
	}
	//select 하는 것
	public ArrayList<DeptVO> allDept() {
		try {
			con=DBUtil.getCon();
			String sql = "SELECT * FROM dept2 order by deptno asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<DeptVO> arr= new ArrayList<>();
			while(rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				DeptVO dvo =new DeptVO(deptno,dname,loc);
				arr.add(dvo);
			}
			return arr;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}
	//부서 정보를 삭제하는 메소드
	public boolean deleteDept(String deptno) {
		try {
			con = DBUtil.getCon();
			String sql = "delete from dept2 where deptno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, deptno);
			int n = ps.executeUpdate();
			return (n>0) ? true: false;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close();
		}
	}
	
	public void close() {
		
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				if(con!=null)	con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
