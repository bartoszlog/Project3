package aplikacja.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppModel extends Application {

	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stg) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/aplikacja/view/MainPane.fxml"));
		Scene sce = new Scene(root,785,306);		
		stg.setScene(sce);
		stg.show();
		
	}

}