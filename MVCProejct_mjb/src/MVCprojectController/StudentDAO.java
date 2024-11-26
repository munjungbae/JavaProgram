package MVCprojectController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MVCprojectModel.DBU;
import MVCprojectModel.StudentVO;

public class StudentDAO {
	public static final String STUDENT_SELECT = "SELECT NO, S.NAME, YEAR, GRADE, BIRTH, PHONE, S.MNUM, M.NAME AS MAJOR FROM STUDENT2 S INNER JOIN MAJOR M ON S.MNUM = M.MNUM";
	public static final String STUDENT_INSERT = "INSERT INTO STUDENT2 VALUES(STUDENT2_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	public static final String STUDENT_UPDATE = "UPDATE STUDENT2 SET NAME = ?, YEAR = ?, GRADE = ?, BIRTH = ?, PHONE = ?, MNUM = ? WHERE NO = ? ";
	public static final String STUDENT_DELETE = "DELETE FROM STUDENT2 WHERE NO = ?";
	
	public ArrayList<StudentVO> studentSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();

		con = DBU.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(STUDENT_SELECT);
			
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String year = rs.getString("YEAR");
				int grade = rs.getInt("GRADE");
				String birth = rs.getString("BIRTH");
				String phone = rs.getString("PHONE");
				String mNum = rs.getString("MNUM");
				String mName = rs.getString("MAJOR");
				
				StudentVO stu = new StudentVO(no, name, year, grade, birth, phone, mNum, mName);
				
				studentList.add(stu);
				
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return studentList;
	}

	public boolean studentInsert(StudentVO sVo) throws SQLException {
				boolean successFlag = false;
				Connection con = null;
				PreparedStatement pstmt = null;

				// 1 Load, 2. connect
				con = DBU.dbCon();
				
				pstmt = con.prepareStatement(STUDENT_INSERT);
				pstmt.setString(1, sVo.getName());
				pstmt.setString(2, sVo.getYear());
				pstmt.setInt(3, sVo.getGrade());
				pstmt.setString(4, sVo.getBirth());
				pstmt.setString(5, sVo.getPhone());
				pstmt.setString(6, sVo.getmNum());

				int result1 = pstmt.executeUpdate();

				successFlag = (result1 != 0) ? true : false;
				
				DBU.dbClose(con, pstmt);
				
				return successFlag;
	}

	public boolean studentUpdate(StudentVO sVo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		
		con = DBU.dbCon();

		pstmt = con.prepareStatement(STUDENT_UPDATE);
		pstmt.setString(1, sVo.getName());
		pstmt.setString(2, sVo.getYear());
		pstmt.setInt(3, sVo.getGrade());
		pstmt.setString(4, sVo.getBirth());
		pstmt.setString(5, sVo.getPhone());
		pstmt.setString(6, sVo.getmNum());
		pstmt.setInt(7, sVo.getNo());

		int result1 = pstmt.executeUpdate();
		
		cstmt = con.prepareCall("protocol line");
		int result2 = cstmt.executeUpdate();

		successFlag = (result1 != 0 && result2 != 0) ? true : false;
		
		DBU.dbClose(con, pstmt, cstmt);
		
		return successFlag;
	}

	public boolean studentDelete(StudentVO sVo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		pstmt = con.prepareStatement(STUDENT_DELETE);
		pstmt.setInt(1, sVo.getNo());
		int result = pstmt.executeUpdate();

		successFlag = (result != 0) ? true : false;

		DBU.dbClose(con, pstmt);
		
		return successFlag;
	}

}
