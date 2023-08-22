package com.dto;

import java.util.List;

public class PageDTO {

	//4가지 정보
	List<BoardDTO> list; //3개의 목록
	
	int perPage = 3; //페이지 당 보여줄 행 갯수
	
	int totalcount; // 전체 레코드 갯수
	int curPage; //현재 페이지 번호
	
	//검색용
	String searchName;
	String searchValue;
	
	
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<BoardDTO> getList() {
		return list;
	}

	public void setList(List<BoardDTO> list) {
		this.list = list;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

}
