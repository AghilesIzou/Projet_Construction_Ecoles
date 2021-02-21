package up_info_ai_ecoles_tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import up_info_ai_ecoles.RepresentationCa;
import up_info_ai_ecoles.Route;

public class TestRepresenterCa {
	
	
	@Test
	void testGetEcoles() {
		
		ArrayList<String> ecoles = new ArrayList<>();
		
		assertEquals(ecoles, RepresentationCa.getEcoles());
	
	}
	
	@Test
	void testGetRoutes() {
		
		ArrayList<Route> routes= new ArrayList<>();
		
		assertEquals(routes, RepresentationCa.getRoutes());
	
	}

}
