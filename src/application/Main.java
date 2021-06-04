package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	public static Stage principal;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("design.fxml"));
			Scene scene = new Scene(root);
			
			Parent secondWindow = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
			Scene secondScene = new Scene(secondWindow);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			
			mainController.setStage(primaryStage);
			
			principal = primaryStage;
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}