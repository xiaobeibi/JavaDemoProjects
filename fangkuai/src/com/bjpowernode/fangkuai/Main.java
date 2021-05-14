package com.bjpowernode.fangkuai;

import com.bjpowernode.fangkuai.model.Board;


public class Main {
	public static void main(String[] args) {		
		doIt();		
		
	}
	private static void doIt() {
		Board board = new Board();
		Controll controller = new Controll(board);
		controller.start();
		
	}
	
}
