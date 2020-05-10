package uvsq.fr.pglp5_1;

public class NumeroTele{
	private String nom;
	private String telephone;

	public NumeroTele(String nom, String telephone) {
		this.nom = nom;
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return nom + " - " + telephone;
	}

	public String getNom() {
		return nom;
	} 


	public String getTelephone() {
		return telephone;
	}

}
