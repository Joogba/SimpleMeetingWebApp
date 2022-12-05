package meet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MeetDAO {
	private Connection conn;
	private ResultSet rs;

	public MeetDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/WEBPAGE";
			String dbID = "root";
			String dbPassword = "admin";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getNext() {
		String SQL = "SELECT meetid FROM meet ORDER BY meetid DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}

	public Meet getMeetbbsID(int bbsID) {
		String SQL = "select * from meet where bbsID = ?";
		try {
			System.out.println("log");
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();

			System.out.println(rs.getString(4));
			if (rs.next()) {
				Meet meet = new Meet();
				meet.setMeetid(rs.getInt(1));
				meet.setBbsid(rs.getInt(2));
				meet.setMeetDate(rs.getString(3));
				meet.setMeetTitle(rs.getString(4));
				meet.setMeetPlace(rs.getString(5));
				meet.setCount(rs.getInt(6));
				meet.setMaxcount(rs.getInt(7));
				System.out.println(rs);
				return meet;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; // 데이터베이스 오류
	}

	public int write(int bbsid, String date, String title, String place, int maxcount) {
		String SQL = "INSERT INTO meet VALUES(? ,?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setInt(2, bbsid);
			pstmt.setString(3, date);
			pstmt.setString(4, title);
			pstmt.setString(5, place);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, maxcount);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
}
