package FabrikMethode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {

	private BufferedReader br;

	public ConcreteProductA() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("TeppichAusgabe.csv"));
	}

	@Override
	public void schliessDatei() throws IOException {

		br.close();
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		// TODO Auto-generated method stub
		String[] ergebnisZeile = br.readLine().split(";");

		return ergebnisZeile;
	}
}
