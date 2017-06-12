package aplikacja.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	
    @FXML
    private Button enterOne;
    @FXML
    private PasswordField passwordOne;
    @FXML
    private TextField textOne;
    @FXML
    private MenuButton menuOne;
    @FXML
    private Label lebalStatus;
    @FXML
    private ImageView imgOne;


	public void Login(ActionEvent event) throws Exception{
		if(textOne.getText().equals("admin") & passwordOne.getText().equals("admin123")){
			lebalStatus.setText("Login Sucess");
			Stage stg2 = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/aplikacja/view/SecondPane.fxml"));
			Scene sce = new Scene(root,600,583);		
			stg2.setScene(sce);
			stg2.show();
			
		}
	 else {
		lebalStatus.setText("Login Failed");
	}
}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
}
}


