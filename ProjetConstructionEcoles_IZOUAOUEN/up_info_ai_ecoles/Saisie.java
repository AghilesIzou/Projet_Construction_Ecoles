package up_info_ai_ecoles;

import java.util.InputMismatchException;

import java.util.Scanner;

/**
 * 
 * la classe Saisie  permet de traiter les choix de modes de résolutions et d'appeler les méthodes des algorithmes correspondant 
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 * 
 */



public class Saisie {
	
	/*
	 * Permet à l'utilisateur de choisir l'opération qu'il souhaite  effectuer parmi les 4 offertes par le programme
	 *@param commuAgglo correspond à notre communauté d'agglomération
	 *@param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 *
	 */
	
	public static void modeDeResolution(Scanner clavier, CommuAgglo commuAgglo) {
		
		int choix=0;
		
		boolean choixEstFait=false;
		
		do {
		
			try {
				choix = clavier.nextInt();
				clavier.nextLine();
				choixEstFait = true;
				
				switch(choix) {
				
				 case 1 : 
					 choixManuel(clavier,commuAgglo);
					 break;
				
				 case 2: 
					 
					 choixAutomatique(clavier, commuAgglo);
					 break;
				 
				 case 3:
					 
					 RepresentationCa.sauvgarderCa(commuAgglo, clavier);
					 break;
				
				 case 4:
					
					 Utilitaire.menuFin();
					 break;
				
				 default:
					
					System.out.println("\nErreur : Vous devez saisir un nombre entier entre 1 et 4.\n");
					choixEstFait = false;
					Utilitaire.menuPrincipal();
					break;
				
				}
				
			} catch (InputMismatchException e  ) {
				
				System.out.println("\nErreur : Vous devez saisir un nombre entier.\n");
				clavier.nextLine();
				Utilitaire.menuPrincipal();
			}
			
			
		} while (!choixEstFait) ;
		
		
		
		
	}

	/*
	 * Permet à l'utilisateur de choisir le mode de résolution manuelle 
	 	@param commuAgglo correspond à notre communauté d'agglomération
	 * @param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 */
	
	public static void choixManuel(Scanner clavier, CommuAgglo commuAgglo) {
		
		Utilitaire.menuResolutionManuelle();
		int choix=0;
		boolean choixEstFait=false;
		
		do {
		
			try {
				choix = clavier.nextInt();
				choixEstFait = true;
				
				switch(choix) {
				
				 case 1 : 
					 Algorithmes.resolutionManuelleSaisie(clavier,commuAgglo);;
					 break;
				
				 case 2: 
					
					  Algorithmes.resolutionManuelleFichier(clavier, commuAgglo);
					 break;
				 
				
				 default:
					
					System.out.println("\nErreur : Vous devez saisir un nombre entier entre 1 et 2.\n");
					choixEstFait = false;
					break;
				
				}
				
			} catch (InputMismatchException e  ) {
				
				System.out.println("\nErreur : Vous devez saisir un nombre entier.\n");
				clavier.nextLine();
				Utilitaire.menuResolutionManuelle();
			}
			
			
		} while (!choixEstFait) ;
		
		
	}
	/*
	 * Permet à l'utilisateur de choisir le mode de résolution automatique
	 * @param commuAgglo correspond à notre communauté d'agglomération
	  @param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 */ 
	
	public static void choixAutomatique(Scanner clavier, CommuAgglo commuAgglo) {
		
		Utilitaire.menuResolutionAutomatique();
		int choix=0;
		boolean choixEstFait=false;
		
		do {
		
			try {
				choix = clavier.nextInt();
				choixEstFait = true;
				
				switch(choix) {
				
				 case 1 : 
					Algorithmes.resolutionAutomatiqueNaive(clavier, commuAgglo);
					 break;
				
				 case 2: 
					
					 Algorithmes.resolutionAutomatiqueAlgoApproximation(clavier, commuAgglo);
					 break;
				 
				 case 3 :
					 
					Utilitaire.menuPrincipal();
					Saisie.modeDeResolution(clavier,commuAgglo);
					break;
				 
				 default:
					
					System.out.println("\nErreur : Vous devez saisir un nombre entier entre 1 et 3.\n");
					choixEstFait = false;
					break;
				
				}
				
			} catch (InputMismatchException e  ) {
				
				System.out.println("\nErreur : Vous devez saisir un nombre entier.\n");
				clavier.nextLine();
				Utilitaire.menuResolutionAutomatique();
			}
			
			
		} while (!choixEstFait) ;
		
		
	}

}
