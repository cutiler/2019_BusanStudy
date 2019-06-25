package com.cutiler.service;

import java.util.List;

import com.cutiler.vo.LottoVO;

public interface LottoService {
	
	// 최신 정보
	LottoVO readNewest() throws Exception;	
	
	// n회차 저장
	void write(LottoVO lottoVO) throws Exception;
	
	// n회차 정보
	LottoVO read(int drwNo) throws Exception;
		
	
	// 모든회차 정보
	List<LottoVO> readList() throws Exception;
	

}
