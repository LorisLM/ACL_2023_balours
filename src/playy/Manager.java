package playy;
import playy.action.Action;
import playy.entity.*;
import playy.action.Move;
import playy.entity.Hero;
import playy.equipement.Tresor;
import playy.entity.Monstre;
import playy.Labyrinthe;
import playy.Manager;
import playy.Position;

import java.util.Scanner;

public class Manager {
	private Interface InterfaceJeu;
	private static Manager manager;
	public Manager() {
		this.InterfaceJeu = new Interface(new int[10][10]);
	}
	private Hero pacman;
	private Monstre monstre;
	private Malus malus;
	private Tresor tresor;
	private Portal portala;
	private Portal portalb;
	private Labyrinthe lab;
	private Fantom fantom;
	private int x;
	public void start() {
		manager = this;
		pacman = new Hero();
		monstre=new Monstre(Position.InitPosition());
		fantom=new Fantom(Position.InitPosition());
		malus = new Malus();
		tresor = new Tresor();
		portala = new Portal();
		portalb = new Portal();
		lab = Labyrinthe.FromFile(tresor, pacman,monstre,malus, portala, portalb, fantom);
		InterfaceJeu.AfficherJeu();

		while (!tresor.flag) {

			System.out.println(pacman);
			lab.afficher();
			InterfaceJeu.MAJPlateauJeu(lab.getPlateau());
			InterfaceJeu.afficherLabyrinthe();
			System.out.println("Entrez une commande (H/G/B/D/S)+(A/E)");
			
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();


			pacman.executeAction(Action.getActionFromAcronyme(input));


			lab.updateLab();
			if (tresor.getPosition().getY() == pacman.getPosition().getY() && tresor.getPosition().getX() == pacman.getPosition().getX()) {
                tresor.gagner();
                System.out.println("Vous avez gagné !");
				break;
			}
			
			if (portala.getPosition().getY() == pacman.getPosition().getY() && portala.getPosition().getX() == pacman.getPosition().getX()) {
				Move.TP2();
			}
			
			if (portalb.getPosition().getY() == pacman.getPosition().getY() && portalb.getPosition().getX() == pacman.getPosition().getX()) {
				Move.TP1();
			}
		}
	}

	public static Manager getManager() {
		return manager;
	}

	public Hero getPacman() {
		return pacman;
	}

	public Labyrinthe getLab() {
		return lab;
	}

	public Monstre getMonstre() {
		return monstre;
	}
	public Portal getPortala() {
		return portala;
	}
	public Portal getPortalb() {
		return portalb;
	}

}