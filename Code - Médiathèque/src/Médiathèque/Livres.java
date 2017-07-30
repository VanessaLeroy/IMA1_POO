package Médiathèque;

public class Livres  extends Ouvrage{
	private String auteurs;
	private String edition;

	public Livres(int annee, String cote, String titre, String auteurs, String edition, String genre) {
		super(annee, cote, titre, genre);
		this.auteurs = auteurs;
		this.edition = edition;
	}

	public String getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(String auteurs) {
		this.auteurs = auteurs;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public void affiche(){
		super.affiche();
		System.out.println("   Auteur(s) : " + auteurs +"'.");
		System.out.println("   Edition du livre : " + edition +"'. \n");
	}
}
