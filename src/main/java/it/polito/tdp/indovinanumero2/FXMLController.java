package it.polito.tdp.indovinanumero2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private final int NMAX=100;
	private final int TMAX=8;
	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtrisultati;

    @FXML
    private Button btnnuova;

    @FXML
    private TextField txtrimasti;

    @FXML
    private HBox layouttentativo;

    @FXML
    private TextField txttentativi;

    @FXML
    private Button btnprova;

    @FXML 
    void doNuova(ActionEvent event) {
    	 //evento associato al click del bottone nuova partita	
    	//geztione dell'inizio della nuova partita
    	this.segreto = (int)(Math.random() * NMAX) +1;
    	this.tentativiFatti = 0;
    	this.inGioco = true;
    	
    	//gestione interfaccia
    	layouttentativo.setDisable(false);
    	txtrisultati.clear();
    	txtrimasti.setText(Integer.toString(TMAX));
    	  	
    }  
    	
    
    @FXML
    void doTentativo(ActionEvent event) {
        //evento definire un nuovo tentativo
    	//leggere l'imput dell'utente
    	String ts= txttentativi.getText();
    	
    	//controllare l'input
    	int tentativo;
    	
    	try {
    	 tentativo = Integer.parseInt(ts);
    	} catch (NumberFormatException e) {
    	txtrisultati.appendText("devi inserire un numero");
    	return;
    	}
    	this.tentativiFatti ++; // incremento i tentativi fatti
    	
    	
    	if (tentativo == this.segreto) {
    		//ho indovinato
    		txtrisultati.appendText("HAI VINTO! Hai utilizzato" + this.tentativiFatti + "tentativi!" );
    		layouttentativo.setDisable(true);
    		this.inGioco=false;
    		return;
    	}
    	if (tentativiFatti==TMAX){
    		// ho esaurito i tentativi
    		txtrisultati.appendText("HAI PERSO!");
    		layouttentativo.setDisable(true);
    		this.inGioco=false;
    	return;
    	}
    	
    	//informare L'utente se il tentativo è troppo alto o troppo basso
    	 
    	 if (tentativo < this.segreto) {
    		 txtrisultati.appendText("Tentativo troppo basso \n");
    	 } else {
    		 txtrisultati.appendText("Tentativo troppo alto \n");
    	 
    	txtrimasti.setText(Integer.toString(TMAX-tentativiFatti));
    	
    	
    	 }
    	
    		
    	
    	
    }

    @FXML
    void initialize() {
        assert txtrisultati != null : "fx:id=\"txtrisultati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnnuova != null : "fx:id=\"btnnuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtrimasti != null : "fx:id=\"txtrimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layouttentativo != null : "fx:id=\"layouttentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttentativi != null : "fx:id=\"txttentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnprova != null : "fx:id=\"btnprova\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

