package PublicDataTest.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import LandPriceVO.LandPriceVO;

public class LandPriceDAO {

	public static final String LANDPRICE_SELECT = "SELECT * FROM LANDPRICE";
	public static final String LANDPRICE_CHECK_SELECT = "SELECT COUNT(*) FROM LANDPRICE WHERE NODENO = ?";
    public static final String LANDPRICE_INSERT = "INSERT INTO LANDPRICE VALUES(?, ?, ?, ?, ?)";
    public static final String LANDPRICE_UPDATE = "UPDATE LANDPRICE SET GPSLATI = ?, GPSLONG = ?, NODEID = ?, NODENM = ? WHERE NODENO = ?";
    public static final String LANDPRICE_DELETE = "DELETE FROM LANDPRICE WHERE NODENO = ?";
	
	public ArrayList<LandPriceVO> landPriceSelect(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<LandPriceVO> LandList = new ArrayList<LandPriceVO>();

		con = DBUtility.dbCon();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(LANDPRICE_SELECT);
			
			if(rs.next()) {
				do{
					int no = rs.getInt("NODENO");
					Double gpslati  = rs.getDouble("GPSLATI");
					Double gpslong = rs.getDouble("GPSLONG");
					String nodeid = rs.getString("NODEID");
					String nodenm = rs.getString("NODENM");
					LandPriceVO lvo = new LandPriceVO(no, gpslati, gpslong, nodeid, nodenm);
					LandList.add(lvo);
				}while (rs.next());
			}else {
				LandList = null; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtility.dbClose(con, stmt, rs);
		}
		return LandList;
	}
	
	public boolean landPriceInsert(LandPriceVO lvo){
		//Conection
		boolean successFlag = false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		try {
			pstmt = con.prepareStatement(LANDPRICE_INSERT);
			pstmt.setInt(1, lvo.getNodeno());
			pstmt.setDouble(2, lvo.getGpslati());
			pstmt.setDouble(3, lvo.getGpslong());
			pstmt.setString(4, lvo.getNodeid());
			pstmt.setString(5, lvo.getNodenm());
			
			int result = pstmt.executeUpdate();
			successFlag = (result != 0 ) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag; 
	}

	public static boolean landPriceUpdate(LandPriceVO lvo){
		boolean successFlag = false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		try {
			pstmt = con.prepareStatement(LANDPRICE_UPDATE);
			pstmt.setDouble(1, lvo.getGpslati());
			pstmt.setDouble(2, lvo.getGpslong());
			pstmt.setString(3, lvo.getNodeid());
			pstmt.setString(4, lvo.getNodenm());
			pstmt.setInt(5, lvo.getNodeno());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0 ) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag; 
	}

	public static boolean landPriceDelete(LandPriceVO lvo){
		boolean successFlag =false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		try {
			pstmt = con.prepareStatement(LANDPRICE_DELETE);
			pstmt.setInt(1, lvo.getNodeno());
			int result = pstmt.executeUpdate();
			successFlag = (result != 0) ? true : false ;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag; 
	}

	public int landPriceCheckNodeNOSelect(LandPriceVO lvo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		con = DBUtility.dbCon();
		try {
			pstmt = con.prepareStatement(LANDPRICE_CHECK_SELECT);
			pstmt.setInt(1, lvo.getNodeno());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return count;
	}
}

