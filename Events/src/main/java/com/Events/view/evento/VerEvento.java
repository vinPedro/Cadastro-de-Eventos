package com.Events.view.evento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import com.Events.model.Evento;
import com.Events.view.Janela;
import com.Events.view.JanelaFacade;

public class VerEvento extends Janela{

    private Evento evento;

	public VerEvento(Evento evento, String tela_anterior){
		
		this.evento = evento;
		montarTela();

	}

	public void montarTela(){
		JanelaFacade.criarTexto(this, 0, 40, 550, 30, "Ver evento", new java.awt.Font("Arial", java.awt.Font.BOLD, 20), JLabel.CENTER, Color.WHITE);
		
        JanelaFacade.criarTexto(this, 65, 110, 550, 30, "Nome: "+evento.getNomeString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 140, 550, 30, "Inicio: "+evento.getDataInicialDate().toString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 170, 550, 30, "Fim: "+evento.getDataFinalDate().toString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 200, 550, 30, "Local: "+evento.getLocalString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 230, 550, 30, "Max Participantes: "+evento.getQuantParticipantes(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 270, 550, 30, "Descricao: "+evento.getDescricaoString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        
        JanelaFacade.criarBotao(this, ouvinteBotaoVoltar(), "Voltar", new java.awt.Font("Arial", java.awt.Font.TRUETYPE_FONT, 13), Color.WHITE, 40, 43, 50, 25, new Color(35,35, 142), new LineBorder(Color.WHITE, 2), null, 0, 0);		

        setVisible(true);
	}
    
    
    public ActionListener ouvinteBotaoVoltar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
       
    public ActionListener ouvinteBotaoDetalhes() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}
}
