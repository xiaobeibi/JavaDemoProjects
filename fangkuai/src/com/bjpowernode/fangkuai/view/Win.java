package com.bjpowernode.fangkuai.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.bjpowernode.fangkuai.Controll;
import com.bjpowernode.fangkuai.tool.MuiscPlayer;

public class Win extends JFrame {

	private static final long serialVersionUID = 1L;
	private MyLabel[][] lables;
	private MyLabel[][] smallLabel;
	private JLabel text;
	private JLabel scoreText;
	private JLabel levelText;
	private Controll controller;
	private JLayeredPane topPanel;
	private JButton stop;
	private JButton help;
	private JPanel main;
	private Color color = new Color(10, 0, 20);
	private Color toolcolor = new Color(60, 90, 190);
	private Color linecolor = new Color(60, 20, 130);
	private JLabel toptxtLabel;

	public Win(Controll controller) {
		this.setController(controller);
		init();

	}

	public void init() {
		setTitle("俄罗斯方块");
		setSize(650, 650);
		setContentPane(createContentPanel());
		setFocusable(true);
		setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setLocation((dimension.width - getWidth()) / 2,
				(dimension.height - getHeight()) / 2);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				new Thread() {
					public void run() {
						if (controller.getTime() != null) {
							controller.getTime().setStop(true);
						}
						controller.getTime().setStop(true);
						ImageIcon icon = new ImageIcon(
								Win.class.getResource("exit.png"));

						int i = JOptionPane.showConfirmDialog(
								controller.getWin(), "真的要离开吗？", "EXIT",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, icon);
						if (i == JOptionPane.NO_OPTION) {
							if (controller != null) {
								controller.getTime().setStop(false);
							}
							transferFocusUpCycle();
						}
						if (i == JOptionPane.YES_OPTION) {
							controller.getMuiscPlayer().setBgmMusic(false);
							controller.getMuiscPlayer().playVol(
									MuiscPlayer.gameover);

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
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!controller.getTime().isStop()) {
					if(topPanel.isVisible()){
						topPanel.setVisible(false);
						main.setBorder(new LineBorder(linecolor, 8));
						controller.startButton();					
					}
					switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
					case KeyEvent.VK_W:
						controller.upDownLeftRight(1);
						break;
					case KeyEvent.VK_DOWN:
					case KeyEvent.VK_S:
						controller.upDownLeftRight(2);
						break;
					case KeyEvent.VK_LEFT:
					case KeyEvent.VK_A:
						controller.upDownLeftRight(3);
						break;
					case KeyEvent.VK_RIGHT:
					case KeyEvent.VK_D:
						controller.upDownLeftRight(4);
						break;
					default:
						break;
					}
					super.keyPressed(e);
					try {
						Thread.sleep(20);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}

	public Container createContentPanel() {
		main = new JPanel(new BorderLayout());
		JLayeredPane jLayeredPane = new JLayeredPane();
		jLayeredPane.add(creatBackground(), JLayeredPane.BOTTOM_ALIGNMENT);
		jLayeredPane.add(createBoardPanel(), JLayeredPane.POPUP_LAYER);
		jLayeredPane.add(createToolsPanel(), JLayeredPane.POPUP_LAYER);
		jLayeredPane.add(createLine(), JLayeredPane.POPUP_LAYER);
		jLayeredPane.add(createTop(), JLayeredPane.DRAG_LAYER);
		new Thread() {
			public void run() {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				topPanel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent e) {
						topPanel.setVisible(false);
						main.setBorder(new LineBorder(linecolor, 8));
						controller.startButton();
					};
				});

			};
		}.start();
		main.add(jLayeredPane);
		return main;
	}

