package rumicube;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RumiCube extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private static Image background = new ImageIcon(Main.class.getResource("../img/introBackGround.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../img/menuBar.png")));

	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../img/startButtonEntered.png"));
	private static ImageIcon startButtonBasicImage = new ImageIcon(
			Main.class.getResource("../img/startButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../img/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../img/exitButtonBasic.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private static JButton startButton = new JButton(startButtonBasicImage);

	private boolean isGameScreen;

	private int mouseX, mouseY;

	private static Game game;

	public RumiCube() {
		setUndecorated(true);
		setTitle("RumiCube");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}

			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				Game.setMoveRumi(mouseX, mouseY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 자동 생성된 메소드 스텁

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Game.moveRumi(x, y);

			}
		});

		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// buttonPressedMusic.start();
				try {
					Thread.sleep(600);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		startButton.setBounds(535, 350, 256, 256);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				// buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				// buttonPressedMusic.start();
				gameStart();
			}
		});
		add(startButton);

		menuBar.setBounds(0, 0, Main.SCREEN_WIDTH, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if (isGameScreen)
			game.screenDraw(g);
		paintComponents(g);
		this.repaint();
	}

	public void gameStart() {
		game = new Game();
		startButton.setVisible(false);
		isGameScreen = true;
		background = new ImageIcon(Main.class.getResource("../img/gameBackground.jpg")).getImage();
		game.start();
		setFocusable(true);
	}
}
