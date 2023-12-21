package playy.entity;

import java.util.Random;
import playy.Labyrinthe;
import playy.Manager;
import playy.Position;

public class Fantom extends Entity {
	public Fantom createFantom() {
        Position position;
        do {
            position = Position.InitPosition();
        }while(this.position == Manager.getManager().getPacman().getPosition());
        return new Fantom(position);
    }

    public Fantom(Position position) {
        super(2, position);
    }

    public void moveFantom(Labyrinthe labyrinthe, Entity target) {
        int moveX = 0;
        int moveY = 0;
    	if (target.position.getX() - position.getX() > 0) {
    		moveX = 1;
    	}
    	else if (target.position.getX() - position.getX() < 0) {
    		moveX = -1;
    	}
    	if (target.position.getY() - position.getY() > 0) {
    		moveY = 1;
    	}
    	else if (target.position.getY() - position.getY() < 0) {
    		moveY = -1;
    	}
    	
        int newX = position.getX() + moveX;
        int newY = position.getY() + moveY;

        if (newX >= 0 && newX < Labyrinthe.TAILLE &&
                newY >= 0 && newY < Labyrinthe.TAILLE ) {
            position.setX(newX);
            position.setY(newY);
        }
    }

    @Override
    public String toString() {
        return "fantom - abscisse: " + position.getX() + " ordonnÃ©e: " + position.getY() + " Vie : " + life;
    }

    public Position getPosition() {
        return position;
    }
}
