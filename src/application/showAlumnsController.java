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
import db_clases.Students_data;
import db_clases.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class showAlumnsController implements Initializable{
	
	static Stage show_alumns;
	private static ArrayList<Degree> degreeArray;	
	
	private static ArrayList<Students_data> studentArray;
	private static ArrayList<JSONObject> studentJSONArray;

    @FXML
    private TableView<Students_data> idTableView;

    @FXML
    private TableColumn<Students_data, String> idColumnDni;

    @FXML
    private TableColumn<Students_data, String> idColumnName;

    @FXML
    private TableColumn<Students_data, String> idColumnFirstSurname;

    @FXML
    private TableColumn<Students_data, String> idColumnSecondSurname;

    @FXML
    private TableColumn<Students_data, String> idPhoneNumber;

    @FXML
    private TableColumn<Students_data, String> idMail;

    @FXML
    private ChoiceBox<String> degreeList;

    @FXML
    private Button studensButton;
	
	
    
    
    
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
    void handleSelectCycleGetStudens(ActionEvent event) {
		
		
		try {
			idTableView.getItems().clear();
			
			String degreeName = degreeList.getValue();
			
			String url ="https://team-danis-api.herokuapp.com/api/getAlumn?degreeName=" + degreeName.replaceAll("\\s+","%20");
			URL obj = new URL(url);
			
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			// Read JSON response and print
			JSONArray listStudens = new JSONArray(response.toString());
			
			studentArray = new ArrayList<Students_data>();
			
			studentJSONArray = new ArrayList<JSONObject>();
			
			
			for(int i = 0; i < listStudens.length(); i ++) {
				
				JSONObject student = listStudens.getJSONObject(i);
				studentJSONArray.add(student);
				
				Students_data studentEntity = new Students_data();
				
				studentEntity.setDni(student.get("RALC_id").toString());
				studentEntity.setName(student.get("Name").toString());
				studentEntity.setFirst_surname(student.get("First_surname").toString());
				studentEntity.setSecond_surname(student.get("Last_surname").toString());
				studentEntity.setPhone_number(student.get("Phone_number").toString());
				studentEntity.setMail(student.get("Email").toString());
				
				studentArray.add(studentEntity);
				
			}
			
			idColumnDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
			idColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
			idColumnFirstSurname.setCellValueFactory(new PropertyValueFactory<>("first_surname"));
			idColumnSecondSurname.setCellValueFactory(new PropertyValueFactory<>("second_surname"));
			idPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
			idMail.setCellValueFactory(new PropertyValueFactory<>("mail"));

			for (Students_data s : studentArray) {
				idTableView.getItems().add(s);
			}			
			
			
			
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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


}
