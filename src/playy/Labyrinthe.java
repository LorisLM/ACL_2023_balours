package playy;


public class Labyrinthe {
	public static final int TAILLE = 10;

	private int plateau [][] = new int[TAILLE][TAILLE];
	private Hero hero;
	public Monstre monstre;
	public Malus malus;
	public Labyrinthe(Hero hero,Monstre monstre, Malus malus)  {
		this.hero = hero;
	    this.monstre = monstre;
	    this.malus = malus;

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
	        }
	    }

	}

    private Labyrinthe(Hero hero,Monstre monstre,Malus malus, int[][] plateau){
        this.hero = hero;
        this.monstre=monstre;
        this.plateau = plateau;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                plateau[i][j] = 0;
                if (i == 0 || i == TAILLE - 1 || j == 0 || j == TAILLE - 1)
                    plateau[i][j] = -1;
                if (i == hero.getPosition().getY() && j == hero.getPosition().getX()) {
                    plateau[i][j] = 2;
                }
                if (i == monstre.getPosition().getY() && j == monstre.getPosition().getX()) {
                    plateau[i][j] = 9;
                }
                if (i == malus.getPosition().getY() && j == monstre.getPosition().getX()) {
	            	plateau[i][j] = 4;
	            }
            }
        }
    }
	
	public void updateLab() {

		
		    for (int i = 0; i < plateau.length; i++) {
		        for (int j = 0; j < plateau.length; j++) {
		            if (plateau[i][j] == 2 || plateau[i][j] == 9) {
		                plateau[i][j] = 0;
		            }
		        }
		    }

		    plateau[hero.getPosition().getY()][hero.getPosition().getX()] = 2;
		    plateau[monstre.getPosition().getY()][monstre.getPosition().getX()] = 9; // Mettez à jour la position du monstre

		    hero.moveHero(Move.getMoveFromAcronyme("S"), this);
		    monstre.moveMonstre(this);
		}

	
	public void afficher() {
        for (int i = 0; i < plateau.length; i++) { 
            for (int j = 0; j < plateau.length; j++) { 
                System.out.print(plateau[i][j] + "\t"); 
            } 
            System.out.println(); 
        } 
	}
	
	public void toFile() {
        for (int i = 0; i < plateau.length; i++) { 
            for (int j = 0; j < plateau.length; j++) { 
               
            } 
          
       } 
	}

    public int[][] getPlateau() {
        return plateau;
    }

    public static Labyrinthe FromFile(Hero hero, Monstre monstre, Malus malus) {
		return new Labyrinthe(hero,monstre,malus, Utilitaire.readPlateauFromFile());
	}

}
