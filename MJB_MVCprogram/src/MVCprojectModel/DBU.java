package MVCprojectModel;

import java.awt.Taskbar.State;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBU {

	public static Connection dbCon() {

		Connection con = null;

		// 1. db.properties file 에서 url, id, pw를 가져오기
		String filePath = "D:\\eclipse\\Java\\MVCProejct_mjb\\src\\db.properties";
		Properties pt = new Properties();
		try {
			pt.load(new FileReader(filePath));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		String id = pt.getProperty("id");
		String pw = pt.getProperty("pw");
		String url = pt.getProperty("url");

		// 2. jdbc driver load
		// 3. connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return con;
	}

	public static void dbClose(Connection con, PreparedStatement pstmt, ResultSet rs, Statement stmt) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}
	
	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}

	public static void dbClose(Connection con, Statement stmt) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}
	
	public static void dbClose(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}

	public static void dbClose(Connection con, Statement stmt, CallableStatement cstmt) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (cstmt != null) {
			try {
				cstmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}
}
