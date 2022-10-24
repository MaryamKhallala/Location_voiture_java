import java.util.Iterator;
import java.util.Scanner;

public class testAgence {
	
	public static void saisieVoiture(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		String Modele = new String();
		String Marque = new String();
		int id,anneeProd, Prix;
		
		System.out.println(">Entrer le numero de la voiture: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		id = clavier.nextInt();
		
		System.out.println(">Entrer le Modele: ");
			Modele = clavier.next();
		System.out.println(">Entrer la Marque: ");
			Marque = clavier.next();
		
		System.out.println(">Entrer le Prix en DH: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		Prix = clavier.nextInt();
		
		System.out.println(">Entrer l'année de Production: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		anneeProd = clavier.nextInt();
		
		Voiture v = new Voiture(id, Modele, Marque, anneeProd, Prix);
		a.addVoiture(v);
		
		clavier.close();
	}
	
	public static void saisieClient(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		String nom = new String();
		String prenom = new String();
		String cin = new String();
		Civilite statut = Civilite.M;
		
		System.out.println(">Entrer le CIN: ");
			cin = clavier.next();
		System.out.println(">Entrer la nom: ");
			nom = clavier.next();
		System.out.println(">Entrer la prenom: ");
			prenom = clavier.next();
		
		System.out.println(">Choisir l'etat civil: ");
		int choice;
		do{
			System.out.println("<1> Mr.");
			System.out.println("<2> Mlle.");
			System.out.println("<3> Mme.");
			while( ! clavier.hasNextInt() ) {
				System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
				clavier.next();
			}
			choice = clavier.nextInt();
			switch(choice)
			{
			case 1:statut = Civilite.M;choice = 0; break;
			case 2:statut = Civilite.Mlle;choice = 0;break;
			case 3:statut = Civilite.Mme;choice = 0;break;
			default:System.out.println("Unknown choice !");choice = 4;break;
			}
			
		}while(choice!=0);
		
		Client c = new Client(cin, nom, prenom, statut);
		a.addClient(c);
		clavier.close();
	}
	
	public static void supprimerVoiture(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		int idCar;
		
		System.out.println(">Entrer l'ID de votre voiture: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		idCar = clavier.nextInt();
		a.deletVoiture(a.displayCarbyID(idCar));
		
		clavier.close();
	}
	
	public static void supprimerClient(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		String cin = new String();
		
		System.out.println(">Entrer le CIN de votre client: ");
		if(clavier.hasNextLine())
			cin = clavier.nextLine();
		a.deletClient(a.displayClientbyCIN(cin));
		
		clavier.close();
	}
	
	public static void verifierClient(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		String cin = new String();
		
		System.out.println(">Entrer le CIN de votre client: ");
		if(clavier.hasNextLine())
			cin = clavier.nextLine();
		a.displayClientbyCIN(cin);
		
		clavier.close();
	}
	
	public static void verifierVoiture(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		int id;
		
		System.out.println(">Entrer l'ID de la voiture: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		id = clavier.nextInt();
		a.displayCarbyID(id);
		
		clavier.close();
	}
	
	public static void afficherLocatedCars(Agence a)
	{
		Iterator<Voiture> iter = a.lesVoituresLouees();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	
	public static void Louer(Agence a)
	{
		a.displayAllClients();
		a.displayAllCars();
		Scanner clavier = new Scanner(System.in);
		String cin = new String();
		int id;
		
		System.out.println(">Entrer l'ID de la voiture: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		id = clavier.nextInt();
		//clavier.next();
		System.out.println(">Entrer le CIN de votre client: ");
		//if(clavier.hasNextLine())
			cin = clavier.next();
		a.loueVoiture(cin, a.displayCarbyID(id));
		
		clavier.close();
	}
	
	public static void Rendre(Agence a)
	{
		a.displayAllClientCars();
		Scanner clavier = new Scanner(System.in);
		String cin = new String();
		System.out.println(">Entrer le CIN de votre client: ");
		if(clavier.hasNextLine())
			cin = clavier.nextLine();
		a.rendVoiture(cin);
		
		clavier.close();
	}
	
	public static void displayCarByPrice(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		
		int price;
		System.out.println(">Entrer le prix de la voiture: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		price = clavier.nextInt();
		
		Critere c = new CriterePrix(price);
		Iterator<Voiture> iter = a.selectionne(c);
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		clavier.close();
	}
	
	public static void displayCarByAnnee(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		
		int an;
		System.out.println(">Entrer l'annee de la voiture: ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		an = clavier.nextInt();
		
		Critere c = new CritereAnnee(an);
		Iterator<Voiture> iter = a.selectionne(c);
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		clavier.close();
	}
	
	public static void displayCarByMarque(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		System.out.println(">Entrer la Marque de votre voiture: ");
		String marque = new String();
		if(clavier.hasNextLine())
			marque = clavier.nextLine();
		Critere c = new CritereMarque(marque);
		Iterator<Voiture> iter = a.selectionne(c);
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		clavier.close();
	}
	
	public static void displayCarByStar(Agence a)
	{
		InterCritere IC = new InterCritere();
		Critere c;
		Scanner clavier = new Scanner(System.in);
		int choice;
		do{
			System.out.println("<1> Ajouter critere d'anne de production");
			System.out.println("<2> Ajouter critere de marque");
			System.out.println("<3> Ajouter critere de prix");
			System.out.println("<0> quiter");
			System.out.println("   > Entrer votre choix : ");
			while( ! clavier.hasNextInt() ) {
				System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
				clavier.next();
			}
			choice = clavier.nextInt();
			switch(choice)
			{
			case 1:
				int an;
				System.out.println(">Entrer l'annee de la voiture: ");
				while( ! clavier.hasNextInt() ) {
					System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
					clavier.next();
				}
				an = clavier.nextInt();
				
				 c = new CritereAnnee(an);
				IC.addCritere(c);
				break;
			case 2:
				System.out.println(">Entrer la Marque de votre voiture: ");
				String marque = new String();
				marque = clavier.next();
				 c = new CritereMarque(marque);
				IC.addCritere(c);
				break;
			case 3:
				int price;
				System.out.println(">Entrer le prix de la voiture: ");
				while( ! clavier.hasNextInt() ) {
					System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
					clavier.next();
				}
				price = clavier.nextInt();
				c = new CriterePrix(price);
				IC.addCritere(c);
				break;
			case 4:break;
			}
		}while(choice!=0);
		
		Iterator<Voiture> iter = a.selectionne(IC);
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
		clavier.close();
	}
	
	public static void Quitter(Agence a)
	{
		Scanner clavier = new Scanner(System.in);
		
		int choice;
		System.out.println(">Voulez vous sauvegarder ? (Entrer 1 si oui) ");
		while( ! clavier.hasNextInt() ) {
			System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
			clavier.next();
		}
		choice = clavier.nextInt();
		if(choice == 1)
		{
			a.saveAgence();
			System.out.println("Merci !");
		}
		else
			System.out.println("Vos Modification n'ont pas étaient enregistrer ! Merci !");
		
		clavier.close();
	}
	
	public static void main(String[] args) {
		
		Scanner clavier = new Scanner(System.in);
		
		/***	Chargement de La Base de Données de l'Agence ***/
		/*
		Client C1 = new Client("ID59759", "El-Harrougui", "Mohamed", Civilite.M);
		Client C2 = new Client("IC59759", "Fatimi", "Soukaina", Civilite.Mlle);
		Client C3 = new Client("AB59759", "Benseddik", "Hafida", Civilite.Mme);
		Client C4 = new Client("TX59759", "Ennaciri", "Ahmad", Civilite.M);
		Client C5 = new Client("AA59759", "El-Iraqui", "Mohamed", Civilite.M);
		
		
		Voiture V1 = new Voiture(123,"Renault", "R4", 1994, 100);
		Voiture V2 = new Voiture(213,"Audit", "A6", 2012, 580);
		Voiture V3 = new Voiture(312,"Ferrari", "F1", 1990, 230);
		Voiture V4 = new Voiture(432,"Dacia", "Logan", 2010, 700);
		Voiture V5 = new Voiture(243,"Citroen", "C8", 2012, 340);
		Voiture V6 = new Voiture(421,"Mercedes", "AMG", 2012, 440);
		Voiture V7 = new Voiture(124,"Peugeot", "307", 2007, 140);
		
		Agence agence = new Agence();
		
		agence.addVoiture(V1);	agence.addVoiture(V2);	agence.addVoiture(V3);
		agence.addVoiture(V4);	agence.addVoiture(V5);	agence.addVoiture(V6);
		agence.addVoiture(V7);
		
		agence.addClient(C1); 	agence.addClient(C2);	
		agence.addClient(C3);	agence.addClient(C4);	
		agence.addClient(C5);
		
		agence.loueVoiture(C1.getClientCIN(), V1);
		agence.loueVoiture(C2.getClientCIN(), V2);
		agence.loueVoiture(C3.getClientCIN(), V3);
		agence.loueVoiture(C4.getClientCIN(), V4);
		agence.loueVoiture(C5.getClientCIN(), V5);
		
		*/
		/**********************************************************************/
		Agence agence = new Agence();
		System.out.println("<... Récupéaration des données de l'Agence ...>");
		agence = Agence.getAgence();
		
		int choice;
		do{
			System.out.println("\n********************************");
			System.out.println("*** Test Agence main Program ***");
			System.out.println("********************************\n");
			System.out.println("<1> Ajouter voiture");
			System.out.println("<2> Ajouter client");
			System.out.println("<3> Supprimer voiture");
			System.out.println("<4> Supprimer client");
			System.out.println("<5> Affichage de tout les voitures");
			System.out.println("<6> Affichage de tout les clients");
			System.out.println("<7> Affichage de tout les locations");
			System.out.println("<8> Vérifier un client");
			System.out.println("<9> Vérifier d'une voiture");
			System.out.println("<10> Afficher les voitures loué");
			System.out.println("<11> Afficher les voitures selon critère annee");
			System.out.println("<12> Afficher les voitures selon critère marque");
			System.out.println("<13> Afficher les voitures selon critère prix");
			System.out.println("<14> Afficher les voitures selon plusieurs critères");
			System.out.println("<15> Loué une voiture à un client");
			System.out.println("<16> Rendre une voiture à un client");
			System.out.println("<0> Quitter l'application !");
			
			System.out.println("   > Entrer votre choix : ");
			
			try{
				/*
				 * while( ! clavier.hasNextInt() ) {
				 
				System.out.println("Votre entrée n'est pas de type 'Int' réessayer: ");
				clavier.next();
			}*/
				choice = clavier.nextInt();
				System.out.println("***"+choice+"***");
			
			}catch(Exception e)
			{
				choice = clavier.nextInt();;
			}
			switch(choice)
			{
			case 1:saisieVoiture(agence);break;
			case 2:saisieClient(agence);break;
			case 3:supprimerVoiture(agence);break;
			case 4:supprimerClient(agence);break;
			case 5:agence.displayAllCars();break;
			case 6:agence.displayAllClients();break;
			case 7:agence.displayAllClientCars();break;
			case 8:verifierClient(agence);break;
			case 9:verifierVoiture(agence);break;
			case 10:afficherLocatedCars(agence);break;
			case 11:displayCarByAnnee(agence);break;
			case 12:displayCarByMarque(agence);break;
			case 13:displayCarByPrice(agence); break;
			case 14:displayCarByStar(agence);break;
			case 15:Louer(agence);break;
			case 16:Rendre(agence);break;
			case 0: Quitter(agence);break;
			default:System.out.println("Unknown operation's number !");break;
			}
			
		}while(choice!=0);
		
	
		clavier.close();
	}
}
