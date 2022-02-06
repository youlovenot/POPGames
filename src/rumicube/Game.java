package rumicube;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image boardImage1 = new ImageIcon(Main.class.getResource("../img/board1.png")).getImage();
	private Image boardImage2 = new ImageIcon(Main.class.getResource("../img/board2.png")).getImage();
	private Image black1Image = new ImageIcon(Main.class.getResource("../img/black1.png")).getImage();
	private Image black2Image = new ImageIcon(Main.class.getResource("../img/black2.png")).getImage();
	private Image black3Image = new ImageIcon(Main.class.getResource("../img/black3.png")).getImage();
	private Image black4Image = new ImageIcon(Main.class.getResource("../img/black4.png")).getImage();
	private Image black5Image = new ImageIcon(Main.class.getResource("../img/black5.png")).getImage();
	private Image black6Image = new ImageIcon(Main.class.getResource("../img/black6.png")).getImage();
	private Image black7Image = new ImageIcon(Main.class.getResource("../img/black7.png")).getImage();
	private Image black8Image = new ImageIcon(Main.class.getResource("../img/black8.png")).getImage();
	private Image black9Image = new ImageIcon(Main.class.getResource("../img/black9.png")).getImage();
	private Image black10Image = new ImageIcon(Main.class.getResource("../img/black10.png")).getImage();
	private Image black11Image = new ImageIcon(Main.class.getResource("../img/black11.png")).getImage();
	private Image black12Image = new ImageIcon(Main.class.getResource("../img/black12.png")).getImage();
	private Image black13Image = new ImageIcon(Main.class.getResource("../img/black13.png")).getImage();
	private Image blackJokerImage = new ImageIcon(Main.class.getResource("../img/blackJoker.png")).getImage();
	private Image red1Image = new ImageIcon(Main.class.getResource("../img/red1.png")).getImage();
	private Image red2Image = new ImageIcon(Main.class.getResource("../img/red2.png")).getImage();
	private Image red3Image = new ImageIcon(Main.class.getResource("../img/red3.png")).getImage();
	private Image red4Image = new ImageIcon(Main.class.getResource("../img/red4.png")).getImage();
	private Image red5Image = new ImageIcon(Main.class.getResource("../img/red5.png")).getImage();
	private Image red6Image = new ImageIcon(Main.class.getResource("../img/red6.png")).getImage();
	private Image red7Image = new ImageIcon(Main.class.getResource("../img/red7.png")).getImage();
	private Image red8Image = new ImageIcon(Main.class.getResource("../img/red8.png")).getImage();
	private Image red9Image = new ImageIcon(Main.class.getResource("../img/red9.png")).getImage();
	private Image red10Image = new ImageIcon(Main.class.getResource("../img/red10.png")).getImage();
	private Image red11Image = new ImageIcon(Main.class.getResource("../img/red11.png")).getImage();
	private Image red12Image = new ImageIcon(Main.class.getResource("../img/red12.png")).getImage();
	private Image red13Image = new ImageIcon(Main.class.getResource("../img/red13.png")).getImage();
	private Image redJokerImage = new ImageIcon(Main.class.getResource("../img/redJoker.png")).getImage();
	private Image blue1Image = new ImageIcon(Main.class.getResource("../img/blue1.png")).getImage();
	private Image blue2Image = new ImageIcon(Main.class.getResource("../img/blue2.png")).getImage();
	private Image blue3Image = new ImageIcon(Main.class.getResource("../img/blue3.png")).getImage();
	private Image blue4Image = new ImageIcon(Main.class.getResource("../img/blue4.png")).getImage();
	private Image blue5Image = new ImageIcon(Main.class.getResource("../img/blue5.png")).getImage();
	private Image blue6Image = new ImageIcon(Main.class.getResource("../img/blue6.png")).getImage();
	private Image blue7Image = new ImageIcon(Main.class.getResource("../img/blue7.png")).getImage();
	private Image blue8Image = new ImageIcon(Main.class.getResource("../img/blue8.png")).getImage();
	private Image blue9Image = new ImageIcon(Main.class.getResource("../img/blue9.png")).getImage();
	private Image blue10Image = new ImageIcon(Main.class.getResource("../img/blue10.png")).getImage();
	private Image blue11Image = new ImageIcon(Main.class.getResource("../img/blue11.png")).getImage();
	private Image blue12Image = new ImageIcon(Main.class.getResource("../img/blue12.png")).getImage();
	private Image blue13Image = new ImageIcon(Main.class.getResource("../img/blue13.png")).getImage();
	private Image yellow1Image = new ImageIcon(Main.class.getResource("../img/yellow1.png")).getImage();
	private Image yellow2Image = new ImageIcon(Main.class.getResource("../img/yellow2.png")).getImage();
	private Image yellow3Image = new ImageIcon(Main.class.getResource("../img/yellow3.png")).getImage();
	private Image yellow4Image = new ImageIcon(Main.class.getResource("../img/yellow4.png")).getImage();
	private Image yellow5Image = new ImageIcon(Main.class.getResource("../img/yellow5.png")).getImage();
	private Image yellow6Image = new ImageIcon(Main.class.getResource("../img/yellow6.png")).getImage();
	private Image yellow7Image = new ImageIcon(Main.class.getResource("../img/yellow7.png")).getImage();
	private Image yellow8Image = new ImageIcon(Main.class.getResource("../img/yellow8.png")).getImage();
	private Image yellow9Image = new ImageIcon(Main.class.getResource("../img/yellow9.png")).getImage();
	private Image yellow10Image = new ImageIcon(Main.class.getResource("../img/yellow10.png")).getImage();
	private Image yellow11Image = new ImageIcon(Main.class.getResource("../img/yellow11.png")).getImage();
	private Image yellow12Image = new ImageIcon(Main.class.getResource("../img/yellow12.png")).getImage();
	private Image yellow13Image = new ImageIcon(Main.class.getResource("../img/yellow13.png")).getImage();

	private int mouseX, mouseY;

	private static int setRumi;
	
	private static boolean findRumi=false;
	
	private int[] xLocation = { 315, 380, 445, 510, 575, 640, 705, 770, 835, 900 };
	private int[] yLocation = { 520, 620 };

	private int[][] check = new int[4][14];

	private String[] colorList = { "black", "red", "blue", "yellow" };

	static ArrayList<Card> myCard = new ArrayList<Card>();

	public Game() {
		pickCard();
	}

	public void close() {
		this.interrupt();
	}

	public void pickCard() {
		for (int i = 0; i < 14; i++) {
			while (true) {
				int num = (int) (Math.random() * 100) % 14;
				num++;
				int color = (int) (Math.random() * 100) % 4;
				if (num != 14) {
					if (check[color][num - 1] <= 2) {
						check[color][num - 1]++;
						if (myCard.size() < 10)
							myCard.add(new Card(xLocation[myCard.size()], yLocation[0], num, colorList[color]));
						else
							myCard.add(new Card(xLocation[myCard.size() - 10], yLocation[1], num, colorList[color]));
						break;
					}
				} else {
					if (check[color][num - 1] == 0 && color <= 1) {
						check[color][num - 1]++;
						if (myCard.size() < 10)
							myCard.add(new Card(xLocation[myCard.size()], yLocation[0], num, colorList[color]));
						else
							myCard.add(new Card(xLocation[myCard.size() - 10], yLocation[1], num, colorList[color]));
						break;
					}
				}
			}
		}
	}

	public static void setMoveRumi(int x, int y) {
		for (int i = 0; i < myCard.size(); i++) {
			if (myCard.get(i).getX() <= x && myCard.get(i).getX() + 60 >= x && myCard.get(i).getY() <= y
					&& myCard.get(i).getY() + 100 >= y) {
				setRumi=i;
				findRumi=true;
				break;
			}
		}
		findRumi=false;
	}

	public static void moveRumi(int x, int y) {
		if(findRumi)return;
		int nx,ny;
		nx=myCard.get(setRumi).getX();
		ny=myCard.get(setRumi).getY();
		myCard.get(setRumi).setX(x);
		myCard.get(setRumi).setY(y);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(boardImage1, 310, 530, null);
		g.drawImage(boardImage2, 300, 620, null);
		for (int i = 0; i < myCard.size(); i++) {
			if (myCard.get(i).getColor() == "black") {
				if (myCard.get(i).getNumber() == 1)
					g.drawImage(black1Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 2)
					g.drawImage(black2Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 3)
					g.drawImage(black3Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 4)
					g.drawImage(black4Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 5)
					g.drawImage(black5Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 6)
					g.drawImage(black6Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 7)
					g.drawImage(black7Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 8)
					g.drawImage(black8Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 9)
					g.drawImage(black9Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 10)
					g.drawImage(black10Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 11)
					g.drawImage(black11Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 12)
					g.drawImage(black12Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 13)
					g.drawImage(black13Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 14)
					g.drawImage(blackJokerImage, myCard.get(i).getX(), myCard.get(i).getY(), null);
			} else if (myCard.get(i).getColor() == "red") {
				if (myCard.get(i).getNumber() == 1)
					g.drawImage(red1Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 2)
					g.drawImage(red2Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 3)
					g.drawImage(red3Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 4)
					g.drawImage(red4Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 5)
					g.drawImage(red5Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 6)
					g.drawImage(red6Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 7)
					g.drawImage(red7Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 8)
					g.drawImage(red8Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 9)
					g.drawImage(red9Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 10)
					g.drawImage(red10Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 11)
					g.drawImage(red11Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 12)
					g.drawImage(red12Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 13)
					g.drawImage(red13Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 14)
					g.drawImage(redJokerImage, myCard.get(i).getX(), myCard.get(i).getY(), null);
			} else if (myCard.get(i).getColor() == "blue") {
				if (myCard.get(i).getNumber() == 1)
					g.drawImage(blue1Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 2)
					g.drawImage(blue2Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 3)
					g.drawImage(blue3Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 4)
					g.drawImage(blue4Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 5)
					g.drawImage(blue5Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 6)
					g.drawImage(blue6Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 7)
					g.drawImage(blue7Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 8)
					g.drawImage(blue8Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 9)
					g.drawImage(blue9Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 10)
					g.drawImage(blue10Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 11)
					g.drawImage(blue11Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 12)
					g.drawImage(blue12Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 13)
					g.drawImage(blue13Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
			} else if (myCard.get(i).getColor() == "yellow") {
				if (myCard.get(i).getNumber() == 1)
					g.drawImage(yellow1Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 2)
					g.drawImage(yellow2Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 3)
					g.drawImage(yellow3Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 4)
					g.drawImage(yellow4Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 5)
					g.drawImage(yellow5Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 6)
					g.drawImage(yellow6Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 7)
					g.drawImage(yellow7Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 8)
					g.drawImage(yellow8Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 9)
					g.drawImage(yellow9Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 10)
					g.drawImage(yellow10Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 11)
					g.drawImage(yellow11Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 12)
					g.drawImage(yellow12Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
				if (myCard.get(i).getNumber() == 13)
					g.drawImage(yellow13Image, myCard.get(i).getX(), myCard.get(i).getY(), null);
			}
		}
	}
}
