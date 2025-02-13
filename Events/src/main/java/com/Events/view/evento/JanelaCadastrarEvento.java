package com.Events.view.evento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.Events.dao.Persistencia;
import com.Events.model.Adm;
import com.Events.model.Evento;
import com.Events.model.Gerenciador;
import com.Events.view.Janela;
import com.Events.view.JanelaFacade;
import com.Events.view.JanelaLogin;
import com.Events.view.usuario.JanelaMenuGerenciador;

public class JanelaCadastrarEvento extends Janela{
    
    private Evento evento;

	private JTextField campoNome;
	private JTextField campoInicio;
	private JTextField campoFim;
	private JTextField campoLocal;
	private JTextField campoParticipantes;
	private JTextField campoDescricao;
    
	
	/**
	 * Metodo Construtor
	 */
	public JanelaCadastrarEvento()  {
		montarJanela();
	}		

	/**
	 * Monta a janela
	 */
	public void montarJanela(){
		JanelaFacade.criarTexto(this, 65,  50, 400, 120, "Cadastrar Evento", new Font("TimesRoman", Font.PLAIN, 17), JLabel.CENTER, Color.WHITE);
		
		JanelaFacade.criarTexto(this, 65, 160, 400, 120, "Nome:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoNome = JanelaFacade.criarCampoTextoComum(this, 125, 209, 330, 25, new LineBorder(Color.BLACK, 2));
		
		JanelaFacade.criarTexto(this, 65, 220, 200, 120, "Inicio:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoInicio = JanelaFacade.criarCampoTextoMascarado(this, 125, 269, 130, 25, new LineBorder(Color.BLACK, 2), "##/##/####");
        
        JanelaFacade.criarTexto(this, 280, 220, 400, 120, "Fim:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoFim = JanelaFacade.criarCampoTextoMascarado(this, 325, 269, 130, 25, new LineBorder(Color.BLACK, 2), "##/##/####");
		
		JanelaFacade.criarTexto(this, 65, 280, 400, 120, "Local:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoLocal = JanelaFacade.criarCampoTextoComum(this, 125, 330, 225, 25, new LineBorder(Color.BLACK, 2));
		
		JanelaFacade.criarTexto(this, 65, 340, 400, 120, "Participantes:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoParticipantes = JanelaFacade.criarCampoTextoComum(this, 185, 390, 270, 25, new LineBorder(Color.BLACK, 2));	
        
        JanelaFacade.criarTexto(this, 65, 400, 400, 120, "Descricao:", new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
		this.campoDescricao = JanelaFacade.criarCampoTextoComum(this, 160, 450, 295, 25, new LineBorder(Color.BLACK, 2));		
		
		
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

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date_inicio = LocalDate.parse(campoInicio.getText(), formatter);
                LocalDate date_fim = LocalDate.parse(campoFim.getText(), formatter);
				
				evento = new Evento(campoNome.getText(), date_inicio, date_fim, campoLocal.getText(), Integer.parseInt(campoParticipantes.getText()), campoDescricao.getText());

                Adm adm = Persistencia.carregar();

                Gerenciador gerenciador = adm.getGerenciadores().get(0);
                gerenciador.addEvento(evento);

				Persistencia.persistir(adm);

				dispose();
				new JanelaMenuGerenciador();
					
			}
			
		};
	}
	
	public ActionListener ouvinteVoltar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaMenuGerenciador();
			}
		};
	}


	// Getters e Setters


	public JTextField getCampoNome() {
		return campoNome;
	}
	
	public JTextField getCampoInicio() {
        return campoInicio;
    }

    public JTextField getCampoFim() {
        return campoFim;
    }

    public JTextField getCampoLocal() {
        return campoLocal;
    }

    public JTextField getCampoParticipantes() {
        return campoParticipantes;
    }

    public JTextField getCampoDescricao() {
        return campoDescricao;
    }

}
