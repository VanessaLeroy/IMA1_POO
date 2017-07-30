package Médiathèque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListeEmprunts {
	private ArrayList <FicheEmprunt> listeEmprunt;

	public ListeEmprunts() {
		listeEmprunt = new ArrayList <FicheEmprunt>();
	}
	
	public void ajouterFicheEmprunt(String cote, int numeroAbonne){
		int i=0;
		while(i<listeEmprunt.size() && listeEmprunt.get(i).getCote().equals(cote)){
			i++;
		}
		if (i<listeEmprunt.size() && listeEmprunt.get(i).getCote().equals(cote))
			System.out.println("Cet ouvrage est déjà emprunter.");
		else{ 
			Calendar d =Calendar.getInstance();
			int mois = 1+d.get(Calendar.MONTH);
			String dateEmprunt = d.get(Calendar.DATE)+"/"+mois+"/"+d.get(Calendar.YEAR);
			listeEmprunt.add(new FicheEmprunt(cote, dateEmprunt, numeroAbonne));
		} 
	}
	
	public  FicheEmprunt rechercheFicheParAbonne(int num){
		for(FicheEmprunt a : listeEmprunt) {
			if(a.getNumeroAbonne()==num)
				return a;
		}
		return null;
	}

	public FicheEmprunt rechercheFicheParOuvrage(String cote){
		for(FicheEmprunt a : listeEmprunt) {
			if(a.getCote().equals(cote))
				return a;
		}
		return null;
	}
	
	public boolean existe(String cote){
		int i=0;		
		for (FicheEmprunt fiche : listeEmprunt){
			if (fiche.getCote().equals(cote))
				return true;
			i++;
		}
		return false;
	}
	
	public void supprimerFicheEmprunt(String cote){
		for(FicheEmprunt fiche : listeEmprunt)
			if (fiche.getCote()==cote)
				listeEmprunt.remove(fiche);
	}
	
	public void alarme(){
		for (FicheEmprunt emprunt : listeEmprunt){
			String[] dateFin = emprunt.getDateFinEmprunt();
			Date dateFinEmprunt = new Date(Integer.parseInt(dateFin[2]),Integer.parseInt(dateFin[1]),Integer.parseInt(dateFin[0]));
			Calendar d = Calendar.getInstance();
			if (dateFinEmprunt.before(d.getTime()))
				emprunt.affiche();
		}
	}
	
	public void affiche(){
		for (int i=0 ; i< listeEmprunt.size(); i++)
			listeEmprunt.get(i).affiche();
	}
	
	public void enregistrerArticle()throws FileNotFoundException{
		String nomFich = "sauvegardeEmprunt.txt";
		PrintWriter fich = new PrintWriter (new File(nomFich));
		fich.println("Liste des Emprunts :\n");
		for (FicheEmprunt e : listeEmprunt)
			fich.println("\nNuméro de l'abonné : " + e.getNumeroAbonne() + "\nCôte de l'article : " + e.getCote() + "\nDate de l'emprunt : " + e.getDateEmprunt() + "\nDate de fin de l'emprunt : " + e.getDateFinEmprunt());
		fich.close();
	}
}	