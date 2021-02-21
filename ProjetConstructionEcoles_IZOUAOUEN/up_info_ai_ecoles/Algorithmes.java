package up_info_ai_ecoles;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * la classe ALgorithmes  permet d'implémenter les différents algorithmes utilisés dans notre programme
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 * 
 */

public class Algorithmes {
	
	
	/*
	 * Permet à l'utilisateur de résoudre manuellement le programme en saisisant par lui même les noms des villes et la construction des routes et l'ajout d'écoles
	 *@param commuAgglo correspond à notre communauté d'agglomération
	 *@param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 *
	 */
	
	public static void resolutionManuelleSaisie(Scanner clavier,CommuAgglo commuAgglo) {
		
		int nombreDeVille=-1;
		int choix=0;
		
	
		
		while(nombreDeVille<=0 || nombreDeVille>26) {
			
			Utilitaire.menuNombreVille();
			
			try {
				
				nombreDeVille = clavier.nextInt();
				if(nombreDeVille <=0 || nombreDeVille>26) {
					
					System.out.println("Erreur : le nombre saisi ne correspond pas à un entier (compris entre 1 et 26) !\n ");
				}
				
			}catch(InputMismatchException e) {
				
				System.out.println("Erreur : "+clavier.next() +" ne correspond pas à un entier (compris entre 1 et 26) !\n ");
			}
			
		}
		
		clavier.nextLine();
		
		Utilitaire.menuNomVille();
		
		for(int i=0; i<nombreDeVille;i++) {
			String nomVille;
			boolean nomVilleNonValide=false;
			
			do {
				
				System.out.println("nom de la ville N° "+(i+1)+"  :");
				nomVille = clavier.nextLine();
				nomVilleNonValide=false;
				
				for(int j=0 ; j<nomVille.length();j++) {
					
					if(!(Character.isLetter(nomVille.charAt(j)))) {
						
						System.out.println("\nErreur : Le nom de la ville doit correspondre à une chaîne de caractère contenant uniquement des lettre de l'alphabet\n");
						nomVilleNonValide=true;
						break;
					}
				}
				
			}while( nomVilleNonValide  | (commuAgglo.nomVilleExiste(nomVille)));
			
			commuAgglo.ajouterVille(new Ville(nomVille));
		}
		
		do {
			
			try {
				
				Utilitaire.menuAjoutRoute();
				choix = clavier.nextInt();
				clavier.nextLine();
				
			}catch(InputMismatchException e) {
				
				
				clavier.nextLine();
				choix=4;
			}
			
	
			switch(choix) {
		
			case 1 : 
				Utilitaire.menuConstructionRoute();
				commuAgglo.afficherVilles();
				
				Ville villeA;
				 Ville villeB;
				 boolean laVilleExiste = true;
				 String nomVilleA, nomVilleB;
				
				do {
					
					System.out.println("ville 1 : ");
					 nomVilleA = clavier.nextLine();
					 
					 
					 System.out.println("ville 2 : ");
					  nomVilleB = clavier.nextLine();
					 
					 
					 if(nomVilleA.equals(nomVilleB)) {
						 
						 System.out.println("Erreur : les deux villes à saisir doivent être différentes !");
					 }
					 
					 laVilleExiste = (commuAgglo.nomVilleExisteBis(nomVilleA)) | (commuAgglo.nomVilleExisteBis(nomVilleB))	;
					 if(laVilleExiste) {
						 break;
					 }
					  villeA = commuAgglo.chercherVille(nomVilleA);
					  villeB = commuAgglo.chercherVille(nomVilleB);
					  villeA.routeExiste(villeB);
					 
					 
				}while(laVilleExiste && (nomVilleA.equals(nomVilleB)));
				 
				
				
				break;
		
			case 2 :
				
					System.out.println("\nVotre communauté est désormais générée, elle est composée des villes suivantes : ");
					commuAgglo.afficherVilles();
					System.out.println("\nPS :toutes les villes disposent d'une école.");
					Utilitaire.menuAjoutEcole();
					choix=2;
					break;
				

			default :
				System.out.println("\nErreur : vous devez saisir un nombre entier qui correspond à 1 ou 2.\n");
				break;
		
			}
			
			if(choix!=2) {
				choix=0;
			}
			
		}while(choix != 1 && choix!=2);
		 
		choix=0;
		String nomVille;	
		
		do {
			
			try {
				
				choix = clavier.nextInt();
				clavier.nextLine();
				
			}catch(InputMismatchException e) {
				
				
				clavier.nextLine();
				choix=4;
			}
			
			
			
			
			switch(choix) {
			
			case 1 :
				
				commuAgglo.afficherVilles();
				commuAgglo.afficherLesEcolesDesVilles();
				System.out.println("\nDans quelle ville parmi ces villes souhaitez-vous construire une école ? ");
				nomVille = clavier.nextLine();
				 
				if(commuAgglo.nomVilleExisteBis(nomVille)) {
					
					break;
				}
				commuAgglo.ajouterEcole(nomVille);
				
				break;
			
			case 2 : 
				
				commuAgglo.afficherVilles();
				commuAgglo.afficherLesEcolesDesVilles();
				System.out.println("\nDans quelle ville parmi ces villes souhaitez-vous retirer une école ? ");
				nomVille = clavier.nextLine();
				
				if(commuAgglo.nomVilleExisteBis(nomVille)) {
					break;
				}
				commuAgglo.retirerEcole(nomVille);
				
				
				break;
				
				
			case 3 : 
				
				choix=-1;
				break;
				
			default :
				
				System.out.println("\nErreur : vous devez saisir un nombre entier compris entre 1 & 3.\n");
				choix=1;
				break;
			}
			
			if(choix!=-1) {
				commuAgglo.afficherLesEcolesDesVilles();
				Utilitaire.menuAjoutEcole();
			}
			
		}while(choix==1 || choix==2 || choix==3);
		
		Utilitaire.menuPrincipal();
		Saisie.modeDeResolution(clavier,commuAgglo);
}
	
