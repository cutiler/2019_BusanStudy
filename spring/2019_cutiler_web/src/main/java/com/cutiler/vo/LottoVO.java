package com.cutiler.vo;

import java.util.Date;

import lombok.Data;

@Data
public class LottoVO {
	
	// 로또 회차.
	private int drwNo;		
	// 추첨일
	private Date drwNoDate;

	// 총 팔린 금액
	private long totSellamnt;
	// 1등 당첨자수
	private int firstPrzwnerCo;
	// 1게임 1등 담청금액
	private long firstWinamnt;
	// 총 1등 당첨금액
	private long firstAccumamnt;

	// 당첨번호
	private int drwtNo1;
	private int drwtNo2;
	private int drwtNo3;
	private int drwtNo4;
	private int drwtNo5;
	private int drwtNo6;
	//보너스 번호
	private int bnusNo;

}
