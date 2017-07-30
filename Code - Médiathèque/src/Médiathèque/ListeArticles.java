package Médiathèque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListeArticles {
	private ArrayList <Ouvrage>listeArticle;

	public ListeArticles() {
		listeArticle = new ArrayList <Ouvrage>();

		CD pinkfloyd = new CD(1975,"c0","dark side of the moon",15,"rock","roger/waters",10);
		CD rancid = new CD(2003,"c1","indestructuble",19,"punk","tim/armstrong",19);

		DVD valkyrie = new DVD(2007,"d0","Valkyrie",150,"historique","william");
		DVD Charlieetlachocolatrie=new DVD(2006,"d1","Charlie et la chocolatrie",154,"animation","tim/burton");

		Livres lasvegasparano = new Livres (1979,"l0","las vegas parano","hunterSthompson","machin chose","drogue");
		Livres lordofthering = new Livres (1959,"l1","lord of the ring","tolkien","achette","fantasy");

		listeArticle.add(pinkfloyd);
		listeArticle.add(rancid);
		listeArticle.add(valkyrie);
		listeArticle.add(Charlieetlachocolatrie);
		listeArticle.add(lasvegasparano);
		listeArticle.add(lordofthering);
	}

	public boolean existe(String titre){
		int i=0;
		for (Ouvrage ouvrage : listeArticle){
			if (ouvrage.getTitre().equals(titre))
				return true;
			i++;
		}
		return false;
	}

	public void ajouterLivre(int annee, String titre, String auteurs, String edition, String genre){
		if (existe(titre))
			System.out.println("Ce titre existe déjà");
		else{ 
			String cote = "l"+listeArticle.size();
			listeArticle.add(new Livres(annee,cote,titre,auteurs, edition,genre));

		} 
	}

	public void ajouterCD(int annee,String titre, int duree, String genre, String interprete, 
			int nombreChansons){
		if (existe(titre))
			System.out.println("Ce titre existe déjà.");
		else{ 
			String cote = "c"+listeArticle.size();//il ne faut pas prendre la listeAreticle mais la liste du CD
			listeArticle.add(new CD(annee,cote,titre, duree, genre,interprete, nombreChansons));
		} 
	}

	public void ajouterDVD(int annee, String titre, int duree, String genre, String producteur){
		if (existe(titre))
			System.out.println("Ce titre existe déjà.");
		else{ 
			String cote = "d"+listeArticle.size();
			listeArticle.add(new DVD(annee,cote, titre,duree, genre, producteur));
		} 
	}

	public Ouvrage rechercheOuvrage(String cote){
		int i=0;
		for (Ouvrage ouvrage : listeArticle){
			if (ouvrage.getCote().equals(cote))
				return listeArticle.get(i);
			i++;
		}
		return null;
	}

	public Ouvrage rechercheOuvrageTitre(String titre){
		for (Ouvrage ouvrage : listeArticle){
			if (ouvrage.getTitre().equals(titre))
				return ouvrage;
		}
		return null;
	}

	public Livres rechercheOuvrageAuteur(String auteur){
		int i=0;
		while(i< listeArticle.size() && !listeArticle.get(i).getAuteur().equals(auteur))
			i++;
		if (listeArticle.get(i) instanceof Livres)
			return (Livres)listeArticle.get(i);
		else 
			return null;
	}

	public CD rechercheOuvrageInterprete(String interprete){
		int i=0;
		while(i< listeArticle.size() && listeArticle.get(i).equals(interprete))
			i++;
		if (listeArticle.get(i) instanceof CD)
			return (CD)listeArticle.get(i);
		else 
			return null;
	}

	public DVD rechercheOuvrageProducteur(String producteur){

		int i=0;
		while(i< listeArticle.size() && listeArticle.get(i).equals(producteur))
			i++;
		if (listeArticle.get(i) instanceof DVD)
			return (DVD)listeArticle.get(i);
		else 
			return null;
	}

	public void supprimerOuvrage (String cote){
		boolean trouvé = false;
		for (int i = 0; i < listeArticle.size() && trouvé == false; i++){
			Ouvrage o = (Ouvrage)listeArticle.get(i);
			if (cote.equals(o.getCote())){
				trouvé = true;
				listeArticle.remove(i);
			}
		}
	}

	public void affiche(){
		for (int i=0 ; i< listeArticle.size(); i++)
			listeArticle.get(i).affiche();
	}

	public void afficheCD() {
		int i=0;
		for (Ouvrage ouvrage : listeArticle){
			if(ouvrage instanceof CD)
				listeArticle.get(i).affiche();
			i++;	
		}	
	}

	public void afficheDVD() {
		int i=0;
		for (Ouvrage ouvrage : listeArticle){
			if(ouvrage instanceof DVD)
				listeArticle.get(i).affiche();
			i++;	
		}
	}

	public void afficheLivre() {
		int i=0;
		for (Ouvrage ouvrage : listeArticle){
			if(ouvrage instanceof Livres)
				listeArticle.get(i).affiche();
			i++;	
		}
	}
	public void enregistrerArticle()throws FileNotFoundException{
		String nomFich = "sauvegardeArticle.txt";
		PrintWriter fich = new PrintWriter (new File(nomFich));
		fich.println("Liste des Articles :\n");
		for (Ouvrage o : listeArticle){
			if (o instanceof Livres)
				fich.println("\nCôte : " + o.getCote() + "\nTitre : " + o.getTitre() + "\nAuteur : " + o.getAuteur() + "\nAnnée de parution : " + o.getAnnee() + "\nGenre : " + o.getGenre() + "\nDisponible : " + o.isDisponible());
			if (o instanceof CD)
				fich.println("\nCôte : " + o.getCote() + "\nTitre : " + o.getTitre() + "\nInterprète : " + o.getInterprete() + "\nAnnée de parution : " + o.getAnnee() + "\nGenre : " + o.getGenre() + "\nDisponible : " + o.isDisponible() + "\nNombre de chansons : " + "\nDurée du CD : ");
			if (o instanceof DVD)
				fich.println("\nCôte : " + o.getCote() + "\nTitre : " + o.getTitre() + "\nProducteur : " + o.getProducteur() + "\nAnnée de parution : " + o.getAnnee() + "\nGenre : " + o.getGenre() + "\nDisponible : " + o.isDisponible() + "\nDurée du DVD : ");				
		}
		fich.close();
	}
}