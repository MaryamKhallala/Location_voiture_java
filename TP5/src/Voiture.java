import java.io.Serializable;

public class Voiture implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCar;
	private int anneProd;
	private String marque;
	private String nomModele;
	private int prixLocJr;
	
	public Voiture(int id, String nom, String mark, int anne, int prix){
		prixLocJr = prix; 	anneProd = anne;
		marque	= mark;	nomModele = nom;
		idCar = id;
	}

	public String toString(){
		return ("<"+idCar+">Modele : "+nomModele+"  >Marque : "+marque+"  >Prix : "+prixLocJr+"DHs");
	}

	public boolean equals(Voiture v){
		if( v.anneProd == anneProd &&
		    v.nomModele == nomModele &&
		    v.marque == marque &&
		    v.prixLocJr == prixLocJr ) return true;
		return false;
	}
	
	public String getVoitureMarque()
	{
		return marque;
	}
	
	public int getVoitureAnnee()
	{
		return anneProd;
	}
	
	public int getVoiturePrix()
	{
		return prixLocJr;
	}
	
	public int getVoitureID()
	{
		return idCar;
	}

}
