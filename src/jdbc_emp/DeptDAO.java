package jdbc_emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
