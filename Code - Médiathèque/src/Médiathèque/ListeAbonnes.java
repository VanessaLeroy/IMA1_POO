package Médiathèque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

public class ListeAbonnes {
	private ArrayList <Abonnes> listeAbonne;

	public ListeAbonnes() {
		listeAbonne = new ArrayList <Abonnes>();
	}

	public boolean existe(String nom, String prenom){
		int i=0;
		for (Abonnes a : listeAbonne){
			if (a.getNom().equals(nom) && a.getPrenom().equals(prenom))
				return true;
			i++;
		}
		return false;
	}

	public void ajouterAbonne(String nom, String prenom, String adresse, int telephone, 
			String email){
		int numeroAbonne = listeAbonne.size()+1;

		Calendar d =Calendar.getInstance();
		int annee = 1+d.get(Calendar.YEAR);
		int mois = 1+d.get(Calendar.MONTH);
		String dateFinAbonnement = d.get(Calendar.DATE)+"/"+mois+"/"+annee;

		listeAbonne.add(new Abonnes(nom, prenom, adresse, telephone, email, numeroAbonne, dateFinAbonnement));
	}
	
	public Abonnes rechercheAbonne(int numeroAbonne){
		for(Abonnes a : listeAbonne) {
			if(a.getNumeroAbonne()==numeroAbonne)
				return a;
		}
		return null;
	}
	
	public int rechercheNumeroAbonne(String nom, String prenom){
		for(Abonnes a : listeAbonne) {
			if(a.getNom().equals(nom) && a.getPrenom().equals(prenom))
				return a.getNumeroAbonne();
		}
		return -1;
	}
	
	public void supprimerAbonne(int numeroAbonne){
		boolean trouvé = false;
		for (int i = 0; (i < listeAbonne.size()) && (trouvé == false); i++){
			Abonnes a = (Abonnes)listeAbonne.get(i);
			if (numeroAbonne == a.getNumeroAbonne()){
				trouvé = true;
				listeAbonne.remove(i);
			}
		}
	}

	public void affiche(){
		for (int i=0 ; i< listeAbonne.size(); i++)
			listeAbonne.get(i).affiche();
	}
	
	public void enregistrerAbonnes()throws FileNotFoundException{
		String nomFich = "sauvegardeAbonne.txt";
		PrintWriter fich = new PrintWriter (new File(nomFich));
		fich.println("Liste des Abonnés :\n			");
		for (Abonnes a : listeAbonne)
			fich.println("\nN° Abonné : " + a.getNumeroAbonne()+ "\nNom : " + a.getNom()+ "\nPrénom : "  + a.getPrenom()+ "\nAdresse : "  + a.getAdresse()+ "\nTéléphone : "  + a.getTelephone()+ "\nEmail : "  + a.getEmail()+ "\nDate Fin Abonnement : "  + a.getDateFinAbonnement()+ "\nNombre Prêt En Cours : "  + a.getNombrePretEnCours());
		fich.close();
	}
}