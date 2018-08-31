/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.AnagrammaModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private AnagrammaModel model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretto"
    private TextArea txtCorretto; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrato"
    private TextArea txtErrato; // Value injected by FXMLLoader

    @FXML
    void doAnagramma(ActionEvent event) {

    	String cerca = txtParola.getText();
    	Set<String> an = model.calcolaAnagrammi(cerca);
    	
    	for(String s : an) {
    		if(model.isCorrect(s))
    			txtCorretto.appendText(s + " \n");
    		else 
    			txtErrato.appendText(s + "\n");
    	}
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtParola.clear();
    	txtCorretto.clear();
    	txtErrato.clear();
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtErrato != null : "fx:id=\"txtErrato\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(AnagrammaModel model) {
		this.model = model;
		
		
	}
    
    
}

