package rhythmgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../img/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../img/noteRouteLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../img/gameInfo.png")).getImage();
	private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
	private Image flareImage;
	private Image judgeImage;
	private Image keyPadAImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	private int keyDropA = 0;
	private int keyDropS = 0;
	private int keyDropD = 0;
	private int keyDropSpace = 0;
	private int keyDropJ = 0;
	private int keyDropK = 0;
	private int keyDropL = 0;
	private int score = 0;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteAImage, 228, 30, null);
		g.drawImage(noteRouteSImage, 332, 30, null);
		g.drawImage(noteRouteDImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 620)
				judgeImage = new ImageIcon(Main.class.getResource("../img/judgeMiss.png")).getImage();
			if (!note.isProceed()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("A", 270, 609);
		g.drawString("S", 374, 609);
		g.drawString("D", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.setColor(Color.LIGHT_GRAY);
		g.drawString(Integer.toString(score), 565, 702);
		g.drawImage(flareImage, 300, 335, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadAImage, 228, 580, null);
		g.drawImage(keyPadSImage, 332, 580, null);
		g.drawImage(keyPadDImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}

	public void pressA() {
		judge("A");
		keyPadAImage = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteAImage = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropA == 0)
			new Music("drumSmall.mp3", false).start();
		keyDropA = 1;
	}

	public void releseA() {
		keyPadAImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteAImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropA = 0;
	}

	public void pressS() {
		judge("S");
		keyPadSImage = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteSImage = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropS == 0)
			new Music("drumSmall.mp3", false).start();
		keyDropS = 1;
	}

	public void releseS() {
		keyPadSImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteSImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropS = 0;
	}

	public void pressD() {
		judge("D");
		keyPadDImage = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteDImage = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropD == 0)
			new Music("drumSmall.mp3", false).start();
		keyDropD = 1;
	}

	public void releseD() {
		keyPadDImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteDImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropD = 0;
	}

	public void pressSpace() {
		judge("Space");
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropSpace == 0)
			new Music("drumBig.mp3", false).start();
		keyDropSpace = 1;
	}

	public void releseSpace() {
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropSpace = 0;
	}

	public void pressJ() {
		judge("J");
		keyPadJImage = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteJImage = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropJ == 0)
			new Music("drumSmall.mp3", false).start();
		keyDropJ = 1;
	}

	public void releseJ() {
		keyPadJImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteJImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropJ = 0;
	}

	public void pressK() {
		judge("K");
		keyPadKImage = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteKImage = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropK == 0)
			new Music("drumSmall.mp3", false).start();
		keyDropK = 1;
	}

	public void releseK() {
		keyPadKImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteKImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropK = 0;
	}

	public void pressL() {
		judge("L");
		keyPadLImage = new ImageIcon(Main.class.getResource("../img/keyPadPressed.png")).getImage();
		noteRouteLImage = new ImageIcon(Main.class.getResource("../img/noteRoutePressed.png")).getImage();
		if (keyDropL == 0)
			new Music("drumSmall.mp3", false).start();
		keyDropL = 1;
	}

	public void releseL() {
		keyPadLImage = new ImageIcon(Main.class.getResource("../img/keyPadBasic.png")).getImage();
		noteRouteLImage = new ImageIcon(Main.class.getResource("../img/noteRoute.png")).getImage();
		keyDropL = 0;
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("Roads")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "A"), new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 5, "A"), new Beat(startTime + gap * 7, "S"),
					new Beat(startTime + gap * 9, "A"), new Beat(startTime + gap * 11, "S"),
					new Beat(startTime + gap * 13, "A"), new Beat(startTime + gap * 15, "S"),
					new Beat(startTime + gap * 18, "A"), new Beat(startTime + gap * 20, "A"),
					new Beat(startTime + gap * 22, "S"), new Beat(startTime + gap * 24, "S"),
					new Beat(startTime + gap * 26, "A"), new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 30, "A"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 35, "A"), new Beat(startTime + gap * 37, "S"),
					new Beat(startTime + gap * 39, "A"), new Beat(startTime + gap * 41, "S"),
					new Beat(startTime + gap * 43, "A"), new Beat(startTime + gap * 45, "S"),
					new Beat(startTime + gap * 48, "A"), new Beat(startTime + gap * 49, "S"),
					new Beat(startTime + gap * 50, "A"), new Beat(startTime + gap * 52, "S"),
					new Beat(startTime + gap * 52, "D"), new Beat(startTime + gap * 52, "Space"),
					new Beat(startTime + gap * 54, "A"), new Beat(startTime + gap * 56, "S"),
					new Beat(startTime + gap * 59, "A"), new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 59, "D"), new Beat(startTime + gap * 61, "A"),
					new Beat(startTime + gap * 63, "S"), new Beat(startTime + gap * 65, "A"),
					new Beat(startTime + gap * 65, "S"), new Beat(startTime + gap * 65, "Space"),
					new Beat(startTime + gap * 70, "A"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "A"), new Beat(startTime + gap * 78, "S"),
					new Beat(startTime + gap * 79, "A"), new Beat(startTime + gap * 80, "S"),
					new Beat(startTime + gap * 83, "A"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "A"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "A"), new Beat(startTime + gap * 93, "S"),
					new Beat(startTime + gap * 96, "A"), new Beat(startTime + gap * 98, "S"),
					new Beat(startTime + gap * 100, "A"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 103, "A"), new Beat(startTime + gap * 106, "S"),
					new Beat(startTime + gap * 109, "A"), new Beat(startTime + gap * 111, "S"),
					new Beat(startTime + gap * 116, "A"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "A"), new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 123, "A"), new Beat(startTime + gap * 124, "S"),
					new Beat(startTime + gap * 125, "A"), new Beat(startTime + gap * 126, "S"),
					new Beat(startTime + gap * 127, "A"), new Beat(startTime + gap * 130, "S"),
					new Beat(startTime + gap * 133, "A"), new Beat(startTime + gap * 136, "S"),
					new Beat(startTime + gap * 138, "A"), new Beat(startTime + gap * 140, "S"),
					new Beat(startTime + gap * 142, "A"), new Beat(startTime + gap * 144, "S"),
					new Beat(startTime + gap * 146, "A"), new Beat(startTime + gap * 150, "S"),
					new Beat(startTime + gap * 152, "A"), new Beat(startTime + gap * 157, "S"),
					new Beat(startTime + gap * 161, "A"), new Beat(startTime + gap * 165, "S"),
					new Beat(startTime + gap * 167, "A"), new Beat(startTime + gap * 169, "S"),
					new Beat(startTime + gap * 171, "A"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "A"), new Beat(startTime + gap * 178, "S"),
					new Beat(startTime + gap * 180, "A"), new Beat(startTime + gap * 181, "S"),
					new Beat(startTime + gap * 184, "A"), new Beat(startTime + gap * 187, "S"),
					new Beat(startTime + gap * 188, "A"), new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "A"), new Beat(startTime + gap * 192, "S"),
					new Beat(startTime + gap * 196, "A"), new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 200, "A"), new Beat(startTime + gap * 200, "S"),
					new Beat(startTime + gap * 207, "A"), new Beat(startTime + gap * 207, "S"),
					new Beat(startTime + gap * 211, "A"), new Beat(startTime + gap * 211, "S"),
					new Beat(startTime + gap * 216, "A"), new Beat(startTime + gap * 216, "S"),
					new Beat(startTime + gap * 218, "A"), new Beat(startTime + gap * 221, "S"),
					new Beat(startTime + gap * 223, "A"), new Beat(startTime + gap * 225, "S"),
					new Beat(startTime + gap * 227, "A"), new Beat(startTime + gap * 227, "S"),
					new Beat(startTime + gap * 231, "A"), new Beat(startTime + gap * 231, "S"),
					new Beat(startTime + gap * 235, "A"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 242, "A"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "D"), new Beat(startTime + gap * 246, "A"),
					new Beat(startTime + gap * 246, "S"), new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 250, "A"), new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 250, "D"), new Beat(startTime + gap * 255, "A"),
					new Beat(startTime + gap * 257, "S"), new Beat(startTime + gap * 259, "A"),
					new Beat(startTime + gap * 262, "S"), new Beat(startTime + gap * 262, "A"),
					new Beat(startTime + gap * 266, "S"), new Beat(startTime + gap * 266, "A"),
					new Beat(startTime + gap * 270, "A"), new Beat(startTime + gap * 270, "S"),
					new Beat(startTime + gap * 275, "A"), new Beat(startTime + gap * 277, "S"),
					new Beat(startTime + gap * 279, "A"), new Beat(startTime + gap * 282, "S"),
					new Beat(startTime + gap * 284, "A"), new Beat(startTime + gap * 286, "S"),
					new Beat(startTime + gap * 289, "A"), new Beat(startTime + gap * 291, "S"),
					new Beat(startTime + gap * 293, "A"), new Beat(startTime + gap * 295, "S"),
					new Beat(startTime + gap * 297, "A"), new Beat(startTime + gap * 299, "S"),
					new Beat(startTime + gap * 301, "A"), new Beat(startTime + gap * 304, "S"),
					new Beat(startTime + gap * 306, "A"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "A"), new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 314, "A"), new Beat(startTime + gap * 317, "S"),
					new Beat(startTime + gap * 319, "A"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "A"), new Beat(startTime + gap * 325, "S"),
					new Beat(startTime + gap * 327, "A"), new Beat(startTime + gap * 330, "S"),
					new Beat(startTime + gap * 332, "A"), new Beat(startTime + gap * 332, "S"),
					new Beat(startTime + gap * 336, "A"), new Beat(startTime + gap * 336, "S"),
					new Beat(startTime + gap * 340, "A"), new Beat(startTime + gap * 340, "S") };
		} else if (titleName.equals("Black Sea")) {
			int startTime = 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "A"), new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 5, "A"), new Beat(startTime + gap * 7, "S"),
					new Beat(startTime + gap * 9, "A"), new Beat(startTime + gap * 11, "S"),
					new Beat(startTime + gap * 13, "A"), new Beat(startTime + gap * 15, "S"),
					new Beat(startTime + gap * 18, "A"), new Beat(startTime + gap * 20, "A"),
					new Beat(startTime + gap * 22, "S"), new Beat(startTime + gap * 24, "S"),
					new Beat(startTime + gap * 26, "A"), new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 30, "A"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 35, "A"), new Beat(startTime + gap * 37, "S"),
					new Beat(startTime + gap * 39, "A"), new Beat(startTime + gap * 41, "S"),
					new Beat(startTime + gap * 43, "A"), new Beat(startTime + gap * 45, "S"),
					new Beat(startTime + gap * 48, "A"), new Beat(startTime + gap * 49, "S"),
					new Beat(startTime + gap * 50, "A"), new Beat(startTime + gap * 52, "S"),
					new Beat(startTime + gap * 52, "D"), new Beat(startTime + gap * 52, "Space"),
					new Beat(startTime + gap * 54, "A"), new Beat(startTime + gap * 56, "S"),
					new Beat(startTime + gap * 59, "A"), new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 59, "D"), new Beat(startTime + gap * 61, "A"),
					new Beat(startTime + gap * 63, "S"), new Beat(startTime + gap * 65, "A"),
					new Beat(startTime + gap * 65, "S"), new Beat(startTime + gap * 65, "Space"),
					new Beat(startTime + gap * 70, "A"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "A"), new Beat(startTime + gap * 78, "S"),
					new Beat(startTime + gap * 79, "A"), new Beat(startTime + gap * 80, "S"),
					new Beat(startTime + gap * 83, "A"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "A"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "A"), new Beat(startTime + gap * 93, "S"),
					new Beat(startTime + gap * 96, "A"), new Beat(startTime + gap * 98, "S"),
					new Beat(startTime + gap * 100, "A"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 103, "A"), new Beat(startTime + gap * 106, "S"),
					new Beat(startTime + gap * 109, "A"), new Beat(startTime + gap * 111, "S"),
					new Beat(startTime + gap * 116, "A"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "A"), new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 123, "A"), new Beat(startTime + gap * 124, "S"),
					new Beat(startTime + gap * 125, "A"), new Beat(startTime + gap * 126, "S"),
					new Beat(startTime + gap * 127, "A"), new Beat(startTime + gap * 130, "S"),
					new Beat(startTime + gap * 133, "A"), new Beat(startTime + gap * 136, "S"),
					new Beat(startTime + gap * 138, "A"), new Beat(startTime + gap * 140, "S"),
					new Beat(startTime + gap * 142, "A"), new Beat(startTime + gap * 144, "S"),
					new Beat(startTime + gap * 146, "A"), new Beat(startTime + gap * 150, "S"),
					new Beat(startTime + gap * 152, "A"), new Beat(startTime + gap * 157, "S"),
					new Beat(startTime + gap * 161, "A"), new Beat(startTime + gap * 165, "S"),
					new Beat(startTime + gap * 167, "A"), new Beat(startTime + gap * 169, "S"),
					new Beat(startTime + gap * 171, "A"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "A"), new Beat(startTime + gap * 178, "S"),
					new Beat(startTime + gap * 180, "A"), new Beat(startTime + gap * 181, "S"),
					new Beat(startTime + gap * 184, "A"), new Beat(startTime + gap * 187, "S"),
					new Beat(startTime + gap * 188, "A"), new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "A"), new Beat(startTime + gap * 192, "S"),
					new Beat(startTime + gap * 196, "A"), new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 200, "A"), new Beat(startTime + gap * 200, "S"),
					new Beat(startTime + gap * 207, "A"), new Beat(startTime + gap * 207, "S"),
					new Beat(startTime + gap * 211, "A"), new Beat(startTime + gap * 211, "S"),
					new Beat(startTime + gap * 216, "A"), new Beat(startTime + gap * 216, "S"),
					new Beat(startTime + gap * 218, "A"), new Beat(startTime + gap * 221, "S"),
					new Beat(startTime + gap * 223, "A"), new Beat(startTime + gap * 225, "S"),
					new Beat(startTime + gap * 227, "A"), new Beat(startTime + gap * 227, "S"),
					new Beat(startTime + gap * 231, "A"), new Beat(startTime + gap * 231, "S"),
					new Beat(startTime + gap * 235, "A"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 242, "A"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "D"), new Beat(startTime + gap * 246, "A"),
					new Beat(startTime + gap * 246, "S"), new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 250, "A"), new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 250, "D"), new Beat(startTime + gap * 255, "A"),
					new Beat(startTime + gap * 257, "S"), new Beat(startTime + gap * 259, "A"),
					new Beat(startTime + gap * 262, "S"), new Beat(startTime + gap * 262, "A"),
					new Beat(startTime + gap * 266, "S"), new Beat(startTime + gap * 266, "A"),
					new Beat(startTime + gap * 270, "A"), new Beat(startTime + gap * 270, "S"),
					new Beat(startTime + gap * 275, "A"), new Beat(startTime + gap * 277, "S"),
					new Beat(startTime + gap * 279, "A"), new Beat(startTime + gap * 282, "S"),
					new Beat(startTime + gap * 284, "A"), new Beat(startTime + gap * 286, "S"),
					new Beat(startTime + gap * 289, "A"), new Beat(startTime + gap * 291, "S"),
					new Beat(startTime + gap * 293, "A"), new Beat(startTime + gap * 295, "S"),
					new Beat(startTime + gap * 297, "A"), new Beat(startTime + gap * 299, "S"),
					new Beat(startTime + gap * 301, "A"), new Beat(startTime + gap * 304, "S"),
					new Beat(startTime + gap * 306, "A"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "A"), new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 314, "A"), new Beat(startTime + gap * 317, "S"),
					new Beat(startTime + gap * 319, "A"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "A"), new Beat(startTime + gap * 325, "S"),
					new Beat(startTime + gap * 327, "A"), new Beat(startTime + gap * 330, "S"),
					new Beat(startTime + gap * 332, "A"), new Beat(startTime + gap * 332, "S"),
					new Beat(startTime + gap * 336, "A"), new Beat(startTime + gap * 336, "S"),
					new Beat(startTime + gap * 340, "A"), new Beat(startTime + gap * 340, "S"), };
		} else if (titleName.equals("Slow Down")) {
			int startTime = 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "A"), new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 5, "A"), new Beat(startTime + gap * 7, "S"),
					new Beat(startTime + gap * 9, "A"), new Beat(startTime + gap * 11, "S"),
					new Beat(startTime + gap * 13, "A"), new Beat(startTime + gap * 15, "S"),
					new Beat(startTime + gap * 18, "A"), new Beat(startTime + gap * 20, "A"),
					new Beat(startTime + gap * 22, "S"), new Beat(startTime + gap * 24, "S"),
					new Beat(startTime + gap * 26, "A"), new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 30, "A"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 35, "A"), new Beat(startTime + gap * 37, "S"),
					new Beat(startTime + gap * 39, "A"), new Beat(startTime + gap * 41, "S"),
					new Beat(startTime + gap * 43, "A"), new Beat(startTime + gap * 45, "S"),
					new Beat(startTime + gap * 48, "A"), new Beat(startTime + gap * 49, "S"),
					new Beat(startTime + gap * 50, "A"), new Beat(startTime + gap * 52, "S"),
					new Beat(startTime + gap * 52, "D"), new Beat(startTime + gap * 52, "Space"),
					new Beat(startTime + gap * 54, "A"), new Beat(startTime + gap * 56, "S"),
					new Beat(startTime + gap * 59, "A"), new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 59, "D"), new Beat(startTime + gap * 61, "A"),
					new Beat(startTime + gap * 63, "S"), new Beat(startTime + gap * 65, "A"),
					new Beat(startTime + gap * 65, "S"), new Beat(startTime + gap * 65, "Space"),
					new Beat(startTime + gap * 70, "A"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "A"), new Beat(startTime + gap * 78, "S"),
					new Beat(startTime + gap * 79, "A"), new Beat(startTime + gap * 80, "S"),
					new Beat(startTime + gap * 83, "A"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "A"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "A"), new Beat(startTime + gap * 93, "S"),
					new Beat(startTime + gap * 96, "A"), new Beat(startTime + gap * 98, "S"),
					new Beat(startTime + gap * 100, "A"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 103, "A"), new Beat(startTime + gap * 106, "S"),
					new Beat(startTime + gap * 109, "A"), new Beat(startTime + gap * 111, "S"),
					new Beat(startTime + gap * 116, "A"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "A"), new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 123, "A"), new Beat(startTime + gap * 124, "S"),
					new Beat(startTime + gap * 125, "A"), new Beat(startTime + gap * 126, "S"),
					new Beat(startTime + gap * 127, "A"), new Beat(startTime + gap * 130, "S"),
					new Beat(startTime + gap * 133, "A"), new Beat(startTime + gap * 136, "S"),
					new Beat(startTime + gap * 138, "A"), new Beat(startTime + gap * 140, "S"),
					new Beat(startTime + gap * 142, "A"), new Beat(startTime + gap * 144, "S"),
					new Beat(startTime + gap * 146, "A"), new Beat(startTime + gap * 150, "S"),
					new Beat(startTime + gap * 152, "A"), new Beat(startTime + gap * 157, "S"),
					new Beat(startTime + gap * 161, "A"), new Beat(startTime + gap * 165, "S"),
					new Beat(startTime + gap * 167, "A"), new Beat(startTime + gap * 169, "S"),
					new Beat(startTime + gap * 171, "A"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "A"), new Beat(startTime + gap * 178, "S"),
					new Beat(startTime + gap * 180, "A"), new Beat(startTime + gap * 181, "S"),
					new Beat(startTime + gap * 184, "A"), new Beat(startTime + gap * 187, "S"),
					new Beat(startTime + gap * 188, "A"), new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "A"), new Beat(startTime + gap * 192, "S"),
					new Beat(startTime + gap * 196, "A"), new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 200, "A"), new Beat(startTime + gap * 200, "S"),
					new Beat(startTime + gap * 207, "A"), new Beat(startTime + gap * 207, "S"),
					new Beat(startTime + gap * 211, "A"), new Beat(startTime + gap * 211, "S"),
					new Beat(startTime + gap * 216, "A"), new Beat(startTime + gap * 216, "S"),
					new Beat(startTime + gap * 218, "A"), new Beat(startTime + gap * 221, "S"),
					new Beat(startTime + gap * 223, "A"), new Beat(startTime + gap * 225, "S"),
					new Beat(startTime + gap * 227, "A"), new Beat(startTime + gap * 227, "S"),
					new Beat(startTime + gap * 231, "A"), new Beat(startTime + gap * 231, "S"),
					new Beat(startTime + gap * 235, "A"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 242, "A"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "D"), new Beat(startTime + gap * 246, "A"),
					new Beat(startTime + gap * 246, "S"), new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 250, "A"), new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 250, "D"), new Beat(startTime + gap * 255, "A"),
					new Beat(startTime + gap * 257, "S"), new Beat(startTime + gap * 259, "A"),
					new Beat(startTime + gap * 262, "S"), new Beat(startTime + gap * 262, "A"),
					new Beat(startTime + gap * 266, "S"), new Beat(startTime + gap * 266, "A"),
					new Beat(startTime + gap * 270, "A"), new Beat(startTime + gap * 270, "S"),
					new Beat(startTime + gap * 275, "A"), new Beat(startTime + gap * 277, "S"),
					new Beat(startTime + gap * 279, "A"), new Beat(startTime + gap * 282, "S"),
					new Beat(startTime + gap * 284, "A"), new Beat(startTime + gap * 286, "S"),
					new Beat(startTime + gap * 289, "A"), new Beat(startTime + gap * 291, "S"),
					new Beat(startTime + gap * 293, "A"), new Beat(startTime + gap * 295, "S"),
					new Beat(startTime + gap * 297, "A"), new Beat(startTime + gap * 299, "S"),
					new Beat(startTime + gap * 301, "A"), new Beat(startTime + gap * 304, "S"),
					new Beat(startTime + gap * 306, "A"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "A"), new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 314, "A"), new Beat(startTime + gap * 317, "S"),
					new Beat(startTime + gap * 319, "A"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "A"), new Beat(startTime + gap * 325, "S"),
					new Beat(startTime + gap * 327, "A"), new Beat(startTime + gap * 330, "S"),
					new Beat(startTime + gap * 332, "A"), new Beat(startTime + gap * 332, "S"),
					new Beat(startTime + gap * 336, "A"), new Beat(startTime + gap * 336, "S"),
					new Beat(startTime + gap * 340, "A"), new Beat(startTime + gap * 340, "S") };
		}
		if (titleName.equals("Mighty Love")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime + gap * 1, "A"), new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 5, "A"), new Beat(startTime + gap * 7, "S"),
					new Beat(startTime + gap * 9, "A"), new Beat(startTime + gap * 11, "S"),
					new Beat(startTime + gap * 13, "A"), new Beat(startTime + gap * 15, "S"),
					new Beat(startTime + gap * 18, "A"), new Beat(startTime + gap * 20, "A"),
					new Beat(startTime + gap * 22, "S"), new Beat(startTime + gap * 24, "S"),
					new Beat(startTime + gap * 26, "A"), new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 30, "A"), new Beat(startTime + gap * 32, "S"),
					new Beat(startTime + gap * 35, "A"), new Beat(startTime + gap * 37, "S"),
					new Beat(startTime + gap * 39, "A"), new Beat(startTime + gap * 41, "S"),
					new Beat(startTime + gap * 43, "A"), new Beat(startTime + gap * 45, "S"),
					new Beat(startTime + gap * 48, "A"), new Beat(startTime + gap * 49, "S"),
					new Beat(startTime + gap * 50, "A"), new Beat(startTime + gap * 52, "S"),
					new Beat(startTime + gap * 52, "D"), new Beat(startTime + gap * 52, "Space"),
					new Beat(startTime + gap * 54, "A"), new Beat(startTime + gap * 56, "S"),
					new Beat(startTime + gap * 59, "A"), new Beat(startTime + gap * 59, "S"),
					new Beat(startTime + gap * 59, "D"), new Beat(startTime + gap * 61, "A"),
					new Beat(startTime + gap * 63, "S"), new Beat(startTime + gap * 65, "A"),
					new Beat(startTime + gap * 65, "S"), new Beat(startTime + gap * 65, "Space"),
					new Beat(startTime + gap * 70, "A"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "A"), new Beat(startTime + gap * 78, "S"),
					new Beat(startTime + gap * 79, "A"), new Beat(startTime + gap * 80, "S"),
					new Beat(startTime + gap * 83, "A"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "A"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "A"), new Beat(startTime + gap * 93, "S"),
					new Beat(startTime + gap * 96, "A"), new Beat(startTime + gap * 98, "S"),
					new Beat(startTime + gap * 100, "A"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 103, "A"), new Beat(startTime + gap * 106, "S"),
					new Beat(startTime + gap * 109, "A"), new Beat(startTime + gap * 111, "S"),
					new Beat(startTime + gap * 116, "A"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "A"), new Beat(startTime + gap * 120, "S"),
					new Beat(startTime + gap * 123, "A"), new Beat(startTime + gap * 124, "S"),
					new Beat(startTime + gap * 125, "A"), new Beat(startTime + gap * 126, "S"),
					new Beat(startTime + gap * 127, "A"), new Beat(startTime + gap * 130, "S"),
					new Beat(startTime + gap * 133, "A"), new Beat(startTime + gap * 136, "S"),
					new Beat(startTime + gap * 138, "A"), new Beat(startTime + gap * 140, "S"),
					new Beat(startTime + gap * 142, "A"), new Beat(startTime + gap * 144, "S"),
					new Beat(startTime + gap * 146, "A"), new Beat(startTime + gap * 150, "S"),
					new Beat(startTime + gap * 152, "A"), new Beat(startTime + gap * 157, "S"),
					new Beat(startTime + gap * 161, "A"), new Beat(startTime + gap * 165, "S"),
					new Beat(startTime + gap * 167, "A"), new Beat(startTime + gap * 169, "S"),
					new Beat(startTime + gap * 171, "A"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "A"), new Beat(startTime + gap * 178, "S"),
					new Beat(startTime + gap * 180, "A"), new Beat(startTime + gap * 181, "S"),
					new Beat(startTime + gap * 184, "A"), new Beat(startTime + gap * 187, "S"),
					new Beat(startTime + gap * 188, "A"), new Beat(startTime + gap * 189, "S"),
					new Beat(startTime + gap * 192, "A"), new Beat(startTime + gap * 192, "S"),
					new Beat(startTime + gap * 196, "A"), new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 200, "A"), new Beat(startTime + gap * 200, "S"),
					new Beat(startTime + gap * 207, "A"), new Beat(startTime + gap * 207, "S"),
					new Beat(startTime + gap * 211, "A"), new Beat(startTime + gap * 211, "S"),
					new Beat(startTime + gap * 216, "A"), new Beat(startTime + gap * 216, "S"),
					new Beat(startTime + gap * 218, "A"), new Beat(startTime + gap * 221, "S"),
					new Beat(startTime + gap * 223, "A"), new Beat(startTime + gap * 225, "S"),
					new Beat(startTime + gap * 227, "A"), new Beat(startTime + gap * 227, "S"),
					new Beat(startTime + gap * 231, "A"), new Beat(startTime + gap * 231, "S"),
					new Beat(startTime + gap * 235, "A"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 242, "A"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "D"), new Beat(startTime + gap * 246, "A"),
					new Beat(startTime + gap * 246, "S"), new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 250, "A"), new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 250, "D"), new Beat(startTime + gap * 255, "A"),
					new Beat(startTime + gap * 257, "S"), new Beat(startTime + gap * 259, "A"),
					new Beat(startTime + gap * 262, "S"), new Beat(startTime + gap * 262, "A"),
					new Beat(startTime + gap * 266, "S"), new Beat(startTime + gap * 266, "A"),
					new Beat(startTime + gap * 270, "A"), new Beat(startTime + gap * 270, "S"),
					new Beat(startTime + gap * 275, "A"), new Beat(startTime + gap * 277, "S"),
					new Beat(startTime + gap * 279, "A"), new Beat(startTime + gap * 282, "S"),
					new Beat(startTime + gap * 284, "A"), new Beat(startTime + gap * 286, "S"),
					new Beat(startTime + gap * 289, "A"), new Beat(startTime + gap * 291, "S"),
					new Beat(startTime + gap * 293, "A"), new Beat(startTime + gap * 295, "S"),
					new Beat(startTime + gap * 297, "A"), new Beat(startTime + gap * 299, "S"),
					new Beat(startTime + gap * 301, "A"), new Beat(startTime + gap * 304, "S"),
					new Beat(startTime + gap * 306, "A"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "A"), new Beat(startTime + gap * 312, "S"),
					new Beat(startTime + gap * 314, "A"), new Beat(startTime + gap * 317, "S"),
					new Beat(startTime + gap * 319, "A"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "A"), new Beat(startTime + gap * 325, "S"),
					new Beat(startTime + gap * 327, "A"), new Beat(startTime + gap * 330, "S"),
					new Beat(startTime + gap * 332, "A"), new Beat(startTime + gap * 332, "S"),
					new Beat(startTime + gap * 336, "A"), new Beat(startTime + gap * 336, "S"),
					new Beat(startTime + gap * 340, "A"), new Beat(startTime + gap * 340, "S"), };
		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if (!judge.equals("None"))
			flareImage = new ImageIcon(Main.class.getResource("../img/flare.png")).getImage();
		if (judge.equals("Miss"))
			judgeImage = new ImageIcon(Main.class.getResource("../img/judgeMiss.png")).getImage();
		else if (judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../img/judgeLate.png")).getImage();
			score += 100;
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../img/judgeGood.png")).getImage();
			score += 200;
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../img/judgeGreat.png")).getImage();
			score += 300;
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../img/judgePerfect.png")).getImage();
			score += 500;
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../img/judgeEarly.png")).getImage();
			score += 100;
		}
	}
}