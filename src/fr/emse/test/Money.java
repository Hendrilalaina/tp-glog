package fr.emse.test;

public class Money {
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
		/////
	}
	
	public int amount() {
		return fAmount;
	}
	
	public String currency() {
		return fCurrency;
	}
	
	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
		
	}
	
	public boolean equals(Money m) {
		if (m == null) return false;
		return (amount() == m.amount() && currency().equals(m.currency()));
	}
}
