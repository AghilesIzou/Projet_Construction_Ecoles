package up_info_ai_ecoles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Class CommuAgglo pour construire une communauté d'agglomeration à partir des villes 
 * 
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 *
 */

public class CommuAgglo {
	/*
	 * les villes de la communauté d'agglomeration 						
	 */
	
	private List<Ville> communauteAgglo;
	
	/*
	 * construit une communauté d'agglomeration 
	 */
	
	public CommuAgglo() {
		
		communauteAgglo = new ArrayList<Ville>();
	}
	
	/*
	 * methode pour ajouter une ville 
	 * @param ville une ville de la communauté d'agglomeration
	 * 
	 */
	
	public void ajouterVille(Ville ville) {
		
		communauteAgglo.add(ville);
		
	}
	
	/*
	 * methode qui verifie l'existence du nom d'une ville dont le nom est passé en paramétre  
	 * @param  c nom de la ville
	 * @return boolean true/false selon l'existence de la ville 
	 * 
	 */
	
	public boolean nomVilleExiste(String nom) {
		
		for (Ville ville : communauteAgglo) {
			
			if(ville.getNomVille().equals(nom)) {
		
				System.out.println("\nErreur : Ce nom de ville existe déja veuillez choisir un autre nom !!\n");
				return true;
				
			}
		}
		return false;
		
	}
	
	/*
	 * methode qui verifie l'appartenance  de la ville a la communaute d'agglomeration
	 * @param  c nom de la ville
	 * @return boolean true/false selon l'appartenance de la ville 
	 * 
	*/
	
	public boolean nomVilleExisteBis(String  nom) {
		
		for (Ville ville : communauteAgglo) {
			
			if(ville.getNomVille().equals(nom)) {
		
				return false;
				
			}
		}
		System.out.println("\nErreur : la ville "+ nom+ " ne fait pas partie de notre communauté d'agglomération");
		return true;
		
	}
	
	/*
	 *  methode qui affiche toutes les villes de la communauté d'agglomeration
	 *  
	 */
	
	public void  afficherVilles() {
		
		Iterator <Ville> it = communauteAgglo.iterator();
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("\t\t\t\t\tLa communauté d'agglomération est composée des villes suivantes : \n");
		
		while(it.hasNext()) {
			
			System.out.print(it.next().getNomVille()+"\t");
		}
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------\n");
		
	}
	
	/*
	 * methode qui sert a rechercher une ville dans la communauté d'agglomeration
	 * @param a nom de la ville
	 * @return  la ville recherchée
	 */
	
	public Ville chercherVille(String nom) {
		
		for (Ville ville : communauteAgglo) {
			
			if(ville.getNomVille().equals(nom)) {
				return ville;
			}	
			
		}
		return null;
	}
	
	/*
	 * méthode qui sert a trouver les villes qui sont isolées et pour lesquelles on devra construire une route
	 * @return boolean true/false selon l'existence de la ville dans la communauté d'agglomeration  
	 * 
	 */
	
	
	
	/*
	 * methode qui sert a ajouter une ecole
	 * @param a nom d'une ville
	 * @return boolean true/false selon l'existence d'une école dans cette ville
	 */
	
	public boolean ajouterEcole(String nom) {
		Ville v = null;
		v = chercherVille(nom);
		if(v.possedeEcole) {
			System.out.println("\nCette ville dispose déja d'une école.\n");
			return true;
		}
		v.setPossedeEcole(true);
		System.out.println("\nFélicitations l'école a été construite avec succès dans la ville "+v.getNomVille()+"\n");
		return false;
	}
	
	/*
	 * methode qui sert tout simplement a ajouter une ecole dans une ville
	 * @param a nom d'une ville
	 * 
	 */
	
	public void ajouterEcoleTre(String nom) {
		Ville v = null;
		v = chercherVille(nom);
		v.setPossedeEcole(true);
		
	}
	/*
	 * methode qui sert a ajouter une ecole dans une ville qui ne possède pas d'école
	 * @param a nom d'une ville
	 * @return boolean true/false selon l'existence d'une école dans cette ville
	 */
	public boolean ajouterEcoleBis(String nom) {
		Ville v = null;
		v = chercherVille(nom);
		if(v.possedeEcole) {
			System.out.println("\nCette ville dispose déja d'une école -> l'école ne sera pas ajouté dans la ville "+nom+".\n");
			return true;
		}
		v.setPossedeEcole(true);
		return false;
	}
	
