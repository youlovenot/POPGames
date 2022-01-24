package snakegame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		if (SnakeGame.game == null)
			return;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			SnakeGame.game.pressRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			SnakeGame.game.pressLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			SnakeGame.game.pressUp();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			SnakeGame.game.pressDown();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (SnakeGame.game == null)
			return;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			SnakeGame.game.releseRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			SnakeGame.game.releseLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			SnakeGame.game.releseUp();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			SnakeGame.game.releseDown();
		}
	}
}
