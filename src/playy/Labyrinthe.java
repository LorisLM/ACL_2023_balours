package playy;


public class Labyrinthe {
	public static final int TAILLE = 10;

	private int plateau [][] = new int[TAILLE][TAILLE];
	private Hero hero;
	public Labyrinthe(Hero hero)  {
		this.hero = hero;
        for (int i = 0; i < plateau.length; i++) { 
            for (int j = 0; j < plateau.length; j++) { 
                plateau[i][j] = 0;
                if (i == 0 || i==TAILLE-1 || j==0 || j==TAILLE-1)
                    plateau[i][j] = -1;
                if (i == hero.getPosition().getY() && j == hero.getPosition().getX()) {
                    plateau[i][j] = 2;

                }
            } 
        }

	}

    private Labyrinthe(Hero hero, int[][] plateau){
        this.hero = hero;
        this.plateau = plateau;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                if (i == hero.getPosition().getY() && j == hero.getPosition().getX()) {
                    plateau[i][j] = 2;

                }
            }
        }
    }
	
	public void updateLab() {

        for (int i = 0; i < plateau.length; i++) { 
            for (int j = 0; j < plateau.length; j++) { 
                if (plateau[i][j] == 2) {
                	plateau[i][j] = 0;
                }                
            } 
        }
    	plateau[hero.getPosition().getY()][hero.getPosition().getX()] = 2;


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

    public static Labyrinthe FromFile(Hero hero) {
		return new Labyrinthe(hero, Utilitaire.readPlateauFromFile());
	}

}
