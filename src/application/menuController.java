package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class menuController {
	
	@FXML
    private Button btn_show_alumns;
	
	@FXML
    private Button btn_show_degrees;
	
	@FXML
    private Button btn_add_degrees;
	
	static Stage show_alumns;
	static Stage show_degrees;
	static Stage add_degrees;
	
	@FXML
    void changeToShowAlumns(ActionEvent event) {
    	
    	Parent mainWindow;
    	
    	show_alumns = Main.principal;
    	
		try {
			
			mainWindow = FXMLLoader.load(getClass().getResource("alumnsWindow.fxml"));
			Scene scene = new Scene(mainWindow);
	        show_alumns.setScene(scene);
	        show_alumns.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
	@FXML
    void changeToAddDegrees(ActionEvent event) {
    	
    	Parent mainWindow;
    	
    	show_alumns = Main.principal;
    	
		try {
			
			mainWindow = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
			Scene scene = new Scene(mainWindow);
	        show_alumns.setScene(scene);
	        show_alumns.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	
	@FXML
    void changeToShowDegrees(ActionEvent event) {
    	
    	Parent mainWindow;
    	
    	show_alumns = Main.principal;
    	
		try {
			
			mainWindow = FXMLLoader.load(getClass().getResource("showDegrees.fxml"));
			Scene scene = new Scene(mainWindow);
	        show_alumns.setScene(scene);
	        show_alumns.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


}
