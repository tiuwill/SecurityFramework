package topdezOWASP;

import java.util.Hashtable;
import java.util.List;

import analiseCodigoFonte.AnaliseHTML;

public class MFLAC {


	private Hashtable<String, Boolean> vulneravel;
	private AnaliseHTML elementos;

	
	
	public Hashtable<String, Boolean> isVulneravel() {
		return vulneravel;
	}
	
	
	public void atacarMFLAC(List<String> enderecos){
		vulneravel = new Hashtable<String, Boolean>();
		for (String endereco : enderecos) {
			elementos = new AnaliseHTML(endereco);
			elementos.leCodigoFonte();
			if(elementos.isExiste())
				vulneravel.put(endereco, true);
			else
				vulneravel.put(endereco, false);
			
		}
	}
	
	
}
