package MVCprojectController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MVCprojectModel.ArchitectureVO;
import MVCprojectModel.DBU;

public class ArchitectureDAO {
	public static final String ARCHITECTURE_SELECT = "SELECT M.MNUM AS NUM, M.NAME AS MAJOR, NO, A.NAME, GRADE FROM ARCHITECTURE A INNER JOIN MAJOR M ON A.MNUM = M.MNUM";
	public static final String ARCHITECTURE_INSERT = "INSERT INTO ARCHITECTURE VALUES(ARCHI_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String ARCHITECTURE_DELETE = "DELETE FROM ARCHITECTURE WHERE NO = ?";

	public ArrayList<ArchitectureVO> architectureSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<ArchitectureVO> archiList = new ArrayList<ArchitectureVO>();

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

				ArchitectureVO archiVO = new ArchitectureVO(no, num, mName, iName, grade);
				archiList.add(archiVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBU.dbClose(con, stmt, rs);
		}
		return archiList;
	}

	public boolean architectureInsert(ArchitectureVO archiVo) {
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

	public boolean architectureDelete(ArchitectureVO archiVo) {
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

}
