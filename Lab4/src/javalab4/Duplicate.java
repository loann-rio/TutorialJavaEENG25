package javalab4;

import java.util.LinkedList;
import java.util.TreeSet;

public class Duplicate {

	public TreeSet<People> getPeopleList(LinkedList<People> peopleP) {
		 TreeSet<People> set = new TreeSet<>();
		
		for(People p : peopleP) {
			if (p!=null) {set.add(p);}
		}
		return set;
	}	
}
