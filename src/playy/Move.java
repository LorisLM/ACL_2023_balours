package playy;


public enum Move {
	HAUT("H"), GAUCHE("G"), BAS("B"), DROITE("D"), STAY("S");
	
	private Move(String acronyme) {
		this.acronyme = acronyme;
	}
	
	public static Move getMoveFromAcronyme(String input) {
		for(Move move  : Move.values()) {
			if (input.equalsIgnoreCase(move.acronyme))
				return  move;
		}
		return STAY;
	}
	
	private String acronyme;
}
