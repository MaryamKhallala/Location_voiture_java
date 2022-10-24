import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class Agence implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Client> Clients;
	private List<Voiture> Voitures;
	private Map<String,Voiture> Locations;
	
	public Agence()
	{
		Voitures = new LinkedList<Voiture>();
		Locations = new TreeMap<String,Voiture>();
		Clients = new ArrayList<Client>();
	}
	
	public void displayAllCars()
	{
		System.out.println(" <Affichage de tout les Voitures de l'Agence>");
		for(Voiture v : Voitures)
		{
			System.out.println(v);
		}
		
	}
	
	public void displayAllClients()
	{
		System.out.println(" <Affichage de tout les Clients de l'Agence>");
		for(Client c : Clients)
		{
			System.out.println(c);
		}
	}
	
	public void displayAllClientCars()
	{
		System.out.println(" <Affichage de tout les Locations de l'Agence>");
	    for (Map.Entry<String,Voiture> me : Locations.entrySet())
	    {
	    	System.out.print(">Client: "+me.getKey() + ": ");
	         System.out.println(me.getValue());
	    }
	}
	
	public Client displayClientbyCIN(String CIN)
	{
		for(Client c : Clients)
		{
			if(c.getClientCIN().equals(CIN))
			{
				System.out.println(c);
				return c;
			}
		}
		System.out.println("Ce Client n'existe pas la BdD des Clients de l'Agence!");
		return null;
	}
	
	public Voiture displayCarbyID(int id)
	{
		for(Voiture v : Voitures)
		{
			if(v.getVoitureID() == id)
			{
				System.out.println(v);
				return v;
			}
		}
		System.out.println("Cette voiture n'existe pas la BdD des Voitures de l'Agence!");
		return null;
	}
	
	public void addVoiture(Voiture v)
	{
		Voitures.add(v);
	}
	
	public void addClient(Client c)
	{
		Clients.add(c);
	}
	
	public boolean deletVoiture(Voiture v)
	{
		return Voitures.remove(v);
	}
	
	public boolean deletClient(Client c)
	{
		
		return Clients.remove(c);
	}
	
	public Iterator<Voiture> selectionne(Critere c)
	{
		Iterator<Voiture> iter = Voitures.iterator();
		Vector<Voiture> selectedVoitures = new Vector<Voiture>();
		Voiture v;
		while(iter.hasNext())
		{
			v = iter.next();
			if(c.estSatisfaitPar(v))
				selectedVoitures.add(v);
		}
		Iterator<Voiture> itResult = selectedVoitures.iterator();
		return itResult;
	}
	
	public void afficheSelectionne(Critere c)
	{
		System.out.println(this.selectionne(c));
	}
	
	public void loueVoiture(String client, Voiture v)
	{
		if(displayClientbyCIN(client)!=null)
		{
			if(!Voitures.contains(v)) 
				System.out.println("La voiture n'existe pas dans la BdD des voitures de l'Agence !");
			{
				if(Locations.containsValue(v))
				{
					System.out.println(v);
					System.out.println("Cette voiture est déjà Loué");
				}
				else if(Locations.containsKey(client))
					System.out.println("Ce client à déjà une voiture en location");
				else
				{
					Locations.put(client, v);
					System.out.println(v);
					System.out.println("Operation de Location achevé avec Succès");
					System.out.println("****************************************");
				}
					
			}
		}
	}
	
	public boolean estLoueur(String client)	//CIN
	{
		return Locations.containsKey(client);
	}
	
	public void rendVoiture(String client)
	{
		if(!Locations.containsKey(client))
			System.out.println("Ce Client n'existe pas dans la BdD des Clients de l'Agence !");
		else if(estLoueur(client))
			Locations.remove(client);
		else
			System.out.println("Ce client n'a Loué aucune voiture");
	}
	
	public Iterator<Voiture> lesVoituresLouees()
	{
		Iterator<Voiture> iter = Voitures.iterator();
		Vector<Voiture> locatedVoitures = new Vector<Voiture>();
		Voiture v;
		while(iter.hasNext())
		{
			v = iter.next();
			if(Locations.containsValue(v))
				locatedVoitures.add(v);
		}
		Iterator<Voiture> itResult = locatedVoitures.iterator();
		return itResult;
	}
	
	public static Agence getAgence()
	{
		Agence A=null;
		try{
			ObjectInputStream read = new ObjectInputStream(new FileInputStream("Agence"));
			try {
				// On cast l'entrée
				A = (Agence)read.readObject();
			} finally {
				read.close();
			}
			}catch(Exception e) {}
			
			return A;
	}
	
	public void saveAgence()
	{
		try
		{
		ObjectOutputStream put = new ObjectOutputStream(new FileOutputStream("Agence"));
		
			try {
				put.writeObject(this);
			put.flush();
		} finally {
			put.close();
		}
		}catch(Exception e2) { System.out.println(e2);}
	}

}
