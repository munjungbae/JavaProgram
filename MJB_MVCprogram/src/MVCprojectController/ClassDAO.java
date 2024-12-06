package MVCprojectController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import MVCprojectModel.ClassVO;
import MVCprojectModel.DBU;

public class ClassDAO {
	// 정보통신 부문
	public static final String CLASS_SELECT_ALL = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, C.NAME AS CLASS, GRADE FROM CLASS C INNER JOIN MAJOR M ON C.MNUM = M.MNUM ORDER BY NUM, C.NO ASC";
	public static final String CLASS_SELECT_MAJOR = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, C.NO AS NO, C.NAME AS CLASS, C.GRADE AS GRADE FROM CLASS C INNER JOIN MAJOR M ON C.MNUM = M.MNUM WHERE C.MNUM = ? ORDER BY NO ASC";
	public static final String CLASS_INSERT = "INSERT INTO CLASS VALUES(Class_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String CLASS_DELETE = "DELETE FROM CLASS WHERE NO = ?";
	public static final String CLASS_CHECK = "SELECT COUNT(*) AS COUNT FROM CLASS WHERE NAME = ?";
	
	public ArrayList<ClassVO> classAllSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> classList = new ArrayList<ClassVO>();

		con = DBU.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(CLASS_SELECT_ALL);
			while (rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("CLASS");
				int grade = rs.getInt("GRADE");

				ClassVO classVO = new ClassVO(no, num, mName, iName, grade);
				classList.add(classVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return classList;
	}

	public ArrayList<ClassVO> classMajorSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		con = DBU.dbCon();
		try {
			
			pstmt = con.prepareStatement(CLASS_SELECT_MAJOR);
			pstmt.setString(1, "01");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("CLASS");
				int grade = rs.getInt("GRADE");
				
				ClassVO infoVO = new ClassVO(no, num, mName, iName, grade);
				infoList.add(infoVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt, rs);
		}
		return infoList;
	}
	
	public ArrayList<ClassVO> classChildSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		con = DBU.dbCon();
		try {
			
			pstmt = con.prepareStatement(CLASS_SELECT_MAJOR);
			pstmt.setString(1, "02");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("CLASS");
				int grade = rs.getInt("GRADE");
				
				ClassVO infoVO = new ClassVO(no, num, mName, iName, grade);
				infoList.add(infoVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt, rs);
		}
		return infoList;
	}
	
	public ArrayList<ClassVO> classArchiSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		con = DBU.dbCon();
		try {
			
			pstmt = con.prepareStatement(CLASS_SELECT_MAJOR);
			pstmt.setString(1, "03");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("CLASS");
				int grade = rs.getInt("GRADE");
				
				ClassVO infoVO = new ClassVO(no, num, mName, iName, grade);
				infoList.add(infoVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt, rs);
		}
		return infoList;
	}
	
	public boolean classCheck (ClassVO classVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		con = DBU.dbCon();
		
		try {
			pstmt = con.prepareStatement(CLASS_CHECK);
			pstmt.setString(1, classVo.getiName());
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("COUNT");
			} else {
				count = 0;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt, rs);
		}
		return (count != 0) ? (false) : (true);
	}

	public boolean classInsert(ClassVO classVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(CLASS_INSERT);
			pstmt.setString(1, classVo.getmNum());
			pstmt.setString(2, classVo.getiName());
			pstmt.setInt(3, classVo.getGrade());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}

		return successFlag;
	}

	public boolean classDelete(ClassVO classVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(CLASS_DELETE);
			pstmt.setInt(1, classVo.getNo());
			int result = pstmt.executeUpdate();

			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}
		return successFlag;
	}

}
