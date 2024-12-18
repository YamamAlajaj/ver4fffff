package gui.Teppich;

import java.io.IOException;

import business.Teppich;

//package gui.guiBodenbelaege;

import business.TeppichModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class BodenbelaegeView {
	
	private BodenbelaegeView view;
	private BodenbelaegeControl bodenbelaegeControl;
	private TeppichModel model;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeTeppiche = new Label("Anzeige Teppiche");
	private TextArea txtAnzeigeTeppiche = new TextArea();
	private Button btnAnzeigeTeppiche = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public BodenbelaegeView(BodenbelaegeControl bodenbelaegeControl, Stage primaryStage, TeppichModel model) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Bodenbelägen");
		primaryStage.show();
		this.bodenbelaegeControl = bodenbelaegeControl;
		this.model = model;
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeTeppiche.setLayoutX(310);
		lblAnzeigeTeppiche.setLayoutY(40);
		lblAnzeigeTeppiche.setFont(font);
		lblAnzeigeTeppiche.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeTeppiche);
		// Textbereich
		txtAnzeigeTeppiche.setEditable(false);
		txtAnzeigeTeppiche.setLayoutX(310);
		txtAnzeigeTeppiche.setLayoutY(90);
		txtAnzeigeTeppiche.setPrefWidth(220);
		txtAnzeigeTeppiche.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeTeppiche);
		// Button
		btnAnzeigeTeppiche.setLayoutX(310);
		btnAnzeigeTeppiche.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeTeppiche);
	}

	private void initListener() {
		btnAnzeigeTeppiche.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//zeigeTeppicheAn();
				
				bodenbelaegeControl.update();
			}
		});
		
	}
	
	public void zeigeTeppicheAn() {
		if(this.model.getTeppich().size() > 0) {
    		StringBuffer t = new StringBuffer();
    		for (Teppich teppich : model.getTeppich()) {
				t.append(teppich.gibTeppichZurueck(' ')+"\n");
				this.txtAnzeigeTeppiche.setText(t.toString());
			}
    	}else {
    		zeigeInformationsfensterAn("Teppich wurde bisher nicht aufgenommen");
    	}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

    public void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }
	
	public void schreibeTeppichInCsvDatei() {
		try {
			this.model.schreibeTeppichInCsvDatei();
			//this.view.zeigeInformationsfensterAn("Die Teppiche wurden geschpeichert!");
		} catch (IOException exc) {
			this.view.zeigeFehlermeldungsfensterAn("IOExeption beim Speichern!");
		} catch (Exception exc) {
			this.view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void leseAusDatei(String typ) {
		try {
			this.model.leseAusDatei(typ);
			//this.view.zeigeInformationsfensterAn("Die Teppiche wurden gespeichert!");
		} catch (IOException exc) {
			this.view.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}

	}


}
