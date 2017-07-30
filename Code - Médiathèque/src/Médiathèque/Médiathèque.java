package Médiathèque; 

import java.io.FileNotFoundException;

public class Médiathèque {
	private ListeAbonnes listAbonnes;
	private ListeArticles listArticles;
	private ListeEmprunts listEmprunts;


	public Médiathèque() {
		this.listAbonnes = new ListeAbonnes();
		this.listArticles = new ListeArticles();
		this.listEmprunts = new ListeEmprunts();
	}

	public void emprunter(String nom, String prenom, String cote){
		boolean ok = listAbonnes.existe(nom, prenom);
		if (ok){
			int numeroAbonne = listAbonnes.rechercheNumeroAbonne(nom, prenom);
			if (listArticles.rechercheOuvrage(cote).isDisponible()){
				listEmprunts.ajouterFicheEmprunt(cote, numeroAbonne);
				listAbonnes.rechercheAbonne(numeroAbonne).setNombrePretEnCours(1);
				listArticles.rechercheOuvrage(cote).setDisponible(false);
			} else
				System.out.print("Erreur : Ouvrage non disponible.");
		}	
	}

	public void retourEmprunt(String nom, String prenom, String cote){
		boolean ok = listAbonnes.existe(nom, prenom);
		if (ok){
			boolean existe = listEmprunts.existe(cote);
			if (existe){
				int numeroAbonne = listAbonnes.rechercheNumeroAbonne(nom, prenom);
				listAbonnes.rechercheAbonne(numeroAbonne).decNombrePretEnCours(1);
				listArticles.rechercheOuvrage(cote).setDisponible(true);
				listEmprunts.supprimerFicheEmprunt(cote);
			}
			else 
				System.out.println("ERREUR : La fiche emprunt n'existe pas.");
		}
		else 
			System.out.println("ERREUR : La personne n'est pas abonnée.");
	}

	public ListeAbonnes getListAbonnes() {
		return listAbonnes;
	}

	public void setListAbonnes(ListeAbonnes listAbonnes) {
		this.listAbonnes = listAbonnes;
	}

	public ListeArticles getListArticles() {
		return listArticles;
	}

	public void setListArticles(ListeArticles listArticles) {
		this.listArticles = listArticles;
	}

	public ListeEmprunts getListEmprunts() {
		return listEmprunts;
	}

	public void setListEmprunts(ListeEmprunts listEmprunts) {
		this.listEmprunts = listEmprunts;
	}

	public void enregistrerDonnes() throws FileNotFoundException{
		listAbonnes.enregistrerAbonnes();
		listArticles.enregistrerArticle();
		listEmprunts.enregistrerArticle();
	}
}