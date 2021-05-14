package com.bjpowernode.fangkuai.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private int xx;
	private int yy;
	public int icon;
	private static int size=23;
	private static ImageIcon zero = new ImageIcon(MyLabel.class.getResource("0.png"));
	private static ImageIcon one = new ImageIcon(MyLabel.class.getResource("1.png"));
	private static ImageIcon two = new ImageIcon(MyLabel.class.getResource("2.png"));
	private static ImageIcon three = new ImageIcon(MyLabel.class.getResource("3.png"));
	private static ImageIcon four = new ImageIcon(MyLabel.class.getResource("4.png"));
	private static ImageIcon five = new ImageIcon(MyLabel.class.getResource("5.png"));
	private static ImageIcon six = new ImageIcon(MyLabel.class.getResource("6.png"));
	private static ImageIcon seven = new ImageIcon(MyLabel.class.getResource("7.png")); 

	public MyLabel(int x, int y) {
		this.xx = x;
		this.yy = y;
		icon = 0;
		setHorizontalAlignment(JLabel.CENTER);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(MyLabel.this.xx + "," + MyLabel.this.yy);
			}
		});
	}
	
	static{
		zero.setImage(zero.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		one.setImage(one.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		two.setImage(two.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		three.setImage(three.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		four.setImage(four.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		five.setImage(five.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		six.setImage(six.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		seven.setImage(seven.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
	}

	public void setImageIcon(int i) {
		icon=i;
		switch (i) {
		case 1:
			setIcon(one);
			break;
		case 2:
			setIcon(two);
			break;
		case 3:
			setIcon(three);
			break;
		case 4:
			setIcon(four);
			break;
		case 5:
			setIcon(five);
			break;
		case 6:
			setIcon(six);
			break;
		case 7:
			setIcon(seven);
			break;
		/*case 0:
			setIcon(zero);
			break;*/
		default:
			setIcon(null);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xx;
		result = prime * result + yy;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyLabel other = (MyLabel) obj;
		if (xx != other.xx)
			return false;
		if (yy != other.yy)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyLabel [x=" + xx + ", y=" + yy + ", icon=" + "]";
	}

}
