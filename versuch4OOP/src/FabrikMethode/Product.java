package FabrikMethode;

import java.io.*;

import business.Teppich;

public abstract class Product {

	
	public abstract String[] leseAusDatei() throws IOException;
    public abstract void schliessDatei()throws IOException ;
}