package com.bjpowernode.fangkuai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.bjpowernode.fangkuai.model.Board;
import com.bjpowernode.fangkuai.model.Cell;
import com.bjpowernode.fangkuai.model.MyModel;
import com.bjpowernode.fangkuai.tool.MuiscPlayer;
import com.bjpowernode.fangkuai.tool.Timer;
import com.bjpowernode.fangkuai.view.HelpWin;
import com.bjpowernode.fangkuai.view.Win;

public class Controll {
	private Timer time;
	private Win win;
	private Board board;
	private MuiscPlayer muiscPlayer;
	private Thread bgmthread;

	public Controll(Board board) {
		this.board = board;
		init();
	}

	public void init() {
		win = new Win(this);
		if (time != null) {
			time.setLiving(false);
		}
		time = new Timer(this);
		muiscPlayer = new MuiscPlayer();

	}

	public void startButton() {
		new Thread() {
			public void run() {
				muiscPlayer.setStartMusic(false);

			};
		}.start();
		if (bgmthread == null) {
			bgmthread = new Thread() {
				public void run() {
					try {
						// sleep(1000);
						// muiscPlayer.playVol(MuiscPlayer.gamestart);
						sleep(1000);
						muiscPlayer.playBgm();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				};
			};
			bgmthread.start();
		}

		board = new Board();
		initBoard();
		if (time != null) {
			time.setLiving(false);
		}
		time = new Timer(this);
		win.getScoreText().setText("0");
		win.getLevelText().setText("1");
		setSmallModel(board.getNextModel());
		time.start();

	}

	public void initBoard() {
		int x = this.getBoard().getHeigth();
		int y = this.getBoard().getWeidth();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				win.getLables()[i][j].setImageIcon(0);
			}
		}
	}

	public synchronized boolean upDownLeftRight(int i) {
		clearModel();
		switch (i) {
		case 1:
			muiscPlayer.playVol(MuiscPlayer.change);
			return up();

		case 2:
			muiscPlayer.playVol(MuiscPlayer.xx);
			return down();

		case 3:
			muiscPlayer.playVol(MuiscPlayer.left);
			return left();

		case 4:
			muiscPlayer.playVol(MuiscPlayer.left);
			return right();

		default:
			return false;
		}

	}

	public boolean up() {
		board.getModel().rotate(1);
		boolean b = isMoveAble();
		if (b) {
			setModel();
			return b;
		}

		if (!b) {

			board.getModel().move(0, -1);
			boolean lb = isMoveAble();
			if (lb) {

				setModel();
				return true;
			} else {
				board.getModel().move(0, 1);
			}

			board.getModel().move(0, 1);
			boolean rb = isMoveAble();
			if (rb) {

				setModel();
				return true;
			} else {
				board.getModel().move(0, -1);
			}

			board.getModel().move(0, -1);
			board.getModel().move(0, -1);
			boolean llb = isMoveAble();
			if (llb) {

				setModel();
				return true;
			} else {
				board.getModel().move(0, 1);
				board.getModel().move(0, 1);
			}
			board.getModel().rotate(-1);
			setModel();
		}

		return b;

	}

	public synchronized boolean down() {
		board.getModel().move(1, 0);
		boolean b = isMoveAble();
		if (!b) {
			board.getModel().move(-1, 0);
		}
		setModel();
		return b;
	}

	public boolean left() {
		board.getModel().move(0, -1);
		boolean b = isMoveAble();
		if (!b) {
			board.getModel().move(0, 1);
		}
		setModel();
		return b;
	}

	public boolean right() {
		board.getModel().move(0, 1);
		boolean b = isMoveAble();
		if (!b) {
			board.getModel().move(0, -1);
		}
		setModel();
		return b;
	}

	/** 清空board上当前模型上的值 */
	public void clearModel() {
		for (Cell p : board.getModel().getCells()) {
			if (p.getX() < 0) {
				continue;
			}
			board.getBoard()[p.getX()][p.getY()] = 0;
			win.getLables()[p.getX()][p.getY()].setImageIcon(0);
		}
	}

	/** 给模板赋值 绘制界面 */
	public void setModel() {
		for (Cell p : board.getModel().getCells()) {
			if (p.getX() < 0) {
				continue;
			}
			board.getBoard()[p.getX()][p.getY()] = board.getModel().getStatue();
			win.getLables()[p.getX()][p.getY()].setImageIcon(board.getBoard()[p
					.getX()][p.getY()]);
		}
	}

	/** 判断是否可以移动 */
	public synchronized boolean isMoveAble() {
		for (int i = 0; i < 4; i++) {
			int x = board.getModel().getCells()[i].getX();
			int y = board.getModel().getCells()[i].getY();
			if (x < 0) {
				continue;
			}
			if (y < 0 || x > board.getHeigth() - 1 || y > board.getWeidth() - 1
					|| board.getBoard()[x][y] != 0) {
				// muiscPlayer.playVol(MuiscPlayer.xx);
				return false;
			}
		}
		return true;
	}

	/**
	 * 产生下一个的模块
	 * */
	public void nextModel() {
		board.setNextModel(new MyModel());
		setSmallModel(board.getNextModel());
		int score = Integer.parseInt(win.getScoreText().getText().trim())
				+ new Random().nextInt(20);
		win.getScoreText().setText(score + "");
		isLvlup(score);

	}

	/** 设置小格子 */
	public void setSmallModel(MyModel nextModel) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				win.getSmallLabel()[i][j].setImageIcon(0);
			}
		}

		for (int m = 0; m < 4; m++) {
			int x = nextModel.getCells()[m].getX() + 2;
			int y = nextModel.getCells()[m].getY() - 9;
			win.getSmallLabel()[x][y].setImageIcon(nextModel.getStatue());
		}
	}

	/** 判断消行 */
	public synchronized void clearRow() {
		muiscPlayer.playVol(MuiscPlayer.button);
		ArrayList<Integer> celllist = new ArrayList<Integer>();
		ArrayList<Integer> clearlist = new ArrayList<Integer>();
		for (int i = 0; i < board.getModel().getCells().length; i++) {// x指的是行
			int id = board.getModel().getCells()[i].getX();
			if (!celllist.contains(id)) {
				celllist.add(id);
			}
		}
		for (int j = celllist.size() - 1; j >= 0; j--) {
			for (int k = 0; k < board.getWeidth(); k++) {
				if (board.getBoard()[celllist.get(j)][k] == 0) {
					break;
				}
				if (k == board.getWeidth() - 1) {// 如果一行全有值
					clearlist.add(celllist.get(j));
				}
			}
		}
		showClearRow(clearlist);// 消掉这些行
		if (clearlist.size() != 0) {
			int score = Integer.parseInt(win.getScoreText().getText().trim())
					+ (clearlist.size() * clearlist.size()) * 100;
			win.getScoreText().setText(score + "");
			isLvlup(score);
		}
	}

	/** 执行消行 */
	private void showClearRow(ArrayList<Integer> list) {
		if (list.size() != 0) {
			muiscPlayer.playVol(MuiscPlayer.clear);
		}
		Collections.sort(list);// 从上面的开始销，防止销掉下面的格子后改变原有的坐标而无法删掉。
		for (int d = 0; d < list.size(); d++) {
			for (int i = list.get(d); i > 0; i--) {
				for (int j = 0; j < board.getWeidth(); j++) {
					board.getBoard()[i][j] = board.getBoard()[i - 1][j];
					win.getLables()[i][j].setIcon(win.getLables()[i - 1][j]
							.getIcon());
				}
			}
			for (int j = 0; j < board.getWeidth(); j++) {
				board.getBoard()[0][j] = 0;
				win.getLables()[0][j].setImageIcon(0);
			}
		}

	}

	private void isLvlup(int score) {
		if (score < 2000) {
			time.setMillis(500);
			win.getLevelText().setText("1");
		}
		if (score >= 2000 && score < 4000) {
			time.setMillis(400);
			win.getLevelText().setText("2");
		}
		if (score >= 4000 && score < 6000) {
			time.setMillis(300);
			win.getLevelText().setText("3");
		}
		if (score >= 6000 && score < 8000) {
			time.setMillis(200);
			win.getLevelText().setText("4");
		}
		if (score >= 8000 && score < 10000) {
			time.setMillis(150);
			win.getLevelText().setText("5");
		}
		if (score >= 10000 && score < 12000) {
			time.setMillis(100);
			win.getLevelText().setText("6");
		}
		if (score >= 14000 && score < 16000) {
			time.setMillis(60);
			win.getLevelText().setText("7");
		}
		if (score >= 16000) {
			time.setMillis(30);
			win.getLevelText().setText("8");
		}
	}

	public void start() {
		new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				muiscPlayer.setStartMusic(true);
			};
		}.start();

		win.toShow();

	}

	public void help() {
		if(time!=null){
			time.setStop(true);
		}
		HelpWin helpWin = new HelpWin(this);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					Controll.class.getResourceAsStream("help.txt"), "GBK"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		StringBuilder text = new StringBuilder();
		String temp;
		try {
			while ((temp = reader.readLine()) != null) {
				text.append(temp);
				text.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		helpWin.getTextArea().setText(text.toString());
		helpWin.getTextArea().setCaretPosition(0);
		helpWin.toShow();
	}

	public Win getWin() {
		return win;
	}

	public void setWin(Win win) {
		this.win = win;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Timer getTime() {
		return time;
	}

	public void setTime(Timer time) {
		this.time = time;
	}

	public MuiscPlayer getMuiscPlayer() {
		return muiscPlayer;
	}

	public void setMuiscPlayer(MuiscPlayer muiscPlayer) {
		this.muiscPlayer = muiscPlayer;
	}

}
