package net.andreu.confusio;

import java.util.ArrayList;

public class QuadreDirectiu {

	Professor director;
	Professor secretari;
	ArrayList<Professor> capEstudis = new ArrayList<Professor>();
	Professor coordinador;
	
	public QuadreDirectiu(){
		
	}
	
	public Professor getDirector() {
		return director;
	}
	
	public boolean setDirector(Professor p) {
		boolean inscriure=true;
		
		if(capEstudis.contains(p)){
			inscriure=false;
		}
		if(coordinador!=null){
			if(coordinador.equals(p)){
				inscriure=false;
			}
		}
		if(secretari!=null){
			if(secretari.equals(p)){
				inscriure=false;
			}
		}
		if(inscriure==true){
			this.director = p;
		}
		return inscriure;
	}
	
	public Professor getSecretari() {
		return secretari;
	}
	
	public boolean setSecretari(Professor p) {
		boolean inscriure=true;
		
		if(capEstudis.contains(p)){
			inscriure=false;
		}
		if(coordinador!=null){
			if(coordinador.equals(p)){
				inscriure=false;
			}
		}
		if(director!=null){
			if(director.equals(p)){
				inscriure=false;
			}
		}
		if(inscriure==true){
			this.secretari = p;
		}
		return inscriure;		
	}
	
	public ArrayList<Professor> getCapEstudis() {
		return capEstudis;
	}
	
	public void setCapEstudis(ArrayList<Professor> capEstudis) {
		this.capEstudis = capEstudis;
	}
	
	public boolean addCapEstudis(Professor p) {
		boolean inscriure = true;
		
		if(capEstudis.size()<2){
			if(capEstudis.contains(p)){
				inscriure=false;
			}
			if(director!=null){
				if(director.equals(p)){
					inscriure=false;
				}
			}
			if(secretari!=null){
				if(secretari.equals(p)){
					inscriure=false;
				}
			}
			if(coordinador!=null){
				if(coordinador.equals(p)){
					inscriure=false;
				}
			}
			if(inscriure==true){
				this.capEstudis.add(p);
			}
		}
		return inscriure;
	}
	
	public int nCapEstudis(){
		return this.capEstudis.size();
	}
	
	public void netejaCapEstudis(){
		this.capEstudis.clear();
	}
	
	public Professor getCoordinador() {
		return coordinador;
	}
	
	public boolean compleixParitat(){
		boolean paritat = true;
		int nHomes=0;
		int nDones=0;
		
		if(director!=null){
			if(director.esHome()){
				nHomes++;
			}else{
				nDones++;
			}
		}
		if(secretari!=null){
			if(secretari.esHome()){
				nHomes++;
			}else{
				nDones++;
			}
		}
		if(coordinador!=null){
			if(coordinador.esHome()){
				nHomes++;
			}else{
				nDones++;
			}
		}
		for(Professor p:capEstudis){
			if(p.esHome()){
				nHomes++;
			}else{
				nDones++;
			}
		}
		if(nHomes-nDones>1 || nHomes-nDones<-1){
			paritat = false;
		}
		return paritat;
	}
	
	public boolean setCoordinador(Professor p) {
		boolean inscriure=true;
		
		if(capEstudis.contains(p)){
			inscriure=false;
		}
		if(director!=null){
			if(director.equals(p)){
				inscriure=false;
			}
		}
		if(secretari!=null){
			if(secretari.equals(p)){
				inscriure=false;
			}
		}
		if(inscriure==true){
			this.coordinador = p;
		}
		return inscriure;
	}
}
