package uvsq.fr.pglp5_1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;

import uvsq.fr.pglp5_1.Personnel;
public class App 
{
    public static void main( String[] args )
    {
      String nomFichier ="personne.serial";
      Personnel personneTest = new Personnel.Builder(null, null, null).build();
     
  	Personnel personne = new Personnel
  			
			.Builder("Marc","Michel","Manager")
			.dateNaissance( LocalDate.of(1970, Month.APRIL, 20))
			.addNumTelephone(new NumeroTele("Personnel","0605485237"))
			.addNumTelephone(new NumeroTele("Professionnel","06054414527"))
			.build();
  	
  	try{
		ObjectOutputStream out = new ObjectOutputStream(
				
						new FileOutputStream("personne.serial"));
		out.writeObject(personne);
		System.out.print("Personne est bien sérialisé !\n");
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("personne.serial"));
	       personneTest = (Personnel) in.readObject();
	       System.out.print("Personne est bien désérialisé !\n");
	       System.out.println(personneTest);
	       in.close();
		}
	catch(Exception e) {
		e.printStackTrace();
	}

    
    	
}
}