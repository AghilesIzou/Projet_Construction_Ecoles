package up_info_ai_ecoles_tests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import up_info_ai_ecoles.CommuAgglo;
import up_info_ai_ecoles.Ville;

public class TestCommuAgglo {
	
	
	@Test
	void testChercherVille() {
		
		CommuAgglo ca = new CommuAgglo();
		Ville villeA = new Ville("Paris");
		
		assertEquals(villeA, ca.chercherVille("Paris"));
	
	}

	
	@Test
	void testRetirerEcoleAlgo() {
		
		CommuAgglo ca = new CommuAgglo();
	assertEquals(true, ca.retirerEcoleAlgo("Paris"));
	
	}
}
