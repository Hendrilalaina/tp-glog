package fr.emse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Money m12CHF;
	Money m14CHF;
	@Before
	public void setUp() throws Exception {
		m12CHF = new Money(12, "CHF"); 
		m14CHF = new Money(14, "CHF");
	}

	@Test
	public void testSimpleAdd() {
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF); 
		assertTrue(expected.equals(result));
//		Reponse de question3:
//		Ce test ne passe pas car le methode equals() retourne vrai si les instances sont identiques mais dans ce cas, seuls les proprietes sont de meme valeur.
	}

	@Test
	public void testEquals() {
		
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
}
