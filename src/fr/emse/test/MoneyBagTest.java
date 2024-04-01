package fr.emse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {

	MoneyBag fMB1, fMB2;
	Money f12CHF, f14CHF, f7USD, f21USD;
	@Before
	public void setUp() throws Exception {
		f12CHF = new Money(12, "CHF");
		f14CHF = new Money(14, "CHF");
		f7USD = new Money(7, "USD");
		f21USD = new Money(21, "USD");
		fMB1 = new MoneyBag(f12CHF, f7USD);
		fMB2 = new MoneyBag(f14CHF, f21USD);
	}

	@Test
	public void testEquals() {
		assertTrue(!fMB1.equals(null));
		assertEquals(fMB1, fMB1);
		assertTrue(!fMB1.equals(f12CHF));
		assertTrue(!f12CHF.equals(fMB1));
		assertTrue(!fMB1.equals(fMB2));
	}
	
	@Test
	public void testMixedSimpleAdd() {
		Money bag[] = { f12CHF, f7USD };
		MoneyBag expected = new MoneyBag(bag);
		assertEquals(expected, f12CHF.add(f7USD));
	}
	
	@Test
	public void testSimpleAdd() {
		// [12 CHF] + {[7 USD]} == {[7 USD][12 CHF]}
		Money bag[] = {f7USD};
		MoneyBag moneyBag = new MoneyBag(bag);
		MoneyBag expected = new MoneyBag(f7USD, f12CHF);
		assertTrue(expected.equals(f12CHF.add(f7USD)));
	}
	
	@Test
	public void testBagSimpleBagAdd() {
		// [12 CHF] + {[7 USD, 12 CHF]} == {[24 CHF] [7 USD]}
		Money bag[] = {f12CHF, f7USD};
		MoneyBag expected = new MoneyBag(new Money(24, "CHF"), f7USD);
		assertEquals(expected, f12CHF.add(new MoneyBag(bag)));
	}
	
	@Test
	public void testBagBagAdd() {
		// {[12 CHF][7 USD]} + {[7 USD] [12 CHF]} == {[12 CHF][7 USD]}
		Money bag1[] = {f12CHF, f7USD};
		Money bag2[] = {f7USD, f12CHF};
		MoneyBag expected = (MoneyBag) new MoneyBag(bag1).add(new MoneyBag(bag2));
		assertEquals(expected, new MoneyBag(bag1).add(new MoneyBag(bag2)));
	}
}
