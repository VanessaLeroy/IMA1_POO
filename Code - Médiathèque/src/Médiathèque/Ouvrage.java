package Médiathèque;

public class Ouvrage{
	private String cote;
	private String titre;
	private int annee;
	private String genre;
	private boolean disponible;

	public Ouvrage(int annee, String cote, String titre, String genre) {
		this.annee = annee;
		this.cote = cote;
		this.titre = titre;
		this.genre = genre;
		this.disponible = true;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getCote() {
		return cote;
	}

	public void setCote(String cote) {
		this.cote = cote;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public void affiche(){
		System.out.println("   Côte de l'article : " + cote + ".");
		System.out.println("   Titre : " + titre + ".");
		System.out.println("   Année de parution : " + annee + ".");
		System.out.println("   Genre de l'article : " + genre + ".");
	}

	public String getAuteur() {
		return ((Livres) this).getAuteurs();
	}

	public String getInterprete() {
		return ((CD) this).getInterprete();
	}
	
	public String getProducteur() {
		return ((CD) this).getProducteur();
	}
}
