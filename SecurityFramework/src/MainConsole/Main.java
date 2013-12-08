package MainConsole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JEditorPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import forcaBruta.Medusa;
import nmap.Nmap;
import ping.Ping;
import preenchimentoDeCampos.TestaCampos;
import topdezOWASP.CSRF;
import topdezOWASP.Injection;
import topdezOWASP.MFLAC;
import topdezOWASP.SQLInjection;
import topdezOWASP.XSS;
import analiseCodigoFonte.AnaliseHTML;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Nmap nmap = new Nmap("192.168.160.129");
//		nmap.executaComando(); 		
//		Ping ping = new Ping("192.168.160.129");
//		ping.executaPing();
//		System.out.println(ping.getRespota());
//		System.out.println(ping.getRespota());
//		Medusa medusa = new Medusa("192.168.160.129", "ftp");
//		medusa.executaForcaBruta();
//		Exploit exp = new Exploit("192.168.160.129", "perl","/root/slowloris.pl");
//		exp.executaExploit();

//		AnaliseHTML analise = new AnaliseHTML("http://192.168.160.129/vulneravel/vulnerabilities/sqli/");
//		analise.leCodigoFonte();
//		
//		TestaCampos campos = new TestaCampos();
//		 campos.getRespostaCampos(campos.criaStringCamposEvalores(analise.getElementos().get(0),""));
//		System.out.println(campos.getRespotaFormatada());
		
		//System.out.println(medusa.getResposta().toString());
//		for (String linha : nmap.getRespostaFormatada()) {
//			System.out.println(linha);
//		}
		
		//respostas
		Hashtable<String, Boolean> vulneraveisXss;
		Hashtable<String, Boolean> vulneraveisSqlInjection;
		Hashtable<String, Boolean> vulnerabilidadesCSRF;
		Hashtable<String, Boolean> vulnerabilidadesMFLAC;
		Hashtable<String, Boolean> vulnerabilidadesInjection;
		
		List<String> paginas = new ArrayList<String>();
//		paginas.add("http://192.168.160.129/vulneravel/vulnerabilities/xss_r/");
//		XSS xss = new XSS();
//		xss.atacarXSS(paginas);
//		vulneraveisXss = xss.isVulneravel();
//		System.out.println(vulneraveisXss.get("http://192.168.160.129/vulneravel/vulnerabilities/xss_r/"));
//		
		//http://192.168.160.129/vulneravel/vulnerabilities/sqli/
		//http://192.168.160.129/vulneravel/vulnerabilities/csrf/
//		paginas = new ArrayList<String>();
//		paginas.add("http://192.168.160.129/vulneravel/vulnerabilities/xss_r/");
//		SQLInjection sql = new SQLInjection();
//		sql.atacarSQLInjection(paginas);
//		vulneraveisSqlInjection = sql.isVulneravel();
//		System.out.println(vulneraveisSqlInjection.get("http://192.168.160.129/vulneravel/vulnerabilities/xss_r/"));
//		
//		paginas = new ArrayList<String>();
//		paginas.add("http://192.168.160.129/vulneravel/vulnerabilities/csrf/");
//		CSRF csrf = new CSRF();
//		csrf.atacarCSRF(paginas);
//		vulnerabilidadesCSRF = csrf.isVulneravel();
//		System.out.println(vulnerabilidadesCSRF.get("http://192.168.160.129/vulneravel/vulnerabilities/csrf/"));
//		
//		paginas = new ArrayList<String>();
//		paginas.add("http://192.168.160.129/vulneravel/vulnerabilities/teste/vuln.html");
//		paginas.add("http://192.168.160.129/vulneravel/vulnerabilities/teste/teste.html");
//		MFLAC mflac = new MFLAC();
//		mflac.atacarMFLAC(paginas);
//		vulnerabilidadesMFLAC = mflac.isVulneravel();
//		System.out.println("http://192.168.160.129/vulneravel/vulnerabilities/teste/vuln.html "+vulnerabilidadesMFLAC.get("http://192.168.160.129/vulneravel/vulnerabilities/teste/vuln.html"));
//		System.out.println("http://192.168.160.129/vulneravel/vulnerabilities/teste/teste.html "+vulnerabilidadesMFLAC.get("http://192.168.160.129/vulneravel/vulnerabilities/teste/teste.html"));
//		
//		paginas = new ArrayList<String>();
//		paginas.add("http://192.168.160.129/vulneravel/vulnerabilities/sqli/");
//		Injection injection = new Injection();
//		injection.atacarInjectionPrimeiraEtapa(paginas);
//		vulnerabilidadesInjection = injection.isVulneravel();
//		System.out.println(vulnerabilidadesInjection.get("http://192.168.160.129/vulneravel/vulnerabilities/sqli/"));
//		
//		
	}

}
