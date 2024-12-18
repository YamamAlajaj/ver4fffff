package business;

import java.util.ArrayList;

public class Teppich {
	
	//  -> ArtikelNummer von teppich
    private int artikelNummer;
    //  -> KategorieTyp
    private String kategorie;
    // Bereite 
    private float bereite;
    // -> Laenge
    private float laenge;
    // -> Farben
    //private String[] farben;
    
    private ArrayList<String>farben;
  
    
	public Teppich(int artikelNummer, String kategorie, float bereite, float laenge, String[] farben) {
		super();
		
		if(farben == (null)) {
			throw new IllegalArgumentException();
			
		}
		this.artikelNummer = artikelNummer;
		this.kategorie = kategorie;
		this.bereite = bereite;
		this.laenge = laenge;
		//s
		setFarbenAusStringArray(farben);
		
		}
	

	

	public int getArtikelNummer() {
		return artikelNummer;
	}



	public void setArtikelNummer(int artikelNummer) {
		this.artikelNummer = artikelNummer;
	}



	public String getKategorie() {
		return kategorie;
	}



	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}



	public float getBereite() {
		return bereite;
	}



	public void setBereite(float bereite) {
		this.bereite = bereite;
	}



	public float getLaenge() {
		return laenge;
	}



	public void setLaenge(float laenge) {
		this.laenge = laenge;
	}



	public ArrayList<String> getFarben() {
		return farben;
	}



	public void setFarben(ArrayList<String> farben) {
		this.farben = farben;
	}

	public void setFarbenAusStringArray(String[] farben) {
        this.farben = new ArrayList<String>();
        for (int i = 0; i < farben.length; i++) {
            //f
        	this.farben.add(farben[i]);
        }
    }

	public String getFarbenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		//								g
		for(i = 0; i < this.getFarben().size() - 1; i++) {
			//										g
			ergebnis = ergebnis + this.getFarben().get(i) + trenner; 
		}
		//				remove
		return ergebnis;
	}
	
	public String gibTeppichZurueck(char trenner){
  		return ""+this.getArtikelNummer() + trenner 
  			+ this.getKategorie() + trenner
  		    + this.getBereite() + trenner
  		    + this.getLaenge() + trenner 
  		    + this.getFarbenAlsString(trenner) + "\n";
  	}
}