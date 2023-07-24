package net.daum.dao;

import java.util.Scanner;

import net.daum.vo.GuVo;

public class Gu_Insert {
	public static void main(String[] args) {
		GuVo g = new GuVo();
		GuDAOImpl gDAO = new GuDAOImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("tbl_gu 테이블에 레코드 저장하기 >> ");
		System.out.print("gname 입력 >> ");
		String gname = sc.nextLine();
		System.out.print("gtitle 입력 >> ");
		String gtitle = sc.nextLine();
		System.out.print("gcont 입력 >> ");
		String gcont = sc.nextLine();
		
		g.setGname(gname);
		g.setGtitle(gtitle);
		g.setGcont(gcont);
		
		gDAO.insertGu(g);
		
		sc.close();
	}
}
