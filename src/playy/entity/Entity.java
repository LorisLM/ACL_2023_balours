package playy.entity;

import playy.Position;
import playy.equipement.Equipement;

import java.util.ArrayList;

public class Entity {
    protected Position position;
    protected int life;

    public Entity(int life, Position position) {
        this.life = life;
        this.position = position;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }
}
