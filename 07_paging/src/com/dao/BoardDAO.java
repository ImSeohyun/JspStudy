package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.BoardDTO;
import com.dto.PageDTO;

public class BoardDAO {

	public PageDTO list(SqlSession session, int curPage) {
		
	// PageDTO에 3개의 데이터 저장
	/*
	 * List<BoardDTO> list;
	 * int perPage = 3; //페이지 당 보여줄 갯수
	 * int curPage; // 현재 페이지 번호, 맨 처음 보여질 경우 1
	 * int totalCount; //전체 레코드 갯수
	 */
	PageDTO pageDTO = new PageDTO();
	
	//시작위치 = (현재페이지 - 1)* 페이지 당 보여줄 갯수
	int offset = (curPage - 1)*pageDTO.getPerPage();
	
	//테이블에서 얻을 갯수
	int limit = pageDTO.getPerPage();
	
	List<BoardDTO> list = session.selectList("BoardMapper.list", null,
										new RowBounds(offset,limit));
	pageDTO.setList(list);
	//현재 페이지 번호 저장됨
	pageDTO.setCurPage(curPage);
	
	//전체 레코드갯수
	int totalCount = session.selectOne("BoardMapper.totalCount");
	pageDTO.setTotalCount(totalCount);
	
	return pageDTO;
	}
	
}
