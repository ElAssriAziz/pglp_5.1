package uvsq.fr.pglp5_1;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import uvsq.fr.pglp5_1.NumeroTele;
import uvsq.fr.pglp5_1.Personnel.Builder;

public class TestSerialisation {

	
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
	
}