	private JLayeredPane createTop() {
		topPanel = new JLayeredPane();
		ImageIcon icon = new ImageIcon(Win.class.getResource("beijing4.png"));
		icon.setImage(icon.getImage().getScaledInstance(getWidth(),
				getHeight(), Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		label.setBounds(0, 0, getWidth(), getHeight());
		topPanel.add(label);
		toptxtLabel = new JLabel();
		toptxtLabel.setBounds(120, 450, 150, 150);
		toptxtLabel.setFont(new Font(Font.MONOSPACED, Font.TYPE1_FONT, 23));
		toptxtLabel.setForeground(new Color(200, 0, 100));
		new Thread() {
			public void run() {
				while (topPanel.isVisible()) {
					toptxtLabel.setText("按任意键进入游戏");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					toptxtLabel.setText("");
					try {
						sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			};
		}.start();

		topPanel.add(toptxtLabel, JLayeredPane.DRAG_LAYER);
		topPanel.setBounds(0, 0, getWidth(), getHeight());
		return topPanel;
	}

	private JPanel creatBackground() {
		JPanel main = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(Win.class.getResource("beijing5.png"));
		icon.setImage(icon.getImage().getScaledInstance(getWidth(),
				getHeight(), Image.SCALE_DEFAULT));
		JLabel label = new JLabel(icon);
		main.add(label);
		main.setBounds(0, 0, getWidth(), getHeight());
		return main;
	}

	private JPanel createBoardPanel() {// 中心部分
		JPanel main = new JPanel(new BorderLayout());
		main.setOpaque(false);
		main.setBounds(0, 0, 460, 600);
		int x = controller.getBoard().getHeigth();
		int y = controller.getBoard().getWeidth();
		JPanel bigGride = new JPanel(new GridLayout(x, y));
		bigGride.setOpaque(false);
		bigGride.setBorder(new EmptyBorder(20, 20, 20, 20));

		lables = new MyLabel[controller.getBoard().getHeigth()][controller
				.getBoard().getWeidth()];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				MyLabel label = new MyLabel(i, j);
				label.setImageIcon(0);
				label.setBorder(new LineBorder(color));
				lables[i][j] = label;
				bigGride.add(lables[i][j]);
			}
		}
		main.add(bigGride);
		return main;
	}

	private JPanel createToolsPanel() {// 右边框栏
		JPanel tools = new JPanel(new BorderLayout());
		tools.setOpaque(false);
		tools.setBounds(470, 0, 150, 600);
		tools.setBackground(toolcolor);
		tools.setBorder(new EmptyBorder(20, 10, 10, 10));
		tools.add(BorderLayout.CENTER, createCenterToolPanel());
		tools.add(BorderLayout.SOUTH, createSouthToolPanel());

		return tools;
	}

	public JPanel createCenterToolPanel() {
		JPanel main = new JPanel();
		main.setOpaque(false);
		main.setBackground(toolcolor);
		JPanel smallGrid = new JPanel(new GridLayout(4, 4));
		smallGrid.setOpaque(false);
		smallLabel = new MyLabel[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				MyLabel label = new MyLabel(i, j);
				label.setPreferredSize(new Dimension(20, 20));
				label.setImageIcon(0);
				label.setBorder(new LineBorder(new Color(80, 0, 160)));
				smallLabel[i][j] = label;
				smallGrid.add(smallLabel[i][j]);
			}
		}
		main.add(smallGrid);
		return main;
	}

	public JPanel createSouthToolPanel() {
		Color color = new Color(220, 0, 30);
		Color color2 = new Color(220, 0, 90);
		JPanel main = new JPanel(new GridLayout(9, 1, 15, 20));
		main.setOpaque(false);
		text = new JLabel("Next");
		text.setForeground(color);
		main.add(text);
		text = new JLabel("Score： ");
		text.setForeground(color);
		main.add(text);
		scoreText = new JLabel("0");
		scoreText.setForeground(color2);
		scoreText.setHorizontalAlignment(JLabel.CENTER);
		main.add(scoreText);
		text = new JLabel("Level： ");
		text.setForeground(color);
		main.add(text);
		levelText = new JLabel("1");
		levelText.setForeground(color2);
		levelText.setHorizontalAlignment(JLabel.CENTER);
		main.add(levelText);

		JButton start = new JButton("开始");
		start.setPreferredSize(new Dimension(60, 25));
		start.setBackground(toolcolor);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.startButton();
				transferFocusUpCycle();
			}
		});
		start.setForeground(Color.black);
		main.add(start);
		stop = new JButton("暂停");
		stop.setBackground(toolcolor);
		stop.setPreferredSize(new Dimension(60, 25));
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transferFocusUpCycle();
				if (stop.getText().trim().equals("暂停")) {
					controller.getTime().setStop(true);
					new Thread() {
						@Override
						public void run() {
							controller.getMuiscPlayer().setBgmMusic(false);
						}
					}.start();

					stop.setText("继续");
					stop.setForeground(Color.red);
					return;
				}
				if (stop.getText().trim().equals("继续")) {
					new Thread() {
						@Override
						public void run() {
							try {
								sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							controller.getMuiscPlayer().setBgmMusic(true);
						}
					}.start();
					controller.getMuiscPlayer().start();
					controller.getTime().setStop(false);
					stop.setText("暂停");
					stop.setForeground(Color.black);
					return;
				}
			}
		});
		stop.setForeground(Color.black);
		main.add(stop);
		
		help = new JButton("帮助");
		help.setBackground(toolcolor);
		help.setForeground(Color.black);
		help.setPreferredSize(new Dimension(60, 25));
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.help();				
			}
		});
		main.add(help);
		
		JButton exit = new JButton("退出");
		exit.setPreferredSize(new Dimension(60, 25));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Thread() {
					public void run() {
						controller.getTime().setStop(true);
						ImageIcon icon = new ImageIcon(Win.class
								.getResource("exit.png"));

						int i = JOptionPane.showConfirmDialog(
								controller.getWin(), "真的要离开吗？", "EXIT",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, icon);
						if (i == JOptionPane.NO_OPTION) {
							controller.getTime().setStop(false);
							transferFocusUpCycle();
						}
						if (i == JOptionPane.YES_OPTION) {
							controller.getMuiscPlayer().setBgmMusic(false);
							controller.getMuiscPlayer().playVol(
									MuiscPlayer.gameover);

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
		});
		exit.setForeground(Color.black);
		exit.setBackground(toolcolor);
		main.add(exit);

		return main;
	}

	private JPanel createLine() {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(460, 0, 10, 650);
		jPanel.setBackground(linecolor);
		return jPanel;
	}

	public void setController(Controll controller) {
		this.controller = controller;
	}

	public void toShow() {
		setVisible(true);
	}

	public MyLabel[][] getLables() {
		return lables;
	}

	public void setLables(MyLabel[][] lables) {
		this.lables = lables;
	}

	public MyLabel[][] getSmallLabel() {
		return smallLabel;
	}

	public void setSmallLabel(MyLabel[][] smallLabel) {
		this.smallLabel = smallLabel;
	}

	public JLabel getText() {
		return text;
	}

	public void setText(JLabel text) {
		this.text = text;
	}

	public JLabel getScoreText() {
		return scoreText;
	}

	public void setScoreText(JLabel scoreText) {
		this.scoreText = scoreText;
	}

	public JLabel getLevelText() {
		return levelText;
	}

	public void setLevelText(JLabel levelText) {
		this.levelText = levelText;
	}

	public Controll getController() {
		return controller;
	}

}
