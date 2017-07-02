import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 */

/**
 * @author kevin
 *
 */
public class Missile {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	private static final int X_SPEED = 10;
	private static final int Y_SPEED = 10;
	private boolean live = true;
	private int x, y;
	private Direction dir;
	private TankClient tc;

	/**
	 * @param x
	 * @param y
	 * @param dir
	 * @param tc
	 */
	public Missile(int x, int y, Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;
	}

	/**
	 * @param x
	 * @param y
	 * @param dir
	 */
	public Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		move();
	}

	private void move() {

		switch (dir) {
		case L:
			x -= X_SPEED;
			break;
		case LU:
			x -= X_SPEED;
			y -= Y_SPEED;
			break;
		case U:
			y -= Y_SPEED;
			break;
		case RU:
			x += X_SPEED;
			y -= Y_SPEED;
			break;
		case R:
			x += X_SPEED;
			break;
		case RD:
			x += X_SPEED;
			y += Y_SPEED;
			break;
		case D:
			y += Y_SPEED;
			break;
		case LD:
			x -= X_SPEED;
			y += Y_SPEED;
			break;
		case STEADY:
			break;
		}

		if (x < 0 || y < 0 || x > TankClient.WIDTH || y > TankClient.HEIGHT) {
			live = false;
			tc.ms.remove(this);
		}
	}

	/**
	 * @return the width
	 */
	public static int getWidth() {
		return WIDTH;
	}

	/**
	 * @return the height
	 */
	public static int getHeight() {
		return HEIGHT;
	}

	/**
	 * @return the live
	 */
	public boolean isLive() {
		return live;
	}

}