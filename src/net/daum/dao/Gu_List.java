package net.daum.dao;

import java.util.List;

import net.daum.vo.GuVo;

public class Gu_List {
	public static void main(String[] args) {
		GuDAOImpl gdao = new GuDAOImpl();
		List<GuVo> glist = gdao.getGuList();

		System.out.println(">>>>>>>>>>>>게시판 목록<<<<<<<<<<<<<");
		System.out.println("번호\t 제목 \t 글쓴이 \t 글내용 \t 등록날짜");
		System.out.println("====================================");
		if (glist != null && glist.size() > 0) {
			for (GuVo g : glist) {
				System.out.println(g.getGno() + "\t" + g.getGtitle() + "\t" + g.getGname() + "\t" + g.getGcont() + "\t"
						+ g.getGdate());
			}
		} else {
			System.out.println("게시물 목록이 없습니다.");
		}
	}
}
