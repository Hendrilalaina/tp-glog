package iut.bad;

public class Femme extends Humain{
	public Femme(String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public static void main(String args[]) {
		Femme femme = new Femme("Ashley", "Johnsom", 26);
		Homme homme = new Homme("Bob", "Alvin", 30);
		
		femme.ami(homme);
	}
}
