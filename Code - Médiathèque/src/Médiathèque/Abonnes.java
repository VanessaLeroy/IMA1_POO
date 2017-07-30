package Médiathèque;

public class Abonnes{
	private int numeroAbonne;
	private String nom;
	private String adresse;
	private String prenom;
	private int telephone;
	private int nombrePretEnCours;
	private String email;
	private String dateFinAbonnement;

	public Abonnes(String nom, String prenom, String adresse, int telephone, String email, 
			int numeroAbonne, String dateFinAbonnement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.numeroAbonne = numeroAbonne;
		nombrePretEnCours = 0;		
		this.dateFinAbonnement = dateFinAbonnement;		
	}

	public int getNumeroAbonne() {
		return numeroAbonne;
	}

	public void setNumeroAbonne(int numeroAbonne) {
		this.numeroAbonne = numeroAbonne;
	}

	public String getNom(){
		return nom;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

	public String getAdresse(){
		return adresse;
	}

	public void setAdresse(String adresse){
		this.adresse = adresse;
	}

	public String getPrenom(){
		return prenom;
	}

	public void setPrenom(String prenom){
		this.prenom = prenom;
	}

	public int getTelephone(){
		return telephone;
	}

	public void setTelephone(int telephone){
		this.telephone = telephone;
	}

	public int getNombrePretEnCours(){
		return nombrePretEnCours;
	}

	public void setNombrePretEnCours(int nombrePretEnCours){
		this.nombrePretEnCours += nombrePretEnCours;
	}
	public void decNombrePretEnCours(int nombrePretEnCours){
		this.nombrePretEnCours -= nombrePretEnCours;
	}
	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getDateFinAbonnement(){
		return dateFinAbonnement;
	}

	public void setDateFinAbonnement(String dateFinAbonnement){
		this.dateFinAbonnement = dateFinAbonnement;
	}

	public void affiche(){
		System.out.println("   Numéro d'abonné : " + numeroAbonne + ".");
		System.out.println("   Nom : " + nom + ".");
		System.out.println("   Prénom : " + prenom + ".");
		System.out.println("   Téléphone : " + telephone + ".");
		System.out.println("   Email : " + email + ".");		
		System.out.println("   Nombre de prêts en cours : " + nombrePretEnCours + ".");
		System.out.println("   Date de fin d'abonnement : " + dateFinAbonnement + ". \n");
	}
}
