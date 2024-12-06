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
	//정보통신 부문
	public static final String INFOMATION_SELECT = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, I.NAME, GRADE FROM IMFOMATION I INNER JOIN MAJOR M ON I.MNUM = M.MNUM ORDER BY NO ASC";
	public static final String INFOMATION_INSERT = "INSERT INTO IMFOMATION VALUES(IMFO_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String INFOMATION_DELETE = "DELETE FROM IMFOMATION WHERE NO = ?";
	//유아교육 부문
	public static final String CHILD_SELECT = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, C.NAME, GRADE FROM CHILD C INNER JOIN MAJOR M ON C.MNUM = M.MNUM ORDER BY NO ASC";
	public static final String CHILD_INSERT = "INSERT INTO CHILD VALUES(CHILD_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String CHILD_DELETE = "DELETE FROM CHILD WHERE NO = ?";
	//건축공학 부문
	public static final String ARCHITECTURE_SELECT = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, A.NAME, GRADE FROM ARCHITECTURE A INNER JOIN MAJOR M ON A.MNUM = M.MNUM ORDER BY NO ASC";
	public static final String ARCHITECTURE_INSERT = "INSERT INTO ARCHITECTURE VALUES(ARCHI_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String ARCHITECTURE_DELETE = "DELETE FROM ARCHITECTURE WHERE NO = ?";
	//클래스 전체출력구문
//	public static final String CLASS_ALL_SELETE = 
	//정보통신 DAO
	public ArrayList<ClassVO> infomationSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();

		con = DBU.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(INFOMATION_SELECT);
			while (rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("NAME");
				int grade = rs.getInt("GRADE");

				ClassVO infoVO = new ClassVO(no, num, mName, iName, grade);
				infoList.add(infoVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return infoList;
	}

	public boolean infomationInsert(ClassVO infoVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(INFOMATION_INSERT);
			pstmt.setString(1, infoVo.getmNum());
			pstmt.setString(2, infoVo.getiName());
			pstmt.setInt(3, infoVo.getGrade());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}

		return successFlag;
	}

	public boolean infomationDelete(ClassVO infoVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(INFOMATION_DELETE);
			pstmt.setInt(1, infoVo.getNo());
			int result = pstmt.executeUpdate();

			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}
		return successFlag;
	}

	
	//유아교육과 DAO
	public ArrayList<ClassVO> childSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> childList = new ArrayList<ClassVO>();

		con = DBU.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(CHILD_SELECT);
			while (rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("NAME");
				int grade = rs.getInt("GRADE");

				ClassVO childVO = new ClassVO(no, num, mName, iName, grade);
				childList.add(childVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return childList;
	}

	public boolean childInsert(ClassVO childVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(CHILD_INSERT);
			pstmt.setString(1, childVo.getmNum());
			pstmt.setString(2, childVo.getiName());
			pstmt.setInt(3, childVo.getGrade());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}

		return successFlag;
	}

	public boolean childDelete(ClassVO childVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(CHILD_DELETE);
			pstmt.setInt(1, childVo.getNo());
			int result = pstmt.executeUpdate();

			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}
		return successFlag;
	}

	//건축공학 DAO
	public ArrayList<ClassVO> architectureSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ClassVO> archiList = new ArrayList<ClassVO>();

		con = DBU.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(ARCHITECTURE_SELECT);
			while (rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String mName = rs.getString("MAJOR");
				String iName = rs.getString("NAME");
				int grade = rs.getInt("GRADE");

				ClassVO archiVO = new ClassVO(no, num, mName, iName, grade);
				archiList.add(archiVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return archiList;
	}

	public boolean architectureInsert(ClassVO archiVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(ARCHITECTURE_INSERT);
			pstmt.setString(1, archiVo.getmNum());
			pstmt.setString(2, archiVo.getiName());
			pstmt.setInt(3, archiVo.getGrade());

			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}

		return successFlag;
	}

	public boolean architectureDelete(ClassVO archiVo) {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		try {
			pstmt = con.prepareStatement(ARCHITECTURE_DELETE);
			pstmt.setInt(1, archiVo.getNo());
			int result = pstmt.executeUpdate();

			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, pstmt);
		}
		return successFlag;
	}

//	public ArrayList<ClassVO> ClassAllSelect() {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<ClassVO> classList = new ArrayList<ClassVO>();
//		con = DBU.dbCon();
//		pstmt = con.prepareStatement(CLASS_ALL_SELETE)
//		
//		return null;
//	}
}
