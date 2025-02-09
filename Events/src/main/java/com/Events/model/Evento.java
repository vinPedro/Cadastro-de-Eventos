package com.Events.model;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Evento {

	private String nomeString;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dataInicialDate;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dataFinalDate;

	private String localString;
	private int quantParticipantes;
	private ArrayList<Participante> participantes = new ArrayList<Participante>();
	private String descricaoString;

	public Evento(String nomeString, LocalDate dataInicialDate, LocalDate dataFinalDate, String localString,
			int quantParticipantes, String descricaoString) {

		super();
		this.nomeString = nomeString;
		this.dataInicialDate = dataInicialDate;
		this.dataFinalDate = dataFinalDate;
		this.localString = localString;
		this.quantParticipantes = quantParticipantes;
		this.descricaoString = descricaoString;
	}

	// adiciona um usuário a lista de participantes do evento
	public boolean addparticipante(Participante participante) {
		if (participante.equals(null)) {

			return false;
		}

		else if (participantes.add(participante) == true) {
			return true;

		}

		return false;
	}

	// remove um usuário da lista de participantes do evento pelo index(lugar na
	// lista) do participante
	public boolean excluirEscricaoParticipante(int index) {
		if (index < 0 || index >= participantes.size()) {
			return false;
		}

		else if (!participantes.remove(index).equals(null)) {

			return true;
		}

		return false;
	}

	// remove um usuário da lista de participantes do evento pelo passando o proprio
	// participante recuperado da lista de inscricoes
	public boolean excluirEscricaoParticipante(Participante participante) {
		if (participante.equals(null)) {
			return false;
		}

		else if (participantes.remove(participante) == true) {
			return true;
		}

		return false;
	}

	public Participante recuperarParticipante(int index) {
		Participante participante = participantes.get(index);
		if (!participante.equals(null)) {
			return participante;
		}

		return null;
	}

	public Evento() {
	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public void setDataInicialDate(LocalDate dataInicialDate) {
		this.dataInicialDate = dataInicialDate;
	}

	public void setDataFinalDate(LocalDate dataFinalDate) {
		this.dataFinalDate = dataFinalDate;
	}

	public String getLocalString() {
		return localString;
	}

	public void setLocalString(String localString) {
		this.localString = localString;
	}

	public int getQuantParticipantes() {
		return quantParticipantes;
	}

	public void setQuantParticipantes(int quantParticipantes) {
		this.quantParticipantes = quantParticipantes;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public String getDescricaoString() {
		return descricaoString;
	}

	public void setDescricaoString(String descricaoString) {
		this.descricaoString = descricaoString;
	}

}
