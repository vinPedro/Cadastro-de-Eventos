package com.Events.model;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Gerenciador {
	
	private String usuario = "admin";
	private String senhaString = "admin" ;
	
	@XmlElementWrapper(name= "eventos")
	@XmlElement(name= "evento")
	private ArrayList<Evento> eventos = new  ArrayList<Evento>();
	
	@XmlElementWrapper(name= "participantes")
	@XmlElement(name= "participante")
	private ArrayList<Participante> participantes = new ArrayList<Participante>();
	
	//adiciona um evento a lista de eventos da aplicação
	public boolean addEvento(Evento evento) {
		if(evento.equals(null)) {
			return false;
		}
		
		else if(eventos.add(evento)==true) {
			return true;
		}
		
		return false;
	}
	
	//adiciona um usuário a lista de usuários da aplicação
	public boolean addparticipante(Participante participante) {
		if(participante.equals(null)) {
			return false;
		}
		
		else if(participantes.add(participante)==true) {
			return true;
		}
		
		return false;
	}
	
	
	//deleta um evento da lista de eventos da aplicação
	public boolean deleteEvento(Evento evento) {
		if(evento.equals(null)) {
			return false;
		}
		
		else if(eventos.remove(evento)==true) {
			return true;
		}
		
		return false;
	}
	
	//deleta um usuário da lista de eventos da aplicação
	public boolean deleteparticipante(Participante participante) {
		if(participante.equals(null)) {
			return false;
		}
		
		else if(participantes.remove(participante)==true) {
			return true;
		}
		
		return false;
	}
	
	//recupera um evento na lista de eventos da aplicação, por sua posição na lista
	public Evento recuperarEvento(int index) {
		Evento evento = eventos.get(index);
		if (!evento.equals(null)) {
			return evento;
		}
		
		return null;
	}
	
	//recupera um usuário na lista de usuários da aplicação, por sua posição na lista
	public Participante recuperarParticipante(int index) {
		Participante participante = participantes.get(index);
		if (!participante.equals(null)) {
			return participante;
		}
		
		return null;
	}
	
	/*
	 * //Atualiza um evento
	 * atualizarEvento(Evento evento){ if (evento.equals(null)) { return false; }
	 * 
	 * for (Evento evento1 : eventos) { if (evento1.equals(evento)) { evento1 =
	 * evento; return true; } }
	 * 
	 * return false; }
	 */
	 
	 
	 

	// Getts e Sets
	public Gerenciador() {}
	
	
	public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario = usuario;
	}

	
	public String getSenhaString() {
		return senhaString;
	}

	public void setSenhaString(String senhaString) {
		this.senhaString = senhaString;
	}

	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	
	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}


}
