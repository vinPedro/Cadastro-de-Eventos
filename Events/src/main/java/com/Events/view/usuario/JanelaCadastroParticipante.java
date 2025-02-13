package com.Events.view.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.Events.view.Janela;
import com.Events.model.Adm;
import com.Events.model.Gerenciador;
import com.Events.model.Participante;
import com.Events.model.Sexo;
import com.Events.view.JanelaFacade;
import com.Events.view.JanelaLogin;
import com.Events.dao.Persistencia;

public class JanelaCadastroParticipante extends Janela{

	private Participante participante;

	private JTextField campoNome;
	private JTextField campoEmail;
	private JTextField campoCPF;
	private JTextField campoTelefone;
	private JTextField campoIdade;
	private JTextField campoSenha;
	private JTextField campoSexo;
    
	
	/**
	 * Metodo Construtor
	 */
	public JanelaCadastroParticipante() {
		montarJanela();
	}		

	/**
	 * Monta a janela
	 */
	public void montarJanela(){
		JanelaFacade.criarTexto(this, 0, 40, 550, 30, "Bem-vindo(a)!", new java.awt.Font("Arial", java.awt.Font.BOLD, 20), JLabel.CENTER, Color.WHITE);
		JanelaFacade.criarTexto(this, 65,  55, 400, 120, "Faça aqui o seu cadastro", new Font("TimesRoman", Font.PLAIN, 17), JLabel.CENTER, Color.WHITE);
		
		JanelaFacade.criarTexto(this, 65, 160, 400, 120, "Nome:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoNome = JanelaFacade.criarCampoTextoComum(this, 125, 209, 330, 25, new LineBorder(Color.BLACK, 2));
		
		JanelaFacade.criarTexto(this, 65, 220, 400, 120, "E-mail:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoEmail = JanelaFacade.criarCampoTextoComum(this, 125, 269, 330, 25, new LineBorder(Color.BLACK, 2));
		
		JanelaFacade.criarTexto(this, 65, 280, 400, 120, "Idade:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoIdade = JanelaFacade.criarCampoTextoComum(this, 125, 330, 225, 25, new LineBorder(Color.BLACK, 2));
		
		JanelaFacade.criarTexto(this, 65, 340, 400, 120, "Senha:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoSenha = JanelaFacade.criarCampoTextoComum(this, 125, 390, 330, 25, new LineBorder(Color.BLACK, 2));	
        
        JanelaFacade.criarTexto(this, 65, 400, 400, 120, "Sexo:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoSexo = JanelaFacade.criarCampoTextoComum(this, 125, 450, 330, 25, new LineBorder(Color.BLACK, 2));		
		
		
		JanelaFacade.criarBotao(this, ouvinteConcluir(), "Concluir", new Font("Fonte", Font.BOLD, 13), Color.WHITE, 295, 560, 150, 30, new Color(138, 43, 226), new LineBorder(Color.WHITE, 2), null, 0, 0);
		
		
		JanelaFacade.criarBotao(this, ouvinteVoltar(), "Voltar", new java.awt.Font("Arial", java.awt.Font.TRUETYPE_FONT, 13), Color.WHITE, 40, 43, 50, 25, new Color(35,35, 142), new LineBorder(Color.WHITE, 2), null, 0, 0);		
		
		setVisible(true);
	}

	/**
	 * Ouvinte do botão Concluir
	 * @return
	 */
	public ActionListener ouvinteConcluir(){
		return new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				participante = new Participante(campoNome.getText(), campoSenha.getText(), Integer.parseInt(campoIdade.getText()), Sexo.valueOf(campoSexo.getText()), campoEmail.getText());

                Adm adm = Persistencia.carregar();

                Gerenciador gerenciador = adm.getGerenciadores().get(0);
				Participante participante_cadastrado = adm.recuperarParticipante(campoEmail.getText());

				if(participante_cadastrado == null){
					
					gerenciador.addparticipante(participante);

					Persistencia.persistir(adm);
					dispose();

					JOptionPane.showMessageDialog(null, "Preparando o seu cadastro...");
					gerenciador.enviarConfirmacaoCadastro(participante);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

					new JanelaLogin();
				}else{
					JOptionPane.showMessageDialog(null, "Email já cadastrado");
				}
					
			}
			
		};
	}
	
	public ActionListener ouvinteVoltar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
	
	public JTextField getCampoCPF() {
		return campoCPF;
	}
	
	public JTextField getCampoTelefone() {
		return campoTelefone;
	}
	
	public JTextField getCampoIdade() {
		return campoIdade;
	}
	
	public JTextField getCampoSenha() {
		return campoSenha;
	}

}
