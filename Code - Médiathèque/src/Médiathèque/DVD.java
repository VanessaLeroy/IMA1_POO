package Médiathèque;

public class DVD  extends Ouvrage{
	private String producteur;
	private int duree;

	public DVD(int annee, String cote, String titre, int duree, String genre, String producteur) {
		super(annee, cote, titre, genre);
		this.duree = duree;
		this.producteur = producteur;
	}

	public String getProducteur() {
		return producteur;
	}

	public void setProducteur(String producteur) {
		this.producteur = producteur;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void affiche(){
		super.affiche();
		System.out.println("   Producteur : " + producteur +".");
		System.out.println("   Durée du DVD : " + duree + " minutes. \n");
	}
}
