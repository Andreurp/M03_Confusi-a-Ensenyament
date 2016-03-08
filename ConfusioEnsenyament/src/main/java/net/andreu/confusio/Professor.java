package net.andreu.confusio;

public class Professor {
	
	String nomProfe;
	String cognomProfe;
	boolean esHome;
	int edatProfe;
	
	public Professor (String nomProfe, String cognomProfe, boolean esHome, int edatProfe){
		this.nomProfe=nomProfe;
		this.cognomProfe=cognomProfe;
		this.esHome=esHome;
		this.edatProfe=edatProfe;
	}
	
	public boolean esHome() {
		return esHome;
	}

	public int getEdatProfe() {
		return edatProfe;
	}
	
	public String getNomComplet(){
		return nomProfe+" "+cognomProfe;
	}
	
	@Override
	public String toString(){
		String retorn = nomProfe+" "+cognomProfe+",";
		if(esHome){
			retorn+= " home,";
		}else{
			retorn+= " dona,";
		}
		retorn+=" "+edatProfe+" anys.";
		return retorn;
	}
}
