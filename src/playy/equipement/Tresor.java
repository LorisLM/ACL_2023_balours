package playy.equipement;

import playy.Position;

public class Tresor {
	private Position position;
	public boolean flag;
	
	public Tresor() {
		position = Position.InitPosition();
	}
	
	public void gagner() {
		this.flag = true;
	}
	
	public Position getPosition() {
        return position;
    }
}

