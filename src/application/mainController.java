package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class mainController {

	static Stage loginStage;
	
	
    @FXML
    private TextField userNameTF;

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField userPasswordTF;

    @FXML
    void loginAction(ActionEvent event) {

    	URL url;
		try {
			
			String userName = userNameTF.getText();
			
			String userPassword = userPasswordTF.getText();
			
			String res = "";
			
			
			//localhost:3000/api/loginAdmins?userName="+userName+"&userPassword="+userPassword
			//https://team-danis-api.herokuapp.com/api/login?userName="+userName+"&userPassword="+userPassword
			
			url = new URL("https://team-danis-api.herokuapp.com/api/loginAdmin?adminUsername="+userName+"&adminPassword="+userPassword);
			URLConnection conexion = url.openConnection();
	        conexion.connect();
	        
	        //lectura InputStream is = conexion.getInputStream();
			InputStream is = conexion.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			char[] buffer = new char[2000];
			int leido;
			while ((leido = br.read(buffer)) > 0) {
				res = new String(buffer, 0, leido);
	         }
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(res);
			
			Boolean correct = (Boolean) json.get("correct");
	        
			if(correct == true) {
				Parent mainWindow = FXMLLoader.load(getClass().getResource("main_menu.fxml"));
				Scene scene = new Scene(mainWindow);
		        loginStage.setScene(scene);
		        loginStage.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Login failed");
				alert.setContentText("El usuario o la contraseña son incorrectos");

				alert.showAndWait();
			}
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
    }
    
    public static void setStage(Stage primaryStage) {
    	loginStage = primaryStage;
    }
    

}
