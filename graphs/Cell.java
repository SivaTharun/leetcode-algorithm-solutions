package com.graphs.practice;

public class Cell {

	int row;
    int col;
    int distance;

	Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	Cell(int row, int col,int distance) {
		this.row = row;
		this.col = col;
		this.distance=distance;
	}
}
