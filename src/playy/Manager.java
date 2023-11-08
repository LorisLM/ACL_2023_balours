package playy;
import java.util.Scanner;

public class Manager {
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		Hero pacman = new Hero();
		Labyrinthe lab = new Labyrinthe(pacman);

		while (true) {
			System.out.println(pacman);
			lab.afficher();
			System.out.println("Entrez une commande (H/G/B/D/S)");
			
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();
			
			pacman.moveHero(Move.getMoveFromAcronyme(input));
			lab.updateLab();

		}
	}
}
