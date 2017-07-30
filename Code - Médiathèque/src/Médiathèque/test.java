package M�diath�que;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	private static Scanner clavier = new Scanner(System.in);
	private static M�diath�que mediatheque = new M�diath�que();
	public static ListeAbonnes listAbonne = mediatheque.getListAbonnes();
	public static ListeArticles listArticle = mediatheque.getListArticles();
	public static ListeEmprunts listEmprunt = mediatheque.getListEmprunts();

	public static void main(String[] args) {
		System.out.println("Bienvenue dans notre m�diath�que\n");
		menu();
	}

	public static void menu(){
		System.out.println("\nPlusieurs choix s'offrent � vous : Que voulez-vous faire?");
		System.out.println("   Tapez 1 pour Ajouter un abonn�.");
		System.out.println("   Tapez 2 pour Ajouter un livre.");
		System.out.println("   Tapez 3 pour Ajouter un CD.");
		System.out.println("   Tapez 4 pour Ajouter un DVD.");
		System.out.println("   Tapez 5 pour Emprunter un livre.");
		System.out.println("   Tapez 6 pour Emprunter un CD.");
		System.out.println("   Tapez 7 pour Emprunter un DVD.");		
		System.out.println("   Tapez 8 pour Rechercher un abonn�.");
		System.out.println("   Tapez 9 pour Rechercher un livre.");
		System.out.println("   Tapez 10 pour Rechercher un CD.");
		System.out.println("   Tapez 11 pour Rechercher un DVD.");
		System.out.println("   Tapez 12 pour Rechercher une fiche emprunt.");
		System.out.println("   Tapez 13 pour Supprimer un abonn�.");
		System.out.println("   Tapez 14 pour Supprimer un Ouvrage.");
		System.out.println("   Tapez 15 pour Retourner un Ouvrage.");
		System.out.println("   Tapez 16 pour Afficher la liste des Abonn�s.");
		System.out.println("   Tapez 17 pour Afficher la liste des Emprunts.");
		System.out.println("   Tapez 18 pour Afficher la liste des Articles.");
		System.out.println("   Tapez 19 pour Afficher la liste des Emprunts en retard.");
		System.out.println("   Tapez 20 pour Quitter le programme.");

		int choix = clavier.nextInt();

		switch(choix){
		case 1 : ajouterAbonne();
		break;
		case 2 : ajouterLivre();
		break;		
		case 3 : ajouterCD();
		break;
		case 4 : ajouterDVD();
		break;
		case 5 : emprunterLivre();
		break;
		case 6 : emprunterCD();
		break;
		case 7 : emprunterDVD();
		break;
		case 8 : rechercherAbonne();
		break;
		case 9 : rechercherLivre();
		break;
		case 10 : rechercherCD();
		break;
		case 11 : rechercherDVD();
		break;
		case 12 : rechercherFicheEmprunt();
		break;
		case 13 : supprimerAbonne();
		break;
		case 14 : supprimerOuvrage();
		break;
		case 15 : supprimerFicheEmprunt();
		break;
		case 16 : afficherAbonne();
		break;
		case 17 : afficherEmprunt();
		break;
		case 18 : afficherArticle();
		break;
		case 19 : afficherAlarme();
		break;
		case 20: 
			try {
				mediatheque.enregistrerDonnes();
				System.out.println("Enregistrement des donn�es r�ussi !");
			} catch (FileNotFoundException e) {
				System.out.println("Erreur lors de l'enregistrement des donn�es !");
			}
			System.exit(0);
			break;
		default : System.out.print("Choix incorrect !!! Veuillez saisir un des num�ros qui s'offrent � vous.\n");
		menu();
		break;
		}	
	}

	public static void ajouterAbonne(){
		System.out.println("\nVous avez choisi d'ajouter un abonn� : \n");	
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est son nom (s�parer chaque mot avec un /) ?");
			String nom = clavier.next();
			System.out.println(" Quel est son pr�nom (s�parer chaque mot avec un /) ?");
			String prenom = clavier.next();
			System.out.println(" Quel est son adresse (s�parer chaque mot avec un /) ?");
			String adresse = clavier.next();
			System.out.println(" Quel est son num�ro de t�l�phone ?");
			int telephone = clavier.nextInt();
			System.out.println(" Quel est son email ?");
			String email = clavier.next();

			if (listAbonne.existe(nom, prenom)== true)
				System.out.println("La personne existe d�j�. Veuillez entrer un autre nom.\n");
			else {
				listAbonne.ajouterAbonne(nom, prenom, adresse, telephone, email);
				int num = listAbonne.rechercheNumeroAbonne(nom, prenom);

				System.out.println("\nVoici le r�capitulatif des donn�es de l'abonn� : ");
				System.out.println("   Num�ro d'abonn� : " + num + ".");
				System.out.println("   Nom : " + nom + ".");
				System.out.println("   Pr�nom : " + prenom + ".");
				System.out.println("   T�l�phone : " + telephone + ".");
				System.out.println("   Email : " + email + ".");
				System.out.println("   Date de fin d'abonnement : " + listAbonne.rechercheAbonne(num).getDateFinAbonnement() + ". \n");

				System.out.println("Ces donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
				boolean juste = clavier.nextBoolean();
				if (juste == true)
					exact = true;
				else
					exact = false;
			}
		}
		System.out.println ("L'abonn� a bien �t� enregistr�.");
		menu();
	}

	public static void ajouterLivre(){
		System.out.println("\nVous avez choisi d'ajouter un livre : \n");
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est l'auteur (s�parer chaque mot avec un /) ?");
			String auteur = clavier.next();		
			System.out.println(" Quel est le titre (s�parer chaque mot avec un /) ?");
			String titre = clavier.next();
			System.out.println(" Quel est le genre (s�parer chaque mot avec un /) ?");
			String genre = clavier.next();
			System.out.println(" Quel est l'ann�e de parution ?");
			int annee = clavier.nextInt();			
			System.out.println(" Quel est l'�dition ?");
			String edition = clavier.next();

			if(listArticle.existe(titre) == true)
				System.out.println("Ce livre existe d�j�. Veuillez entrer un titre diff�rent.");
			else{	
				listArticle.ajouterLivre(annee,titre,auteur, edition,genre);

				System.out.println("\nVoici le r�capitulatif des donn�es du livre :");
				System.out.println("   C�te du livre : " + listArticle.rechercheOuvrageTitre(titre).getCote() + ".");
				System.out.println("   Auteur(s): " + auteur +".");			
				System.out.println("   Titre : " + titre + ".");
				System.out.println("   Genre : " + genre + ".");
				System.out.println("   Edition : " + edition + ".");
				System.out.println("   Ann�e de parution : " + annee + ".");

				System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
				boolean juste = clavier.nextBoolean();
				if (juste == true)
					exact = true;
				else
					exact = false;
			}
		}
		System.out.println ("Le livre a bien �t� enregistr�.");
		menu();
	}

	public static void ajouterCD(){
		System.out.println("\nVous avez choisi d'ajouter un CD : \n ");
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est le titre (s�parer chaque mot avec un /) ?");
			String titre = clavier.next();
			System.out.println(" Quel est l'interpr�te (s�parer chaque mot avec un /) ?");
			String interprete = clavier.next();
			System.out.println(" Quel est le genre (s�parer chaque mot avec un /) ?");
			String genre = clavier.next();
			System.out.println(" Quel est l'ann�e de parution ?");
			int annee = clavier.nextInt();			
			System.out.println(" Quel est le nombre de chansons ?");
			int nombreChansons = clavier.nextInt();
			System.out.println(" Quel est la dur�e totale du CD (nombre de minutes) ?");
			int duree = clavier.nextInt();	

			if(listArticle.existe(titre) == true)
				System.out.println("\nCe CD existe d�j�. Veuillez entrer un titre diff�rent.\n");
			else{
				listArticle.ajouterCD(annee,titre, duree, genre,interprete, nombreChansons);

				System.out.println("\nVoici le r�capitulatif des donn�es du CD :");
				System.out.println("   C�te du CD : " + listArticle.rechercheOuvrageTitre(titre).getCote() + ".");
				System.out.println("   Interpr�te(s) : " + interprete +".");			
				System.out.println("   Titre : " + titre + ".");
				System.out.println("   Genre : " + genre + ".");				
				System.out.println("   Ann�e de sorti : " + annee + ".");
				System.out.println("   Dur�e du CD : " + duree + " minutes.");
				System.out.println("   Nombre de chansons : " + nombreChansons + ".");

				System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
				boolean juste = clavier.nextBoolean();
				if (juste == true)
					exact = true;
				else
					exact = false;
			}
		}
		System.out.println ("Le CD a bien �t� enregistr�.");
		menu();
	}

	public static void ajouterDVD(){
		System.out.println("\nVous avez choisi d'ajouter un DVD : \n ");		
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est le titre (s�parer chaque mot avec un /) ?");
			String titre = clavier.next();
			System.out.println(" Quel est le producteur (s�parer chaque mot avec un /) ?");
			String producteur = clavier.next();			
			System.out.println(" Quel est le genre (s�parer chaque mot avec un /) ?");
			String genre = clavier.next();
			System.out.println(" Quel est l'ann�e de parution ?");
			int annee = clavier.nextInt();			
			System.out.println(" Quel est la dur�e du DVD (nombre de minutes) ?");
			int duree = clavier.nextInt();

			if(listArticle.existe(titre) == true)
				System.out.println("\nCe DVD existe d�j�. Veuillez entrer un titre diff�rent.\n");
			else{
				listArticle.ajouterDVD(annee, titre,duree, genre, producteur);

				System.out.println("\nVoici le r�capitulatif des donn�es du CD : \n");
				System.out.println("   C�te du DVD : " + listArticle.rechercheOuvrageTitre(titre).getCote() + ".");
				System.out.println("   Producteur(s) : " + producteur +".");			
				System.out.println("   Titre : " + titre + ".");
				System.out.println("   Genre : " + genre + ".");
				System.out.println("   Ann�e de sorti : " + annee + ".");
				System.out.println("   Dur�e du DVD : " + duree + " minutes.");

				System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
				boolean juste = clavier.nextBoolean();
				if (juste == true)
					exact = true;
				else
					exact = false;
			}
		}
		System.out.println ("Le DVD a bien �t� enregistr�.");
		menu();
	}

	public static void emprunterLivre(){
		System.out.println("\nVous avez choisi d'emprunter un livre : \n");
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est la c�te du livre que vous souhaitez emprunter ?");
			String cote = clavier.next();
			System.out.println(" Quel est le nom de l'abonn� souhaitant emprunter ?");
			String nom = clavier.next();
			System.out.println(" Quel est le pr�nom de l'abonn� souhaitant emprunter ?");
			String prenom = clavier.next();		

			mediatheque.emprunter(nom, prenom, cote);

			System.out.println("\nVoici le r�capitulatif de la fiche emprunt : ");
			System.out.println("   *Num�ro d'abonn� de l'emprunteur : " + listAbonne.rechercheNumeroAbonne(nom, prenom) + ". \n   *Son nom : "+ nom + ". \n   *Son pr�nom : "+ prenom + ".");
			System.out.println("   -Cc�te du livre emprunt� : " + cote + ". \n   -Auteur du livre : "+ listArticle.rechercheOuvrage(cote).getAuteur() +". \n   -Titre du livre : "+listArticle.rechercheOuvrage(cote).getTitre() +".");	
			System.out.println("   Date d'emprunt : " + listEmprunt.rechercheFicheParOuvrage(cote).getDateEmprunt() + ".");
			System.out.println("   Date de retour de l'emprunt : " + listEmprunt.rechercheFicheParOuvrage(cote).dateFinEmprunt() +".");

			System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
			boolean juste = clavier.nextBoolean();
			if (juste == true)
				exact = true;
			else
				exact = false;
		}
		System.out.println ("L'emprunt du livre a bien �t� enregistr�.");
		menu();
	}

	public static void emprunterCD(){
		System.out.println("\nVous avez choisi d'emprunter un CD : \n");
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est la c�te du CD que vous souhaitez emprunter ?");
			String cote = clavier.next();
			System.out.println(" Quel est le nom de l'abonn� souhaitant emprunter ?");
			String nom = clavier.next();
			System.out.println(" Quel est le pr�nom de l'abonn� souhaitant emprunter ?");
			String prenom = clavier.next();	

			mediatheque.emprunter(nom, prenom, cote);

			System.out.println("\nVoici le r�capitulatif de la fiche emprunt : ");
			System.out.println("   *Num�ro d'abonn� de l'emprunteur : " + listAbonne.rechercheNumeroAbonne(nom, prenom) + ". \n   *Son nom : "+ nom + ". \n   *Son pr�nom : "+ prenom + ".");
			System.out.println("   -C�te du CD emprunt� : " + cote + ". \n   -Interpr�te du CD : "+ listArticle.rechercheOuvrage(cote).getInterprete() +". \n   -Titre du CD : "+listArticle.rechercheOuvrage(cote).getTitre() +".");	
			System.out.println("   Date d'emprunt : " + listEmprunt.rechercheFicheParOuvrage(cote).getDateEmprunt() + ".");
			System.out.println("   Date de retour de l'emprunt : " + listEmprunt.rechercheFicheParOuvrage(cote).dateFinEmprunt() +".");

			System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
			boolean juste = clavier.nextBoolean();
			if (juste == true)
				exact = true;
			else
				exact = false;
		}
		System.out.println ("L'emprunt du CD a bien �t� enregistr�.");
		menu();
	}

	public static void emprunterDVD(){
		System.out.println("\nVous avez choisi d'emprunter un DVD : \n");
		boolean exact = false;
		while (exact == false){
			System.out.println(" Quel est la c�te du DVD que vous souhaitez emprunter ?");
			String cote = clavier.next();
			System.out.println(" Quel est le nom de l'abonn� souhaitant emprunter ?");
			String nom = clavier.next();
			System.out.println(" Quel est le pr�nom de l'abonn� souhaitant emprunter ?");
			String prenom = clavier.next();	

			mediatheque.emprunter(nom, prenom, cote);

			System.out.println("\nVoici le r�capitulatif de la fiche emprunt : ");
			System.out.println("   *Num�ro d'abonn� de l'emprunteur : " + listAbonne.rechercheNumeroAbonne(nom, prenom) + ". \n   *Son nom : "+ nom + ". \n   *Son pr�nom : "+ prenom + ".");
			System.out.println("   -C�te du DVD emprunt� : " + cote + ". \n   -Producteur du DVD : "+ listArticle.rechercheOuvrage(cote).getProducteur() +". \n   -Titre du DVD : "+listArticle.rechercheOuvrage(cote).getTitre() +".");	
			System.out.println("   Date d'emprunt : " + listEmprunt.rechercheFicheParOuvrage(cote).getDateEmprunt() + ".");
			System.out.println("   Date de retour de l'emprunt : " + listEmprunt.rechercheFicheParOuvrage(cote).dateFinEmprunt() +".");

			System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
			boolean juste = clavier.nextBoolean();
			if (juste == true)
				exact = true;
			else
				exact = false;
		}
		System.out.println ("L'emprunt du DVD a bien �t� enregistr�.");
		menu();
	}

	public static void rechercherAbonne(){
		System.out.println("\nVous avez choisi de rechercher un abonn� : \n \nPlusieurs choix s'offrent � vous : Vous voulez rechercher l'abonn� par rapport � : \n -> son num�ro d'abonn�, pour cela tapez 1. \n -> son nom et son pr�nom, pour cela tapez 2.");

		int choix = clavier.nextInt();

		switch(choix){
		case 1 : rechercheAbonneParNumeroAbonne();
		break;	
		case 2 : rechercheAbonneParNom();
		break;
		default : System.out.println("Choix incorrect !!! \n ");
		rechercherAbonne();
		break;
		}	
	}

	public static void rechercheAbonneParNumeroAbonne(){
		System.out.println("\nVous avez choisi de rechercher un abonn� par rapport � son num�ro d'abonn� : \n \n Quel est le numero d'abonn� ?");
		int num = clavier.nextInt();

		System.out.println("L'abonn� recherch� est :");
		Abonnes abonne = listAbonne.rechercheAbonne(num);
		abonne.affiche();
		System.out.println("Liste des emprunts en cours :");
		listEmprunt.rechercheFicheParAbonne(num);
		
		System.out.println();

		menu();
	}

	public static void rechercheAbonneParNom(){
		System.out.println("\nVous avez choisi de rechercher un abonn� par rapport � son nom : \n \n Quel est son nom ?");
		String nom = clavier.next();
		System.out.println(" Quel est son pr�nom ?");
		String prenom = clavier.next();

		int num = listAbonne.rechercheNumeroAbonne(nom, prenom);

		System.out.println("L'abonn� recherch� est :");
		Abonnes abonne = listAbonne.rechercheAbonne(num);
		abonne.affiche();
		System.out.println("Liste des emprunts en cours :");
		listEmprunt.rechercheFicheParAbonne(num);
		System.out.println();

		menu();
	}

	public static void rechercherLivre(){
		System.out.println("\nVous avez choisi de rechercher un livre : \n \nPlusieurs choix s'offrent � vous : Vous voulez rechercher un livre par rapport � : \n -> sa cote, pour cela tapez 1. \n -> son auteur, pour cela tapez 2. \n -> son titre, pour cela tapez 3.");	

		int choix = clavier.nextInt();

		switch(choix){
		case 1 : rechercheLivreParCote();
		break;
		case 2 : rechercheLivreParAuteur();
		break;
		case 3 : rechercheLivreParTitre();
		break;
		default : System.out.println("Choix incorrect !!! \n");
		rechercherLivre();
		break;
		}	
	}

	public static void rechercheLivreParCote(){
		System.out.println("\nVous avez choisi de rechercher un livre par rapport � sa cote : \n Quel est la cote du livre recherch� ?");
		String cote = clavier.next();

		Ouvrage ouvrage = listArticle.rechercheOuvrageTitre(cote);

		if (ouvrage instanceof Livres){
			System.out.println ("Le livre recherch� est :");
			((Livres)ouvrage).affiche();		
		}
		else
			System.out.println("Cette cote ne fais pas r�f�rence � un Livre.");

		menu();
	}

	public static void rechercheLivreParAuteur(){
		System.out.println("\nVous avez choisi de rechercher un livre par rapport � son auteur : \n Quel est l'auteur recherch� ?");
		String auteur = clavier.next();

		System.out.println("Le livre recherch� est :");
		Livres livre = listArticle.rechercheOuvrageAuteur(auteur);

		livre.affiche();
		System.out.println();

		menu();
	}

	public static void rechercheLivreParTitre(){
		System.out.println("\nVous avez choisi de rechercher un livre par rapport � son titre : \n Quel est le titre recherch� ?");
		String titre = clavier.next();
		Ouvrage ouvrage = listArticle.rechercheOuvrageTitre(titre);

		if (ouvrage instanceof Livres)
			((Livres)ouvrage).affiche();
		else
			System.out.println("Ce titre ne fais pas r�f�rence � un Livre. \n");

		menu();
	}

	public static void rechercherCD(){
		System.out.println("\nVous avez choisi de rechercher un CD : \n \nPlusieurs choix s'offrent � vous : Vous voulez rechercher un CD par rapport � : \n -> sa cote, pour cela tapez 1. \n -> son interpr�te, pour cela tapez 2. \n -> son titre, pour cela tapez 3.");	
		int choix = clavier.nextInt();

		switch(choix){
		case 1 : rechercheCDParCote();
		break;
		case 2 : rechercheCDParInterpr�te();
		break;
		case 3 : rechercheCDParTitre();
		break;
		default : System.out.println("Choix incorrect !!!");
		rechercherCD();
		break;
		}	
	}

	public static void rechercheCDParCote(){
		System.out.println("\nVous avez choisi de rechercher un CD par rapport � sa cote : \n Quel est la cote du CD recherch� ?");
		String cote = clavier.next();

		Ouvrage ouvrage = listArticle.rechercheOuvrage(cote);

		if (ouvrage instanceof CD){
			System.out.println ("Le CD recherch� est :");
			((CD)ouvrage).affiche();		
		}
		else
			System.out.println("Cette cote ne fais pas r�f�rence � un CD.");

		menu();
	}

	public static void rechercheCDParInterpr�te(){
		System.out.println("\nVous avez choisi de rechercher un CD par rapport � son intrepr�te : \n Quel est l'interpr�te recherch� ?");
		String interprete = clavier.next();


		System.out.println("Le CD recherch� est :");
		CD cd = listArticle.rechercheOuvrageInterprete(interprete);

		cd.affiche();
		System.out.println();

		menu();
	}

	public static void rechercheCDParTitre(){
		System.out.println("\nVous avez choisi de rechercher un CD par rapport � son titre : \n Quel est le titre recherch� ?");
		String titre = clavier.next();

		Ouvrage ouvrage = listArticle.rechercheOuvrageTitre(titre);

		if (ouvrage instanceof CD){
			System.out.println ("Le CD recherch� est :");
			((CD)ouvrage).affiche();		
		}
		else
			System.out.println("Ce titre ne fais pas r�f�rence � un CD.");

		menu();
	}

	public static void rechercherDVD(){
		System.out.println("\nVous avez choisi de rechercher un DVD : \n \nPlusieurs choix s'offrent � vous : Vous voulez rechercher un DVD par rapport � : \n -> sa cote, pour cela tapez 1. \n -> son producteur, pour cela tapez 2. \n -> son titre, pour cela tapez 3.");	
		int choix = clavier.nextInt();

		switch(choix){
		case 1 : rechercheDVDParCote();
		break;
		case 2 : rechercheDVDParProducteur();
		break;
		case 3 : rechercheDVDParTitre();
		break;
		default : System.out.println("Choix incorrect !!!");
		rechercherDVD();
		break;
		}	
	}

	public static void rechercheDVDParCote(){
		System.out.println("\nVous avez choisi de rechercher un DVD par rapport � sa cote : \n Quel est la c�te du CD recherch� ?");
		String cote = clavier.next();

		Ouvrage ouvrage = listArticle.rechercheOuvrage(cote);

		if (ouvrage instanceof DVD){
			System.out.println ("Le DVD recherch� est :");
			((DVD)ouvrage).affiche();		
		}
		else
			System.out.println("Cette cote ne fais pas r�f�rence � un DVD. \n");

		menu();
	}

	public static void rechercheDVDParProducteur(){
		System.out.println("\nVous avez choisi de rechercher un DVD par rapport � son producteur : \n Quel est le producteur recherch� ?");
		String producteur = clavier.next();

		System.out.println("Le DVD recherch� est :");
		DVD dvd = listArticle.rechercheOuvrageProducteur(producteur);

		dvd.affiche();
		System.out.println();

		menu();
	}

	public static void rechercheDVDParTitre(){
		System.out.println("\nVous avez choisi de rechercher un DVD par rapport � son titre : \n Quel est le titre recherch� ?");
		String titre = clavier.next();

		Ouvrage ouvrage = listArticle.rechercheOuvrageTitre(titre);

		if (ouvrage instanceof DVD){
			System.out.println ("Le DVD recherch� est :");
			((DVD)ouvrage).affiche();		
		}
		else
			System.out.println("Ce titre ne fais pas r�f�rence � un DVD. \n");

		menu();
	}

	public static void rechercherFicheEmprunt(){
		System.out.println("\nVous avez choisi de rechercher une fiche emprunt : \n \nPlusieurs choix s'offrent � vous : Vous voulez rechercher une fiche emprunt par rapport : \n -> au num�ro de l'abonn�, pour cela tapez 1. \n -> � la cote de l'ouvrage, pour cela tapez 2.");
		int choix = clavier.nextInt();

		switch(choix){
		case 1 : rechercheFicheEmpruntParAbonne();
		break;
		case 2 : rechercheFicheEmpruntParOuvrage();
		break;
		default : System.out.println("Choix incorrect !!!");
		rechercherFicheEmprunt();
		break;
		}	
	}

	public static void rechercheFicheEmpruntParAbonne(){
		System.out.println("\nVous avez choisi de rechercher une fiche emprunt par rapport au num�ro d'abonn� : \n Quel est le num�ro d'abonn� associ� � la fiche recherch� ?");
		int num = clavier.nextInt();

		System.out.println("L'abonn� associ�s � ce num�ro est :");
		Abonnes abonne = listAbonne.rechercheAbonne(num);
		abonne.affiche();

		System.out.println("\nVoici le r�capitulatif des fiches emprunts associ�s � ce num�ro : ");
		listEmprunt.rechercheFicheParAbonne(num);
		System.out.println();

		menu();
	}

	public static void rechercheFicheEmpruntParOuvrage(){
		System.out.println("\nVous avez choisi de rechercher une fiche emprunt par rapport � la cote de l'ouvrage : \n Quel est la c�te de l'ouvrage associer � la fiche recherch� ?");
		String cote = clavier.next();

		System.out.println("L'ouvrage associ�s � ce num�ro est :");
		Ouvrage o = listArticle.rechercheOuvrage(cote);
		o.affiche();

		System.out.println("\nVoici le r�capitulatif des fiches emprunts associ�s � ce num�ro : ");
		listEmprunt.rechercheFicheParOuvrage(cote);
		System.out.println();

		menu();
	}

	public static void supprimerAbonne(){
		System.out.println("\nVous avez choisi de supprimer un abonn� : \n Quel est le num�ro d'abonn� � supprimer ? ");
		int num = clavier.nextInt();

		listAbonne.supprimerAbonne(num);

		System.out.println("L'abonn� ayant pour num�ro d'abonn� : " + num + " a bien �t� supprim�.");
		System.out.println();

		menu();
	}

	public static void supprimerOuvrage(){
		System.out.println("\nVous avez choisi de supprimer un Ouvrage : \n ");		
		boolean exact = false;
		while (exact == false){
			System.out.println("\n Quel est la cote de l'ouvrage � supprimer ?");
			String cote = clavier.next();

			Ouvrage o = listArticle.rechercheOuvrage(cote);
			System.out.println("L'article associ� � cette c�te :");
			o.affiche();
			listArticle.supprimerOuvrage(cote);
			System.out.println("\nCes donn�es sont-elles exacts (mettre true pour vrai et false pour faux) ?");
			boolean juste = clavier.nextBoolean();
			if (juste == true)
				exact = true;
			else
				exact = false;
		}
		System.out.println ("L'ouvrage a bien �t� supprim�.");
		menu();
	}

	public static void supprimerFicheEmprunt(){
		System.out.println("\nVous avez choisi de supprimer une fiche emprunt : \n Quel est son nom (s�parer chaque mot avec un /) ?");
		String nom = clavier.next();
		System.out.println(" Quel est son pr�nom (s�parer chaque mot avec un /) ?");
		String prenom = clavier.next();
		System.out.println(" Quel est la cote de l'ouvrage emprunter ?");
		String cote = clavier.next();

		mediatheque.retourEmprunt(nom, prenom, cote);

		System.out.println("La fiche emprunt correspondant � l'ouvrage ayant pour cote : " + cote + " a bien �t� supprim�.");
		System.out.println();

		menu();
	}

	private static void afficherAbonne() {
		System.out.print("\nVoici la liste des abonn�s : \n");
		listAbonne.affiche();
		menu();
	}

	private static void afficherEmprunt() {
		System.out.print("\nVoici la liste des fiches emprunts : \n");
		listEmprunt.affiche();
		menu();
	}

	private static void afficherArticle() {
		System.out.print("\nVous avez choisi d'afficher une liste d'article \n \nVeuillez selectionner le type d'article � afficher : \n -> pour les CD taper 1 \n -> pour les DVD taper 2 \n -> pour les livres taper 3 \n");
		int choix = clavier.nextInt();

		switch(choix){
		case 1 : afficherCD();
		break;
		case 2 : afficherDVD();
		break;		
		case 3 : afficherLivre();
		break;
		default : System.out.print("Choix incorrect !!! Veuillez saisir un des num�ros qui s'offrent � vous.\n");
		afficherArticle();
		break;
		}
	}

	private static void afficherCD() {
		System.out.print("\nVoici la liste des CD : \n");
		listArticle.afficheCD();
		menu();
	}

	private static void afficherDVD() {
		System.out.print("\nVoici la liste des DVD : \n");
		listArticle.afficheDVD();
		menu();
	}

	private static void afficherLivre() {
		System.out.print("\nVoici la liste des Livres : \n");
		listArticle.afficheLivre();
		menu();
	}

	private static void afficherAlarme() {
		System.out.print("\nVoici la liste des fiches emprunts en retard : \n");
		listEmprunt.alarme();
		System.out.println("Pensez � leur envoyer un email ou leur t�l�phoner en recherchant l'abonn� en question.");
		menu();
	}
}