package playy.entity;
import playy.Labyrinthe;
import playy.Position;

import java.util.Random;

public class Monstre extends Entity {

    public Monstre() {
        super(2, Position.InitPosition());
    }

    public void moveMonstre(Labyrinthe labyrinthe) {
        Random rand = new Random();
        int moveX = rand.nextInt(3) - 1; 
        int moveY = rand.nextInt(3) - 1;  

        
        int newX = position.getX() + moveX;
        int newY = position.getY() + moveY;

        if (newX >= 0 && newX < Labyrinthe.TAILLE &&
            newY >= 0 && newY < Labyrinthe.TAILLE &&
            labyrinthe.getPlateau()[newY][newX] != -1) {
            position.setX(newX);
            position.setY(newY);
        }
    }

    @Override
    public String toString() {
        return "Monstre - abscisse: " + position.getX() + " ordonnée: " + position.getY();
    }

    public Position getPosition() {
        return position;
    }
}

