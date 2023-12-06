package playy;

import org.junit.Test;
import playy.entity.Entity;
import playy.entity.Hero;
import playy.entity.Monstre;
import playy.entity.Portal;
import playy.equipement.Epee;
import playy.equipement.Tresor;

import static org.junit.Assert.*;

public class TestAll {
    @Test
    public void testCreationLabyrinthe() {

        Hero hero = new Hero();
        Monstre monstre = new Monstre(Position.InitPosition());
        Malus malus = new Malus();
        Tresor tresor = new Tresor();
        Portal portala = new Portal();
        Portal portalb = new Portal();

        Labyrinthe labyrinthe = new Labyrinthe(tresor, hero, monstre, malus, portala, portalb);

        assertEquals(2, labyrinthe.getPlateau()[hero.getPosition().getY()][hero.getPosition().getX()]);
        assertEquals(3, labyrinthe.getPlateau()[monstre.getPosition().getY()][monstre.getPosition().getX()]);
    }

    @Test
    public void testFromFile() {
        Hero hero = new Hero();
        Monstre monstre = new Monstre(Position.InitPosition());
        Malus malus = new Malus();
        Tresor tresor = new Tresor();
        Portal portala = new Portal();
        Portal portalb = new Portal();
        Labyrinthe labyrinthe = Labyrinthe.FromFile(tresor, hero, monstre, malus, portala, portalb);

        assertNotNull(labyrinthe);
    }

    @Test
    public void testAttackWithSword() {
        Hero hero = new Hero();
        Entity target = new Entity(15, new Position(1, 1));
        hero.getEquipements().add(new Epee(5));

        hero.attack(target);

        assertEquals(10, target.getLife());
    }

    @Test
    public void testHeal() {
        Hero hero = new Hero();
        hero.setLife(10);
        hero.heal();

        assertEquals(20, hero.getLife());
    }
}
