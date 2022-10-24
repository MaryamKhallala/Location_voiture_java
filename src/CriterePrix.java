
public class CriterePrix implements Critere {
	private int Prix;
	public CriterePrix(int prix)
	{
		Prix = prix;
	}
	
	public String toString()
	{
		return ">Critere Prix: "+Prix;
	}
	
	@Override
	public boolean estSatisfaitPar(Voiture v) {
		return (v.getVoiturePrix() <= Prix);
	}
}

