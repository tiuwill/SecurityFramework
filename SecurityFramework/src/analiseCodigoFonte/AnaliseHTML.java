package analiseCodigoFonte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AnaliseHTML {
	private List<List<String>> elementos = new ArrayList<List<String>>();
	private String codigo;
	private String endereco;
	private boolean existe;
	
	public boolean isExiste() {
		return existe;
	}

	public AnaliseHTML(String endereco){
		this.endereco = endereco;
	}
	
	public List<List<String>> getElementos() {
		return elementos;
	}
	public void setElementos(List<List<String>> elementos) {
		this.elementos = elementos;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void leCodigoFonte(){
		try {
			URL url = new URL(endereco);
			URLConnection con = url.openConnection();
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			List<String> campos = new ArrayList<String>();
			List<String> botoes = new ArrayList<String>();
			
			String linha = br.readLine();
			codigo = "";
			while (linha!=null) {
				codigo += linha;
				String campo = analisaCampo(linha);
				if(!campo.isEmpty())
					campos.add(campo);
				campo = analisaBotao(linha);
				if(!campo.isEmpty())
					botoes.add(campo);
				linha = br.readLine();
			}
			
			elementos.add(campos);
			elementos.add(botoes);
			existe = true;
			
		} catch (MalformedURLException e) {
			existe = false;
			JOptionPane.showMessageDialog(null, "A url pode estar incorreta");
			
		} catch (IOException e) {
			existe = false;
			JOptionPane.showMessageDialog(null, "Erro ao analisar os campos html");
		}
		
	}
	
	
	private String analisaCampo(String linha){
		String nomeCampo = "";
		if(linha.contains("input") && !linha.contains("submit")){
			int indexNome = linha.indexOf("name=");
			if(indexNome!=-1){
				
				boolean inicioPalavra=false;
				for (int i = indexNome; i < linha.length(); i++) {
					
					if(inicioPalavra && linha.charAt(i)!='\"')
						nomeCampo+=linha.charAt(i);
					if(linha.charAt(i)=='\"'){
						
						if(inicioPalavra==true)
							inicioPalavra = false;
						else
							inicioPalavra = true;
						
					}
				}
			}
				
		}
		return nomeCampo;
	}
	
	private String analisaBotao(String linha){
		String nomeCampo = "";
		if(linha.contains("submit") && linha.contains("input")){
			int indexNome = linha.indexOf("name=");
			if(indexNome!=-1){
				
				boolean inicioPalavra=false;
				for (int i = indexNome; i < linha.length(); i++) {
					
					if(inicioPalavra && linha.charAt(i)!='\"')
						nomeCampo+=linha.charAt(i);
					if(linha.charAt(i)=='\"'){
						
						if(inicioPalavra==true)
							inicioPalavra = false;
						else
							inicioPalavra = true;
						
					}
					
				}
			}
				
		}
		return nomeCampo;
	}
	
	
			

}
