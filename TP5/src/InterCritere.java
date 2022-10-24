import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterCritere implements Critere{
	
	private List<Critere> lesCriteres;
	
	public InterCritere()
	{
		lesCriteres = new ArrayList<Critere>();
	}
	
	public String toString()
	{
		return lesCriteres.toString();
	}
	
	public void addCritere(Critere c)
	{
		lesCriteres.add(c);
	}
	
	public boolean estSatisfaitPar(Voiture v)
	{
		Iterator<Critere> iter = lesCriteres.iterator();
		while (iter.hasNext()){
			if(!iter.next().estSatisfaitPar(v))
				return false;
		}
		return true;
	}
}
