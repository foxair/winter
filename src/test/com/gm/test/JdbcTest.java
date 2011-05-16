package com.gm.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import junit.framework.TestCase;

public class JdbcTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();

	}

	public void test() {
		try {
			Class.forName("net.sf.log4jdbc.DriverSpy").newInstance();
			Connection con = java.sql.DriverManager
					.getConnection(
							"jdbc:log4jdbc:mysql://localhost:3306/base?user=root;password=;useUnicode=true&amp;characterEncoding=UTF-8",
							"root", "");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from user_info");
			while (rst.next()) {
				System.out.println(rst.getString("user_info_id"));
			}
			//关闭连接、释放资源
			rst.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
