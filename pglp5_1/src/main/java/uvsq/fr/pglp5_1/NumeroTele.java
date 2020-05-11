package uvsq.fr.pglp5_1;

import java.io.Serializable;

public class NumeroTele implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3882401496786760351L;
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
