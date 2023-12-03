package playy.action;

import playy.Labyrinthe;
import playy.Manager;
import playy.Position;
import playy.entity.Hero;

public enum Interaction implements Action{
    ATTACK("A"){
        @Override
        public void execute() {
            System.out.println("J'attaque !");
            Hero h = Manager.getManager().getPacman();
            Position hero = h.getPosition();
            Position[] p = {hero, new Position(hero.getX()+1,hero.getY()+1),new Position(hero.getX()+1,hero.getY()-1),
                    new Position(hero.getX()-1,hero.getY()+1),new Position(hero.getX()-1,hero.getY()-1),
                    new Position(hero.getX()+1,hero.getY()),new Position(hero.getX()-1,hero.getY()),
                    new Position(hero.getX(),hero.getY()+1),new Position(hero.getX(),hero.getY()-1)};

            Labyrinthe lab = Manager.getManager().getLab();
            for(Position position : p) {

                if(lab.getPlateau()[position.getX()][position.getY()] == 9) {
                    h.attack(Manager.getManager().getMonstre());
                }
            }
        }
    },
    HEAL("E"){
        @Override
        public void execute() {
            Hero h = Manager.getManager().getPacman();
            System.out.println(h.getLife());
            h.heal();
            System.out.println(h.getLife());
        }
    };



    Interaction(String acronyme) {
        this.acronyme = acronyme;
    }

    protected String acronyme;

}