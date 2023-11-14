package playy.entity;

import playy.Labyrinthe;
import playy.Move;
import playy.Position;
import playy.equipement.Epee;
import playy.equipement.Equipement;
import playy.equipement.Soin;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Hero extends Entity {
	protected ArrayList<Equipement> equipements = new ArrayList<>();

	public Hero() {
		super(20, Position.InitPosition());
		equipements.add(new Epee(10));
	}
	
	public void excuteAction(Move move, Labyrinthe labyrinthe){
		if (labyrinthe.getPlateau()[getPosition().getY()+move.getY()][getPosition().getX()+move.getX()] == -1)
			return;
		position.setX(position.getX()+move.getX());
		position.setY(position.getY()+move.getY());
	}

	public void attack(Entity target){
		try{
			Epee epee = equipements.stream()
					.filter(equipement -> equipement instanceof Epee)
					.map(equipement -> (Epee) equipement)
					.findFirst().get();

			epee.use(target);
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
}