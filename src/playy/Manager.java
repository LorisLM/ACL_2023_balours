package playy;
import playy.entity.Hero;
import playy.equipement.Tresor;
import playy.entity.Monstre;

import java.util.Scanner;

public class Manager {
	private Interface InterfaceJeu;

	public Manager() {
		this.InterfaceJeu = new Interface(new int[10][10]);
	}
	
	public void start() {
		Hero pacman = new Hero();
		Monstre monstre=new Monstre();
		Malus malus = new Malus();
		Tresor tresor = new Tresor();
		Labyrinthe lab = Labyrinthe.FromFile(tresor, pacman,monstre,malus);

		while (!(tresor.flag)) {
			System.out.println(pacman);
			lab.afficher();
			InterfaceJeu.MAJPlateauJeu(lab.getPlateau());
            		InterfaceJeu.AfficherJeu();

			System.out.println("Entrez une commande (H/G/B/D/S)+(A/H)");
			
			Scanner keyboard = new Scanner(System.in);
			String input = keyboard.nextLine();


			pacman.excuteAction(Move.getMoveFromAcronyme(input), lab);


			lab.updateLab();
			if (tresor.getPosition().getY() == pacman.getPosition().getY() && tresor.getPosition().getX() == pacman.getPosition().getX()) {
                tresor.Gagner();
                System.out.println("Vous avez gagné !");
			}
		}
	}
}