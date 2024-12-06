package MVCprojectController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MVCprojectModel.DBU;
import MVCprojectModel.ImfomationVO;

public class ImfomationDAO {
	public static final String INFOMATION_SELECT = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, I.NAME, GRADE FROM IMFOMATION I INNER JOIN MAJOR M ON I.MNUM = M.MNUM ORDER BY NO ASC";
	public static final String INFOMATION_INSERT = "INSERT INTO IMFOMATION VALUES(IMFO_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String INFOMATION_DELETE = "DELETE FROM IMFOMATION WHERE NO = ?";

	public ArrayList<ImfomationVO> infomationSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ImfomationVO> infoList = new ArrayList<ImfomationVO>();

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

				ImfomationVO infoVO = new ImfomationVO(no, num, mName, iName, grade);
				infoList.add(infoVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return infoList;
	}

	public boolean infomationInsert(ImfomationVO infoVo) {
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

	public boolean infomationDelete(ImfomationVO infoVo) {
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



}
