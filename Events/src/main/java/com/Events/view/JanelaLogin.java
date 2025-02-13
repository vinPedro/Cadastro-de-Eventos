package com.Events.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Font;

import com.Events.dao.Persistencia;
import com.Events.model.Adm;
import com.Events.view.usuario.JanelaCadastroParticipante;
import com.Events.view.usuario.JanelaMenuGerenciador;

public class JanelaLogin extends Janela{
	private JTextField campoEmail;
	private JTextField campoSenha;
	
	JLabel label = new JLabel();
	
	public JTextField getCampoEmail() {
		return campoEmail;
	}



	public JTextField getCampoSenha() {
		return campoSenha;
	}
	
	public JanelaLogin() {
		
		
		JanelaFacade.criarTexto(this, 0, 150, 550, 30, "Faça o login na sua conta", new java.awt.Font("Arial", java.awt.Font.ROMAN_BASELINE, 20), JLabel.CENTER, new Color(174, 55, 255));
		
		JanelaFacade.criarTexto(this, 120, 220, 550, 30, "E-mail:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.BLACK);
		campoEmail = JanelaFacade.criarCampoTextoComum(this, 120, 260, 315, 25, new LineBorder(new Color(174, 55, 255), 2));
		
		
		JanelaFacade.criarTexto(this, 120, 320, 550, 30, "Senha:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.BLACK);
		campoSenha = JanelaFacade.criarCampoTextoComum(this, 120, 360, 315, 25, new LineBorder(new Color(174, 55, 255), 2));		
		
		JanelaFacade.criarBotao(this, ouvinteBotaoLogin(), "Login", new Font("TimesRoman", Font.PLAIN, 17), Color.WHITE, 200, 430, 170, 30, new Color(174, 55, 255), new LineBorder(new Color(174, 55, 255), 2), null, 0, 0);
		
		JanelaFacade.criarTexto(this, 170, 500, 275, 25, "Ainda não tem uma conta?", new java.awt.Font("Arial", java.awt.Font.PLAIN, 13), JLabel.LEFT, Color.BLACK);
		
		JanelaFacade.criarBotao(this, ouvinteBotaoCadastro(), "Cadastre-se!", new java.awt.Font("Arial", java.awt.Font.ITALIC, 13), new Color(174, 55, 255), 325, 500, 80, 25, Color.WHITE, new LineBorder(Color.WHITE, 1), null, 0, 0);
		
		JanelaFacade.criarPanel(this, 70, 90, 405, 470, Color.WHITE);
		
		
		
		setVisible(true);
	
	}
	
	public ActionListener ouvinteBotaoLogin() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				Adm adm = Persistencia.carregar();

				boolean isAdmin = adm.isAdmin(campoEmail.getText(), campoSenha.getText());
				boolean isParticipante = adm.isParticipante(campoEmail.getText(), campoSenha.getText());

				if(isAdmin) {
					
					System.out.println("Login admin");
					dispose();
					new JanelaMenuGerenciador();
					
				}else if(isParticipante){
					System.out.println("Login participante");

				} else{
					JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!", "Tente novamente", JOptionPane.DEFAULT_OPTION);
				}
				
			}
		};
	}
	
	public ActionListener ouvinteBotaoCadastro() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaCadastroParticipante();
				
			}
		};
	}
	
}
