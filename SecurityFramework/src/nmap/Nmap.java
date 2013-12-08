package nmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Nmap {

	private BufferedReader resposta;
	private String endereco;
	private List<String> respostaFormatada = new ArrayList<String>();
	

	public List<String> getRespostaFormatada() {
		return respostaFormatada;
	}

	public Nmap(String endereco)
	{
		this.endereco = endereco;
	}
	
	public void executaComando()
	{
		respostaFormatada = new ArrayList<String>();
		String comando = "nmap -A "+endereco;
		Process processo;

		try {
			processo = Runtime.getRuntime().exec(comando);
			processo.waitFor();
			resposta = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String s;
			while ((s= resposta.readLine())!=null) {
				//System.out.println(s);
				String linhaFormatada = formatarResposta(s);
				if(linhaFormatada!=null && !linhaFormatada.isEmpty())
					respostaFormatada.add(linhaFormatada);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao iniciar o namp");
		}	
		
	}
	
	
	private String formatarResposta(String linha){
		
		if(linha.length()>2){
			if(linha.charAt(0)!='|' && linha.charAt(0)!='S' && linha.charAt(2)!='F')
				return linha;
		}
		
		return null;
	}
	
	
	public BufferedReader getResposta() {
		return resposta;
	}
	
}
