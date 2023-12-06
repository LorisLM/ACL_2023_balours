package playy.entity;
import playy.Labyrinthe;
import playy.Manager;
import playy.Position;

import java.util.Random;

public class Monstre extends Entity {

    public Monstre createMonstre() {
        Position position;
        do {
            position = Position.InitPosition();
        }while(this.position == Manager.getManager().getPacman().getPosition());
        return new Monstre(position);
    }

    public Monstre(Position position) {
        super(2, position);
    }

    public void moveMonstre(Labyrinthe labyrinthe) {
        Random rand = new Random();
        int moveX = rand.nextInt(3) - 1;
        int moveY = rand.nextInt(3) - 1;


        int newX = position.getX() + moveX;
        int newY = position.getY() + moveY;

        if (labyrinthe.getPlateau()[newX][newY] != 0)
            return;

        if (newX >= 0 && newX < Labyrinthe.TAILLE &&
                newY >= 0 && newY < Labyrinthe.TAILLE &&
                labyrinthe.getPlateau()[newY][newX] != -1) {
            position.setX(newX);
            position.setY(newY);
        }
    }

    @Override
    public String toString() {
        return "Monstre - abscisse: " + position.getX() + " ordonnÃ©e: " + position.getY() + " Vie : " + life;
    }

    public Position getPosition() {
        return position;
    }
}

