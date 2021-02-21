package up_info_ai_ecoles;

/*
 * classe Utilitaire  qui sert à afficher des menus
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 */

public class Utilitaire {
	
	/*
    * methode qui affiche le menu de bienvenue
    */
  
	
	public static void menuBienvenue() {
		
		
		System.out.println("");
		System.out.println("|===================================================================|");
		System.out.println("|======== Bienvenue dans le projet de construction d'écoles ========|");
		System.out.println("|===================================================================|");
		System.out.println("|                                                                   |");
		System.out.println("|                       - Aghiles IZOUAOUEN                         |");
		System.out.println("|                                                                   |");
		System.out.println("|===================================================================|\n");
			
	
	
	}
	/*
	 * methode qui affiche le menu qui demande le chemin d'un fichier 
	 */
	public static void menuCheminFichier() {
		
		
		System.out.println("");
		System.out.println("|=======================================================================================|");
		System.out.println("|    Veuillez Saisir le chemin vers le fichier Contenant la Communauté d'agglomération  |");
		System.out.println("|=======================================================================================|\n");
	}
	
	/*
	 * methode qui affiche le menu qui demande le chemin du fichier de sauvgarde
	 */
	public static void menuCheminFichierSauvgarde() {
		
		
		System.out.println("");
		System.out.println("|==========================================================================================================|");
		System.out.println("|    Veuillez Saisir le chemin vers le fichier ou vous souhaitez sauvgarder votre solution                 |");
		System.out.println("|==========================================================================================================|\n");
	}
	
	/*
	 * methode qui affiche le menu qui demande le chemin vers un fichier valide 
	 */
	public static void menuCheminFichierBis() {
		
		
		System.out.println("");
		System.out.println("|=====================================================================================================|");
		System.out.println("|  Veuillez Saisir un chemin correct vers un fichier valide Contenant la Communauté d'agglomération  :|");
		System.out.println("|=====================================================================================================|\n");
	}
	
	/*
	 * methode qui affiche le menu qui demande le chemin valide vers un fichier de sauvegarde
	 */
	public static void menuCheminFichierSauvgardeBis() {
		
		
		System.out.println("");
		System.out.println("|=====================================================================================================|");
		System.out.println("|  Veuillez Saisir un chemin correct vers un fichier de sauvgarde de votre solution                  :|");
		System.out.println("|=====================================================================================================|\n");
	}
	
	/*
	 * methode  qui affiche le menu de choix d'opération à effectuer
	 * 
	 */
	
	public static void menuAjoutRoute() {
		
		System.out.println("");
		System.out.println("|=================================================================|");
		System.out.println("|============== Création de route entre les villes ===============|");
		System.out.println("|=================================================================|");
		System.out.println("|1) Ajouter une route.                                            |");
		System.out.println("|2) Fin.                                                          |");
		System.out.println("|=================================================================|");
	}
	
	/*
	 * methode  qui affiche le menu d'ajout d'écoles qui invite l'utilisateur à ajouter, retirer une école ou à terminer le programme 
	 *
	 */
	public static  void menuAjoutEcole() {
		
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|================== Ajout/Retrait d'écoles ===================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Ajouter une école.                                        |");
		System.out.println("|2) Retirer une école.                                        |");
		System.out.println("|3) Fin.                                                      |");
		System.out.println("|=============================================================|");
		
		
	}
	
	/*
	 * methode  qui  affiche un message invitant l'utilisateur à saisir le nombre de villes de la communauté d'agglomeration
	 * 
	 */
	
	public static void menuNombreVille() {
		
		System.out.println("");
		System.out.println("|=====================================================================================================|");
		System.out.println("|  Veuillez saisir le nombre de ville de votre communauté d'agglomération (compris entre 1 et 26)     :|");
		System.out.println("|=====================================================================================================|\n");
		
		
	}
	/*
	 * methode  qui  affiche un message invitant l'utilisateur à saisir le nom de chaque ville
	 * 
	 */
	
	public static void menuNomVille() {
		
		System.out.println("");
		System.out.println("|=====================================================================================================|");
		System.out.println("|                        Veuillez saisir le nom de chaque villes                                      |");
		System.out.println("|=====================================================================================================|\n");
	}
	
	/*
	 * methode  qui  affiche un message invitant l'utilisateur à dire entre quelles villes il souhaite construire une route
	 * 
	 */
	public static void menuConstructionRoute() {
		
		System.out.println("");
		System.out.println("|=====================================================================================================|");
		System.out.println("|   Parmi ces villes entre lesquelles souhaitez-vous construire une route                             |");
		System.out.println("|=====================================================================================================|\n");
		
		
	}
	/*
	 * methode qui affiche le menu de choix du mode de résolution
	 */
	public static void  menuPrincipal() {
		
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|==================== Mode de Résolution  ====================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Résoudre manuellement.                                    |");
		System.out.println("|2) Résoudre automatiquement.                                 |");
		System.out.println("|3) Sauvegarder.                                              |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|\n");
		
	}
	/*
	 * methode qui affiche le menu de la fin 
	 */
	public static void  menuFin() {
		
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|====================== Fin du programme =====================|");
		System.out.println("|=============================================================|");
	}
	
	/*
	 * methode qui affiche le menu qui demande le mode de résolution manuel
	 */
	
	public static void menuResolutionManuelle() {
		
		System.out.println("");
		System.out.println("|=======================================================================================|");
		System.out.println("|=========================== Mode de Résolution manuelle ===============================|");
		System.out.println("|=======================================================================================|");
		System.out.println("|1) Construire manuellement la communauté d'agglomération.                              |");
		System.out.println("|2) Récupérer la communauté d'agglomération à partir d'un fichier.                      |");
		System.out.println("|=======================================================================================|\n");
		
	}
	/*
	 * methode qui affiche le menu qui demande le mode de résolution automatique
	 */
	
		public static void menuResolutionAutomatique() {
		
		System.out.println("");
		System.out.println("|==========================================================================================|");
		System.out.println("|=========================== Mode de Résolution automatique ===============================|");
		System.out.println("|==========================================================================================|");
		System.out.println("|1) Utiliser l'algorithme naîf.                                                            |");
		System.out.println("|2) Utiliser l'algorithme d'approximation (un peu moins naîf).                             |");
		System.out.println("|3) Fin.                                                                                   |");
		System.out.println("|==========================================================================================|\n");
		
	}

	
		

}
