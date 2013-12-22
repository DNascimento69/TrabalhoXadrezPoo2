package modelo.cdp;

import java.io.Serializable;

public class Posicao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int x, y;

	public Posicao(int a, int b) {
		this.x = a;
		this.y = b;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
