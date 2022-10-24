import java.io.Serializable;

public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// TODO Use regex for CIN
	private String nom, prenom, CIN;
	private Civilite etaCivil;
	
	public Client(String cin, String n, String p, Civilite c)
	{
		nom = n;   prenom = p;   CIN = cin;   etaCivil = c;
	}
	
	public String getClientCIN()
	{
		return CIN;
	}
	
	public String toString()
	{
		return(">CIN: "+CIN+"  > "+etaCivil+". "+nom+" "+prenom);
	}

}
