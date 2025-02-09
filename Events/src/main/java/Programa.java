
import com.Events.dao.Persitencia;
import com.Events.model.Adm;
import com.Events.model.Evento;
import com.Events.model.Gerenciador;
import com.Events.model.LocalDateAdapter;
import com.Events.model.Participante;
import com.Events.model.Sexo;

public class Programa {

	public static void main(String[] args) throws Exception {

		 LocalDateAdapter localDateAdapter = new LocalDateAdapter();

		// Participante participante = new Participante("teste", "teste", 20,
		// Sexo.Masculino);
		 Participante participante1 = new Participante("teste1", "teste", 20,
		 Sexo.Masculino, "pedro-lopes.pl@academico.ifpb.edu.br");

		
		  Evento evento1 = new Evento("Teste1",
		  localDateAdapter.unmarshal("07/07/2024"),
		  localDateAdapter.unmarshal("08/07/2024"), "Centro", 10, "teste");
		 

		 Gerenciador gerenciador = new Gerenciador("Teste2", "Teste2");
		 gerenciador.enviarCertificado(participante1, evento1);
		// Adm adm = new Adm();
		// Adm adm = Persitencia.carregar();
		// Gerenciador gerenciador = adm.recuperarAdm(0);
		// System.out.println(gerenciador.recuperarEvento(0));
		// gerenciador.addAdm(grt1);

		// evento.addparticipante(participante1);
		// Evento evento = gerenciador.recuperarEvento(0);
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
