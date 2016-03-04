package net.andreu.confusio;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Processar extends DefaultHandler {
	
	ArrayList<String>director= new ArrayList<String>();
	ArrayList<String>Secretari= new ArrayList<String>();
	ArrayList<String>capEstudi= new ArrayList<String>();
	ArrayList<String>coordinacio= new ArrayList<String>();
	
	boolean professor=false;
	boolean nom=false;
	boolean cognom=false;
	boolean sexe=false;
	boolean edat=false;
	
	String nomProfe;
	String cognomProfe;
	int sexeProfe;
	int edatProfe;
	
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
		/*case "sexe":
			sexe=true;
			break;
		case "edat":
			edat=true;
			break;*/
		}
		
	}
	public void characters(char[] ch, int start, int length) {
		
		if(professor){
			if(nom){
				nomProfe=new String(ch, start, length);
			}else if(cognom){
				cognomProfe=new String(ch, start, length);
			}/*else if(sexe){
				sexeProfe=Integer.parseInt(new String(ch, start, length));
			}else if(edat){
				edatProfe=Integer.parseInt(new String(ch, start, length));
			}*/
		}
		director.add(nomProfe+" "+cognomProfe);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {

		switch (qName) {
		case "professor":
			professor=false;			
			break;
		case "nom":
			nom=false;
			break;
		case "cognom":
			cognom=false;
			break;
		/*case "sexe":
			sexe=false;
			break;
		case "edat":
			edat=false;
			break;*/
		}
		
	}
	
	public void endDocument() {
		for(int i=0; i<director.size(); i++){
			System.out.println(director.get(i));
		}
	}
}
