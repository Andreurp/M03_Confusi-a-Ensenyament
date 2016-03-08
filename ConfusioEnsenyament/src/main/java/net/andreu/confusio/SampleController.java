package net.andreu.confusio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class SampleController {
	@FXML
	private Button fitxer;
	@FXML
	private Button desa;
	@FXML
	private Label direc;
	@FXML
	private Label sec;
	@FXML
	private Label capEstudi;
	@FXML
	private Label coord;
	@FXML
	private Button calcula;
	@FXML
	private Label nomDirec;
	@FXML
	private Label nomSec;
	@FXML
	private Label nomCapEstudi;
	@FXML
	private Label nomCoord;
	
	private ArrayList<Professor>professors= new ArrayList<Professor>();
	private Random r = new Random();
	
	// Event Listener on Button[#fitxer].onMouseClicked
	@FXML
	public void cargaFitxer(MouseEvent event) throws ParserConfigurationException, SAXException, IOException {
		FileChooser buscador = new FileChooser();
		buscador.getExtensionFilters().addAll(new ExtensionFilter("XML Files", "*.xml"));
		File selectedFile = buscador.showOpenDialog(null);
		
		if(selectedFile != null){
			SAXParserFactory fabrica=SAXParserFactory.newInstance();
			fabrica.setNamespaceAware(true);
	        SAXParser parser=fabrica.newSAXParser();
	        InputStream fitxer = new FileInputStream(selectedFile);
	        parser.parse(fitxer,new Processar(professors));
		}

		omplirCamps();
	}
	
	// Event Listener on Button[#desa].onMouseClicked
	@FXML
	public void generarFitxer(MouseEvent event) throws IOException {
		
		BufferedWriter escriure = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Equip directiu.txt"), "utf-8"));
		escriure.write(direc.getText()+" "+nomDirec.getText()+"\n"+sec.getText()+" "+nomSec.getText()+"\n"+capEstudi.getText()+" "+nomCapEstudi.getText()+"\n"+coord.getText()+" "+nomCoord.getText());
		escriure.close();
	}
	
	// Event Listener on Button[#calcula].onMouseClicked
	@FXML
	public void canviaNoms(MouseEvent event) {
		nomCapEstudi.setText("");
		omplirCamps();
	}
	
	public void omplirCamps(){
		QuadreDirectiu q = new QuadreDirectiu();
		
		boolean tincDirector;
		boolean tincSecretari;
		boolean tincCoordinador;
		
		do{
			tincDirector=false;
			tincSecretari=false;
			tincCoordinador=false;
			q.netejaCapEstudis();
			
			while(tincDirector==false){
				tincDirector=q.setDirector(professors.get(r.nextInt(professors.size())));
			}
			while(tincSecretari==false){
				tincSecretari=q.setSecretari(professors.get(r.nextInt(professors.size())));
			}
			while(tincCoordinador==false){
				tincCoordinador=q.setCoordinador(professors.get(r.nextInt(professors.size())));
			}
			while(q.nCapEstudis()<2){
				q.addCapEstudis(professors.get(r.nextInt(professors.size())));
			}
		}while(!q.compleixParitat());
		
		nomDirec.setText(q.getDirector().getNomComplet());
		nomSec.setText(q.getSecretari().getNomComplet());
		nomCoord.setText(q.getCoordinador().getNomComplet());
		for(Professor p:q.getCapEstudis()){
			nomCapEstudi.setText(nomCapEstudi.getText()+p.getNomComplet()+"\n");
		}
		
	}
}
