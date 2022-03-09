package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;

public class Parole {
	List<String> parole;
	
	public Parole() {
			parole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		List<String> paroleOrdinate=new LinkedList<String>(parole);
		paroleOrdinate.sort(new ComparatorOrdineAlfaberico());
		return paroleOrdinate;
	}
	
	public void reset() {
		parole.clear();
	}

}
