package net.andreu.confusio;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {
	
	ArrayList<Professor>professors;
	
	boolean professor=false;
	boolean nom=false;
	boolean cognom=false;
	boolean sexe=false;
	boolean edat=false;
	
	String nomProfe;
	String cognomProfe;
	boolean esHome;
	int edatProfe;
	
	public Processar(ArrayList<Professor>professors){
		this.professors =  professors;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes){
		
		switch (qName) {
		case "professor":
			professor=true;			
			break;
		case "nom":
			nom=true;
			break;
		case "cognom":
			cognom=true;
		case "sexe":
			sexe=true;
			break;
		case "edat":
			edat=true;
			break;
		}
		
	}
	public void characters(char[] ch, int start, int length) {
		
		if(professor){
			if(nom){
				nomProfe=new String(ch, start, length);
			}else if(cognom){
				cognomProfe=new String(ch, start, length);
			}else if(sexe){
				String temp=new String(ch, start, length);
				if(temp.equals("Home")){
					esHome=true;
				}else{
					esHome=false;
				}
			}else if(edat){
				edatProfe=Integer.parseInt(new String(ch, start, length));
			}	
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {
		case "professor":
			Professor p = new Professor(nomProfe, cognomProfe, esHome, edatProfe);
			professors.add(p);
			professor=false;			
			break;
		case "nom":
			nom=false;
			break;
		case "cognom":
			cognom=false;
			break;
		case "sexe":
			sexe=false;
			break;
		case "edat":
			edat=false;
			break;
		}	
	}
	
	public void endDocument() {
	
	}
}
