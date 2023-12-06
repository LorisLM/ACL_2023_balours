package playy;

public class Malus {
	private Position position;
	
	public Malus() {
		position = Position.InitPosition();
	}
	
	@Override
    public String toString() {
        return "Malus - abscisse: " + position.getX() + " ordonnée: " + position.getY();
    }

    public Position getPosition() {
        return position;
    }
}
