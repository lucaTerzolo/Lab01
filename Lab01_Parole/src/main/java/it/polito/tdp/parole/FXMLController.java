package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button btnCancella;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtTempo;


    @FXML
    void doInsert(ActionEvent event) {
    	long start,end;
    	start=System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	String s="";
    	for(String ss:elenco.getElenco())
    		s+=""+ss+"\n";
    	txtResult.setText(s);
    	txtParola.setText("");
    	end=System.nanoTime();
    	txtTempo.setText(""+(end-start)+" 10^-9 s");
    }

    @FXML
    void doReset(ActionEvent event) {
    	long start,end;
    	start=System.nanoTime();
    	elenco.reset();
    	txtParola.setText("");
    	txtResult.setText("");
    	end=System.nanoTime();
    	txtTempo.setText(""+(end-start)+" 10^-9 s");
    }

    @FXML
    void doDelete(ActionEvent event) {
    	long start,end;
    	start=System.nanoTime();
    	String s="";
    	elenco.delete(txtParola.getText());
    	for(String ss:elenco.getElenco())
    		s+=""+ss+"\n";
    	txtResult.setText(s);
    	txtParola.setText("");
    	end=System.nanoTime();
    	txtTempo.setText(""+(end-start)+" 10^-9 s");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
