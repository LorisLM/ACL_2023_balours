package playy;

public class Objets {
	public int vie_objet;
 
}

class epee extends Objets {
	public int damage;
	
	public void Taper() {
		this.vie_objet = this.vie_objet - 1;
	}
	
}

class soin extends Objets {
	
	public void Soigner() {
		this.vie_objet = this.vie_objet - 1;
		
	}
}