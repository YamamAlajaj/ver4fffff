package FabrikMethode;

import java.io.IOException;

public class ConcreteCreatorAB extends Creator {

    @Override
    public Product factoryMethod(String typ) throws IOException {
        if(typ == ("txt")) {
        	return new ConcreteProductB();
        }
        else {
        	return new ConcreteProductA();
        }

    }



}
