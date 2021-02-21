package up_info_ai_ecoles;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * la classe Ville  permet de representer des villes
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 * 
 */

public class Ville {
	
	/*le nom de la ville
	* 
	*/
	private String nomVille;
	/*
	 *   liste des villes voisines 
	 * 
	*/
	private List <Ville> villesVoisines;
	
	/*
	 *   boolean qui vaut true ou false selon l'existence de l'ecole
	 */
	boolean possedeEcole;
	
	/*
	 * Constructeur Pour représenter une ville 
	 * @param nom de la ville 
	 * 
	 */
	
	public Ville(String nomVille) {
		
		this.nomVille=nomVille;
		villesVoisines = new ArrayList<Ville>();
		possedeEcole =true;
		
	}
	
	
	public Ville(String nomVille , boolean possedeEcole) {
		
		this.nomVille=nomVille;
		villesVoisines = new ArrayList<Ville>();
		this.possedeEcole = possedeEcole;
	}
	/*
	 * Permet d'obtenir le nom de la ville 
	 * @return nom de la ville
	 */

	public String getNomVille() {
		return nomVille;
	}
	/*
	 * Permet de modifier le nom d'une ville 
	 */
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	/*
	 * Permet de verifier si l'ecole existe 
	 * @return un boolean selon l'existence ou non de l'ecole dans la ville 
	 */

	public boolean getPossedeEcole() {
		return possedeEcole;
	}

	/*
	 * Permet de modifier l'existence de l'ecole 
	 */
	public void setPossedeEcole(boolean possedeEcole) {
		this.possedeEcole = possedeEcole;
	}
	
	/*
	 * methode qui  verifie l'existence d'une route entre 2 villes et en  construit une lorsqu'il n'y en a pas 
	 * @param v une ville  
	 * @return un boolean selon l'existence de la route entre 2 villes
	 */
	public boolean routeExiste(Ville v) {
		
		if(this.villesVoisines.contains(v) && v.villesVoisines.contains(this)) {
			System.out.println("il existe déja une route entre "+this.nomVille+ " et "+v.nomVille+".");
			return true;
		}else {
			
			this.villesVoisines.add(v);
			v.villesVoisines.add(this);
			System.out.println("\nla route entre les villes "+this.nomVille+" et "+v.nomVille+" a été créé avec succès\n");
			return false;
		}
	}
	
	@Override 
	public boolean equals(Object o) {
		if(o==null || !(o instanceof Ville))
			return false;
		if(this==o)
			return true;
		
		Ville v = (Ville) o;
		
		if(this.nomVille == v.nomVille)
			return true;
		else {
			return false;
		}
		
	}

	/*
	 * methode qui permet de retourner la liste des villes voisines 
	 * @return la liste des villes voisines
	 */  
	public List<Ville> getVillesVoisines() {
		return villesVoisines;
	}

	/*
	 * methode qui permet de remplacer la liste des villes voisines par la liste passé en paramètre
	 *@param villeVoisines c'est une liste de ville qui correspond à toutes les villes voisines d'une ville
	 */  
	public void setVillesVoisines(List<Ville> villesVoisines) {
		this.villesVoisines = villesVoisines;
	}

}
