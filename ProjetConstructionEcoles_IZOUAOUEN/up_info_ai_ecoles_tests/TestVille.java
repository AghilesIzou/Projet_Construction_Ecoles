package up_info_ai_ecoles_tests;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import up_info_ai_ecoles.Ville;


public class TestVille {
	
	@Test
	void testRouteExiste() {
		
		Ville villeA = new Ville("Paris");
		
		assertEquals(true, villeA.routeExiste(villeA));
	
	}
	
	
	@Test
	void testGetNomVille() {
		
		Ville villeA = new Ville("Paris");
		
		assertEquals("Paris", villeA.getNomVille());
	
	}

}