	/*
	 * Permet à l'utilisateur de résoudre manuellement le programme en récupérant la communauté d'agglomération à partir d'un fichier
	 *@param commuAgglo correspond à notre communauté d'agglomération
	 *@param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 *
	 */
	
	public static void resolutionManuelleFichier(Scanner clavier,CommuAgglo commuAgglo) {
	 
	  RepresentationCa.recupererCA(commuAgglo , clavier);
	  
	  commuAgglo.afficherVilles();
	  commuAgglo.afficherLesEcolesDesVilles();
	  
	  int choix=0;
		
	  do {
			
			try {
				
				Utilitaire.menuAjoutRoute();
				choix = clavier.nextInt();
				clavier.nextLine();
				
			}catch(InputMismatchException e) {
				
				
				clavier.nextLine();
				choix=4;
			}
			
	
			switch(choix) {
		
			case 1 : 
				Utilitaire.menuConstructionRoute();
				commuAgglo.afficherVilles();
				
				Ville villeA;
				 Ville villeB;
				 boolean laVilleExiste = true;
				 String nomVilleA, nomVilleB;
				
				do {
					
					System.out.println("ville 1 : ");
					 nomVilleA = clavier.nextLine();
					 
					 
					 System.out.println("ville 2 : ");
					  nomVilleB = clavier.nextLine();
					 
					 
					 if(nomVilleA.equals(nomVilleB)) {
						 
						 System.out.println("Erreur : les noms des deux villes à saisir doivent être différents !");
					 }
					 
					 laVilleExiste = (commuAgglo.nomVilleExisteBis(nomVilleA)) | (commuAgglo.nomVilleExisteBis(nomVilleB))	;
					 if(laVilleExiste) {
						 break;
					 }
					  villeA = commuAgglo.chercherVille(nomVilleA);
					  villeB = commuAgglo.chercherVille(nomVilleB);
					  villeA.routeExiste(villeB);
					 
					 
				}while(laVilleExiste && (nomVilleA.equals(nomVilleB)));
				 
				
				
				break;
		
			case 2 :
				
					
					commuAgglo.afficherVilles();
					Utilitaire.menuAjoutEcole();
					choix=2;
					break;
				

			default :
				System.out.println("\nErreur : vous devez saisir un nombre entier qui correspond à 1 ou 2.\n");
				break;
		
			}
			
			if(choix!=2) {
				choix=0;
			}
			
		}while(choix != 1 && choix!=2);
		 
		choix=0;
		String nomVille;	
		
		do {
			
			try {
				
				choix = clavier.nextInt();
				clavier.nextLine();
				
			}catch(InputMismatchException e) {
				
				
				clavier.nextLine();
				choix=4;
			}
			
			switch(choix) {
			
			case 1 :
				
				commuAgglo.afficherVilles();
				commuAgglo.afficherLesEcolesDesVilles();
				System.out.println("\nDans quelle ville parmi ces villes souhaitez-vous construire une école ? ");
				nomVille = clavier.nextLine();
				 
				if(commuAgglo.nomVilleExisteBis(nomVille)) {
					
					break;
				}
				commuAgglo.ajouterEcole(nomVille);
				
				break;
			
			case 2 : 
				
				commuAgglo.afficherVilles();
				commuAgglo.afficherLesEcolesDesVilles();
				System.out.println("\nDans quelle ville parmi ces villes souhaitez-vous retirer une école ? ");
				nomVille = clavier.nextLine();
				
				if(commuAgglo.nomVilleExisteBis(nomVille)) {
					break;
				}
				commuAgglo.retirerEcole(nomVille);
				
				
				break;
				
				
			case 3 : 
				boolean nonAccesible=false;
				ArrayList<Ville> villes = new ArrayList<>();
				
				for (Ville  ville : commuAgglo.getCommunauteAgglo()) {
					
					if(!ville.possedeEcole) {
					
						if(!commuAgglo.ecoleAccessibleVille(ville)) {
						
							commuAgglo.ajouterEcoleTre(ville.getNomVille());
							villes.add(ville);
							nonAccesible=true;
						
						}   
					}
				}
				if(nonAccesible) {
					System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
					System.out.println("Ajout d'école dans les villes qui n'avaient accès à aucune école, désormais ces villes ont accès à une école : \n");
					for (Ville ville : villes) {
					System.out.print(ville.getNomVille()+"\t");
				}
					System.out.println("\n----------------------------------------------------------------------------------------------------------------------\n");
					commuAgglo.afficherLesEcolesDesVilles();
				}
				
				choix=-1;
				break;
				
			default :
				
				System.out.println("\nErreur : vous devez saisir un nombre entier compris entre 1 & 3.\n");
				choix=1;
				break;
			}
			
			if(choix!=-1) {
				commuAgglo.afficherLesEcolesDesVilles();
				Utilitaire.menuAjoutEcole();
			}
			
		}while(choix==1 || choix==2 || choix==3);
		
		Utilitaire.menuPrincipal();
		Saisie.modeDeResolution(clavier,commuAgglo);	
		
  }
  
