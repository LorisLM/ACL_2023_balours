package playy.entity;
import playy.Position;


public class Portal extends Entity {
	
	public Portal() {
		super(1, Position.InitPosition());
	}
	
	public String toString() {
		return "abscisse: " + position.getX() + " ordonnée: " + position.getY();
	}
	
	public Position getPosition() {
		return position;
	}

}
