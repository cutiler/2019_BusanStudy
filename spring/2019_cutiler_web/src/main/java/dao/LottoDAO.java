package dao;

import java.util.List;

import com.cutiler.vo.LottoVO;

public interface LottoDAO {
	
	//  최신회차 정보 읽기
	LottoVO readNewest() throws Exception;

	// n회차 정보 저장
	void write(LottoVO lottoVO) throws Exception;
	
	// n회차 정보 읽기
	LottoVO read(int drwNo) throws Exception;
	
	//  모든회차 정보 가져오기
	List<LottoVO> readList() throws Exception;
	
	
	


}