	/*
	 * Permet à l'utilisateur de résoudre automtiquement le programme  avec l'algorithme naif optimisé en récupérant la communauté d'agglomération à partir d'un fichier
	 * NB cet algorithme est une version améliorée par les membres du groupe
	 *@param commuAgglo correspond à notre communauté d'agglomération
	 *@param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 *
	 */
	
	
	public static void resolutionAutomatiqueNaive(Scanner clavier,CommuAgglo commuAgglo) {
		
		  int k =0;
		  Random r = new Random();
		  boolean choixEstFait=false;
		  RepresentationCa.recupererCA(commuAgglo , clavier);
		  
		  System.out.println("");
		  System.out.println("|=====================================================================================================================|");
		  System.out.println("|                  État de la communauté d'agglomération avant l'application de l'algorithme naïf                     |");
		  System.out.println("|=====================================================================================================================|\n");
		  
		  commuAgglo.afficherVilles();
		  commuAgglo.afficherLesEcolesDesVilles();
		  
		 do { 
		  	try {
				System.out.println("Veuillez saisir le nombre d'itération pour l'application de l'algorithme (un nombre entier positif) : ");
			  	k = clavier.nextInt();
				choixEstFait = true;
				if(k<=0) {
					choixEstFait = false;
					clavier.nextLine();
				}
		  
		  	}catch (InputMismatchException e  ) {
		
		  		System.out.println("\nErreur : Vous devez saisir un nombre entier.\n");
		  		clavier.nextLine();
		  	}
	   
		 } while(!choixEstFait);
		  
		  System.out.println("");
		  System.out.println("|=====================================================================================================================|");
		  System.out.println("|    L'algorithme naif est en cours d'exécution, veuillez patienter un instant ..........................             |");
		  System.out.println("|=====================================================================================================================|\n");
		  
		  
		  for (int i = 0; i <k; i++) {
			
			  int nombreAleatoire = r.nextInt(commuAgglo.getCommunauteAgglo().size()-1);
			  
			  if(commuAgglo.getCommunauteAgglo().get(nombreAleatoire).possedeEcole ) {
				  
				 commuAgglo.retirerEcoleAlgo(commuAgglo.getCommunauteAgglo().get(nombreAleatoire).getNomVille()); 
				  
				  
			  }else {
				  commuAgglo.ajouterEcoleAlgo(commuAgglo.getCommunauteAgglo().get(nombreAleatoire).getNomVille());
			  }
		
		  }
		
		  
		  System.out.println("");
		  System.out.println("|=====================================================================================================================|");
		  System.out.println("|                  État de la communauté d'agglomération après l'application de l'algorithme naïf                     |");
		  System.out.println("|=====================================================================================================================|\n");
		  
		  commuAgglo.afficherVilles();
		  commuAgglo.afficherLesEcolesDesVilles();
		  
		 Utilitaire.menuPrincipal();
		 Saisie.modeDeResolution(clavier,commuAgglo);	
			
	  }
	 
	
	/*
	 * Permet à l'utilisateur de résoudre automtiquement le programme  avec l'algorithme d'approximation optimisé et en récupérant la communauté d'agglomération à partir d'un fichier
	 * NB cet algorithme est une version améliorée par les membres du groupe
	 *@param commuAgglo correspond à notre communauté d'agglomération
	 *@param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 *
	 */
	
