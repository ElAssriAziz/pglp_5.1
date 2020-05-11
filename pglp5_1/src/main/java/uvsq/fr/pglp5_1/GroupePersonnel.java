package uvsq.fr.pglp5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupePersonnel implements ComponentPersonnel, Iterable<ComponentPersonnel>{
	
	/**
	 * 
	 */

	private final ArrayList<ComponentPersonnel> ListePersonnels;
	
	public GroupePersonnel() {
		ListePersonnels = new ArrayList<ComponentPersonnel>();
	}
	
	public void addPersonnel(ComponentPersonnel pers) {
		ListePersonnels.add(pers);
	}
	
	public void removePersonnel(ComponentPersonnel pers) {
		ListePersonnels.remove(pers);
	}
	
	public ArrayList<ComponentPersonnel> getListePersonnels() {
		return ListePersonnels;
	}

	public int isGroup() {
		return 1;
	}

	public Iterator<ComponentPersonnel> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/*public Iterator<ComponentPersonnel> iterator() {
		 return new ItemIterator(this);
	}*/
}
