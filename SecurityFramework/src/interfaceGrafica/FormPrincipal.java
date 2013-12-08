package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import topdezOWASP.CSRF;
import topdezOWASP.Injection;
import topdezOWASP.MFLAC;
import topdezOWASP.SQLInjection;
import topdezOWASP.XSS;
import forcaBruta.Medusa;
import nmap.Nmap;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private final JLabel lblEndereos = new JLabel("Endereços:");
	private JTextField url1;
	private JTextField url2;
	private JTextField url3;
	private JTextField url4;
	private JTextField url9;
	private JTextField url10;
	private JTextField url11;
	private JTextField url12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(185, 15, 0, 15);
		contentPane.add(textArea_1);
		
		textArea = new JTextArea();
		textArea.setBounds(190, 15, 0, 15);
		contentPane.add(textArea);
		lblEndereos.setBounds(42, -27, 127, 37);
		contentPane.add(lblEndereos);
		
		
		JLabel lblEndereos_1 = new JLabel("Endereços:");
		lblEndereos_1.setBounds(52, 20, 98, 15);
		contentPane.add(lblEndereos_1);
		
		JLabel lblForaBruta = new JLabel("Força Bruta");
		lblForaBruta.setBounds(52, 194, 88, 15);
		contentPane.add(lblForaBruta);
		
		JLabel lblInjection = new JLabel("Injection");
		lblInjection.setBounds(460, 194, 70, 15);
		contentPane.add(lblInjection);
		
		JLabel lblSqlinjection = new JLabel("SqlInjection");
		lblSqlinjection.setBounds(652, 194, 98, 15);
		contentPane.add(lblSqlinjection);
		
		JLabel lblXss = new JLabel("XSS");
		lblXss.setBounds(829, 194, 70, 15);
		contentPane.add(lblXss);
		
		JLabel lblCsrf = new JLabel("CSRF");
		lblCsrf.setBounds(276, 194, 70, 15);
		contentPane.add(lblCsrf);
		
		JLabel lblMissingAcessControl = new JLabel("Missing Acess Control");
		lblMissingAcessControl.setBounds(58, 390, 161, 15);
		contentPane.add(lblMissingAcessControl);
		
		JCheckBox chckbxTesteDeSobrecarga = new JCheckBox("Teste de sobrecarga");
		chckbxTesteDeSobrecarga.setBounds(781, 75, 195, 23);
		contentPane.add(chckbxTesteDeSobrecarga);
		
		final JTextArea nmapText = new JTextArea();
		final JScrollPane nmapScroll = new JScrollPane(nmapText);
		nmapText.setBounds(272, 420, 393, 165);
		nmapScroll.setBounds(272, 420, 393, 165);
		contentPane.add(nmapScroll);
		
		JLabel lblPortasEServios = new JLabel("Portas e serviços");
		lblPortasEServios.setBounds(289, 385, 133, 15);
		contentPane.add(lblPortasEServios);
		
		JLabel lblOnline = new JLabel("Online");
		lblOnline.setBounds(791, 107, 70, 15);
		contentPane.add(lblOnline);
		
		JLabel lblOffline = new JLabel("Offline");
		lblOffline.setBounds(791, 134, 70, 15);
		contentPane.add(lblOffline);
		lblOffline.hide();
		lblOnline.hide();
		
		
		url1 = new JTextField();
		url1.setBounds(36, 45, 369, 19);
		contentPane.add(url1);
		url1.setColumns(10);
		
		url2 = new JTextField();
		url2.setColumns(10);
		url2.setBounds(36, 77, 369, 19);
		contentPane.add(url2);
		
		url3 = new JTextField();
		url3.setColumns(10);
		url3.setBounds(36, 105, 369, 19);
		contentPane.add(url3);
		
		url4 = new JTextField();
		url4.setColumns(10);
		url4.setBounds(36, 132, 369, 19);
		contentPane.add(url4);
		
		url9 = new JTextField();
		url9.setColumns(10);
		url9.setBounds(445, 45, 320, 19);
		contentPane.add(url9);
		
		url10 = new JTextField();
		url10.setColumns(10);
		url10.setBounds(445, 77, 320, 19);
		contentPane.add(url10);
		
		url11 = new JTextField();
		url11.setColumns(10);
		url11.setBounds(445, 105, 320, 19);
		contentPane.add(url11);
		
		url12 = new JTextField();
		url12.setColumns(10);
		url12.setBounds(445, 132, 320, 19);
		contentPane.add(url12);
		
		
		final JTextArea fbtext = new JTextArea();
		final JScrollPane fbscroll = new JScrollPane(fbtext);
		fbtext.setBounds(42, 222, 177, 156);
		fbscroll.setBounds(42, 222, 177, 156);
		contentPane.add(fbscroll);
		
		final JTextArea csrftext = new JTextArea();
		final JScrollPane csrfscroll = new JScrollPane(csrftext);
		csrftext.setBounds(262, 222, 161, 156);
		csrfscroll.setBounds(262, 222, 161, 156);
		contentPane.add(csrfscroll);
		
		final JTextArea injectiontext = new JTextArea();
		final JScrollPane injectionScroll = new JScrollPane(injectiontext);
		injectiontext.setBounds(445, 222, 161, 157);
		injectionScroll.setBounds(445, 222, 161, 157);
		contentPane.add(injectionScroll);
		
		final JTextArea sqltext = new JTextArea();
		final JScrollPane sqlScroll = new JScrollPane(sqltext);
		sqltext.setBounds(640, 222, 161, 157);
		sqlScroll.setBounds(640, 222, 161, 157);
		contentPane.add(sqlScroll);
		
		final JTextArea xsstext = new JTextArea();
		final JScrollPane xssScroll = new JScrollPane(xsstext);
		xsstext.setBounds(823, 222, 153, 156);
		xssScroll.setBounds(823, 222, 153, 156);
		contentPane.add(xssScroll);
		
		final JTextArea missingtext = new JTextArea();
		final JScrollPane missingScroll = new JScrollPane(missingtext);
		missingtext.setBounds(52, 408, 183, 165);
		missingScroll.setBounds(52, 408, 183, 165);
		contentPane.add(missingScroll);
		
		
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(875, 42, 77, 25);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String texto="";
				List<String> respNmap = startNmap(getUrls().get(0));
				List<String> respMedusa = startMedusa(getUrls().get(0));
				if(!respNmap.isEmpty())
					nmapText.setText(textoFinal(respNmap));
				if(!respMedusa.isEmpty())
					fbtext.setText("usuario: "+respMedusa.get(0)+"\n senha: "+respMedusa.get(1));
				Hashtable<String, Boolean> respCSRF = startCSRF(getUrls());
				
				if(!respCSRF.isEmpty()){
					for (String endereco : getUrls()) {
						if(respCSRF.get(endereco))
							texto+=endereco+" \n";
					}
					csrftext.setText(texto);
				}
				texto="";
				Hashtable<String, Boolean> respInjection = startInjection(getUrls());
				if(!respInjection.isEmpty()){
					for (String endereco : getUrls()) {
						if(respInjection.get(endereco))
							texto+=endereco+" \n";
							
					}
					injectiontext.setText(texto);
				}
				
				texto ="";
				Hashtable<String, Boolean> respSQLInjection = startSQLInjection(getUrls());
				if(!respSQLInjection.isEmpty()){
					for (String endereco : getUrls()) {
						if(respSQLInjection.get(endereco))
							texto+=endereco+" \n";
					}
					sqltext.setText(texto);
				}
				
				texto="";
				Hashtable<String, Boolean> respXSS = startXSS(getUrls());
				if(!respXSS.isEmpty()){
					for (String endereco : getUrls()) {
						if(respXSS.get(endereco))
							texto+=endereco+" \n";
					}
					xsstext.setText(texto);
				}
				
				texto="";				
				Hashtable<String, Boolean> respMFLAC = startMissingAcessControl(getUrls());
				if(!respMFLAC.isEmpty()){
					for (String endereco : getUrls()) {
						if(respMFLAC.get(endereco))
							texto+=endereco+" \n";
					}
					missingtext.setText(texto);
				}
		
			}
		});
		contentPane.add(btnIniciar);		
		
		JButton btnfb = new JButton("?");
		btnfb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Força bruta é um ataque onde, um usuário mal intencionado, \n "
						+ "pode tentar utilizar algum software que teste todas as combinações possiveis \n"
						+ "de usuário e senha no sistema. Normalmente pares de usuarios e senhas, com poucos caracteres,\n"
						+ "ou com sequências óbvias, ou senhas faceis de advinhar, são alvos faceis para este tipo de ataque.\n"
						+ "\n"
						+ "A solução para este tipo de problema é utilizar senhas extensas com grande variações de caracteres\n"
						+ "e utilização de caracteres especiais, não utilizando sequencias óbvias ou faceis de advinhar, \n"
						+ "tornando o ataque de força bruta praticamente inviável para um usuário mal intencionado.");
			}
		});
		btnfb.setBounds(141, 189, 49, 25);
		contentPane.add(btnfb);
		
		JButton btncsrf = new JButton("?");
		btncsrf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este ataque força suas vitimas que estão autenticadas ou mandar requisições HTTP forjadas,\n"
						+ "incluindo o cookie de sessão da vitima e qualquer outra autenticação incluída para uma aplicação vulnerável.\n"
						+ "Isso permite ao atacante forçar o navegador da vitima gerar requisições para a aplicação que é vulnerável,\n"
						+ "fazendo com que a aplicação pense que as requisições são de um usuário legítimo."
						+ "\n"
						+ "\nA solução para esta vulnerabilidade é evitar a passagem de parametros pela url,\n"
						+ "a validação dos dados de entradas, e verificação da seção do usuário.");
			}
		});
		btncsrf.setBounds(327, 184, 49, 25);
		contentPane.add(btncsrf);
		
		JButton btnInjection = new JButton("?");
		btnInjection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Injection é um ataque que pode ocorrer quando uma informação não confiável é enviada para um interpretador\n"
						+ "como parte de um comando ou uma query. O atacante através dessas informações enviadas pode burlar\n"
						+ "o interpretador executando comandos não intencionais pela aplicação ou acessar dados não autorizados.\n"
						+ "\n"
						+ "A solução para este tipo de vulnerabilidade, é o tratamento das entradas feitas pelo usuário,\n"
						+ "além de verificações para que aplicação não interprete comandos externos, que possam ser enviados por\n"
						+ "usuários com mais conhecimentos.");
			}
		});
		btnInjection.setBounds(535, 184, 49, 25);
		contentPane.add(btnInjection);
		
		JButton btnSqlInjection = new JButton("?");
		btnSqlInjection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "SQL Injection ocorre quando um atacante de uma aplicação insere comandos SQL (Structured Query Language)\n"
						+ "em um formulário de uma aplicação, numa query string, ou em um campo oculto da aplicação tendo como objetivo\n"
						+ "forçar a aplicação a soltar informações sigilosas.\n"
						+ "\n"
						+ "Uma das soluções para este problema é validar as entradas do usuário, não permitindo\n"
						+ "entradas de caracteres especiais como as aspas (') ou o caracatecter igual (=)");
			}
		});
		btnSqlInjection.setBounds(748, 184, 49, 25);
		contentPane.add(btnSqlInjection);
		
		JButton btnXss = new JButton("?");
		btnXss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cross-site Scripting mais conhecido como XSS é um ataque na qual envolve um código malicioso\n"
						+ "em um navegador que um usuário esteja utilizando. O código geralmente é escrito em HTML/JavaScript,\n"
						+ "mas que pode ser também escrito em outras linguagem como VBscript, Java\n"
						+ "e outras que são suportadas pelo navegador do usuário.\n"
						+ "\nQuando um atacante consegue acesso ao navegador do usuário para executar seu código,\n"
						+ "o mesmo irá ser executado na zona de segurança do web site. Com este privilégio o código\n"
						+ "malicioso pode ler, modificar e transmitir dados sensíveis através do navegador.\n"
						+ "Um usuário infectado pode ter sua conta sequestrada, pode ser redirecionado para outro site,\n"
						+ "ou possivelmente redirecionado para um site fraudulento com\n"
						+ "informações parecidas ao site que estava visitando.");
			}
		});
		btnXss.setBounds(875, 184, 49, 25);
		contentPane.add(btnXss);
		
		JButton btnMAC = new JButton("?");
		btnMAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Praticamente todas as aplicações web possuem funções de verificação de nível de acesso antes\n"
						+ "de disponibilizar a interface do sistema para o usuário. Entretanto as aplicações precisam as mesmas verificações\n"
						+ "de controle de acesso quando a funcionalidade é acessada. Se caso a aplicação\n"
						+ "não verificar as requisições o atacante pode acessar funcionalidade não autorizada.\n"
						+ "\n"
						+ "Uma das soluções para este problema é controlar o acesso a todas as páginas,\n"
						+ "para que somente usuários autorizados e autenticados tenham acesso a determinadas funcionalidades");
			}
		});
		btnMAC.setBounds(222, 385, 49, 25);
		contentPane.add(btnMAC);
		
		JButton btnNmap = new JButton("?");
		btnNmap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Portas abertas apresentam um risco para um sistema,\n"
						+ "deve-se ter um determinado cuidado com os serviços que possuem portas abertas,\n"
						+ "pois os mesmos podem gerar vulnerabilidades caso desatualizados");
			}
		});
		btnNmap.setBounds(423, 385, 49, 25);
		contentPane.add(btnNmap);
		
	}
	
	private Hashtable<String, Boolean> startXSS(List<String> urls){
		XSS injection = new XSS();
		injection.atacarXSS(urls);
		return injection.isVulneravel();
	}
	
	
	private Hashtable<String, Boolean> startSQLInjection(List<String> urls){
		SQLInjection injection = new SQLInjection();
		injection.atacarSQLInjection(urls);
		return injection.isVulneravel();
	}
	
	
	private Hashtable<String, Boolean> startInjection(List<String> urls){
		Injection injection = new Injection();
		injection.atacarInjectionPrimeiraEtapa(urls);
		return injection.isVulneravel();
	}
	
	
	private Hashtable<String, Boolean> startCSRF(List<String> urls){
		CSRF csrf = new CSRF();
		csrf.atacarCSRF(urls);
		return csrf.isVulneravel();
	}
	
	private List<String> getUrls(){
		
		List<String> urls = new ArrayList<String>();
		
		if(!url1.getText().isEmpty())
			urls.add(url1.getText());
		if(!url2.getText().isEmpty())
			urls.add(url2.getText());
		if(!url3.getText().isEmpty())
			urls.add(url3.getText());
		if(!url4.getText().isEmpty())
			urls.add(url4.getText());
		if(!url9.getText().isEmpty())
			urls.add(url9.getText());
		if(!url10.getText().isEmpty())
			urls.add(url10.getText());
		if(!url11.getText().isEmpty())
			urls.add(url11.getText());
		if(!url12.getText().isEmpty())
			urls.add(url12.getText());
		return urls;
		
	}
	
	
	
	private	String textoFinal(List<String> texto){
		String text ="";
		for (String linha : texto) {
			text+=linha+"\n";
		}
		return text;
	}
	
	private List<String> startMedusa(String endereco){
		
		Medusa medusa = new Medusa(endereco, "ftp");
		medusa.executaForcaBruta();
		return medusa.getResposta();
	}
	
	
	private List<String> startNmap(String endereco){
		Nmap nmap = new Nmap(endereco);
		nmap.executaComando();
		return nmap.getRespostaFormatada();
	}
	
	private Hashtable<String, Boolean> startMissingAcessControl(List<String> urls){
		MFLAC mflac = new MFLAC();
		mflac.atacarMFLAC(urlsForjadas(urls));
		return mflac.isVulneravel();
	}
	
	private List<String> urlsForjadas(List<String> urls){
		List<String> forjadas = new ArrayList<String>();
		for (String endereco : urls) {
			for (String teste : getTestes()) {
				forjadas.add(endereco+teste);
			}
		}
		return forjadas;
		
	}
	
	private List<String> getTestes(){
		List<String> testes = new ArrayList<String>();
		testes.add("admin/admin.html");
		testes.add("admin/teste.html");
		testes.add("admin/admin.aspx");
		testes.add("usuario/admin.html");
		return testes;
	}
}
