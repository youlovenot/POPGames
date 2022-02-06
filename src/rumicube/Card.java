package rumicube;

public class Card {

	private int x, y,number;
	private String color;

	public Card(int x, int y, int number, String color) {
		this.x=x;
		this.y=y;
		this.number=number;
		this.color=color;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
