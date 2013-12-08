package topdezOWASP;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

import preenchimentoDeCampos.TestaCampos;
import analiseCodigoFonte.AnaliseHTML;

public class XSS {
	
	private Hashtable<String, Boolean> vulneravel;
	private static final String XSS_PADRAO = "<script>alert('XSS');</script>";
	private AnaliseHTML elementos;
	private String htmlAntesAtaque = "";
	private String htmlPosAtaque = "";
	private TestaCampos atacar;
	
	
	public Hashtable<String, Boolean> isVulneravel() {
		return vulneravel;
	}

	public XSS(){
		
	}
	
	
	public void atacarXSS(List<String> enderecos){
		vulneravel = new Hashtable<String, Boolean>();
		atacar = new TestaCampos();
		for (String endereco : enderecos) {
			elementos = new AnaliseHTML(endereco);
			elementos.leCodigoFonte();
			htmlAntesAtaque  = elementos.getCodigo();
			try {
				String parametros 
				= montaParametros(endereco, elementos.getElementos().get(0));
				atacar.RespostaCampos(parametros,false,false);
				htmlPosAtaque = atacar.getCodigoSemUrl();
				System.out.println(htmlPosAtaque);
				if(htmlPosAtaque.contains(XSS_PADRAO))
					vulneravel.put(endereco, true);
				else
					vulneravel.put(endereco, false);
			} catch (Exception e) {
				vulneravel.put(endereco, false);
				JOptionPane.showMessageDialog(null, "Erro ao testar o ataque XSS");
			}
			
		}
		
	}
	
	private String montaParametros(String endereco,List<String> campos){
		String parametros="";
		parametros += endereco +" ";
		for (String campo : campos) {
			parametros += campo + " "+XSS_PADRAO+" ";
		}
		return parametros;
	}
	
	
}
