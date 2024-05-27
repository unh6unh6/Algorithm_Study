package pknu.it;

import java.sql.*;

public class JDBCExample {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db.pknu.ac.kr:1521:xe", "USER",
					"PASSWD");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from student");

			while (rs.next()) {
				int no = rs.getInt("sno"); // getInt(1)
				String name = rs.getString("sname"); // getString(2)
				int year = rs.getInt("year"); // getInt(3)
				String dept = rs.getString(4); // getString("dept")
				System.out.format("학번: %d 이름: %s 학년:%d 학과:%s \n", no, name, year, dept);
			}

			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException se) {
			System.err.println("SQL 수행중 에러가 발생했습니다." + se.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.err.println("드라이버 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} finally {

		}

	}

}
