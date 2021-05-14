package com.bjpowernode.fangkuai.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.bjpowernode.fangkuai.Controll;

public class HelpWin extends JFrame {

	private static final long serialVersionUID = 1L;

	private Controll controll;
	private JTextArea textArea;
	private Color color = new Color(200, 230, 250);

	public HelpWin(Controll controll) {
		this.controll = controll;
		init();
	}

	private void init() {
		setTitle("帮助");
		setSize(500, 600);
		setContentPane(createContentPane());
		setResizable(false);
		setFocusable(true);
		setAlwaysOnTop(true);
		setBackground(color);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setLocation((dimension.width - getWidth()) / 2,
				(dimension.height - getHeight()) / 2);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

	}

	private Container createContentPane() {
		JPanel main=new JPanel(new BorderLayout());
		main.add(BorderLayout.CENTER,createCenter());
		main.add(BorderLayout.SOUTH,createSouth());
		return main;
	}

	private Component createSouth() {
		JPanel main = new JPanel();
		main.setBorder(new EmptyBorder(0, 0, 15, 0));
		main.setBackground(color);
		JButton button1 = new JButton("确定");
		button1.setBackground(new Color(180, 240, 190));
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpWin.this.setVisible(false);
				try {
					if(controll.getTime()!=null&&controll.getTime().isStop()){
						Thread.sleep(1200);
						controll.getTime().setStop(false);
					}
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		main.add(button1);
		return main;
	}

	private JComponent createCenter() {
		JPanel main = new JPanel(new BorderLayout());
		main.setBounds(0, 150, 287, 390);
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setVisible(true);
		scrollPane.setBorder(new EmptyBorder(10,10,10,10));
		scrollPane.setBackground(new Color(140,180,255));
		textArea=new JTextArea(20,20);
		textArea.setBorder(new EmptyBorder(10,10,10,10));
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(160, 200, 255));
		textArea.setFont(new Font(Font.MONOSPACED, Font.TYPE1_FONT, 12));
		textArea.setForeground(new Color(120,30,100));
		textArea.setSize(new Dimension(300, 600));
		scrollPane.getViewport().add(textArea);
		main.add(BorderLayout.CENTER,scrollPane);
		return main;

	}

	public void toShow() {
		setVisible(true);

	}

	public Controll getControll() {
		return controll;
	}

	public void setControll(Controll controll) {
		this.controll = controll;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

}
