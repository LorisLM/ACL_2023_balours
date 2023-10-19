package playy;
public class Hero {
	private Position position;
	
	public Hero() {
		position = Position.InitPosition();
	}
	
	public void moveHero(Move move) {
		switch(move){
			case HAUT:
				position.setY(position.getY()+1);
				break;
			case BAS:
				position.setY(position.getY()-1);
				break;
			case GAUCHE:
				position.setX(position.getX()-1);
				break;
			case DROITE:
				position.setX(position.getX()+1);
				break;
		}
	}
	
	@Override
	public String toString() {
		return "x: " + position.getX() + " y: " + position.getY();
	}
	
	public Position getPosition() {
		return position;
	}
}
