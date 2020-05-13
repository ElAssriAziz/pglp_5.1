package uvsq.fr.pglp5_1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class PersonnelDAO implements DAO<Personnel>,Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2853081473510341864L;
	private List<Personnel> personnels = new ArrayList<Personnel>();
	 
	
	public List<Personnel> getAll() {
		
		return personnels;
	}

	
	public void create(Personnel p) {
	
		personnels.add(p);
		System.out.print("\nPersonnel a été bien créé !\n");
	}
	public Personnel find(Personnel t) {
		
		for (int i=0;i<personnels.size();i++)
		if(t.equals(personnels.get(i)))
			return personnels.get(i);
			
		return null;
	}

	public Personnel update(Personnel t) {
		int index=-1;
		for(Personnel pers : personnels) {
		    if(pers!=null && t.getNom().equals(pers.getNom())) {
		    	 index = personnels.indexOf(pers);
		        personnels.set(index, t);
		    	System.out.print("\nPersonnel a été bien modifié !\n");
		        break;
		    }
		}
		if(index>=0)
		return personnels.get(index);
		else 
		return null;
	}
	
	public void delete(Personnel t) {
		personnels.remove(t);
		System.out.print("\nPersonnel a été bien supprimé !\n");
		
	}

}
