
public class CritereMarque implements Critere {
	private String Marque;
	public CritereMarque(String marque)
	{
		Marque = marque;
	}
	
	public String toString()
	{
		return ">Critere Marque: "+Marque;
	}
	
	@Override
	public boolean estSatisfaitPar(Voiture v) {
		return (v.getVoitureMarque().equals(Marque));
	}
}
