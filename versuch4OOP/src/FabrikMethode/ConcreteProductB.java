package FabrikMethode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Teppich;

public class ConcreteProductB extends Product{

	private BufferedReader br;

    public ConcreteProductB() throws IOException {
       super();
       this.br = new BufferedReader(new FileReader("TeppichAusgabe.txt"));

    }



    @Override
    public void schliessDatei() throws IOException {

        br.close();
    }



	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String [] ergebnisZeile = new String[5];
		String zeile = br.readLine();
		
		int i = 0;
		
		while(i < ergebnisZeile.length) {
			ergebnisZeile[i] = zeile;
			zeile = br.readLine();
			i++;
		}
		return ergebnisZeile;
	}


}
