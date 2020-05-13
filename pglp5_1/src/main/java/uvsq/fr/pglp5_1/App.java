package uvsq.fr.pglp5_1;


import java.time.LocalDate;
import java.time.Month;

public class App 
{
    public static void main( String[] args )
    {
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
    	
    	System.out.print(p1);
	}
	}