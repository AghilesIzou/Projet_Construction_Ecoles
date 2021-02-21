package up_info_ai_ecoles;


/*
 * classe Route  qui sert à représenter une route entre deux villes 
 * 
 * 
 * @author Aghiles_IZOUAOUEN  
 * 
 * @version 1.0 
 * 
 */

public class Route {
	
	/*le nom de la  première ville reliée par cette route
	* 
	*/
	private String nomVilleA;
	
	/*le nom de la  première ville reliée par cette route
	* 
	*/
	
	private String nomVilleB;
	/*
	 * Constructeur Pour représenter une route
	 * @param nom de la première ville 
	 * @param nom de la deuxième ville
	 */
	
	public Route(String nomVilleA, String nomVilleB) {
		
		this.nomVilleA=nomVilleA;
		this.nomVilleB=nomVilleB;
	
	}
	
	/*
	 * Permet d'obtenir le nom de la  première ville  reliée par cette route
	 * 
	 */
	public String getNomVilleA() {
		return nomVilleA;
	}
	/*
	 * Permet de modifier le nom de la  première ville  reliée par cette route
	 * @return nom de la ville
	 */
	
	public void setNomVilleA(String nomVilleA) {
		this.nomVilleA = nomVilleA;
	}
	/*
	 * Permet d'obtenir le nom de la  deuxième ville  reliée par cette route
	 * @return nom de la ville
	 */
	
	public String getNomVilleB() {
		return nomVilleB;
	}
	
	/*
	 * Permet de modifier le nom de la  deuxième  ville  reliée par cette route
	 * @return nom de la ville
	 */
	
	public void setNomVilleB(String nomVilleB) {
		this.nomVilleB = nomVilleB;
	}
	
	
	

}
