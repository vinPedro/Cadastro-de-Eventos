package com.Events.view.evento;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import com.Events.dao.Persistencia;
import com.Events.model.Adm;
import com.Events.model.Evento;
import com.Events.model.Gerenciador;
import com.Events.model.Participante;
import com.Events.view.Janela;
import com.Events.view.JanelaFacade;
import com.Events.view.usuario.JanelaMenuGerenciador;
import com.Events.view.usuario.JanelaMenuParticipante;

public class VerEvento extends Janela{

    private Evento evento;
    private String tela_anterior;
    private Participante participante;

	public VerEvento(Evento evento, String tela_anterior){
		
		this.evento = evento;
        this.tela_anterior = tela_anterior;
		montarTela();

	}

    public VerEvento(Evento evento, String tela_anterior, Participante participante){
		
		this.evento = evento;
        this.tela_anterior = tela_anterior;
        this.participante = participante;
		montarTela();

	}

	public void montarTela(){
		JanelaFacade.criarTexto(this, 0, 40, 550, 30, "Ver evento", new java.awt.Font("Arial", java.awt.Font.BOLD, 20), JLabel.CENTER, Color.WHITE);
		
        JanelaFacade.criarTexto(this, 65, 110, 550, 30, "Nome: "+evento.getNomeString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 140, 550, 30, "Inicio: "+evento.getDataInicialDate().toString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 170, 550, 30, "Fim: "+evento.getDataFinalDate().toString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 200, 550, 30, "Local: "+evento.getLocalString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 230, 550, 30, "Participantes: "+evento.getParticipantes().size(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 260, 550, 30, "Max Participantes: "+evento.getQuantParticipantes(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        JanelaFacade.criarTexto(this, 65, 290, 550, 30, "Descricao: "+evento.getDescricaoString(), new Font("TimesRoman", Font.PLAIN, 17), JLabel.LEFT, Color.WHITE);
        
        JanelaFacade.criarBotao(this, ouvinteBotaoVoltar(), "Voltar", new java.awt.Font("Arial", java.awt.Font.TRUETYPE_FONT, 13), Color.WHITE, 40, 43, 50, 25, new Color(35,35, 142), new LineBorder(Color.WHITE, 2), null, 0, 0);	
        if(tela_anterior.equals("MenuGerenciador")){
			JanelaFacade.criarBotao(this, ouvinteBotaoDeletar(), "Deletar", new Font("Fonte", Font.BOLD, 13), Color.WHITE, 150, 540, 100, 30, new Color(225, 0, 0), new LineBorder(Color.WHITE, 2), null, 0, 0);
            JanelaFacade.criarBotao(this, ouvinteBotaoEnviarCertificados(), "Enviar Certificados", new Font("Fonte", Font.BOLD, 13), Color.WHITE, 300, 540, 150, 30, new Color(100, 200, 50), new LineBorder(Color.WHITE, 2), null, 0, 0);
		}else{
            JanelaFacade.criarBotao(this, ouvinteBotaoParticipar(), "Participar", new Font("Fonte", Font.BOLD, 13), Color.WHITE, 220, 540, 100, 30, new Color(138, 43, 226), new LineBorder(Color.WHITE, 2), null, 0, 0);
        }

        setVisible(true);
	}
    
    
    public ActionListener ouvinteBotaoVoltar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
                if(tela_anterior.equals("MenuGerenciador")){
                    dispose();
                    new JanelaMenuGerenciador();
                }else{
                    dispose();
                    new JanelaMenuParticipante(participante);
                }
				
			}
		};
	}
       
    public ActionListener ouvinteBotaoDeletar() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar o evento?", "Deletar", JOptionPane.YES_NO_OPTION);

                if(opcao == 0){

                    Adm adm = Persistencia.carregar();
                    Gerenciador gerenciador = adm.getGerenciadores().get(0);

                    for(Evento evento : gerenciador.getEventos()){
                        if(evento.equals(evento)){
                            gerenciador.deletarEvento(evento);
                            Persistencia.persistir(adm);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Evento deletado com sucesso");
                    dispose();
                    new JanelaMenuGerenciador();
                }else{
                    JOptionPane.showMessageDialog(null, "Operacao cancelada");
                }
				
			}
		};
	}

    public ActionListener ouvinteBotaoEnviarCertificados() {

        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Adm adm = Persistencia.carregar();
                Gerenciador gerenciador = adm.getGerenciadores().get(0);
                JOptionPane.showMessageDialog(null, "Enviando certificados...");
                gerenciador.enviarCertificadoParticipantesEvento(evento);
                JOptionPane.showMessageDialog(null, "Certificados enviados");
            }
        };
    }

    public ActionListener ouvinteBotaoParticipar() {

        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(evento.getParticipantes().size() < evento.getQuantParticipantes()){
                    evento.addparticipante(participante);
                    Adm adm = Persistencia.carregar();                    
                    Evento Objevento = adm.recuperarEvento(evento.getNomeString());
                    Objevento.addparticipante(participante);

                    Persistencia.persistir(adm);
                    Gerenciador gerenciador = adm.getGerenciadores().get(0);
                    gerenciador.enviarConfirmacaoEvento(participante, Objevento);
                    JOptionPane.showMessageDialog(null, "Participacao confirmada");
                    dispose();
                    new JanelaMenuParticipante(participante);
                }else{
                    JOptionPane.showMessageDialog(null, "Evento lotado");
                }
            }
        };
    }
}
