package com.Events.model;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Adm {

	@XmlElementWrapper(name = "Gerenciador")
	@XmlElement(name = "Gerenciador")
	// @XmlTransient // Evita problemas de referência cíclica
	private ArrayList<Gerenciador> gerenciadores = new ArrayList<Gerenciador>();

	public Adm() {
	}

	// adiciona um gerenciador a lista de gerenciadores da aplicação
	public boolean addAdm(Gerenciador gerenciador) {
		if (gerenciador == null) {
			return false;
		}

		else if (gerenciadores.add(gerenciador) == true) {
			return true;
		}

		return false;
	}

	// remover um gerenciador a lista de gerenciadores da aplicação
	public boolean removerAdm(Gerenciador gerenciador) {
		if (gerenciador == null) {
			return false;
		}

		else if (gerenciadores.remove(gerenciador) == true) {
			return true;
		}

		return false;
	}

	// recupera um gerenciador na lista de gerentes da aplicação, por sua posição na
	// lista
	public Gerenciador recuperarAdm(int index) {
		Gerenciador gerenciador = gerenciadores.get(index);
		if (gerenciador != null) {
			return gerenciador;
		}

		return null;
	}

	// recupera um gerenciador na lista de gerentes da aplicação, por sua senha e usuario
	public Gerenciador recuperarAdm(String nome, String senha) {
		for (Gerenciador gerenciador : gerenciadores) {
			if(gerenciador.getusuarioG().equals(nome) && gerenciador.getSenhaStringG().equals(senha)) {
				return gerenciador;
			}
		
		}

		return null;
	}

	public ArrayList<Gerenciador> getGerenciadores() {
		return gerenciadores;
	}

	public void setGerenciadores(ArrayList<Gerenciador> gerenciadores) {
		this.gerenciadores = gerenciadores;
	}

	public boolean isAdmin(String login, String senha) {
		
		for (Gerenciador gerenciador : gerenciadores) {
			if(gerenciador.getusuarioG().equals(login) && gerenciador.getSenhaStringG().equals(senha)) {
				return true;
			}
		
		}

		return false;

	}

	public boolean isParticipante(String login, String senha) {
		
		for (Gerenciador gerenciador : gerenciadores) {
			for (Participante participante : gerenciador.getParticipantes()) {
				if(participante.getEmailString().equals(login) && participante.getSenhaString().equals(senha)) {
					return true;
				}
			}
		
		}

		return false;

	}

}
