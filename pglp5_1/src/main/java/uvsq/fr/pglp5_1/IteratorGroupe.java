package uvsq.fr.pglp5_1;

import java.util.Iterator;
import java.util.List;

public class IteratorGroupe implements Iterator<GroupePersonnel> {
 private List groupe ;
 ComponentPersonnel currentItem;
	public boolean hasNext() {
		if(groupe.size()==0)
		return false;
		else return true;
	}

	public GroupePersonnel next() {
		if (hasNext()) {
			ComponentPersonnel nextItem = (ComponentPersonnel) groupe.get(0);
		    if (nextItem instanceof ComponentPersonnel) {
		     /* for (ComponentPersonnel item : currentItem.getItems()) {
		        groupe.add(item);
		      }*/
		    }
		    groupe.remove(0);
		    if (hasNext()) {
		    //  currentItem = groupe.get(0);
		    }
		   // return nextItem;
		  }
		
		return null;
	}

}
