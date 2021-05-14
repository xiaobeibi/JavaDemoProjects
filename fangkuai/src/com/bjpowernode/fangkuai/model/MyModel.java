package com.bjpowernode.fangkuai.model;

import java.util.Random;


public class MyModel {
	
	private int statue;
	private int type;

	private Cell[] cells = new Cell[4];
	
	public MyModel() {
		this(new Random().nextInt(7)+1,new Random().nextInt(4));
	}
	public MyModel(int statue,int type) {
		this.statue = statue;
		this.type = type;
		this.createModel(new Cell(-1,10));
	}
	/**旋转模板*/
	public void  rotate() {
		type = (type+1)%4;
		this.createModel(cells[0]);
	}
	public void rotate(int i) {
		type = (type+i)%4;
		this.createModel(cells[0]);
	}
	/**移动模块*/
	public void move(int x,int y) {
		for(int i=0;i<cells.length;i++){
			cells[i]=new Cell(cells[i].getX()+x,cells[i].getY()+y);
		}
	}
	/**产生模块*/
	public Cell[] createModel(Cell point) {
		int x = point.getX();
		int y = point.getY();
		cells = new Cell[4];
		
		//  l:
		if(this.statue == 1) {
			switch (this.type){
			case 0:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x-1,y);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x+2,y);
				break;
			case 1:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y-1);
				cells[2] = new Cell(x,y+1);
				cells[3] = new Cell(x,y+2);
				break;
			case 2:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x-1,y);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x+2,y);
				break;
			case 3:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y-1);
				cells[2] = new Cell(x,y+2);
				cells[3] = new Cell(x,y+1);
				break;
			}

		}
		
		// 倒7:
		
		else if(this.statue == 2) {
			switch (this.type){
			case 0:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x-1,y);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x-1,y+1);
				break;
			case 1:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y-1);
				cells[2] = new Cell(x,y+1);
				cells[3] = new Cell(x-1,y-1);
				break;
			case 2:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x+1,y);
				cells[2] = new Cell(x-1,y);
				cells[3] = new Cell(x+1,y-1);
				break;
			case 3:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y-1);
				cells[2] = new Cell(x,y+1);
				cells[3] = new Cell(x+1,y+1);
				break;
			}
		}
		
		// 7：
		
		else if(this.statue == 3) {
			switch (this.type){
			case 0:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x-1,y);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x-1,y-1);
				break;
			case 1:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y-1);
				cells[2] = new Cell(x,y+1);
				cells[3] = new Cell(x+1,y-1);
				break;
			case 2:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x+1,y+1);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x-1,y);
				break;
			case 3:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x,y-1);
				cells[3] = new Cell(x-1,y+1);
				break;
			}
		}
		else if(this.statue == 4) {
			switch (this.type){
			case 0:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x-1,y);
				cells[3] = new Cell(x+1,y+1);
				break;
			case 1:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x-1,y+2);
				cells[3] = new Cell(x-1,y+1);
				break;
			case 2:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x-1,y);
				cells[3] = new Cell(x+1,y+1);
				break;
			case 3:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x-1,y+2);
				cells[3] = new Cell(x-1,y+1);
				break;
			}
		}
		else if(this.statue == 5) {
			switch (this.type){
			case 0:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x-1,y+1);
				break;
			case 1:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x+1,y+2);
				cells[3] = new Cell(x+1,y+1);
				break;
			case 2:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x-1,y+1);
				break;
			case 3:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x+1,y+2);
				cells[3] = new Cell(x+1,y+1);
				break;
			}
		}
		else if(this.statue == 6) {
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y+1);
				cells[2] = new Cell(x+1,y);
				cells[3] = new Cell(x+1,y+1);
		}
		else if(this.statue == 7) {
			switch (this.type){
			case 0:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x-1,y);
				cells[2] = new Cell(x-1,y-1);
				cells[3] = new Cell(x-1,y+1);
				break;
			case 1:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x,y-1);
				cells[2] = new Cell(x-1,y-1);
				cells[3] = new Cell(x+1,y-1);
				break;
			case 2:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x+1,y);
				cells[2] = new Cell(x+1,y-1);
				cells[3] = new Cell(x+1,y+1);
				break;
			case 3:
				cells[0] = new Cell(x,y);
				cells[1] = new Cell(x+1,y+1);
				cells[2] = new Cell(x,y+1);
				cells[3] = new Cell(x-1,y+1);
				break;
			}
		}
		return cells;
	}

	
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Cell[] getCells() {
		return cells;
	}
	public void setCells(Cell[] cells) {
		this.cells = cells;
	}


	
}
