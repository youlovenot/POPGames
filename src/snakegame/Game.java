package snakegame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image boardImage = new ImageIcon(Main.class.getResource("../img/board.png")).getImage();
	private Image bodyImage = new ImageIcon(Main.class.getResource("../img/body.png")).getImage();
	private Image headImage = new ImageIcon(Main.class.getResource("../img/head.png")).getImage();
	private Image bonusImage = new ImageIcon(Main.class.getResource("../img/bonus.png")).getImage();
	private Image boomImage = new ImageIcon(Main.class.getResource("../img/boom.png")).getImage();

	static boolean dropRight = true;
	static boolean dropLeft = true;
	static boolean dropUp = true;
	static boolean dropDown = true;

	static int[][] map = new int[24][18]; // blank : 0, head : 1, body : 2, bonus : 3, boom : 4
	static int[][] dir = new int[24][18]; // none : 0, left : 1, up : 2, down : 3, right : 4

	LinkedList<Snake> snake = new LinkedList<Snake>();

	public Game() {
		snake.add(new Snake(10, 11, 4, true));
		snake.add(new Snake(9, 11, 4, false));
		snake.add(new Snake(8, 11, 4, false));
		dir[11][10] = 4;
	}

	public void close() {
		this.interrupt();
	}

	public void pressRight() {
		if (dropRight) {
			new Music("changeDir.mp3", false).start();
			dropRight = false;
		}
		dir[snake.get(0).getY()][snake.get(0).getX()] = 4;
	}

	public void releseRight() {
		dropRight = true;
	}

	public void pressLeft() {
		if (dropLeft) {
			new Music("changeDir.mp3", false).start();
			dropLeft = false;
		}
		dir[snake.get(0).getY()][snake.get(0).getX()] = 1;
	}

	public void releseLeft() {
		dropLeft = true;
	}

	public void pressUp() {
		if (dropUp) {
			new Music("changeDir.mp3", false).start();
			dropUp = false;
		}
		dir[snake.get(0).getY()][snake.get(0).getX()] = 2;
	}

	public void releseUp() {
		dropUp = true;
	}

	public void pressDown() {
		if (dropDown) {
			new Music("changeDir.mp3", false).start();
			dropDown = false;
		}
		dir[snake.get(0).getY()][snake.get(0).getX()] = 3;
	}

	public void releseDown() {
		dropDown = true;
	}

	public void screenDraw(Graphics g) {
		g.drawImage(boardImage, 0, 750, null);
		g.setFont(new Font("맑은고딕", Font.BOLD, 30));
		g.drawString("길이", 230, 800);
		g.drawString("3", 250, 850);
		for(Snake s : snake)
		{
			if(s.isHead())map[s.getY()][s.getX()]=1;
			else map[s.getY()][s.getX()]=2;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1)
					g.drawImage(headImage, j * 30, (i + 1) * 30, null);
				else if (map[i][j] == 2)
					g.drawImage(bodyImage, j * 30, (i + 1) * 30, null);
				else if (map[i][j] == 3)
					g.drawImage(bonusImage, j * 30, (i + 1) * 30, null);
				else if (map[i][j] == 4)
					g.drawImage(boomImage, j * 30, (i + 1) * 30, null);
			}
		}
	}
}