	public static void resolutionAutomatiqueAlgoApproximation(Scanner clavier,CommuAgglo commuAgglo) {
		
		 
		  RepresentationCa.recupererCA(commuAgglo , clavier);
		  int scoreCa = scoreCa(commuAgglo);
		  int scoreCourant = scoreCa;
		  int k =0;
		  int i=0;
		  int amelioration=0;
		  Random r = new Random();
		  boolean choixEstFait=false;
		  
		  System.out.println("");
		  System.out.println("|=====================================================================================================================|");
		  System.out.println("|       État de la communauté d'agglomération avant l'application de l'algorithme d'approximation                     |");
		  System.out.println("|=====================================================================================================================|\n");
		  
		  commuAgglo.afficherVilles();
		  commuAgglo.afficherLesEcolesDesVilles();
		  System.out.println("Nombre d'écoles initiales : "+scoreCa+"\n");
		  
		 do { 
		  	try {
				System.out.println("Veuillez saisir le nombre d'itération pour l'application de l'algorithme (un nombre entier positif) : ");
			  	k = clavier.nextInt();
				choixEstFait = true;
				if(k<=0) {
					choixEstFait = false;
					clavier.nextLine();
				}
		  
		  	}catch (InputMismatchException e  ) {
		
		  		System.out.println("\nErreur : Vous devez saisir un nombre entier.\n");
		  		clavier.nextLine();
		  	}
	   
		 } while(!choixEstFait);
		  
		  System.out.println("");
		  System.out.println("|=====================================================================================================================|");
		  System.out.println("|    L'algorithme d'approximation est en cours d'exécution, veuillez patienter un instant ..........................  |");
		  System.out.println("|=====================================================================================================================|\n");
		  
		  
		  while(i<k && amelioration != commuAgglo.getCommunauteAgglo().size()) {
			  
			  
			  int nombreAleatoire = r.nextInt(commuAgglo.getCommunauteAgglo().size()-1);
			  
			  if(commuAgglo.getCommunauteAgglo().get(nombreAleatoire).possedeEcole ) {
				  
					 if(commuAgglo.retirerEcoleAlgo(commuAgglo.getCommunauteAgglo().get(nombreAleatoire).getNomVille())) {
						 scoreCourant--;
					 }
					  
					  
			}else {
					if(commuAgglo.ajouterEcoleAlgo(commuAgglo.getCommunauteAgglo().get(nombreAleatoire).getNomVille())) {
						scoreCourant++;
					}
			}
			  
			  
			  
			  if(scoreCa<scoreCourant) {
				 i=0;
				 scoreCourant = scoreCa;
				 amelioration++;
			  }else {
				  i++;
			  }
		  }  
		
		
		  
		  System.out.println("");
		  System.out.println("|=====================================================================================================================|");
		  System.out.println("|                  État de la communauté d'agglomération après l'application de l'algorithme d'approximation          |");
		  System.out.println("|=====================================================================================================================|\n");
		  System.out.println();
		  commuAgglo.afficherVilles();
		  commuAgglo.afficherLesEcolesDesVilles();
		  
		  
		 Utilitaire.menuPrincipal();
		 Saisie.modeDeResolution(clavier,commuAgglo);	
			
	  }

	
	/*
	 * Permet d'obtenir le nombre d'écoles d'une communauté d'agglomération 
	 * 
	 *@param commuAgglo correspond à notre communauté d'agglomération
	 *@return le nombre d'ecoles de la Ca
	 *
	 */
	
		public static int scoreCa(CommuAgglo commuAgglo ) {
		int scoreCa =0;
		
		for (Ville ville : commuAgglo.getCommunauteAgglo()) {
			if(ville.possedeEcole) {
				scoreCa++;
			}
		}
		
		
		return scoreCa;
	}


}


