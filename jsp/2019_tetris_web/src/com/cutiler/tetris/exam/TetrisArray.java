package com.cutiler.tetris.exam;

public class TetrisArray {
	
	public static final int WALL = 8;
	
	private int maxRow = 26;
	private int maxColumn = 12;
	
	public int[][] board = new int[maxRow][maxColumn];	
	
	public void init() {
		for(int i=0; i < this.maxRow; i++) {
			for(int j=0; j < this.maxColumn; j++) {
				if(i == (this.maxRow-1)) {	this.board[i][j] = WALL;}
				else if(j == 0 || j == (this.maxColumn - 1)) {this.board[i][j] = WALL; }				
			}
		}
	}

	public int getMaxRow() {
		return maxRow;
	}

	public void setMaxRow(int maxRow) {
		this.maxRow = maxRow;
	}

	public int getMaxColumn() {
		return maxColumn;
	}

	public void setMaxColumn(int maxColumn) {
		this.maxColumn = maxColumn;
	}
	
	
	

}
