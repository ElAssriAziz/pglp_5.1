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
    	 DAO<Personnel> personneDao = DAOFactory.getPersonnelDAO();
    	 // create deux personnes
    	 personneDao.create(p1);
    	 personneDao.create(p2);
        
    	 System.out.println("----------Liste des personnes-----------\n");
         for (Personnel per : personneDao.getAll()) {
            System.out.println("Personne : [Nom : " + per.getNom()+ ", Prenom : " + per.getFonction() 
            +", Date de naissance : "+per.getDateNaissance()+" ,Numeros : "+per.getNumeros()+" ]");
         }


         //update personne P1
        personneDao.getAll().get(0).setNom("NomC");
        personneDao.getAll().get(0).setFonction("Teacher");
        personneDao.update(personneDao.getAll().get(0));
        System.out.println("\n----------Liste des personnes aprèes modification----------\n");
         //get personne
        for (Personnel per : personneDao.getAll()) {
            System.out.println("Personne : [Nom : " + per.getNom()+ ", Prenom : " + per.getFonction() 
            +", Date de naissance : "+per.getDateNaissance()+" ,Numeros : "+per.getNumeros()+" ]");
         }
    	
	}
	}