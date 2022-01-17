package rhythmgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if (RhythmGame.game == null)
			return;
		if (e.getKeyCode() == KeyEvent.VK_A) {
			RhythmGame.game.pressA();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			RhythmGame.game.pressS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			RhythmGame.game.pressD();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			RhythmGame.game.pressSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			RhythmGame.game.pressJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			RhythmGame.game.pressK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			RhythmGame.game.pressL();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (RhythmGame.game == null)
			return;
		if (e.getKeyCode() == KeyEvent.VK_A) {
			RhythmGame.game.releseA();
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			RhythmGame.game.releseS();
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			RhythmGame.game.releseD();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			RhythmGame.game.releseSpace();
		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			RhythmGame.game.releseJ();
		} else if (e.getKeyCode() == KeyEvent.VK_K) {
			RhythmGame.game.releseK();
		} else if (e.getKeyCode() == KeyEvent.VK_L) {
			RhythmGame.game.releseL();
		}
	}
}
