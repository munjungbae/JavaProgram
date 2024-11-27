package subjectMVCProgramcontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import subjectMVCProgrammodel.LessonVO;

//DAO = 자바에서 데이터베이스에 접근하여 CURD를 전담하는 클래스
public class LessonDAO {
	public static String LESSON_SELECT = "SELECT * FROM LESSON";
	public static String LESSON_SELECT_SORT = "SELECT * FROM LESSON ORDER BY NO";
	public static String LESSON_DELETE = "DELETE FROM LESSON WHERE NO = ?";
	public static String LESSON_UPDATE = "UPDATE LESSON SET ABBRE = ?, NAME = ? WHERE NO = ?";
	public static String LESSON_INSERT = "INSERT INTO LESSON VALUES(LESSON_SEQ.NEXTVAL, ?, ?)";

	// lesson 테이블에서 select 출력 레코드를 리턴한다. (READ)
	public ArrayList<LessonVO> lessonSelect(LessonVO lvo) {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문
		ResultSet rs = null; // 오라클에서 결과물을 받는 객체
		ArrayList<LessonVO> lessonList = new ArrayList<LessonVO>(); // 결과값을 다른 객체에 전달하기 위해 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(LESSON_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				LessonVO lessonVo = new LessonVO(no, abbre, name);
				lessonList.add(lessonVo);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}

		return lessonList;
	}

	public ArrayList<LessonVO> lessonSelectSort(LessonVO lvo) {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문
		ResultSet rs = null; // 오라클에서 결과물을 받는 객체
		ArrayList<LessonVO> lessonList = new ArrayList<LessonVO>(); // 결과값을 다른 객체에 전달하기 위해 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(LESSON_SELECT_SORT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				LessonVO lessonVo = new LessonVO(no, abbre, name);
				lessonList.add(lessonVo);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}

		return lessonList;
	}

	// lesson 테이블에서 delete 출력 레코드를 리턴한다. (DELETE)
	public boolean lessonDelete(LessonVO lvo) {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문 // 오라클에서 결과물을 받는 객체

		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(LESSON_DELETE);
			pstmt.setInt(1, lvo.getNo());
			int count = pstmt.executeUpdate();

			successFlag = (count != 0) ? true : false;

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	// lesson 테이블에서 update 출력 레코드를 리턴한다. (UPDATE)
	public boolean lessonUpdate(LessonVO lvo) {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문 // 오라클에서 결과물을 받는 객체
		ArrayList<LessonVO> lessonList = new ArrayList<LessonVO>(); // 결과값을 다른 객체에 전달하기 위해 사용하는 객체

		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(LESSON_UPDATE);
			pstmt.setString(1, lvo.getAbbre());
			pstmt.setString(2, lvo.getName());
			pstmt.setInt(3, lvo.getNo());
			int count = pstmt.executeUpdate();

			successFlag = (count != 0) ? true : false;

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	// lesson 테이블에서 insert 출력 레코드를 리턴한다. (INSERT)
	public boolean lessonInsert(LessonVO lvo) {
		Connection con = null; // 오라클 접속 관문
		PreparedStatement pstmt = null; // 오라클에서 작업 할 쿼리문을 사용할 수 있는 명령문 // 오라클에서 결과물을 받는 객체

		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(LESSON_INSERT);
			pstmt.setString(1, lvo.getAbbre());
			pstmt.setString(2, lvo.getName());
			
			int count = pstmt.executeUpdate();

			successFlag = (count != 0) ? true : false;

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
