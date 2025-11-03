package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	

	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village=village;
	}

	public String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	public void frapper(Romain romain) {
		System.out.println(nom + "envoie un grand coup dans la machoire de" + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	public void boirePotion(int forcePotion) {
        this.effetPotion = forcePotion;
    }
	
	
	 public void sePresenter() {
	        String message;
	        if (village != null && village.getChef() == this) {
	            message = "Bonjour, je m'appelle " + nom + ". Je suis le chef du village " + village.getNom() + ".";
	        } else if (village != null) {
	            message = "Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".";
	        } else {
	            message = "Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.";
	        }
	        parler(message);
	   }
	 
	public String toString() {
		return "Gaulois [nom=" + nom + "force=" + force + "effetPotion=" + effetPotion + "]";
	}
}
