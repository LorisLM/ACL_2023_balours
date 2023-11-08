package playy;


public enum Move {
	HAUT("H", 0,-1), GAUCHE("G",-1,0), BAS("B",0,1), DROITE("D",1,0), STAY("S",0,0);
	
	private Move(String acronyme, int x, int y) {
		this.acronyme = acronyme;
		this.x = x;
		this.y =y;
	}
	
	public static Move getMoveFromAcronyme(String input) {
		for(Move move  : Move.values()) {
			if (input.equalsIgnoreCase(move.acronyme))
				return  move;
		}
		return STAY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private String acronyme;
	private int x,y;
}
