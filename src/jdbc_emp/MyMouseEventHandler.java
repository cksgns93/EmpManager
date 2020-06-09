package jdbc_emp;
/*
 * JTalbe의 마우스 이벤트를 처리하는 클래스
 * 1) MouseListener 인터페이스를 상속받던지
 * 2) MouseAdapter추상클래스를 상속받는다.
 * 이벤트 핸들러를 외부 클래스로 별도 작성하는 경우
 * 유의사항
 *  - 인자 생성자를 구성한다.
 * */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

public class MyMouseEventHandler extends MouseAdapter{
	EmpManagerGui gui;
	public MyMouseEventHandler(EmpManagerGui gui) {
		this.gui=gui;
	}
	
	@Override 
	public void mousePressed(MouseEvent e) {
		gui.setTitle("MousePress");
		Object obj = e.getSource();
		//JTable에서 선택한 행의 인덱스값 받아오기
		JTable table= (JTable)obj;
		int row = table.getSelectedRow();
		gui.setTitle("row"+row);
		//선택한 행이 없으면 -1 반환한다.
		
		
		if(obj==gui.tableDept) {
			getSelectedDeptData(row);
		}else if(obj==gui.tableEmp) {
			getSelectedEmpData(row);
		}
	}

	private void getSelectedEmpData(int row) {
		if(row>=0) {
			String empno = gui.tableEmp.getValueAt(row, 0).toString();
			String ename = gui.tableEmp.getValueAt(row, 1).toString();
			String job = gui.tableEmp.getValueAt(row, 4).toString();
			String hiredate = gui.tableEmp.getValueAt(row, 5).toString();
			
			gui.tempno.setText(empno);
			gui.tename.setText(ename);
			gui.tjob.setText(job);
			gui.thiredate.setText(hiredate);
		}
	}

	private void getSelectedDeptData(int row) {
		if(row>=0) {//선택한 행이 있다면 선택한 행의 각 열의 정보를 추출
			String deptno = gui.tableDept.getValueAt(row,0).toString();
			String dname = gui.tableDept.getValueAt(row, 1).toString();
			String loc = gui.tableDept.getValueAt(row, 2).toString();
			gui.tdeptno.setText(deptno);
			gui.tdname.setText(dname);
			gui.tloc.setText(loc);			
		}//if---
	}//----------------------
}
