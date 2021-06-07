package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import db_clases.Degree;
import db_clases.Unit;
import db_clases.Module;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class cursosController {

	
    @FXML
    private Button btn_imp_cursos;

    @FXML
    private Button btn_imp_alumnes;
    
    @FXML
    private Button testeito;
    
    @FXML
    private TableView<Degree> tableid;

    @FXML
    private TableColumn<Degree, String> codigoCicloId;

    @FXML
    private TableColumn<Degree, String> nombreCicloId;

    @FXML
    private TableColumn<Degree, String> adaptationCurrId;

    @FXML
    private TableColumn<Degree, String> horasTotalId;

    @FXML
    private TableColumn<Degree, String> startDateId;

    @FXML
    private TableColumn<Degree, String> finalDateId;
    
	static Stage alumnStage;
	static Stage mainMenu;
	
	ArrayList<Degree> degrees = new ArrayList<>();

    @FXML	
    void changeStage(ActionEvent event) {
    	
    	Parent mainWindow;
    	
    	alumnStage = Main.principal;
    	
		try {
			
			mainWindow = FXMLLoader.load(getClass().getResource("alumnsWindow.fxml"));
			Scene scene = new Scene(mainWindow);
	        alumnStage.setScene(scene);
	        alumnStage.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    @FXML
    void searchFile (ActionEvent event) {
    	
    	FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Cursos");

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		File file = fileChooser.showOpenDialog(null);	
		
		ArrayList<String[]> lines = new ArrayList<>();
		
		degrees = new ArrayList<Degree>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
			while (br.ready()) {
				lines.add(br.readLine().replaceAll("\"+", "").split(","));
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("El formato del archivo es incorrecto");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		System.out.println(" lines.size(): "+ lines.size());
		
		int c = -1;
		int m = -1;
		
		for (int i = 0; i < lines.size() - 1; i++) {
			System.out.println("indice: "+i);
			if (!lines.get(i)[0].equals(lines.get(i + 1)[0])) {
				m = -1;
				if (i == 0) {
					c += 1;
					m += 1;
					degrees.add(new Degree(lines.get(i + 1)[0], lines.get(i + 1)[1], lines.get(i + 1)[2], lines.get(i + 1)[3], lines.get(i + 1)[4], lines.get(i + 1)[5], new ArrayList<>()));
					degrees.get(c).getModuleList().add(new Module(lines.get(i + 1)[6], lines.get(i + 1)[7], lines.get(i + 1)[8], lines.get(i + 1)[9], lines.get(i + 1)[10], lines.get(i + 1)[11], new ArrayList<>()));
					degrees.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i + 1)[12], lines.get(i + 1)[13], lines.get(i + 1)[14], lines.get(i + 1)[15], lines.get(i + 1)[16], lines.get(i + 1)[17], lines.get(i + 1)[18]));
				} else {
					degrees.get(c).getModuleList().add(new Module(lines.get(i)[6], lines.get(i)[7], lines.get(i)[8], lines.get(i)[9], lines.get(i)[10], lines.get(i)[11], new ArrayList<>()));
					i += 1;
					c += 1;
					m += 1;
					degrees.add(new Degree(lines.get(i)[0], lines.get(i)[1], lines.get(i)[2], lines.get(i)[3], lines.get(i)[4], lines.get(i)[5], new ArrayList<>()));
					degrees.get(c).getModuleList().add(new Module(lines.get(i)[6], lines.get(i)[7], lines.get(i)[8], lines.get(i)[9], lines.get(i)[10], lines.get(i)[11], new ArrayList<>()));
					degrees.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i)[12], lines.get(i)[13], lines.get(i)[14], lines.get(i)[15], lines.get(i)[16], lines.get(i)[17], lines.get(i)[18]));
				}
			} else {
				if (degrees.size() > 0) {
					if (!degrees.get(c).getModuleList().get(m).getCode().equals(lines.get(i)[6])) {
						degrees.get(c).getModuleList().add(new Module(lines.get(i)[6], lines.get(i)[7], lines.get(i)[8], lines.get(i)[9], lines.get(i)[10], lines.get(i)[11], new ArrayList<>()));
						m += 1;
						degrees.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i)[12], lines.get(i)[13], lines.get(i)[14], lines.get(i)[15], lines.get(i)[16], lines.get(i)[17], lines.get(i)[18]));
						
					} else {
						degrees.get(c).getModuleList().get(m).getUnitList().add(new Unit(lines.get(i)[12], lines.get(i)[13], lines.get(i)[14], lines.get(i)[15], lines.get(i)[16], lines.get(i)[17], lines.get(i)[18]));
					}
				}
			}
		}
		

        codigoCicloId.setCellValueFactory(new PropertyValueFactory<>("code_degree"));
        nombreCicloId.setCellValueFactory(new PropertyValueFactory<>("name"));
        adaptationCurrId.setCellValueFactory(new PropertyValueFactory<>("adap_curr"));
        horasTotalId.setCellValueFactory(new PropertyValueFactory<>("hours_duration"));
        startDateId.setCellValueFactory(new PropertyValueFactory<>("initial_date"));
        finalDateId.setCellValueFactory(new PropertyValueFactory<>("final_date"));

        for (Degree i : degrees) {
            tableid.getItems().add(i);
        }
    		  
    }
    
    @FXML
    private void addDegrees(ActionEvent event) {
        try {
        	URL obj = new URL("https://team-danis-api.herokuapp.com/api/importDegrees");

            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            os.write(tableid.getSelectionModel().getSelectedItems().toString().replaceAll("'", "").getBytes("UTF-8"));
            os.close();

            //System.out.println(tableid.getSelectionModel().getSelectedItems().toString().replaceAll("'", ""));

            con.getInputStream();
        } catch (MalformedURLException e) {
            System.err.println("Error en la URL al importar.");
        } catch (IOException e) {
            System.err.println("Error en la respuesta del servidor." +e);
        }
    }
    
    public static void setStage(Stage primaryStage) {
    	alumnStage = primaryStage;
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