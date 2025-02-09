package com.Events.dao;

import java.io.File;

import com.Events.model.Adm;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Persitencia {

	private static final String XML_FILE_STRING = "persistencia.xml";
	
	//Salva a classe Gerenciador no arquivo de persistencia "persistencia.xml"
	public static void persistir(Adm adm) {
		try {
			JAXBContext context = JAXBContext.newInstance(Adm.class);
			Marshaller marshaller = context.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(adm, new  File(XML_FILE_STRING));
			System.out.println("Dados salvos em " + XML_FILE_STRING);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	//Carrega a classe Gerenciador do arquivo de persistencia "persistencia.xml"
	public static Adm carregar() {
		try {
			JAXBContext context = JAXBContext.newInstance(Adm.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (Adm)
			
			unmarshaller.unmarshal(new  File(XML_FILE_STRING));
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
