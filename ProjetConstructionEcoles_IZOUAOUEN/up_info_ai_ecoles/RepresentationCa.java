package up_info_ai_ecoles;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * la classe RepresentationCa  permet de representer de représenter une communautéd'agglomération à partir d'un fichier
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 * 
 */


public class RepresentationCa {
	
	/*
	 *   liste des villes 
	 * 
	*/
	
	private static ArrayList<Ville> villes= new ArrayList<>();
	
	/*
	 *   liste des routes 
	 * 
	*/
	private static ArrayList<Route> routes = new  ArrayList<>();
	
	/*
	 *   liste des écoles
	 * 
	*/
	private static ArrayList<String> ecoles = new ArrayList<>();
	
	/*
	 * 
	 * permet de récuperer une Ca à partir d'un fchier dont le chemin est saisi par  l'utilisateur
	 * @param commuAgglo correspond à notre communauté d'agglomération
	 * @param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 */
	
	
	public static void recupererCA(CommuAgglo commuAgglo,Scanner clavier) {
		clavier.nextLine();
		Utilitaire.menuCheminFichier();
		String chemin = clavier.nextLine();
		
		boolean fichierNonValide = false;
		
		do {
			
			if(fichierNonValide) {
				
				Utilitaire.menuCheminFichierBis();
				chemin = clavier.nextLine();
			}
		
			if (chemin.equals(" ")) {
			
				System.out.println("\nErreur : Ce programme attend qu'un chemin valide vers un fichier soit saisi.\n");
				fichierNonValide=true;
				continue;
			}

			
			String extension = chemin.substring(chemin.lastIndexOf(".") + 1, chemin.length());

			String ca = "ca";
			
			if (!ca.equals(extension)) {
			
				System.out.println("\nErreur : Le format du fichier ne correspond pas au format du fichier attendu.\n");
				fichierNonValide=true;
				continue;
			}
	
			try (BufferedReader reader = new BufferedReader(new FileReader(chemin))) {
			
				fichierNonValide=false;
				String ligne;
				
				while ((ligne = reader.readLine()) != null) {
					
					
				
						if(ligne.startsWith("ville")) {
					
							String nomVille = null;
							StringBuilder sb = new StringBuilder();
							Pattern pattern = Pattern.compile("[a-zA-Z]");   
							Matcher matcher = pattern.matcher(ligne.substring(5)) ;  
					 
							while (matcher.find()) {  
						
								sb.append(matcher.group());
								nomVille = sb.toString();
							}
							
							Ville ville = new Ville(nomVille,false);
							villes.add(ville); 
							
						}
						else if(ligne.startsWith("route")) {
							
							String routesEntresVilles = null;
							StringBuilder sb = new StringBuilder();
							Pattern pattern = Pattern.compile("[a-zA-Z,]");   
							Matcher matcher = pattern.matcher(ligne.substring(5)) ;  
					 
							while (matcher.find()) {  
						
								sb.append(matcher.group());
								routesEntresVilles = sb.toString();
							}
							String villeA= routesEntresVilles.split(",")[0];
							String villeB = routesEntresVilles.split(",")[1];
							
							routes.add(new Route(villeA,villeB));
							
						}
						else if(ligne.startsWith("ecole")) {
							
							String nomVilleEcole = null;
							StringBuilder sb = new StringBuilder();
							Pattern pattern = Pattern.compile("[a-zA-Z]");   
							Matcher matcher = pattern.matcher(ligne.substring(5)) ;  
					 
							while (matcher.find()) {  
						
								sb.append(matcher.group());
								nomVilleEcole = sb.toString();
							}
							
							ecoles.add(nomVilleEcole);
							
						}
					
				}

			} catch (FileNotFoundException e) {
			
				System.out.println("\nErreur : Le fichier ayant pour chemin -> " + chemin + " n'existe pas.\n");
				fichierNonValide=true;
				continue;
			
			}catch (IOException e) {
			
				System.out.println(e.getMessage());
				fichierNonValide=true;
				continue;
			}
	
			
			}while(fichierNonValide);
		
		construireCa(commuAgglo,  clavier);
	
	}
	
	/*
	 * 
	 * permet de construire une communauté d'agglomération à partir des données récupérées d'un ensemble de listes qui ont récupéré les données à leur tour depuis un fichier 
	 * @param commuAgglo correspond à notre communauté d'agglomération
	 * @param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 */
	
	public static void construireCa(CommuAgglo commuAgglo, Scanner clavier) {
		
		System.out.println("");
		System.out.println("|=================================================================================================================|");
		System.out.println("|   Chargement de la communauté d'agglomération à partir du fichier ............. veuillez patienter un instant   |");
		System.out.println("|=================================================================================================================|");
		
		
		if(commuAgglo.getCommunauteAgglo()!=null) {
			commuAgglo.getCommunauteAgglo().clear();
		}
		
		for (Ville ville : villes) {
			
			if(commuAgglo.getCommunauteAgglo().contains(ville)) {
				System.out.println("Erreur : "+ville.getNomVille()+ " existe déjà dans notre communauté d'agglomération.\n");
			}else {
				commuAgglo.getCommunauteAgglo().add(ville);
			}
		}
		
		 
		
		 for (Route route : routes) {
			
			 commuAgglo.chercherVille(route.getNomVilleA()).routeExiste(commuAgglo.chercherVille(route.getNomVilleB()));
		 
		 }
		 
		 
		 for (String nomVille : ecoles) {
			 
			 commuAgglo.ajouterEcoleBis(nomVille);
		 }
		 boolean nonAccessible=false;
		 
		 if(ecoles.isEmpty()) {
			 
			 for (Ville ville : commuAgglo.getCommunauteAgglo()) {
				ville.setPossedeEcole(true);
			 }
			 
		 }else {
			 
			  for (Ville ville : commuAgglo.getCommunauteAgglo()) {
				
				  if(!ville.possedeEcole) {	
					if(!commuAgglo.ecoleAccessibleVille(ville)) {
					 nonAccessible=true;
					} 
				}
			}
		 }
		 
		 if(nonAccessible) {
			 
			 for (Ville ville : commuAgglo.getCommunauteAgglo()) {
					
				 ville.setPossedeEcole(true);
			 }
		 
		 }
		
		 if(villes!=null) {
			 villes.clear();
		 }
		 if(routes!=null) {
			 routes.clear();
		 }
		 
		 if(ecoles!=null) {
			 ecoles.clear();
		 }
	
	
	
	
	
	}
	
