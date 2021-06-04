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
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

public class showDegreesController implements Initializable{

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
    void handleSelectDegree(ActionEvent event) {

    	
    	acordionID.getPanes().clear();
    	
    	String nameCycleSelected = degreeList.getValue();
    	
    	if(nameCycleSelected.length() > 0) {
    	
    		Degree degree= getDegrees(nameCycleSelected);
    		
    		if(degree != null) {
    			
    			for (int i = 0; i < degree.getModuleList().size(); i++) {
					
					Module module = degree.getModuleList().get(i);
					
					AnchorPane anchorPane = new AnchorPane();
					
					TitledPane nameModul = new TitledPane();
					nameModul.setText(module.getName());
					
					ListView<String> unitList = new ListView<String>();
					
					for (int j = 0; j < module.getUnitList().size(); j++) {
						
						
						Unit unit = module.getUnitList().get(j);
						
						unitList.getItems().add(unit.getName());
						
					}

				    AnchorPane.setLeftAnchor(unitList, 00.0);
				    AnchorPane.setRightAnchor(unitList, 00.0);
				    //Cambiar esto si hay muchos
				    nameModul.setContent(anchorPane);
					anchorPane.getChildren().add(unitList);
					
					acordionID.getPanes().add(nameModul);
					
				}
    			
    		}
    		
    	}
    	
    }
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		System.out.println("Estoy dentro");
    	
		try {
			
			
			URL obj = new URL("https://team-danis-api.herokuapp.com/api/getAllDegrees");
			
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			JSONArray listCycles = new JSONArray(response.toString());
			
			System.out.println(listCycles.length());
			
			degreeArray = new ArrayList<Degree>();
			
			for(int i = 0; i < listCycles.length(); i ++) {
				
				JSONObject pipiolo = listCycles.getJSONObject(i);
				Degree cycleEntity = new Degree();
				
				cycleEntity.setName(pipiolo.get("nom_cicle_formatiu").toString());
				
				System.out.println(pipiolo.get("nom_cicle_formatiu").toString());
								
				ArrayList<Module> moduleList = new ArrayList<Module>();
				
				JSONArray listModuls = new JSONArray(pipiolo.getJSONArray("moduls").toString());
				
				for(int j = 0; j < listModuls.length(); j ++) {
					
					JSONObject modul = listModuls.getJSONObject(j);
					
					Module moduleEntity = new Module();
					
					moduleEntity.setName(modul.get("nom_modul").toString());
					
					ArrayList<Unit> unitiList = new ArrayList<Unit>();
					
					JSONArray listUnits = new JSONArray(modul.getJSONArray("unitats").toString());
					
					for(int x = 0; x < listUnits.length(); x ++) {
					
						JSONObject unit = listUnits.getJSONObject(x);
						
						Unit unitEntity = new Unit();
						
						unitEntity.setName(unit.get("nom_unitat_formativa").toString());
						
						System.out.println("unidad "+i+" "+unit.get("nom_unitat_formativa").toString());
						
						unitiList.add(unitEntity);
						
					}	
					
					moduleEntity.setUnitList(unitiList);
					
					moduleList.add(moduleEntity);
					
				}			
				
				cycleEntity.setModuleList(moduleList);
				
				degreeArray.add(cycleEntity);
				
			}
			
			ObservableList<String> cycleArrayList = FXCollections.observableList(new ArrayList<String>());

			for (Degree aaaa : degreeArray) {

				degreeList.getItems().add(aaaa.getName());

			}
			
			
			
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Nos vamos viendo master");
		
	}
	
	public Degree getDegrees(String cycleName) {
		
		Degree degree = null;
		
		for (Degree d : degreeArray) {
			
			if(d.getName().equalsIgnoreCase(cycleName)) {
				
				degree = d;
				
			}			
		}		
		return degree;		
	}
	
}
					