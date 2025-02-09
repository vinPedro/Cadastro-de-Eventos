package com.Events.model;

public class Participante {

	private String nomeString;
	private String senhaString;
	private int idade;

	private Sexo sexoParticipanteSexo;
	private String emailString;

	public Participante(String nomeString, String senha, int idade, Sexo sexoParticipanteSexo, String emaiString) {
		super();
		this.nomeString = nomeString;
		this.senhaString = senha;
		this.idade = idade;
		this.sexoParticipanteSexo = sexoParticipanteSexo;
		this.setEmailString(emaiString);
	}

	public Participante() {

	}

	public String getNomeString() {
		return nomeString;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexoParticipanteSexo() {
		return sexoParticipanteSexo;
	}

	public void setSexoParticipanteSexo(Sexo sexoParticipanteSexo) {
		this.sexoParticipanteSexo = sexoParticipanteSexo;
	}

	public String getSenhaString() {
		return senhaString;
	}

	public void setSenhaString(String senhaString) {
		this.senhaString = senhaString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

}
