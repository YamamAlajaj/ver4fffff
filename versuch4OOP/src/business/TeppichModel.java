package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import FabrikMethode.ConcreteCreatorAB;
import FabrikMethode.Creator;
import FabrikMethode.Product;
import ownUtil.Observable;
import ownUtil.Observer;

public class TeppichModel implements Observable{
	
	// bb
	private ArrayList<Teppich> teppich = new ArrayList<Teppich>();
	private LinkedList<Observer> liste = new LinkedList<Observer>();
	
	
	  
	  private TeppichModel() {
		  //f
		  this.teppich = new ArrayList<Teppich>();
	  }
	
	
	public LinkedList<Observer> getListe() {
		return liste;
		
	}

	public void setListe(LinkedList<Observer> liste) {
		this.liste = liste;
		notifyObservers();
		
	}


	
	private static TeppichModel model;

	
	
	public static TeppichModel getTeppichModel() {
		if(model == null) {
			return model = new TeppichModel();
		}
		return model;
	}

	public void schreibeTeppichInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("TeppichAusgabe.csv", false));
		// mit foreach ändern
		for (Teppich teppich2 : teppich) {
			aus.write(teppich2.gibTeppichZurueck(';'));
		}
		
		aus.close();
		notifyObservers();

	}



	public void leseAusDatei(String typ) throws IOException {
		Creator creator = new ConcreteCreatorAB();
		Product reader = creator.factoryMethod(typ);
		
		String [] zeile = reader.leseAusDatei();
		
		reader.schliessDatei();
		
		this.teppich.add( new Teppich(Integer.parseInt(zeile[0]), 
				zeile[1], 
				Float.parseFloat(zeile[2]), 
				Float.parseFloat(zeile[3]), 
				zeile[4].split("_")));
		
		
				notifyObservers();
		
	}
	//get und set löschen
	
	
	public ArrayList<Teppich> getTeppich() {
		return teppich;
	}

	/*
	public void setTeppich(ArrayList<Teppich> teppich) {
		this.teppich = teppich;
	}*/
	
	//neu einfuegen
	public void addTeppich(Teppich teppich) {
		this.teppich.add(teppich);
	}
	
	@Override
		public void addObserver(Observer obs) {
			liste.add(obs);
			
		}

	@Override
	public void removeObserver(Observer obs) {
		liste.remove(obs);
		
	}
	@Override
	public void notifyObservers() {
		
		for (Observer o : liste) {
		      o.update();
		    }
	}
	

}