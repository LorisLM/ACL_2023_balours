package playy.action;


import main.java.playy.entity.x;
import playy.Labyrinthe;
import playy.Manager;
import playy.Position;

public enum Move implements Action {
	HAUT("H", 0,-1), GAUCHE("G",-1,0), BAS("B",0,1),
	DROITE("D",1,0), STAY("S",0,0);
	
	private Move(String acronyme, int x, int y) {
		this.acronyme = acronyme;
		this.x = x;
		this.y =y;
	}

	@Override
	public void execute() {
		Position position = Manager.getManager().getPacman().getPosition();
		int[][] plateau = Manager.getManager().getLab().getPlateau();

		if (plateau[position.getY()+this.getY()][position.getX()+this.getX()] == -1 ||plateau[position.getY()+this.getY()][position.getX()+this.getX()] == 9)
			return;
		position.setX(position.getX()+this.getX());
		position.setY(position.getY()+this.getY());
	}
	
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	protected String acronyme;
	private int x,y;


}
