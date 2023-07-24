package net.daum.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.daum.vo.GuVo;

public class GuDAOImpl {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "night";
	String password = "123456";

	Connection con = null;
	PreparedStatement pt = null;
	ResultSet rs = null;
	String sql = null;

	public int insertGu(GuVo g) {
		int re = -1;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "insert into tbl_gu values(gno_seq10.nextval,?,?,?,sysdate)";
			
			pt = con.prepareStatement(sql);
			pt.setString(1, g.getGname());
			pt.setString(2, g.getGtitle());
			pt.setString(3, g.getGcont());

			re = pt.executeUpdate();

			if (re == 1) {
				System.out.println("Gu 저장 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	public List<GuVo> getGuList() {
		List<GuVo> glist = new ArrayList<>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			sql = "select * from tbl_gu order by gno desc";
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();

			while (rs.next()) {
				GuVo g = new GuVo();
				g.setGno(rs.getInt("gno"));
				g.setGname(rs.getString("gname"));
				g.setGtitle(rs.getString("gtitle"));
				g.setGcont(rs.getString("gcont"));
				g.setGdate(rs.getString("gdate"));

				glist.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pt != null)
					pt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return glist;
	}
}
