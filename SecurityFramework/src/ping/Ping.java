package ping;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.omg.CORBA.RepositoryIdHelper;

public class Ping {
	
	private String resposta;
	private String endereco;
	private boolean ativo;
	
	public Ping(String endereco)
	{
		this.endereco = endereco;
	}
	
	
	public void executaPing()
	{
		String comando = "ping "+endereco;
		Process processo;
		try {
			processo = Runtime.getRuntime().exec(comando);
			
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(processo.getInputStream()));
			
			resposta = br.readLine();
			resposta = br.readLine();
			if(resposta.contains("Destination Host Unreachable"))
				ativo = false;
			else
				ativo = true;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao executar o ping");
		}
	}
	
	
	public String getRespota() {
		return formataResposta();
	}
	
	public boolean ipAtivo(){
		return this.ativo;
	}
	
	private String formataResposta(){
		String palavras[] = resposta.split(" ");
		return palavras[3].replace(":", "");
	}
	
}
