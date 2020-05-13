package uvsq.fr.pglp5_1;
import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

 
public final class Personnel implements Serializable,ComponentPersonnel{
	

		private static final long serialVersionUID = -5504351746862020764L;
		private  String nom;
		private  String prenom;
		private  String fonction;
		private  LocalDate  dateNaissance;
		private  List<NumeroTele> numeros;
		
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
		/**
		 * Les getters
		 */
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
		
		public int isGroup() {
			return 0;
		}
		/**
		 * Les setters
		 */
		public void setNom(String n) {
			 this.nom=n;
		}
		public void setPrenom(String pr) {
			 this.prenom=pr;
		}
		public void setFonction(String f) {
			 this.fonction=f;
		}
		/**
		 * Personnaliser l'affichage d'une personne
		 */
		public String toString() {
			return nom + " " + prenom + " " + fonction + " " + dateNaissance + " " + numeros.toString();
		}
}
