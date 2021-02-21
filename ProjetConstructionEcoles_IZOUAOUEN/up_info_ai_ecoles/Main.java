package up_info_ai_ecoles;

import java.util.Scanner;

/*
 * classe main qui est le point d'entré pour executer le programme 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 */
public class Main {

	public static void main(String[] args) {
		
		Utilitaire.menuBienvenue();
		Scanner clavier = new Scanner(System.in);
		Utilitaire.menuPrincipal();
		CommuAgglo commuAgglo = new CommuAgglo();
		Saisie.modeDeResolution(clavier,commuAgglo);
		clavier.close();

		
		
	}  
		
		

}
