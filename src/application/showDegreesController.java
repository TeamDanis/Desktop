package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db_clases.Degree;
import db_clases.Module;
import db_clases.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class showDegreesController implements Initializable{

	static Stage mainMenu;
	
	private static ArrayList<Degree> degreeArray;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> degreeList;


    @FXML
    private Accordion acordionID;
    
    
    @FXML
    void selectDegree(ActionEvent event) {

    	acordionID.getPanes().clear();
    	
    	String nameDegreeSelected = degreeList.getValue();
    	
    	if(nameDegreeSelected.length() > 0) {
    	
    		Degree degree= getDegrees(nameDegreeSelected);
    		
    		if(degree != null) {
    			
    			for (int i = 0; i < degree.getModuleList().size(); i++) {
					
					Module module = degree.getModuleList().get(i);
					
					AnchorPane anchorPane = new AnchorPane();
					
					TitledPane nameModule = new TitledPane();
					nameModule.setText(module.getName());
					
					ListView<String> unitList = new ListView<String>();
					
					for (int j = 0; j < module.getUnitList().size(); j++) {
						
						
						Unit unit = module.getUnitList().get(j);
						
						unitList.getItems().add(unit.getName());
						
					}

				    AnchorPane.setLeftAnchor(unitList, 00.0);
				    AnchorPane.setRightAnchor(unitList, 00.0);
				    //Cambiar esto si hay muchos
				    nameModule.setContent(anchorPane);
					anchorPane.getChildren().add(unitList);
					
					acordionID.getPanes().add(nameModule);
					
				}
    			
    		}
    		
    	}
    	
    }
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

    	
		try {
			
			URL obj = new URL("https://team-danis-api.herokuapp.com/api/getAllDegrees");
			
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			JSONArray listDegrees = new JSONArray(response.toString());
			
			System.out.println(listDegrees.length());
			
			degreeArray = new ArrayList<Degree>();
			
			for(int i = 0; i < listDegrees.length(); i ++) {
				
				JSONObject jo = listDegrees.getJSONObject(i);
				Degree degree = new Degree();
				degree.setName(jo.get("nom_cicle_formatiu").toString());
				System.out.println(jo.get("nom_cicle_formatiu").toString());		
				ArrayList<Module> moduleList = new ArrayList<Module>();
				JSONArray listModules = new JSONArray(jo.getJSONArray("moduls").toString());
				
				for(int j = 0; j < listModules.length(); j ++) {
					
					JSONObject modul = listModules.getJSONObject(j);
					Module moduleEntity = new Module();
					moduleEntity.setName(modul.get("nom_modul").toString());
					ArrayList<Unit> unitList = new ArrayList<Unit>();
					JSONArray listUnits = new JSONArray(modul.getJSONArray("unitats").toString());
					
					for(int x = 0; x < listUnits.length(); x ++) {
					
						JSONObject unit = listUnits.getJSONObject(x);
						Unit unitEntity = new Unit();
						unitEntity.setName(unit.get("nom_unitat_formativa").toString());
						unitList.add(unitEntity);
						
					}	
					
					moduleEntity.setUnitList(unitList);
					moduleList.add(moduleEntity);
					
				}			
				
				degree.setModuleList(moduleList);
				degreeArray.add(degree);
				
			}
			

			for (Degree d : degreeArray) {
				degreeList.getItems().add(d.getName());
			}
			
			
			
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public Degree getDegrees(String degreeName) {
		
		Degree degree = null;
		for (Degree d : degreeArray) {
			if(d.getName().equalsIgnoreCase(degreeName)) {
				degree = d;
			}			
		}		
		return degree;		
	}
	
   @FXML
    void backToMenu(ActionEvent event) {

	   Parent mainWindow;
   	
	   mainMenu = Main.principal;
   	
		try {
			
			mainWindow = FXMLLoader.load(getClass().getResource("main_menu.fxml"));
			Scene scene = new Scene(mainWindow);
			mainMenu.setScene(scene);
			mainMenu.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
    }
	
}
					