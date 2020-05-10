package uvsq.fr.pglp5_1;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

 
public final class Personnel implements ComponentPersonnel{
	private final String nom;
	private final String prenom;
	private final String fonction;
	private final LocalDate  dateNaissance;
	private final List<NumeroTele> numeros;
	
	public static class Builder{
		//obligatoire
		private final String nom;
		private final String prenom;  
		private final String fonction;
		//Optionnel
		private  LocalDate  dateNaissance;
		private List<NumeroTele> numeros=new ArrayList<NumeroTele>();
		

	
	public Builder(String nom,String prenom,String fonction) {
		this.nom=nom;
		this.prenom=prenom;
		this.fonction=fonction;
	}
	public Builder dateNaissance(LocalDate dateNaissance) {
		this.dateNaissance=dateNaissance;
		return this;
	}
	public Builder addNumTelephone(NumeroTele num) {
		this.numeros.add(num);
		return this;
	}
	public Personnel build() {
		return new Personnel(this);
	}
}
private Personnel(Builder b) {
	this.nom=b.nom;
	this.prenom=b.prenom;
	this.dateNaissance=b.dateNaissance;
	this.fonction = b.fonction;
	this.numeros = b.numeros;
}
public String getNom() {
	return this.nom;
}
public String getPrenom() {
	return this.prenom;
}
/*
 * 
 */
public String getFonction() {
	return this.fonction;
}
public LocalDate getDateNaissance() {
	return this.dateNaissance;
}
public List<NumeroTele> getNumeros() {
	return this.numeros;
}
public String toString() {
	return nom + " " + prenom + " " + fonction + " " + dateNaissance + " " + numeros.toString();
}
public int isGroup() {
	return 0;
}

}
