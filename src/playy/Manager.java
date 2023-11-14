package playy;
import playy.entity.Hero;
import playy.entity.Monstre;

import java.util.Scanner;

public class Manager {
	
	public Manager() {

	}
	
	public void start() {
		Hero pacman = new Hero();
		Monstre monstre=new Monstre();
		Malus malus = new Malus();
		Labyrinthe lab = Labyrinthe.FromFile(pacman,monstre,malus);

		while (true) {
			System.out.println(pacman);
			lab.afficher();
			System.out.println("Entrez une commande (H/G/B/D/S)+(A/H)");
			
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();


			pacman.excuteAction(Move.getMoveFromAcronyme(input), lab);


			lab.updateLab();

		}
	}
}
