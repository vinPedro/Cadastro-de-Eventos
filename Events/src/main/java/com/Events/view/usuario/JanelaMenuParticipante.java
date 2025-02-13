package com.Events.view.usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.Events.view.JanelaFacade;
import com.Events.view.JanelaLogin;
import com.Events.view.evento.JanelaCadastrarEvento;
import com.Events.view.evento.VerEvento;
import com.Events.dao.Persistencia;
import com.Events.model.Adm;
import com.Events.model.Evento;
import com.Events.model.Gerenciador;
import com.Events.model.Participante;
import com.Events.view.Janela;

public class JanelaMenuParticipante extends Janela{

    private Participante participante;
    
	public JanelaMenuParticipante(Participante participante) {

        this.participante = participante;

		JanelaFacade.criarTexto(this, 0, 40, 550, 30, "Menu do Participante", new java.awt.Font("Arial", java.awt.Font.BOLD, 20), JLabel.CENTER, Color.WHITE);
		
		JanelaFacade.criarBotao(this, ouvinteVerEventos(), "Ver Eventos", new Font("TimesRoman", Font.PLAIN, 17), Color.WHITE, 190, 220, 170, 30, new Color(174, 55, 255), new LineBorder(Color.WHITE, 2), null, 0, 0);
		JanelaFacade.criarBotao(this, ouvinteVerEventos(), "Ver Eventos", new Font("TimesRoman", Font.PLAIN, 17), Color.WHITE, 190, 300, 170, 30, new Color(174, 55, 255), new LineBorder(Color.WHITE, 2), null, 0, 0);
		JanelaFacade.criarBotao(this, ouvinteBotaoLogout(), "Logout", new Font("TimesRoman", Font.PLAIN, 17), Color.WHITE, 190, 460, 170, 30, new Color(174, 55, 255), new LineBorder(Color.WHITE, 2), null, 0, 0);
		
		setVisible(true);
	}
	
	public ActionListener ouvinteCadastrarEvento() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
                new JanelaCadastrarEvento();				
			}
		};
	}	
	
	public ActionListener ouvinteVerEventos() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

                Adm adm = Persistencia.carregar();
                Gerenciador gerenciador = adm.getGerenciadores().get(0);

                Evento[] eventos = new Evento[gerenciador.getEventos().size()];

                for(int i = 0; i < gerenciador.getEventos().size(); i++){
                    eventos[i] = gerenciador.getEventos().get(i);
                }

                if(eventos.length == 0){
                    JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado");
                    new JanelaMenuParticipante(participante);
                }else{
                    Evento resposta = (Evento)JOptionPane.showInputDialog(null, "Test", "Eventos", JOptionPane.DEFAULT_OPTION, null, eventos, "Evento 1");
    
                    if(resposta != null) {
                        new VerEvento(resposta, "MenuParticipante", participante);
                    }else{
                        JOptionPane.showMessageDialog(null, "Nenhum evento selecionado");
                        new JanelaMenuParticipante(participante);
                    }
                }

				
			}
		};
	}	
    
    public ActionListener ouvinteDeletarEvento() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		};
	}	
	
	public ActionListener ouvinteBotaoLogout() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaLogin();
			}
		};
	}
	
}
