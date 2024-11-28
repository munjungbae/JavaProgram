package subjectMVCProgramcontroller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import subjectMVCProgrammodel.StudentJoin;
import subjectMVCProgrammodel.StudentVO;

public class StudentDAO {
	public static final String STUDENT_SELECT = "SELECT * FROM STUDENT";
	public static final String STUDENT_SELECT_SEARCH = "SELECT NUM, NAME, EMAIL FROM STUDENT WHERE NAME = ?";
	public static final String STUDENT_JOIN_SELECT = "SELECT ST.NO, ST.NUM, ST.NAME, ID, PASSWD, S_NUM, SJ.NAME AS S_NAME, BIRTHDAY, PHONE, ADDRESS, EMAIL, SDATE FROM STUDENT ST INNER JOIN SUBJECT SJ ON st.s_num = sj.num";
	public static final String STUDENT_INSERT = "INSERT INTO STUDENT VALUES(STUDENT_SEQ.NEXTVAL, ?, ?, ? ,?, ?, ?, ?, ?, ? ,SYSDATE)";
	public static final String STUDENT_CALL_RANK_PROC = "{call STUDENT_RANK_PROC()}";
	public static final String STUDENT_UPDATE = "UPDATE STUDENT SET NAME = ?, KOR = ?, ENG = ?, MAT = ? WHERE NO = ?";
	public static final String STUDENT_DELETE = "DELETE FROM STUDENT WHERE NO = ?";
	public static final String STUDENT_SORT = "SELECT *FROM STUDENT ORDER BY RANK";
	public static final String STUDENT_ID_CHECK = "select COUNT(*) AS COUNT from student where id = ?";
	public static final String STUDENT_NUM_COUNT = "select LPAD(count(*)+1,4,'0') as total_count from student where s_num = ?";

	public static ArrayList<StudentVO> studentSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();

		con = DBUtility.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(STUDENT_SELECT);
			if (rs.next()) {
				do {
					int no = rs.getInt("NO");
					String name = rs.getString("NAME");
					String num = rs.getString("NUM");
					String id = rs.getString("ID");
					String passwd = rs.getString("PASSWD");
					String s_num = rs.getString("S_NUM");
					String birthday = rs.getString("BIRTHDAY");
					String phone = rs.getString("PHONE");
					String address = rs.getString("ADDRESS");
					String email = rs.getString("EMAIL");
					Date sdate = rs.getDate("SDATE");

					StudentVO stu = new StudentVO(no, name, num, id, passwd, s_num, birthday, phone, address, email,
							sdate);
					studentList.add(stu);
				} while (rs.next());
			} else {
				studentList = null;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, stmt, rs);
		}
		return studentList;
	}

	public static ArrayList<StudentVO> studentNameSelect(String nameValue) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();

		con = DBUtility.dbCon();
		try {
			pstmt = con.prepareStatement(STUDENT_SELECT_SEARCH);
			pstmt.setString(1, nameValue);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					String num = rs.getString("NUM");
					String name = rs.getString("NAME");
					String email = rs.getString("EMAIL");

					StudentVO stu = new StudentVO();
					stu.setNum(num);
					stu.setName(name);
					stu.setEmail(email);

					studentList.add(stu);
				} while (rs.next());
			} else {
				studentList = null;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return studentList;
	}

	public static boolean studentInsert(StudentVO svo) {
		// Conection
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		try {
			pstmt = con.prepareStatement(STUDENT_INSERT);
			pstmt.setString(1, svo.getNum());
			pstmt.setString(2, svo.getName());
			pstmt.setString(3, svo.getId());
			pstmt.setString(4, svo.getPasswd());
			pstmt.setString(5, svo.getS_num());
			pstmt.setString(6, svo.getBirthday());
			pstmt.setString(7, svo.getPhone());
			pstmt.setString(8, svo.getAddress());
			pstmt.setString(9, svo.getEmail());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public static boolean studentUpdate(StudentVO svo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(STUDENT_UPDATE);
		pstmt.setString(1, svo.getName());

		int result1 = pstmt.executeUpdate();
		cstmt = con.prepareCall(STUDENT_CALL_RANK_PROC);
		int result2 = cstmt.executeUpdate();

		successFlag = (result1 != 0 && result2 != 0) ? true : false;

		DBUtility.dbClose(con, pstmt, cstmt);
		return successFlag;
	}

	public static boolean studentDelete(StudentVO svo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(STUDENT_DELETE);
		pstmt.setInt(1, svo.getNo());
		int result = pstmt.executeUpdate();
		successFlag = (result != 0) ? true : false;

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	public static ArrayList<StudentVO> studentSort() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(STUDENT_SORT);

		if (rs.next()) {
			do {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				int kor = rs.getInt("KOR");
				int eng = rs.getInt("ENG");
				int mat = rs.getInt("MAT");
				int total = rs.getInt("TOTAL");
				int ave = rs.getInt("AVE");
				int rank = rs.getInt("RANK");

				StudentVO stu = new StudentVO();
				studentList.add(stu);
			} while (rs.next());
		} else {
			studentList = null;
		}

		DBUtility.dbClose(con, stmt, rs);
		return studentList;
	}

	// 중복아이디 체크
	public boolean studentIdCheck(StudentVO svo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(STUDENT_ID_CHECK);
			pstmt.setString(1, svo.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("COUNT");
			} else {
				count = 0;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return (count != 0) ? (true) : (false);
	}

	// 해당 학과번호 가져오기 01번 학과 2명 있었다면, 0003이 result값.
	public String getStudentCount(StudentVO svo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;

		con = DBUtility.dbCon();
		try {
			pstmt = con.prepareStatement(STUDENT_NUM_COUNT);
			pstmt.setString(1, svo.getS_num());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getString("TOTAL_COUNT");
			} else {
				result = null;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}

		return result;
	}

	public ArrayList<StudentJoin> studentAllSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentJoin> studentJoinList = new ArrayList<StudentJoin>();

		con = DBUtility.dbCon();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(STUDENT_JOIN_SELECT);
			if (rs.next()) {
				do {
					int no = rs.getInt("NO");
					String name = rs.getString("NAME");
					String num = rs.getString("NUM");
					String id = rs.getString("ID");
					String passwd = rs.getString("PASSWD");
					String s_num = rs.getString("S_NUM");
					String s_name = rs.getString("S_NAME");
					String birthday = rs.getString("BIRTHDAY");
					String phone = rs.getString("PHONE");
					String address = rs.getString("ADDRESS");
					String email = rs.getString("EMAIL");
					Date sdate = rs.getDate("SDATE");

					StudentJoin sj = new StudentJoin(no, name, num, id, passwd, s_num, s_name, birthday, phone, address,
							email, sdate);
					studentJoinList.add(sj);
				} while (rs.next());
			} else {
				studentJoinList = null;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, stmt, rs);
		}
		return studentJoinList;

	}

}
