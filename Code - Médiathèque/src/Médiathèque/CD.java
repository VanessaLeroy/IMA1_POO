package Médiathèque;

public class CD extends Ouvrage{
	private String interprete;
	private int nombreChansons;
	private int duree;

	public CD(int annee, String cote, String titre, int duree, String genre, String interprete, 
			int nombreChansons) {
		super(annee, cote, titre, genre);
		this.duree = duree;
		this.interprete = interprete;
		this.nombreChansons = nombreChansons;
	}

	public String getInterprete() {
		return interprete;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}

	public int getNombreChansons() {
		return nombreChansons;
	}

	public void setNombreChansons(int nombreChansons) {
		this.nombreChansons = nombreChansons;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public void affiche(){
		super.affiche();
		System.out.println("   Interprête : " + interprete +".");
		System.out.println("   Durée du CD : " + duree + " minutes.");
		System.out.println("   Nombre de chansons : " + nombreChansons + ". \n");
	}
}