package topdezOWASP;

import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

import preenchimentoDeCampos.TestaCampos;
import analiseCodigoFonte.AnaliseHTML;

public class Injection {
	
	private static final String INJECTION_INICIAL = "teste";
	private static final String INJECTION_ATK = "'or'1'='1";
	
	private Hashtable<String, Boolean> vulneravel;
	private AnaliseHTML elementos;
	private String htmlAntesAtaque = "";
	private String htmlPosAtaque = "";
	private TestaCampos atacar;
	
	
	public Hashtable<String, Boolean> isVulneravel() {
		return vulneravel;
	}
	
	public void atacarInjectionPrimeiraEtapa(List<String> enderecos){
		vulneravel = new Hashtable<String, Boolean>();
		atacar = new TestaCampos();
		for (String endereco : enderecos) {
			elementos = new AnaliseHTML(endereco);
			elementos.leCodigoFonte();
			htmlAntesAtaque  = elementos.getCodigo();
			try {
				String parametros = 
						montaParametrosIniciais(endereco, elementos.getElementos().get(0));
				atacar.RespostaCampos(parametros,false,false);
				htmlPosAtaque = atacar.getRespotaFormatada();
				if(htmlPosAtaque.contains(INJECTION_INICIAL) 
						&& urlComElementos(elementos.getElementos().get(0), 
								atacar.getPrimeiraLinha()))
					verificaVulnerabilidade(montaParametrosFinais(atacar.getPrimeiraLinha())
							, endereco);
				else
					vulneravel.put(endereco, false);
			} catch (Exception e) {
				vulneravel.put(endereco, false);
				JOptionPane.showMessageDialog(null, "Erro ao executar o ataque Injection");
			}
			
		}
		
	}
	
	
	public void atacarInjectionSegundaEtapa(List<String> enderecos){
	
		atacar = new TestaCampos();
		for (String endereco : enderecos) {
			elementos = new AnaliseHTML(endereco);
			elementos.leCodigoFonte();
			htmlAntesAtaque  = elementos.getCodigo();
			try {
				String parametros = montaParametrosIniciais(endereco, 
						elementos.getElementos().get(0));
				atacar.RespostaCampos(parametros,false,false);
				htmlPosAtaque = atacar.getRespotaFormatada();
				if(htmlPosAtaque.contains(INJECTION_ATK))
					vulneravel.put(endereco, true);
				else
					vulneravel.put(endereco, false);
			} catch (Exception e) {
				vulneravel.put(endereco, false);
			}
			
		}
		
	}
	
	
	private void verificaVulnerabilidade(String url,String endereco){
		elementos = new AnaliseHTML(url);
		elementos.leCodigoFonte();
		String codigoPagina = elementos.getCodigo();
		if(codigoPagina.contains(INJECTION_ATK))
			vulneravel.put(endereco, true);
		else
			vulneravel.put(endereco, false);
		
	}
	
	private String montaParametrosIniciais(String endereco,List<String> campos){
		String parametros="";
		parametros += endereco +" ";
		for (String campo : campos) {
			parametros += campo + " "+INJECTION_INICIAL+" ";
		}
		return parametros;
	}
	
	private String montaParametrosFinais(String url){
		url = url.replace(INJECTION_INICIAL, INJECTION_ATK);
		return url;
	}
	
	private boolean urlComElementos(List<String> elementos,String linha){
		boolean flag = false;
		for (String elemento : elementos) {
			if(linha.contains(elemento))
				flag = true;
		}
		
		return flag;
	}
	

}
