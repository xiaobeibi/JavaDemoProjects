package com.bjpowernode.fangkuai.tool;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.bjpowernode.fangkuai.Controll;
import com.bjpowernode.fangkuai.model.Cell;

public class Timer extends Thread {
	private Controll controller;
	private long millis = 500;
	private boolean living;
	private boolean stop;

	public Timer(Controll controller) {
		this.controller = controller;
		living = true;
		stop = false;
	}

	@Override
	public void run() {
		OK:
		while (living) {
			if (stop == false) {
				try {
					if (!controller.upDownLeftRight(2)) {// 下
						for (Cell c : controller.getBoard().getModel()
								.getCells()) {
							if (c.getX() < 0) {
								gameOver();
								break OK;
							}
						}
						controller.clearRow();
						controller.getBoard().setModel(
								controller.getBoard().getNextModel());
						controller.setModel();
						controller.nextModel();
					}
					Thread.sleep(millis);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void gameOver() {
		if(living==false){
			return;
		}
		living = false;
		new Thread() {
			public void run() {
				ImageIcon icon=new ImageIcon(Timer.class.getResource("gameover.png"));
				
				int i = JOptionPane.showConfirmDialog(controller.getWin(),
						"你已经去了，还想来吗？", "GAMEOVER", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
				if (i == JOptionPane.YES_OPTION) {
					controller.startButton();
				}
				if (i == JOptionPane.NO_OPTION) {
					controller.getMuiscPlayer().setBgmMusic(false);
					controller.getMuiscPlayer().playVol(MuiscPlayer.gameover);
					
					try {
						Thread.sleep(2000);
						controller.getWin().dispose();
						Thread.sleep(7000);
						System.exit(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			};
		}.start();
	}

	public Controll getController() {
		return controller;
	}

	public void setController(Controll controller) {
		this.controller = controller;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}

}
