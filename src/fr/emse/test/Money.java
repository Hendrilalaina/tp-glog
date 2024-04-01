package fr.emse.test;

public class Money implements IMoney{
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
	
	public IMoney add(IMoney m) {
		return(m.addMoney(this));
	}

	@Override
	public IMoney addMoney(Money m) {
		if (currency().equals(m.currency())) {
			return(new Money(amount() + m.amount(), currency()));
		}
		else {
			return(new MoneyBag(this, m));
		}
	}

	@Override
	public IMoney addMoneyBag(MoneyBag mb) {
		return(mb.addMoney(this));
	}

}
