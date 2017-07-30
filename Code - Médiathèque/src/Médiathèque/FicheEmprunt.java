package Médiathèque;

public class FicheEmprunt {
	private String dateEmprunt;
	private int numeroAbonne;
	private String cote;
	private String dateFinEmprunt;

	public FicheEmprunt(String cote, String dateEmprunt, int numeroAbonne) {
		super();
		this.cote = cote;
		this.dateEmprunt = dateEmprunt;
		this.numeroAbonne = numeroAbonne;
		dateFinEmprunt = dateFinEmprunt();
	}

	public String dateFinEmprunt(){
		String[] result = dateEmprunt.split("/");
		int jour = Integer.parseInt(result[0]);
		int mois = Integer.parseInt(result[1])+1;
		int annee = Integer.parseInt(result[2]);

		if (mois==13){
			mois=1;
			annee++;
		}
		String date = jour+"/"+mois+"/"+annee;
		return date;
	}

	public String getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(String dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public int getNumeroAbonne() {
		return numeroAbonne;
	}

	public void setNumeroAbonne(int numeroAbonne) {
		this.numeroAbonne = numeroAbonne;
	}

	public String getCote() {
		return cote;
	}

	public void setCote(String cote) {
		this.cote = cote;
	}

	public String[] getDateFinEmprunt() {
		String[] dateFin = dateEmprunt.split("/");
		return dateFin;
	}

	public void setDateFinEmprunt(String dateFinEmprunt) {
		this.dateFinEmprunt = dateFinEmprunt;
	}

	public void affiche(){
		System.out.println("   Numéro d'abonné de l'emprunteur : " + numeroAbonne + ".");
		System.out.println("   Côte du livre emprunté : " + cote + ".");	
		System.out.println("   Date d'emprunt : " + dateEmprunt + ".");
		System.out.println("   Date de retour de l'emprunt : " + dateFinEmprunt +".");
	}
}