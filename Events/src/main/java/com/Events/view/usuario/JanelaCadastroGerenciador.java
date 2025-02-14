package com.Events.view.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.Events.dao.Persistencia;

import com.Events.view.Janela;
import com.Events.model.Adm;
import com.Events.model.Gerenciador;
import com.Events.view.JanelaFacade;
import com.Events.view.JanelaLogin;

public class JanelaCadastroGerenciador extends Janela{

	private Gerenciador gerenciador;

	private JTextField campoNome;
	private JTextField campoEmail;
	private JTextField campoIdade;
	private JTextField campoSenha;
    
	
	/**
	 * Metodo Construtor
	 */
	public JanelaCadastroGerenciador() {
		montarJanela();
	}		

	/**
	 * Monta a janela
	 */
	public void montarJanela(){
		JanelaFacade.criarTexto(this, 0, 40, 550, 30, "Bem-vindo(a) Gerenciador!", new java.awt.Font("Arial", java.awt.Font.BOLD, 20), JLabel.CENTER, Color.WHITE);
		JanelaFacade.criarTexto(this, 65,  55, 400, 120, "Faça aqui o seu cadastro", new Font("TimesRoman", Font.PLAIN, 17), JLabel.CENTER, Color.WHITE);
		
		JanelaFacade.criarTexto(this, 65, 220, 400, 120, "E-mail:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoEmail = JanelaFacade.criarCampoTextoComum(this, 125, 269, 330, 25, new LineBorder(Color.BLACK, 2));
		
		JanelaFacade.criarTexto(this, 65, 260, 400, 120, "Senha:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoSenha = JanelaFacade.criarCampoTextoComum(this, 125, 310, 330, 25, new LineBorder(Color.BLACK, 2));			
		
		JanelaFacade.criarBotao(this, ouvinteConcluir(), "Concluir", new Font("Fonte", Font.BOLD, 13), Color.WHITE, 200, 460, 150, 30, new Color(138, 43, 226), new LineBorder(Color.WHITE, 2), null, 0, 0);		
		
		setVisible(true);
	}

	/**
	 * Ouvinte do botão Concluir
	 * @return
	 */
	public ActionListener ouvinteConcluir(){
		return new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				String erro = null;

				if(campoEmail.getText().isEmpty()) {
					erro = "O campo E-mail não pode ser vazio";
				}
				else if(campoSenha.getText().isEmpty()) {
					erro = "O campo Senha não pode ser vazio";
				}
				else if(!campoEmail.getText().matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
					erro = "E-mail inválido";
				}
				else if(campoSenha.getText().length() < 6) {
					erro = "A senha deve ter no mínimo 6 caracteres";
				}
				
				if(erro != null) {
					JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				gerenciador = new Gerenciador(campoEmail.getText(), campoSenha.getText());

                Adm adm = new Adm();
                adm.addAdm(gerenciador);

				Persistencia.persistir(adm);

				dispose();
				new JanelaLogin();
					
			}
			
		};
	}


	// Getters e Setters


	public JTextField getCampoNome() {
		return campoNome;
	}
	
	public JTextField getCampoEmail() {
		return campoEmail;
	}
	
	public JTextField getCampoIdade() {
		return campoIdade;
	}
	
	public JTextField getCampoSenha() {
		return campoSenha;
	}

}
