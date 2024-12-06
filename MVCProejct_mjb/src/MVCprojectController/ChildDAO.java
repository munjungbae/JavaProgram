package MVCprojectController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MVCprojectModel.DBU;
import MVCprojectModel.ChildVO;
import MVCprojectModel.MajorVO;

public class ChildDAO {
	public static final String CHILD_SELECT = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, C.NAME, GRADE FROM CHILD C INNER JOIN MAJOR M ON C.MNUM = M.MNUM ORDER BY NO ASC";
	public static final String CHILD_INSERT = "INSERT INTO CHILD VALUES(CHILD_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String CHILD_DELETE = "DELETE FROM CHILD WHERE NO = ?";

	public ArrayList<ChildVO> childSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ChildVO> childList = new ArrayList<ChildVO>();

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

				ChildVO childVO = new ChildVO(no, num, mName, iName, grade);
				childList.add(childVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return childList;
	}

	public boolean childInsert(ChildVO childVo) {
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

	public boolean childDelete(ChildVO childVo) {
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

}
