package gui.guiTeppiche;

import java.io.IOException;

import business.TeppichModel;
import business.Teppich;

import javafx.stage.Stage;
import ownUtil.Observer;

public class TeppichControl implements Observer{

	private TeppichModel model;
	private TeppichView view;

	public TeppichControl(Stage stage) {
		this.model = TeppichModel.getTeppichModel();
		this.view = new TeppichView(stage, this, model);
		model.addObserver(this);
	}

	public void nehmeTeppichAuf() {
		try {
			this.model.addTeppich(new Teppich(Integer.parseInt(view.getTxtArtikelnummer().getText()),
					view.getTxtKategorie().getText(), Float.parseFloat(view.getTxtBreite().getText()),
					Float.parseFloat(view.getTxtLaenge().getText()), view.getTxtFarben().getText().split(";")));
			view.zeigeInformationsfensterAn("Das Teppich wurde aufgenommen!");
		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
		this.model.notifyObservers();
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

	@Override
	public void update() {
		
		view.zeigeTeppichAn();
	}

}