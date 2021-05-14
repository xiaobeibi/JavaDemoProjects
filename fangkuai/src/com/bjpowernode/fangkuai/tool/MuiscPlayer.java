package com.bjpowernode.fangkuai.tool;

import java.applet.Applet;
import java.applet.AudioClip;

public class MuiscPlayer extends Applet {

	private static final long serialVersionUID = 1L;

	public static final int dead = 1;
	public static final int stop = 2;
	public static final int down = 3;
	public static final int change = 4;
	public static final int clear = 5;
	public static final int gamestart = 6;
	public static final int gameover = 7;
	public static final int xx = 8;
	public static final int left = 9;
	public static final int button = 10;
	public static final String[] list = { "1.mid", "2.mid", "3.mid", "4.mid",
			"5.mid", "6.mid", };
	public static boolean cando = true;
	private static String url;
	private static boolean playstart = true;
	private static AudioClip startMusic;
	private static AudioClip bgmMusic;

	public void cleckRoom() {
		cando = false;
		new Thread() {
			public void run() {
				try {
					sleep(100);
					cando = true;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

	}

	public synchronized void playVol(int i) {

		if (cando == false) {
			return;
		}
		// cleckRoom();
		url = null;
		switch (i) {
		case stop:
			url = "stop.wav";
			break;
		case down:
			url = "down.wav";
			break;
		case change:
			url = "change.wav";
			break;
		case clear:
			url = "clear.wav";
			break;
		case dead:
			url = "dead.wav";
			break;
		case gameover:
			url = "gameover.wav";
			break;
		case gamestart:
			url = "gamestart.wav";
			break;
		case xx:
			url = "xx.wav";
			break;
		case left:
			url = "left.wav";
			break;
		case button:
			url = "button.wav";
			break;
		default:
			url = "err.mid";
			break;
		}
		new Thread() {
			public void run() {
				try {

					AudioClip p = Applet.newAudioClip(MuiscPlayer.class
							.getResource(url));
					p.play();
				} catch (Exception e) {
					e.printStackTrace();
				}

			};
		}.start();

	}

	public void setStartMusic(boolean b) {
		playstart = b;
		new Thread() {
			public void run() {
				if (startMusic == null) {
					startMusic = Applet.newAudioClip(MuiscPlayer.class
							.getResource("bg.mid"));
				}	
				try {
					if (playstart) {
						System.out.println(startMusic.hashCode()+"START************");
						startMusic.play();
						
					} else {
						System.out.println(startMusic.hashCode()+"STOP************");
						startMusic.stop();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			};

		}.start();

	}

	public void playBgm() {
		new Thread() {
			public void run() {
				playBgm(0);
			};
		}.start();

	}

	private void playBgm(int i) {
		System.out.println(i);
		try {
			bgmMusic = Applet.newAudioClip(MuiscPlayer.class
					.getResource(list[i]));
			bgmMusic.loop();
			Thread.sleep(120 * 1000);
			bgmMusic.stop();
			playBgm((++i) % list.length);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setBgmMusic(boolean b) {
		if(bgmMusic==null){
			return;
		}
		if(b){
			bgmMusic.loop();
		}else{
			bgmMusic.stop();
		}
		
	}

	public static void main(String[] args) {
		new MuiscPlayer().playBgm();
		new MuiscPlayer().playVol(2);
		new MuiscPlayer().playVol(3);
		new MuiscPlayer().playVol(4);
	}

}
