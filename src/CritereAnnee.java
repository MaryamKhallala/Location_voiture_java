
public class CritereAnnee implements Critere {
	private int Annee;
	public CritereAnnee(int annee)
	{
		Annee = annee;
	}
	
	public String toString()
	{
		return ">Critere Année: "+Annee;
	}
	

	public boolean estSatisfaitPar(Voiture v) {
		return (v.getVoitureAnnee() == Annee);
	}
}
