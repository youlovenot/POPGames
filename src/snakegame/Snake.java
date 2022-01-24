package snakegame;

public class Snake {

	private int x;
	private int y;
	private int dir;
	private boolean isHead;
	
	public Snake(int x,int y,int dir,boolean isHead)
	{
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.isHead=isHead;
	}
	
	public boolean isHead() {
		return isHead;
	}

	public void setHead(boolean isHead) {
		this.isHead = isHead;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	
}
