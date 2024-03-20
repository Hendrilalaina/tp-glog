package iut.bad;

public abstract class Humain implements Consommation{
	protected String nom;
	protected String prenom;
	protected int age;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	protected void details() {
		System.out.println("Nom: " + getNom() + "\nPrenom: " + getPrenom() + "\nAge: " + getAge());
	}
	
	@Override
	public void manger() {
		System.out.println(getNom() + " " + getPrenom() + " mange.");
	}
	
	@Override
	public void boire() {
		System.out.println(getNom() + " " + getPrenom() + " mange.");
	}
	
	protected void ami(Humain h) {
		System.out.println(getNom() + " " + getPrenom() + " et " + h.getNom() + " " + h.getPrenom() + " sont ami(e)s.");
	}
}
