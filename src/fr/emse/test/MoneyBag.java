package fr.emse.test;

import java.util.Iterator;
import java.util.Vector;

public class MoneyBag implements IMoney{
	private Vector<Money> fMonies= new Vector<Money>();
	
	MoneyBag(Money m1, Money m2) {
		appendMoney(m1);
		appendMoney(m2);
	}
	
	MoneyBag(Money[] bag) {
		for(Money m : bag) {
			appendMoney(m);
		}
	}
	
	private void appendMoney(Money m) {
		if(fMonies.isEmpty()) {
			fMonies.add(m);
		} else {
			int i = 0;
			while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
				i++;
			if(i >= fMonies.size())
				fMonies.add(m);
			else
				fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
		}
	}
	
//	public boolean equals(MoneyBag mb) {
//		if (mb == null) return false;
//		if(fMonies.size() != mb.fMonies.size()) return false;
//		for(int i = 0; i < fMonies.size(); i++) {
//			if(!fMonies.get(i).equals(mb.fMonies.get(i)))
//				return false;
//		}
//		return true;
//	}
	
	public boolean equals(Object o) {
		if (o == null) return(false);

		if (!(o instanceof MoneyBag)) return(false);

		MoneyBag mb = (MoneyBag)o;
		if (fMonies.size() != mb.fMonies.size()) return(false);

		Iterator<Money> iOther = mb.fMonies.iterator();
		Iterator<Money> iThis = fMonies.iterator();

		while (iThis.hasNext()) {
			Money mOther = (Money)iOther.next();
			Money mThis = (Money)iThis.next();

			if (((mThis.amount() != mOther.amount())
					|| !mThis.currency().equals(mOther.currency()))) {
				return(false);
			}
		}
		return(true);
	}


	public IMoney add(IMoney m) {
		return(m.addMoneyBag(this));
	}
	
	@Override
	public IMoney addMoney(Money m) {
		// Add Money to this MoneyBag
		for (Money mbm : fMonies) {
			if (mbm.currency() == m.currency()) {
				mbm.add(m);
				return(this);
			}
		}
		this.appendMoney(m);
		return(this);
	}

	@Override
	public IMoney addMoneyBag(MoneyBag mb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		String s = "MonbeyBag: ";
		for (Money m : fMonies) {
			s += m.toString() + " ";
		}
		return(s);
	}

}
