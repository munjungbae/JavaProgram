package subjectMVCProgramcontroller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import subjectMVCProgrammodel.TraineeVO;

public class TraineeDAO {

	public static final String TRAINEE_SELECT = "SELECT * FROM TRAINEE";
	public static final String TRAINEE_ALL_SELECT = "SELECT T.NO, T.SECTION, S.NUM, S.NAME as sname, L.ABBRE, L.NAME as lname FROM TRAINEE T INNER JOIN STUDENT ON T.S_NUM = S.NUM INNER JOIN LESSON L ON T.ABBRE = L.ABBRE ORDER BY T.NO";
	public static final String TRAINEE_INSERT = "INSERT INTO TRAINEE VALUES(TRAINEE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
//	public static final String TRAINEE_CALL_RANK_PROC = "{call STUDENT_RANK_PROC()}";
	public static final String TRAINEE_UPDATE = "UPDATE TRAINEE SET S_NUM = ?, ABBRE = ?, SECTION = ?, REGDATE = ? WHERE NO = ?";
	public static final String TRAINEE_DELETE = "DELETE FROM TRAINEE WHERE NO = ?";
	public static final String TRAINEE_SELECT_SORT = "SELECT *FROM TRAINEE ORDER BY RANK";

	public ArrayList<TraineeVO> traineeSelect(TraineeVO tvo) {
		Connection con = null; // 오라클 DB 접속하는 관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할수있게 해주는 명령문
		ResultSet rs = null; // 오라클에서 결과물을 받는객체
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>(); // 결과값을 다른객체에 전달하기 위해서 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String s_num = rs.getString("S_NUM");
				String abbre = rs.getString("ABBRE");
				String section = rs.getString("SECTION");
				Date regdate = rs.getDate("REGDATE");
				TraineeVO traineeVO = new TraineeVO(no, s_num, abbre, section, regdate);
				traineeList.add(traineeVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}

		return traineeList;
	}
	
	
	public ArrayList<TraineeVO> traineeAllSelect(TraineeVO tvo) {
		Connection con = null; // 오라클 DB 접속하는 관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할수있게 해주는 명령문
		ResultSet rs = null; // 오라클에서 결과물을 받는객체
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>(); // 결과값을 다른객체에 전달하기 위해서 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_ALL_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String section = rs.getString("SECTION");
				Date regdate = rs.getDate("REGDATE");
				String s_num = rs.getString("NUM");
				String s_name = rs.getString("SNAME");
				String abbre = rs.getString("ABBRE");
				String l_name = rs.getString("LNAME");
				TraineeVO traineeVO = new TraineeVO(no, s_num, abbre, section, regdate, s_name, l_name);
				traineeList.add(traineeVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}

		return traineeList;
	}
	

	public static boolean traineeInsert(TraineeVO svo) throws SQLException {
		// Conection
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(TRAINEE_INSERT);
		// pstmt.setString(1, svo.getName());

		int result1 = pstmt.executeUpdate();
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");

//		cstmt = con.prepareCall(TRAINEE_CALL_RANK_PROC);
//		int result2 = cstmt.executeUpdate();
//		System.out.println((result2 != 0) ? "프로시저성공" : "프로시저실패");

		DBUtility.dbClose(con, pstmt, cstmt);
		successFlag = (result1 != 0) ? true : false;

		return successFlag;
	}

	public static boolean traineeUpdate(TraineeVO tvo) throws SQLException {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문 // 오라클에서 결과물을 받는 객체
		ArrayList<TraineeVO> lessonList = new ArrayList<TraineeVO>(); // 결과값을 다른 객체에 전달하기 위해 사용하는 객체

		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_UPDATE);
			pstmt.setString(1, tvo.getS_num());
			pstmt.setString(2, tvo.getAbbre());
			pstmt.setString(3, tvo.getSection());
			pstmt.setInt(4, tvo.getNo());

			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public static boolean traineeDelete(TraineeVO svo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();

			con.setAutoCommit(false);
			pstmt = con.prepareStatement(TRAINEE_DELETE);
			pstmt.setInt(1, svo.getNo());
			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? true : false;

			if (count != 0) {
				successFlag = true;
				con.commit();
			} else {
				successFlag = false;
				con.rollback();
			}

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}
	
	

	public static ArrayList<TraineeVO> traineeSort(TraineeVO tvo) throws SQLException {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문
		ResultSet rs = null; // 오라클에서 결과물을 받는 객체
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>(); // 결과값을 다른 객체에 전달하기 위해 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_SELECT_SORT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				TraineeVO traineeVo = new TraineeVO(no, abbre, name);
				traineeList.add(traineeVo);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}

		return traineeList;
	}

}
