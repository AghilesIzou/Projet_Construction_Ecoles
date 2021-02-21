package up_info_ai_ecoles_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import up_info_ai_ecoles.Algorithmes;
import up_info_ai_ecoles.CommuAgglo;

public class TestAlgorithmes {
	
	
	
	@Test
	void testScoreCa() {
		
		CommuAgglo ca = new CommuAgglo();
		
		
		assertEquals(3, Algorithmes.scoreCa(ca));
	
	}

}
