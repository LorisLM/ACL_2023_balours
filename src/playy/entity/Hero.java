package playy.entity;

import playy.Labyrinthe;
import playy.Manager;
import playy.Position;
import playy.action.Action;
import playy.equipement.Epee;
import playy.equipement.Equipement;
import playy.equipement.Soin;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Hero extends Entity {
	protected ArrayList<Equipement> equipements = new ArrayList<>();

	public Hero() {
		super(20, Position.InitPosition());
		equipements.add(new Soin(10));
	}
	public void attack(Entity target){
		try{
			Epee epee = equipements.stream()
					.filter(equipement -> equipement instanceof Epee)
					.map(equipement -> (Epee) equipement)
					.findFirst().get();

			epee.use(target);
			if (target.getLife() <=0){
				Manager.getManager().getLab().getPlateau()[target.position.getY()][target.position.getX()] = 0;
			}
		}catch (NoSuchElementException e){
			System.out.println("Vous n'avez pas d'épée !");
		}

	}

	public void heal(){
		try{
			Soin soin = equipements.stream()
					.filter(equipement -> equipement instanceof Soin)
					.map(equipement -> (Soin) equipement)
					.findFirst().get();
			soin.use(this);
			System.out.println("Je heal !");
		}catch (NoSuchElementException e){
			System.out.println("Vous n'avez pas de heal !");
		}

	}

	@Override
	public String toString() {
		return "abscisse: " + position.getX() + " ordonnée: " + position.getY();
	}
	
	public Position getPosition() {
		return position;
	}

	public void executeAction(Action actionFromAcronyme) {
		actionFromAcronyme.execute();
	}
}
