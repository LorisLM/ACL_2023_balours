package playy;
import java.util.Random;

public class Position {

	private int x,y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Position InitPosition() {
        Random rand = new Random();
        int max = Labyrinthe.TAILLE;
        int min = 1;
		return new Position(rand.nextInt(max - min + 1) + min,(int)(Math.random() * Labyrinthe.TAILLE));
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
