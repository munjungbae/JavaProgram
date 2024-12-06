package MVCprojectController;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MVCprojectModel.DBU;
import MVCprojectModel.MajorVO;

public class MajorDAO {
	public static final String MAJOR_SELECT = "SELECT * FROM MAJOR ORDER BY MNUM ASC";
	public static final String MAJOR_INSERT = "INSERT INTO MAJOR VALUES (?, ?)";
	public static final String MAJOR_UPDATE = "UPDATE MAJOR SET NAME = ? WHERE MNUM = ? ";
	public static final String MAJOR_DELETE = "DELETE FROM MAJOR WHERE MNUM = ?";

	public ArrayList<MajorVO> MajorSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MajorVO> majorList = new ArrayList<MajorVO>();

		con = DBU.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(MAJOR_SELECT);

		while (rs.next()) {
			String num = rs.getString("MNUM");
			String name = rs.getString("NAME");

			MajorVO stu = new MajorVO(num, name);
			majorList.add(stu);
		}
		DBU.dbClose(con, stmt, rs);

		return majorList;
	}

	public boolean majorInsert(MajorVO mVo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		pstmt = con.prepareStatement(MAJOR_INSERT);
		pstmt.setString(1, mVo.getmNum());
		pstmt.setString(2, mVo.getName());

		int result = pstmt.executeUpdate();

		successFlag = (result != 0) ? true : false;
		return successFlag;
	}

	public static boolean majorUpdate(MajorVO mVo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		pstmt = con.prepareStatement(MAJOR_UPDATE);
		pstmt.setString(1, mVo.getName());
		pstmt.setString(2, mVo.getmNum());

		int result1 = pstmt.executeUpdate();

		successFlag = (result1 != 0) ? true : false;

		DBU.dbClose(con, pstmt);

		return successFlag;
	}

	public boolean majorDelete(MajorVO mVo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBU.dbCon();

		pstmt = con.prepareStatement(MAJOR_DELETE);
		pstmt.setString(1, mVo.getmNum());
		int result = pstmt.executeUpdate();

		successFlag = (result != 0) ? true : false;

		DBU.dbClose(con, pstmt);
		
		return successFlag;
	}

}