	/*
	 * methode  qui sert a retirer une ecole selon son existence dans la ville et ses villes voisines
	 * @param a nom d'une ville 
	 * 
	 */
	public void retirerEcole(String nom) {
		
		
		List<Ville> voisin;
		Ville v = null;
		v = chercherVille(nom);
		voisin = v.getVillesVoisines();
		boolean existe = false;
		for (Ville ville : voisin) {
			if(ville.possedeEcole) {
				existe = true;
			}
		}
		if(v.possedeEcole) {
			
			if(existe) {
				v.setPossedeEcole(false);
				System.out.println("\nl'école de la ville "+v.getNomVille()+" a été retiré avec succès\n");
				
			}else {
				System.out.println("\nErreur : impossible de retirer cette école de la ville "+v.getNomVille()+ " car dans son voisinage il n'y a pas d'école");
			}
			
			
		}else {
			
			System.out.println("\nErreur : il n'y a pas d'écoles à retirer de la ville "+v.getNomVille()+ " car elle n'en dispose pas\n");
		}
		
		
	}
	
	/*
	 * methode qui sert a retirer  une ecole d'une ville en respectant un ensemble de contraintes
	 * @param a nom d'une ville
	 * @return boolean true/false qui indique si une école a été retiré ou non de cette ville
	 */
	
	public boolean retirerEcoleAlgo(String nom) {
		
		boolean ecoleRetiree = false;
		List<Ville> voisin;
		Ville v = null;
		v = chercherVille(nom);
		voisin = v.getVillesVoisines();
		ArrayList<Boolean> contraintes = new ArrayList<>();
		boolean existe = false;
		for (Ville ville : voisin) {
			if(ville.possedeEcole) {
				
				existe = true;
			}else {
				

				int nombreEcolesAuxAlentours=0;
				ArrayList<Ville> voisinsDuvoisins = (ArrayList<Ville>) ville.getVillesVoisines();
				for (Ville ville2 : voisinsDuvoisins) {
					if(ville2.getPossedeEcole()) {
						nombreEcolesAuxAlentours++;
					}
				}
				if( nombreEcolesAuxAlentours<2) {
					
					contraintes.add(false);
				}
			}
		}
		if(v.possedeEcole) {
			
			if(existe && ! contraintes.contains(false)) {
				v.setPossedeEcole(false);
				ecoleRetiree=true;
			}
			
		}
		
		return ecoleRetiree; 
	}
	
	/*
	 * methode qui permet d'ajouter une école à une ville si et seulement si elle ne dispose pas d'école et aucune ville voisine n'en possède
	 * @param a nom d'une ville
	 * @return boolean true/false qui indique si une école a été ajouté ou non à cette ville
	 */
	
	public boolean ajouterEcoleAlgo(String nom) {
		
		boolean ecoleAjoutee = false;
		List<Ville> voisin;
		Ville v = null;
		v = chercherVille(nom);
		voisin = v.getVillesVoisines();
		boolean ecolePresente = false;
		for (Ville ville : voisin) {
			if(ville.possedeEcole) {
				ecolePresente = true;
			}
		}
		if(!v.possedeEcole) {
			
			if(!ecolePresente) {
				v.setPossedeEcole(true);
				ecoleAjoutee =true;
			}
			
		}
		return ecoleAjoutee;
		
	}
	
	/*
	 * methode qui permet de vérifier si une ville dispose d'une école ou si dans son voisinage il y'en a une.
	 * @param a nom d'une ville
	 * @return boolean true/false qui indique si une ville a accès à une école
	*/
	
	public boolean ecoleAccessibleVille(Ville ville) {
		
			List<Ville> voisin;
			voisin = ville.getVillesVoisines();
			boolean existe = false;
			
			for (Ville villeVoisine : voisin) {
				if(villeVoisine.possedeEcole) {
					existe = true;
				}
			}
			
			return existe;
		
	}
	
	/* 
	 * Permet d'obtenir la communauté d'agglomeration 
	 * @return une liste de ville de la communauté d'agglomeration 
	 */
	public List<Ville> getCommunauteAgglo() {
		return communauteAgglo;
	}

	/*
	 * Permet de remplacer la liste de communauté d'agglomeration correspondante
	 */
	public void setCommunauteAgglo(List<Ville> communauteAgglo) {
		this.communauteAgglo = communauteAgglo;
	}
	
	/*
	 * methode sert a afficher la liste des villes possédant une école 
	 */
	
	public void  afficherLesEcolesDesVilles() {
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\nListe des villes ayant une école : \n");
		
		for (Ville ville : communauteAgglo) {
			
			if(ville.getPossedeEcole()) {
				
				System.out.println(ville.getNomVille()+"\t");
				
			}
		}
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
	}
	
	
	
	
	
	
	
	

}
