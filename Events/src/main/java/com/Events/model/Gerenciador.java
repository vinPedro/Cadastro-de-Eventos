package com.Events.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Gerenciador {

	private String usuarioG;
	private String senhaStringG;

	@XmlElementWrapper(name = "eventos")
	@XmlElement(name = "evento")
	private ArrayList<Evento> eventos = new ArrayList<Evento>();

	@XmlElementWrapper(name = "Participantes")
	@XmlElement(name = "Participante")
	private ArrayList<Participante> participantes = new ArrayList<Participante>();

	public Gerenciador(String usuarioG, String senhaString) {
		super();
		this.usuarioG = usuarioG;
		this.senhaStringG = senhaString;
	}

	// adiciona um evento a lista de eventos da aplicação
	public boolean addEvento(Evento evento) {
		if (evento == null) {
			return false;
		}

		else if (eventos.add(evento) == true) {
			return true;
		}

		return false;
	}

	// adiciona um usuário a lista de usuários da aplicação
	public boolean addparticipante(Participante participante) {
		if (participante == null) {
			return false;
		}

		else if (participantes.add(participante) == true) {
			return true;
		}

		return false;
	}

	// deleta um evento da lista de eventos da aplicação
	public boolean deleteEvento(Evento evento) {
		if (evento == null) {
			return false;
		}

		else if (eventos.remove(evento) == true) {
			return true;
		}

		return false;
	}

	// deleta um usuário da lista de eventos da aplicação
	public boolean deleteparticipante(Participante participante) {
		if (participante == null) {
			return false;
		}

		else if (participantes.remove(participante) == true) {
			return true;
		}

		return false;
	}

	// recupera um evento na lista de eventos da aplicação, por sua posição na lista
	public Evento recuperarEvento(int index) {
		Evento evento = eventos.get(index);
		if (evento != null) {
			return evento;
		}

		return null;
	}

	// recupera um usuário na lista de usuários da aplicação, por sua posição na
	// lista
	public Participante recuperarParticipante(int index) {
		Participante participante = participantes.get(index);
		if (participante != null) {
			return participante;
		}

		return null;
	}

	// Método para gerar e salvar o PDF na pasta do projeto
	public String gerarPDF(String nomeAluno, String nomeEvento) {

		Document document = new Document();

		// Gerar um nome único para o arquivo (com base na data/hora) String
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String nomePDF = nomeAluno + timestamp + ".pdf";

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(nomePDF));
			document.open();
			document.add(new Paragraph("Certificado"));
			document.add(new Paragraph(""));
			document.add(
					new Paragraph("Parabéns " + nomeAluno + " você compriu com êxito o evento " + nomeEvento + "."));

			document.close();
			writer.close();
			return nomePDF;

		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void enviarConfirmacaoCadastro(Participante participante) {
		
		String USERNAME = "raymonramon49@gmail.com"; 
		String PASSWORD = "uidb hlsg wgra bonn";
		
		SimpleEmail email = new SimpleEmail();	
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(USERNAME);
			email.setSubject("Confirmação");
			email.setMsg("Confirmação de Inscrição!");
			email.addTo(participante.getEmailString());
			email.send();
			System.out.println("Enviado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void enviarConfirmacaoEvento(Participante participante, Evento evento) {
		
		String USERNAME = "raymonramon49@gmail.com"; 
		String PASSWORD = "uidb hlsg wgra bonn";
		
		SimpleEmail email = new SimpleEmail();	
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
		email.setSSLOnConnect(true);
		
		try {
			email.setFrom(USERNAME);
			email.setSubject("Confirmação");
			email.setMsg("Confirmação de Inscrição no evento: " + evento.getNomeString() + ".");
			email.addTo(participante.getEmailString());
			email.send();
			System.out.println("Enviado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enviarCertificado(Participante participante, Evento evento) {

        String USERNAME = "raymonramon49@gmail.com"; 
        String PASSWORD = "uidb hlsg wgra bonn";

        // Gerar o PDF
        String nomeAluno = participante.getNomeString(); // Supondo que o participante tenha um método getNome()
        String nomeEvento = evento.getNomeString(); // Defina o nome do evento aqui
        String nomePDF = gerarPDF(nomeAluno, nomeEvento);

        // Enviar o e-mail com o PDF
        try {
        	Email email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
            email.setSSLOnConnect(true);
            email.setFrom(USERNAME);
            email.setSubject("Certificado: ");
            email.setMsg("Olá " + nomeAluno + ",\n\nParabéns pela conclusão do evento: " + nomeEvento + ".\nSegue o seu certificado em anexo.");

            // Adicionar destinatário
            email.addTo(participante.getEmailString());

            // Anexar o PDF gerado
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(nomePDF); // Caminho do arquivo PDF
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Certificado de Inscrição");
            attachment.setName(nomePDF);
            ((HtmlEmail) email).attach(attachment);

            // Enviar o e-mail
            email.send();
            System.out.println("E-mail enviado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public boolean enviarCertificadoParticipantesEvento(Evento evento) {
		if(evento == null) {
			return false;
		}
		
		for (Participante participante : evento.getParticipantes()) {
			enviarCertificado(participante, evento);
			
		}
		
		return true;
	}

	// Getts e Sets
	public Gerenciador() {
	}

	public String getusuarioG() {
		return usuarioG;
	}

	public void setusuarioG(String usuario) {
		this.usuarioG = usuario;
	}

	public String getSenhaStringG() {
		return senhaStringG;
	}

	public void setSenhaStringG(String senhaString) {
		this.senhaStringG = senhaString;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

}