	/*
	 * 
	 * permet de sauvegarder  une Communauté d'agglomération dans un fichier dont le chemin est saisi par  l'utilisateur
	 * @param commuAgglo correspond à notre communauté d'agglomération
	 * @param clavier correspond à un objet de type Scanner afin de faire des saise au clavier
	 */
	
	
	public static void sauvgarderCa(CommuAgglo commuAgglo, Scanner clavier) {
	
		
		if(!commuAgglo.getCommunauteAgglo().isEmpty()) {
			
			//clavier.nextLine();
			Utilitaire.menuCheminFichierSauvgarde();
			String chemin = clavier.nextLine();
		
			boolean fichierNonValide = false;
		
			do {
			
				if(fichierNonValide) {
				
					Utilitaire.menuCheminFichierSauvgardeBis();
					chemin = clavier.nextLine();
				}
		
				if (chemin.equals(" ")) {
			
					System.out.println("\nErreur : Ce programme attend qu'un chemin valide vers un fichier soit saisi.\n");
					fichierNonValide=true;
					continue;
				}

			
				String extension = chemin.substring(chemin.lastIndexOf(".") + 1, chemin.length());

				String ca = "ca";
			
				if (!ca.equals(extension)) {
			
					System.out.println("\nErreur : Le format du fichier ne correspond pas au format du fichier attendu.\n");
					fichierNonValide=true;
					continue;
				}
	
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(chemin))) {
			
				
				
					for(int i=0; i<commuAgglo.getCommunauteAgglo().size();i++) {
					
						StringBuffer sb = new StringBuffer();
						sb.append("ville(");
						sb.append(commuAgglo.getCommunauteAgglo().get(i).getNomVille());
						sb.append(").");
						writer.write(sb.toString()+"\n");
					}
					ArrayList<Ville> villesASauvgarde = (ArrayList<Ville>) commuAgglo.getCommunauteAgglo();
				
					for(int i=0;i<villesASauvgarde.size();i++) {
					
						ArrayList<Ville> villesVoisines = (ArrayList<Ville>) villesASauvgarde.get(i).getVillesVoisines();
					
						for (Ville villeVoisine : villesVoisines) {
						
							StringBuffer sb = new StringBuffer();
							sb.append("route(");
							sb.append(villesASauvgarde.get(i).getNomVille());
							sb.append(",");
							sb.append(villeVoisine.getNomVille());
							sb.append(").");
							villeVoisine.getVillesVoisines().remove(villesASauvgarde.get(i));
							writer.write(sb.toString()+"\n");
					
						}
					
					}
				
				
					writer.write("\n");
					writer.write("\n");
				
					for(int i=0; i<commuAgglo.getCommunauteAgglo().size();i++) {
					
						if(commuAgglo.getCommunauteAgglo().get(i).getPossedeEcole()) {
						
							StringBuffer sb = new StringBuffer();
							sb.append("ecole(");
							sb.append(commuAgglo.getCommunauteAgglo().get(i).getNomVille());
							sb.append(").");
							writer.write(sb.toString()+"\n");
				
						}
					
					}
				
					fichierNonValide=false;

				} catch (FileNotFoundException e) {
			
					System.out.println("\nErreur : Le fichier ayant pour chemin -> " + chemin + " n'existe pas.\n");
					fichierNonValide=true;
					continue;
			
				}catch (IOException e) {
			
					System.out.println(e.getMessage());
					fichierNonValide=true;
					continue;
				}
	
			
			}while(fichierNonValide);
		
			System.out.println("");
			System.out.println("|=====================================================================================================|");
			System.out.println("|                   La sauvegarde de votre solution a été effectué avec succès                       :|");
			System.out.println("|=====================================================================================================|\n");
		
			}else {
				System.out.println("\nErreur : La communauté étant vide, on ne peut pas effectuer une sauvegarde.\n");
			}
	
		
		
			Utilitaire.menuPrincipal();
			Saisie.modeDeResolution(clavier,commuAgglo);
	}
	
	/*
	 * methode static qui permet d'obtenir la liste de villes de notre communauté d'agglomération
	 * @return la liste des villes de la CA
	 */  
	public static ArrayList<Ville> getVilles() {
		return villes;
	}

	/*
	 * methode static qui permet d'obtenir la liste de routes de notre communauté d'agglomération
	 * @return la liste des routes de la CA
	 */  
	
	public static ArrayList<Route> getRoutes() {
		return routes;
	}

	/*
	 * methode qui permet de retourner la liste des écoles de notres CA 
	 * @return la liste des écoles de notre Ca
	 */  
	public static ArrayList<String> getEcoles() {
		return ecoles;
	}

}
