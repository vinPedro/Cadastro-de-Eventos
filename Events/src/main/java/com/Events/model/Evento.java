package com.Events.model;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.text.DateFormatter;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Evento {

	private String nomeString;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dataInicial;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dataFinal;

	private String localString;
	private int quantParticipantes;
	private ArrayList<Participante> participantes = new ArrayList<Participante>();
	private String descricaoString;

	public Evento(String nomeString, LocalDate dataInicial, LocalDate dataFinal, String localString,
			int quantParticipantes, String descricaoString) {

		super();
		this.nomeString = nomeString;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
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

	public void setDataInicialDate(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataInicialDate() {
		if(this.dataInicial == null) {
			return "";
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.dataInicial.format(formatter);
	}

	public void setDataFinalDate(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDataFinalDate() {
		if(this.dataFinal == null) {
			return "";
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return this.dataFinal.format(formatter);
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

	public String toString(){
		return nomeString;
	}

}
