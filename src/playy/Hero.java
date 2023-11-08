package playy;
public class Hero {
	private Position position;
	
	public Hero() {
		position = Position.InitPosition();
	}
	
	public void moveHero(Move move, Labyrinthe labyrinthe){
		if (labyrinthe.getPlateau()[getPosition().getY()+move.getY()][getPosition().getX()+move.getX()] == -1)
			return;
		position.setX(position.getX()+move.getX());
		position.setY(position.getY()+move.getY());
	}
	
	@Override
	public String toString() {
		return "abscisse: " + position.getX() + " ordonnée: " + position.getY();
	}
	
	public Position getPosition() {
		return position;
	}
}
