package com.Events.dao;

import java.io.File;

import com.Events.model.Gerenciador;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Persitencia {

	private static final String XML_FILE_STRING = "persistencia.xml";
	
	//Salva a classe Gerenciador no arquivo de persistencia "persistencia.xml"
	public static void persistir(Gerenciador gerenciador) {
		try {
			JAXBContext context = JAXBContext.newInstance(Gerenciador.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(gerenciador, new  File(XML_FILE_STRING));
			System.out.println("Dados salvos em " + XML_FILE_STRING);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	//Carrega a classe Gerenciador do arquivo de persistencia "persistencia.xml"
	public static Gerenciador carregar() {
		try {
			JAXBContext context = JAXBContext.newInstance(Gerenciador.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (Gerenciador)
			
			unmarshaller.unmarshal(new  File(XML_FILE_STRING));
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
