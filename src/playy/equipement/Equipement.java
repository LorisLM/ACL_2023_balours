package playy.equipement;

import playy.entity.Entity;

public abstract class Equipement {

    protected int life;

    public Equipement(int life){
        this.life = life;
    }

    public abstract void use(Entity target);

    public boolean verifyAndUpdate(){
        boolean canBeUsed = life > 0;
        if (canBeUsed)
            life--;
        return !canBeUsed;
    }

}
