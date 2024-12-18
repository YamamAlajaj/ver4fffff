package gui.Teppich;

import business.TeppichModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BodenbelaegeControl implements Observer{
	
	
	
		
		private BodenbelaegeView bodenbelaegeView;
		private TeppichModel model;
		public BodenbelaegeControl(Stage primaryStage){
	 		
			//zum einfuegen
			this.model = TeppichModel.getTeppichModel();
			
			//this.teppicheModel = new TeppichModel(); 		
	 		
			this.bodenbelaegeView = new BodenbelaegeView(this, primaryStage,
				model);
			model.addObserver(this);
		}
		@Override
		public void update() {
			bodenbelaegeView.zeigeTeppicheAn();
			
		}
	}




