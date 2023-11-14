package playy.equipement;

import playy.entity.Entity;

public class Soin extends Equipement {


    private final int HEAL = 10;

    public Soin() {
        super(1);
    }

    @Override
    public void use(Entity target) {
        if (verifyAndUpdate())
            return;
        target.setLife(target.getLife()+HEAL);
    }

    @Override
    public String toString() {
        return "life : " + life + " healing : " + HEAL;
    }
}
