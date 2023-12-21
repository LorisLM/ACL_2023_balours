package playy;
import playy.entity.*;
import playy.action.*;

import playy.action.Action;
import playy.action.Move;
import playy.entity.Hero;
import playy.entity.Monstre;
import playy.equipement.Tresor;

public class Labyrinthe {
	public static final int TAILLE = 34;

	private int plateau [][] = new int[TAILLE][TAILLE];
	private Hero hero;
	public Monstre monstre;
	public Malus malus;
	public Tresor tresor;
	public Portal portala;
	public Portal portalb;
	public Fantom fantom;
	
	public Labyrinthe(Tresor tresor, Hero hero,Monstre monstre, Malus malus, Portal portala, Portal portalb,Fantom fantom)  {
		this.hero = hero;
	    this.monstre = monstre;
	    this.malus = malus;
	    this.tresor = tresor;
	    this.portala = portala;
	    this.portala = portalb;
	    this.fantom=fantom;

	    for (int i = 0; i < plateau.length; i++) {
	        for (int j = 0; j < plateau.length; j++) {
	            plateau[i][j] = 0;
	            if (i == 0 || i == TAILLE - 1 || j == 0 || j == TAILLE - 1)
	                plateau[i][j] = -1;
	            if (i == hero.getPosition().getY() && j == hero.getPosition().getX()) {
	                plateau[i][j] = 2;
	            }
	            if (i == monstre.getPosition().getY() && j == monstre.getPosition().getX()) {
	                plateau[i][j] = 3;
	            }
	            if (i == malus.getPosition().getY() && j == malus.getPosition().getX()) {
	            	plateau[i][j] = 4;
	            }
	            if (i == tresor.getPosition().getY() && j == tresor.getPosition().getX()) {
	            	plateau[i][j] = 7;
	            }
	            if (i == portala.getPosition().getY() && j == portala.getPosition().getX() && plateau[i][j] != 0) {
	            	plateau[i][j] = 8;
	            }
	            if (i == portalb.getPosition().getY() && j == portalb.getPosition().getX() && plateau[i][j] != 0) {
	            	plateau[i][j] = 8;
	            }
	            if (i == fantom.getPosition().getY() && j == fantom.getPosition().getX() && plateau[i][j] != 0) {
	            	plateau[i][j] = 8;
	            }
	            
	        }
	    }

	}

    private Labyrinthe(Tresor tresor,Hero hero,Monstre monstre,Malus malus,Portal portala, Portal portalb,Fantom fantom, int[][] plateau){
        this.hero = hero;
        this.monstre=monstre;
        this.plateau = plateau;
	    this.tresor = tresor;
	    this.plateau = plateau;
	    this.portala = portala;
	    this.portalb = portalb;
	    this.fantom=fantom;
	    
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                if (i == hero.getPosition().getY() && j == hero.getPosition().getX()) {
                    plateau[i][j] = 2;
                }
                if (i == monstre.getPosition().getY() && j == monstre.getPosition().getX()) {
                    plateau[i][j] = 9;
                }
                if (i == malus.getPosition().getY() && j == monstre.getPosition().getX()) {
	            	plateau[i][j] = 4;
	            }
                if (i == tresor.getPosition().getY() && j == tresor.getPosition().getX()) {
	            	plateau[i][j] = 7;
	            }
                if (i == portala.getPosition().getY() && j == portala.getPosition().getX()) {
	            	plateau[i][j] = 8;
	            }
                if (i == portalb.getPosition().getY() && j == portalb.getPosition().getX()) {
	            	plateau[i][j] = 8;
	            }
                if (i == fantom.getPosition().getY() && j == fantom.getPosition().getX() ) {
	            	plateau[i][j] = 3;
	            }
            }
        }
    }

	/*
	Actualise la position de toutes les entités présentes sur le labyrinthe
	 */
	public void updateLab() {
		    for (int i = 0; i < plateau.length; i++) {
		        for (int j = 0; j < plateau.length; j++) {
		            if (plateau[i][j] == 2 || plateau[i][j] == 9 || plateau[i][j]==3) {
		                plateau[i][j] = 0;
		            }
		            if (i == portala.getPosition().getY() && j == portala.getPosition().getX() && plateau[i][j] != 2) {
		            	plateau[i][j] = 8;
		            }
	                if (i == portalb.getPosition().getY() && j == portalb.getPosition().getX() && plateau[i][j] != 2) {
		            	plateau[i][j] = 8;
		            }
	                if (i == portalb.getPosition().getY() && j == portalb.getPosition().getX() && plateau[i][j] != 2) {
		            	plateau[i][j] = 8;
		            }
		        }
		    }

		    plateau[hero.getPosition().getY()][hero.getPosition().getX()] = 2;
			if (monstre.getLife() > 0){
				plateau[monstre.getPosition().getY()][monstre.getPosition().getX()] = 9;
				monstre.moveMonstre(this);
			}
			if (fantom.getLife() > 0){
				plateau[fantom.getPosition().getY()][fantom.getPosition().getX()] = 3;
				fantom.moveFantom(this, hero);
			}

		    hero.executeAction(Action.getActionFromAcronyme("S"));
		}

	/*
	Afficher le labyrinthe sous forme de matrice
	 */
	public void afficher() {
        for (int i = 0; i < plateau.length; i++) { 
            for (int j = 0; j < plateau.length; j++) { 
                System.out.print(plateau[i][j] + "\t"); 
            } 
            System.out.println(); 
        } 
	}


	public int[][] getPlateau() {
		return plateau;
	}
	
	/*
	Creee un labyrinthe Ã  partir d'un fichier
	 */
	public static Labyrinthe FromFile(Tresor tresor, Hero hero, Monstre monstre, Malus malus, Portal a, Portal b, Fantom fantom) {
		return new Labyrinthe(tresor, hero,monstre,malus, a, b, fantom, Utilitaire.readPlateauFromFile());
	}

}
