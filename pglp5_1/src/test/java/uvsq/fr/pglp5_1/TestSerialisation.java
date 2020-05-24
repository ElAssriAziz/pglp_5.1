package uvsq.fr.pglp5_1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import uvsq.fr.pglp5_1.NumeroTele;


public class TestSerialisation {
	
	@Test
	public void testSerialisatioGroupePersonnel() {
		try{
			Personnel personne1 = new Personnel
					.Builder("Marc","Michel","Manager")
					.dateNaissance( LocalDate.of(1970, Month.APRIL, 20))
					.addNumTelephone(new NumeroTele("Personnel","0605485237"))
					.addNumTelephone(new NumeroTele("Professionnel","06054414527"))
					.build();
			Personnel personne2 = new Personnel
					.Builder("aaa","bbb","cccc")
					.dateNaissance( LocalDate.of(1995, Month.MARCH, 16))
					.addNumTelephone(new NumeroTele("Personnel","0605221237"))
					.build();
			Personnel personne3 = new Personnel
					.Builder("ddd","eee","ffff")
					.dateNaissance( LocalDate.of(1995, Month.JANUARY, 14))
					.addNumTelephone(new NumeroTele("Personnel","0605221237"))
					.build();
			GroupePersonnel gp1 =new GroupePersonnel();
			GroupePersonnel gp2 =new GroupePersonnel();
			GroupePersonnel gp3 =new GroupePersonnel();
			gp1.addPersonnel(personne1);
			gp1.addPersonnel(personne2);
			gp2.addPersonnel(gp1);
		
			gp2.addPersonnel(personne3);
			ObjectOutputStream out = new ObjectOutputStream(
					
					new FileOutputStream("Groupe.serial"));
	out.writeObject(gp2);
	System.out.print("Groupe 2 est bien sérialisé !\n");
	out.close();
	ObjectInputStream in = new ObjectInputStream(new FileInputStream("Groupe.serial"));
	GroupePersonnel GroupeTest  =new GroupePersonnel();
	GroupeTest = (GroupePersonnel) in.readObject();
       System.out.print("Groupe 2 est bien désérialisé !\n");
    
       
      /* assertFalse("Le groupe 2 ne contient pas personne 2",GroupeTest.getListePersonnels().contains(personne2));
       assertTrue("Le groupe 2 contient groupe 1 et personne3",GroupeTest.getListePersonnels().size()==2);
   */
   	gp3.addPersonnel(personne2);
	gp2.addPersonnel(gp3);
    assertTrue("Le groupe 2 contient groupe 1 et personne3",GroupeTest.getListePersonnels().size()==2);
       in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}}
	
	@Test
	public void testSerialisatioPersonnel() {
		try{
			
		    Personnel personneTest = new Personnel.Builder(null, null, null).build();
		   
			Personnel personne = new Personnel
					.Builder("Marc","Michel","Manager")
					.dateNaissance( LocalDate.of(1970, Month.APRIL, 20))
					.addNumTelephone(new NumeroTele("Personnel","0605485237"))
					.addNumTelephone(new NumeroTele("Professionnel","06054414527"))
					.build();
			ObjectOutputStream out = new ObjectOutputStream(
					
							new FileOutputStream("personne.serial"));
			out.writeObject(personne);
			System.out.print("Personne est bien sérialisé !\n");
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("personne.serial"));
		       personneTest = (Personnel) in.readObject();
		       System.out.print("Personne est bien désérialisé !\n");
		    
		       assertEquals(personneTest.getNom(), "Marc");
		       in.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSerialisatioDAOPersonnel() {
		try{
			
		    PersonnelDAO personnedao = new PersonnelDAO();
		    PersonnelDAO personnedaoTest = new PersonnelDAO();
		    Personnel p1 = new Personnel
	    			.Builder("nomB","prenomB","Directeur")
	    			.dateNaissance( LocalDate.of(1975, Month.MAY, 15))
	    			.addNumTelephone(new NumeroTele("Personnel","06054852371"))
	    			.build();
	    	
	    	Personnel p2 = new Personnel
	    			.Builder("nomA","prenomA","Manager")
	    			.dateNaissance( LocalDate.of(1989, Month.MAY, 10))
	    			.addNumTelephone(new NumeroTele("Personnel","0605842691"))
	    			.build();
	    	 personnedao.create(p1);
	    	 personnedao.create(p2);
	    	 
	    	
			ObjectOutputStream out = new ObjectOutputStream(
					
							new FileOutputStream("personneDAO.serial"));
			out.writeObject(personnedao);
			System.out.print("DAO de pesonnel est bien sérialisé !\n");
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("personneDAO.serial"));
			personnedaoTest = (PersonnelDAO) in.readObject();
			
		       System.out.print("DAO de pesonnel est bien désérialisé !\n");
		    
		       personnedaoTest.delete(personnedaoTest.find(p1));
		       
		       assertFalse("La liste Personneldao ne contient pas p1",personnedaoTest.getAll().contains(p1));
		      
		       in.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
