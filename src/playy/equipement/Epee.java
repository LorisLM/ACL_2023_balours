package playy.equipement;

import playy.entity.Entity;

public class Epee extends Equipement {
    private int damage = 2;

    public Epee(int damage) {
        super(5);
        this.damage = damage;
    }

    @Override
    public void use(Entity target) {
        if (verifyAndUpdate())
            return;
        target.setLife(target.getLife()-damage);
    }

    @Override
    public String toString() {
        return "life : " + life + " damage : " + damage;
    }
}
