package snakegame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

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

	int[][] map = new int[24][18]; // blank : 0, head : 1, body : 2, bonus : 3, boom : 4
	int[][] dir = new int[24][18]; // none : 0, left : 1, up : 2, down : 3, right : 4

	int boomCount = 0;

	ArrayList<Snake> snake = new ArrayList<Snake>();

	public Game() {
		snake.add(new Snake(10, 11, 4, true));
		snake.add(new Snake(9, 11, 4, false));
		snake.add(new Snake(8, 11, 4, false));
	}

	public void run() {
		createBonus();
	}

	public void close() {
		this.interrupt();
	}

	public void createBonus() {
		int x, y;
		for (;;) {
			x = (int) (Math.random() * 100) % 18;
			y = (int) (Math.random() * 100) % 24;
			if (map[y][x] == 0)
				break;
		}
		map[y][x] = 3;
	}

	public void createBoom() {
		int x, y;
		for (;;) {
			x = (int) (Math.random() * 100) % 18;
			y = (int) (Math.random() * 100) % 24;
			if (map[y][x] == 0)
				break;
		}
		boomCount++;
		map[y][x] = 4;
	}

	public void snakeMove() {
		try {
			if (snake.size() * 10 < 250) {
				Thread.sleep(260 - (snake.size() * 10));
			} else {
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boomCount <= (snake.size() - 15) / 3)
			createBoom();
		for (int i = 0; i < snake.size(); i++) {
			if (dir[snake.get(i).getY()][snake.get(i).getX()] != snake.get(i).getDir()
					&& dir[snake.get(i).getY()][snake.get(i).getX()] != 0) {
				snake.get(i).setDir(dir[snake.get(i).getY()][snake.get(i).getX()]);
				if (i == snake.size() - 1)
					dir[snake.get(i).getY()][snake.get(i).getX()] = 0;
			}
			if (snake.get(i).getDir() == 4) {
				if (snake.get(i).getX() + 1 <= 17) {
					if (i == 0 && map[snake.get(i).getY()][snake.get(i).getX() + 1] != 0
							&& map[snake.get(i).getY()][snake.get(i).getX() + 1] != 3) {
						// 게임오버 사운드
						gameOver();
					}
					if (i == 0 && map[snake.get(i).getY()][snake.get(i).getX() + 1] == 3) {
						Snake s = new Snake(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY(),
								snake.get(snake.size() - 1).getDir(), snake.get(snake.size() - 1).isHead());
						if (s.getDir() == 4)
							s.setX(s.getX() - 1);
						else if (s.getDir() == 1)
							s.setX(s.getX() + 1);
						else if (s.getDir() == 2)
							s.setY(s.getY() + 1);
						else if (s.getDir() == 3)
							s.setY(s.getY() - 1);
						snake.add(s);
						createBonus();
					}
					snake.get(i).setX(snake.get(i).getX() + 1);
				} else
					gameOver();
			} else if (snake.get(i).getDir() == 1) {
				if (snake.get(i).getX() - 1 >= 0) {
					if (i == 0 && map[snake.get(i).getY()][snake.get(i).getX() - 1] != 0
							&& map[snake.get(i).getY()][snake.get(i).getX() - 1] != 3) {
						// 게임오버 사운드
						gameOver();
					}
					if (i == 0 && map[snake.get(i).getY()][snake.get(i).getX() - 1] == 3) {
						Snake s = new Snake(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY(),
								snake.get(snake.size() - 1).getDir(), snake.get(snake.size() - 1).isHead());
						if (s.getDir() == 4)
							s.setX(s.getX() - 1);
						else if (s.getDir() == 1)
							s.setX(s.getX() + 1);
						else if (s.getDir() == 2)
							s.setY(s.getY() + 1);
						else if (s.getDir() == 3)
							s.setY(s.getY() - 1);
						snake.add(s);
						createBonus();
					}
					snake.get(i).setX(snake.get(i).getX() - 1);
				} else
					gameOver();
			} else if (snake.get(i).getDir() == 2) {
				if (snake.get(i).getY() - 1 >= 0) {
					if (i == 0 && map[snake.get(i).getY() - 1][snake.get(i).getX()] != 0
							&& map[snake.get(i).getY() - 1][snake.get(i).getX()] != 3) {
						// 게임오버 사운드
						gameOver();
					}
					if (i == 0 && map[snake.get(i).getY() - 1][snake.get(i).getX()] == 3) {
						Snake s = new Snake(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY(),
								snake.get(snake.size() - 1).getDir(), snake.get(snake.size() - 1).isHead());
						if (s.getDir() == 4)
							s.setX(s.getX() - 1);
						else if (s.getDir() == 1)
							s.setX(s.getX() + 1);
						else if (s.getDir() == 2)
							s.setY(s.getY() + 1);
						else if (s.getDir() == 3)
							s.setY(s.getY() - 1);
						snake.add(s);
						createBonus();
					}
					snake.get(i).setY(snake.get(i).getY() - 1);
				} else
					gameOver();
			} else if (snake.get(i).getDir() == 3) {
				if (snake.get(i).getY() + 1 <= 23) {
					if (i == 0 && map[snake.get(i).getY() + 1][snake.get(i).getX()] != 0
							&& map[snake.get(i).getY() + 1][snake.get(i).getX()] != 3) {
						// 게임오버 사운드
						gameOver();
					}
					if (i == 0 && map[snake.get(i).getY() + 1][snake.get(i).getX()] == 3) {
						Snake s = new Snake(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY(),
								snake.get(snake.size() - 1).getDir(), snake.get(snake.size() - 1).isHead());
						if (s.getDir() == 4)
							s.setX(s.getX() - 1);
						else if (s.getDir() == 1)
							s.setX(s.getX() + 1);
						else if (s.getDir() == 2)
							s.setY(s.getY() + 1);
						else if (s.getDir() == 3)
							s.setY(s.getY() - 1);
						snake.add(s);
						createBonus();
					}
					snake.get(i).setY(snake.get(i).getY() + 1);
				} else
					gameOver();
			}
		}
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
		g.drawString(Integer.toString(snake.size()), 250, 850);
		snakeMove();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 3 && map[i][j] != 4)
					map[i][j] = 0;
			}
		}
		for (Snake s : snake) {
			if (s.isHead())
				map[s.getY()][s.getX()] = 1;
			else
				map[s.getY()][s.getX()] = 2;
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

	public void gameOver() {
		System.out.println("Game Over");
		SnakeGame.backMain();
	}
}