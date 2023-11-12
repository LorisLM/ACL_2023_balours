package playy;
import java.util.Scanner;

public class Manager {
	
	public Manager() {

	}
	
	public void start() {
		Hero pacman = new Hero();
		Monstre monstre=new Monstre();
		Labyrinthe lab = Labyrinthe.FromFile(pacman,monstre);

		while (true) {
			System.out.println(pacman);
			lab.afficher();
			System.out.println("Entrez une commande (H/G/B/D/S)");
			
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();


			pacman.moveHero(Move.getMoveFromAcronyme(input), lab);


			lab.updateLab();

		}
	}
}
