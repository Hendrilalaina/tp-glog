package fr.emse.test;

public class Money {
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount() {
		return fAmount;//amount
	}
	
	public String currency() {
		return fCurrency;
	}
	
	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
		
	}
	
	@Override
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(object instanceof Money) {
			Money money = (Money) object;
			return (amount() == money.amount() && currency().equals(money.currency()));
		}
		return false;
		
	}
}
