package esperimenti;

import java.util.ArrayList;

public class Proprietario {
	
	private ArrayList <Casa> listaCase= new ArrayList<>();
	
	public void compraCasa(Casa c) {
		listaCase.add(c);
	}

}
