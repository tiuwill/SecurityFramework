package topdezOWASP;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

import preenchimentoDeCampos.TestaCampos;
import analiseCodigoFonte.AnaliseHTML;

public class CSRF {

	private static final String CSRF_PADRAO = "entradaTeste";
	private Hashtable<String, Boolean> vulneravel;
	private AnaliseHTML elementos;
	private String htmlAntesAtaque = "";
	private String htmlPosAtaque = "";
	private TestaCampos atacar;
	
	
	public Hashtable<String, Boolean> isVulneravel() {
		return vulneravel;
	}
	
	
	public void atacarCSRF(List<String> enderecos){
		vulneravel = new Hashtable<String, Boolean>();
		atacar = new TestaCampos();
		for (String endereco : enderecos) {
			elementos = new AnaliseHTML(endereco);
			elementos.leCodigoFonte();
			htmlAntesAtaque  = elementos.getCodigo();
			try {
				String parametros = 
						montaParametros(endereco, elementos.getElementos().get(0));
				atacar.RespostaCampos(parametros,true,true);
				htmlPosAtaque = atacar.getPrimeiraLinha();
				if(htmlPosAtaque.contains(CSRF_PADRAO))
					vulneravel.put(endereco, true);
				else
					vulneravel.put(endereco, false);
			} catch (Exception e) {
				vulneravel.put(endereco, false);
				JOptionPane.showMessageDialog(null, "Erro ao testar o ataque CSRF");
			}			
			
		}	
	}
	
	private String montaParametros(String endereco,List<String> campos){
		String parametros="";
		parametros += endereco +" ";
		for (String campo : campos) {
			parametros += campo + " "+CSRF_PADRAO+" ";
		}
		return parametros;
	}
	
	
	
}
