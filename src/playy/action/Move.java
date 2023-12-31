package playy.action;

import playy.Labyrinthe;
import static playy.Labyrinthe.TAILLE;
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

		if (position.getY()+this.getY() > TAILLE || position.getX()+this.getX() > TAILLE || position.getY()+this.getY() < 0 || position.getX()+this.getX() < 0 || plateau[position.getY()+this.getY()][position.getX()+this.getX()] == -1 ||plateau[position.getY()+this.getY()][position.getX()+this.getX()] == 9)
			return;
		position.setX(position.getX()+this.getX());
		position.setY(position.getY()+this.getY());
	}
	
	public static void TP1() {
		Position position = Manager.getManager().getPacman().getPosition();
		position.setX(Manager.getManager().getPortalb().getPosition().getX()+1);
		position.setY(Manager.getManager().getPortalb().getPosition().getY()+1);
}
	public static void TP2() {
		Position position = Manager.getManager().getPacman().getPosition();
		position.setX(Manager.getManager().getPortala().getPosition().getX()+1);
		position.setY(Manager.getManager().getPortala().getPosition().getY()+1);
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
