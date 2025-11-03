package personnages;
import objets.Equipement;
public class Romain {
	 private String nom;
	 private int force;
	 private Equipement[] equipements = new Equipement[2];
	  private int nbEquipement = 0;
	 public Romain(String nom, int force) {
		 this.nom = nom;
		 this.force = force;
		 verifierInvariant();
	 }
	 
	 public String getNom() {
		 return nom;
	 }
	 public String prendreParole() {
		 return "Le romain " + nom + " : ";
	 }
	 public void parler(String texte) {
		 System.out.println(prendreParole() + "« " + texte + " »");
	 }
	 
	 private void verifierInvariant() {
        assert force >= 0 : "La force d'un Romain doit être positive ou nulle";
	 }
	 
	 public void recevoirCoup(int forceCoup) {
		 assert force >= 0;
		 int forceAvant = force;
		 force -= forceCoup;
		 if (force > 0) {
			 parler("Aie !");
		 } else {
			 parler("J'abandonne...");
		 }
		 assert force < forceAvant;
		 verifierInvariant();
	 }
	 
	 private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.getNom() + ".");
    }
	 
	 public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 0:
                ajouterEquipement(equipement);
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement.getNom() + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            default:
                break;
        }
    }
	 
	 public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		 
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
		
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
	}
	 
	 
}
