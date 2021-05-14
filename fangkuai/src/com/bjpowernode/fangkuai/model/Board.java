package com.bjpowernode.fangkuai.model;


public class Board {
	
	private int weidth;
	private int heigth;
	private MyModel model;
	private MyModel nextModel;
	private int[][] board;
	
	public Board() {
		this(25,20,new MyModel(),new MyModel());
	}
	public Board(int heigth,int weidth,MyModel model,MyModel nextModel) {
		this.weidth = weidth;
		this.heigth = heigth;
		this.model = model;
		this.nextModel = nextModel;
		board = new int[this.heigth][this.weidth];
	}
	
	
	public int getWeidth() {
		return weidth;
	}
	public void setWeidth(int weidth) {
		this.weidth = weidth;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	public MyModel getModel() {
		return model;
	}
	public void setModel(MyModel model) {
		this.model = model;
	}
	public MyModel getNextModel() {
		return nextModel;
	}
	public void setNextModel(MyModel nextModel) {
		this.nextModel = nextModel;
	}
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	
}
