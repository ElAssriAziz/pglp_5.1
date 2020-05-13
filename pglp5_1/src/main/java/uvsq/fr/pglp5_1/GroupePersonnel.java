package uvsq.fr.pglp5_1;

import java.io.Serializable;
import java.util.ArrayList;


public class GroupePersonnel implements ComponentPersonnel,Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -9104661272545130212L;
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

	
}
