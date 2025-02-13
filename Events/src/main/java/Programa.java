
import javax.swing.JOptionPane;

import com.Events.dao.Persistencia;
import com.Events.model.Adm;
import com.Events.model.Evento;
import com.Events.model.Gerenciador;
import com.Events.model.Participante;
import com.Events.model.Sexo;
import com.Events.view.JanelaLogin;
import com.Events.view.evento.JanelaCadastrarEvento;
import com.Events.view.usuario.JanelaCadastroGerenciador;
import com.Events.view.usuario.JanelaMenuGerenciador;
import com.Events.view.usuario.JanelaMenuParticipante;

public class Programa {

	public static void main(String[] args) throws Exception {

		// Enviar Certificado
		// Participante participante = new Participante("Jeff", "teste", 20,Sexo.Masculino, "jeffersondanilo2517@gmail.com");
		// Evento evento1 = new Evento("Teste1", null, null, "Centro", 10, "teste");
		// Gerenciador gerenciador = new Gerenciador("Teste2", "Teste2");
		// gerenciador.enviarCertificado(participante, evento1);


		Adm adm = new Adm();
		try{
			adm = Persistencia.carregar();
		}catch(Exception e){
			adm = new Adm();
			Persistencia.persistir(adm);
		}

		if(adm.getGerenciadores().size() > 0){

			
			new JanelaLogin();
			// new JanelaCadastrarEvento();
			// new JanelaMenuGerenciador();
			// new JanelaMenuParticipante(null);
			
		}else{
			new JanelaCadastroGerenciador();
		}

		// Exemplos de uso
		// LocalDateAdapter localDateAdapter = new LocalDateAdapter();

		// Participante participante = new Participante("Jeff", "teste", 20,Sexo.Masculino, "jeffersondanilo2517@gmail.com");
		// /*
		//  * Participante participante2 = new Participante("teste2", "teste", 20,
		//  * Sexo.Masculino, "pedro-lopes.pl@academico.ifpb.edu.br");
		//  */

		
		// Evento evento1 = new Evento("Teste1", null, null, "Centro", 10, "teste");
					 

		//  Gerenciador gerenciador = new Gerenciador("Teste2", "Teste2");
		//  gerenciador.enviarCertificado(participante, evento1);
		//  Adm adm = new Adm();
		// Adm adm = Persitencia.carregar();
		// Gerenciador gerenciador = adm.recuperarAdm(0);
		// System.out.println(gerenciador.recuperarEvento(0));
		// gerenciador.addAdm(grt1);

		// evento.addparticipante(participante1);
		// Evento evento = gerenciador.recuperarEvento(0);
		// gerenciador.enviarCertificadoParticipantesEvento(evento);
		// Evento evento1 = gerenciador.recuperarEvento(0);
		// Participante participante = evento.recuperarParticipante(0);
		// gerenciador.deleteparticipante(participante);
		// gerenciador.addparticipante(participante1);
		// evento1.addparticipante(participante);
		// evento.excluirEscricaoParticipante(0);
		// evento.addparticipante(participante1);
		// evento.excluirEscricaoParticipante(0);

		// evento.addparticipante(participante1);

		// gerenciador.deleteEvento(evento);
		// gerenciador.addEvento(evento1);
		// adm.removerAdm(gerenciador);
		// adm.addAdm(gerenciador);
		// gerenciador.deleteparticipante(gerenciador.recuperarParticipante(0));
		// gerenciador.deleteEvento(gerenciador.recuperarEvento(0));
		// Persitencia.persistir(adm);

		// gerenciador.gerarPDF(participante.getNomeString(), evento.getNomeString());

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //gerenciador.addparticipante(participante1); Participante participante1 =
		 * gerenciador.recuperarParticipante(0); Evento evento =
		 * gerenciador.recuperarEvento(0);
		 * 
		 * //System.out.println(evento);
		 * 
		 * evento.addparticipante(participante1);
		 * 
		 * 
		 */

		// Persitencia.persistir(gerenciador);

		// Gerenciador gerenciador = Persitencia.carregar();

		// System.out.println(gerenciador2.getSenhaString() + " / " +
		// gerenciador2.getSenhaString() + " / " +
		// gerenciador2.recuperarEvento(1).getNomeString());

	}
}
