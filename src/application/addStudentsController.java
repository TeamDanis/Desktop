package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import db_clases.ImportedStudents;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class addStudentsController implements Initializable{

	private static ArrayList<ImportedStudents> studentsList;
	private static ArrayList<String> studentListJSON;
	
	static Stage mainMenu;
	
    @FXML
    private TableView<ImportedStudents> tableid;

    @FXML
    private TableColumn<ImportedStudents, String> idConvocatoria;

    @FXML
    private TableColumn<ImportedStudents, String> idCodiSolicitud;

    @FXML
    private TableColumn<ImportedStudents, String> idTipusSolicitud;

    @FXML
    private TableColumn<ImportedStudents, String> idEstatSolicitud;

    @FXML
    private TableColumn<ImportedStudents, String> idNom;

    @FXML
    private TableColumn<ImportedStudents, String> idPrimerCognom;

    @FXML
    private TableColumn<ImportedStudents, String> idSegonCognom;

    @FXML
    private TableColumn<ImportedStudents, String> idRalc;

    @FXML
    private TableColumn<ImportedStudents, String> idTipusAlumne;

    @FXML
    private TableColumn<ImportedStudents, String> idCodiCentre;

    @FXML
    private TableColumn<ImportedStudents, String> idNomCentre;

    @FXML
    private TableColumn<ImportedStudents, String> idNaturalesaCentre;

    @FXML
    private TableColumn<ImportedStudents, String> idMunicipiCentre;

    @FXML
    private TableColumn<ImportedStudents, String> idSSTTCentre;

    @FXML
    private TableColumn<ImportedStudents, String> idCodiEnsenyament;

    @FXML
    private TableColumn<ImportedStudents, String> idNomEnsenyament;

    @FXML
    private TableColumn<ImportedStudents, String> idCodiModalitat;

    @FXML
    private TableColumn<ImportedStudents, String> idModalitat;

    @FXML
    private TableColumn<ImportedStudents, String> idCurs;

    @FXML
    private TableColumn<ImportedStudents, String> idRegim;

    @FXML
    private TableColumn<ImportedStudents, String> idTorn;

    @FXML
    private TableColumn<ImportedStudents, String> idDni;

    @FXML
    private TableColumn<ImportedStudents, String> idNie;

    @FXML
    private TableColumn<ImportedStudents, String> idPass;

    @FXML
    private TableColumn<ImportedStudents, String> idTis;

    @FXML
    private TableColumn<ImportedStudents, String> idDataNaixement;

    @FXML
    private TableColumn<ImportedStudents, String> idSexe;

    @FXML
    private TableColumn<ImportedStudents, String> idNacionalitat;

    @FXML
    private TableColumn<ImportedStudents, String> idPaisNaixement;

    @FXML
    private TableColumn<ImportedStudents, String> idMunicipiNaixement;

    @FXML
    private TableColumn<ImportedStudents, String> idTipusVia;

    @FXML
    private TableColumn<ImportedStudents, String> idNomVia;

    @FXML
    private TableColumn<ImportedStudents, String> idNumeroVia;

    @FXML
    private TableColumn<ImportedStudents, String> idAltresDades;

    @FXML
    private TableColumn<ImportedStudents, String> idProvinciaResidencia;

    @FXML
    private TableColumn<ImportedStudents, String> idMunicipiResidencia;

    @FXML
    private TableColumn<ImportedStudents, String> idLocalitatResidencia;

    @FXML
    private TableColumn<ImportedStudents, String> idCp;

    @FXML
    private TableColumn<ImportedStudents, String> idPaisResidencia;

    @FXML
    private TableColumn<ImportedStudents, String> idTelefon;

    @FXML
    private TableColumn<ImportedStudents, String> idCorreuElectronic;

    @FXML
    private TableColumn<ImportedStudents, String> idTipusDocTutor;

    @FXML
    private TableColumn<ImportedStudents, String> idNumDocTutor;

    @FXML
    private TableColumn<ImportedStudents, String> idNomTutor;

    @FXML
    private TableColumn<ImportedStudents, String> idPrimerCognomTutor;

    @FXML
    private TableColumn<ImportedStudents, String> idSegonCognomTutor;

    @FXML
    private TableColumn<ImportedStudents, String> idTipusDocTutor2;

    @FXML
    private TableColumn<ImportedStudents, String> idNumDocTutor2;

    @FXML
    private TableColumn<ImportedStudents, String> idNomTutor2;

    @FXML
    private TableColumn<ImportedStudents, String> idPrimerCognomTutor2;

    @FXML
    private TableColumn<ImportedStudents, String> idSegonCognomTutor2;

    @FXML
    private TableColumn<ImportedStudents, String> idCodiCentreProc;

    @FXML
    private TableColumn<ImportedStudents, String> idNomCentreProc;

    @FXML
    private TableColumn<ImportedStudents, String> idCodiEnsenyamentProc;

    @FXML
    private TableColumn<ImportedStudents, String> idNomEnsenyamentProc;

    @FXML
    private TableColumn<ImportedStudents, String> idCursProc;

    @FXML
    private TableColumn<ImportedStudents, String> idLlenguaEnten;

    @FXML
    private TableColumn<ImportedStudents, String> idReligio;

    @FXML
    private TableColumn<ImportedStudents, String> idCentreAssignat;

    @FXML
    private Button btn_imp_cursos;

    @FXML
    private Button btn_menu;

    @FXML
    void searchFile(ActionEvent event) {

    	FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Archivo Alumnos");

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));

		studentsList = new ArrayList<ImportedStudents>();
		
		File file = fileChooser.showOpenDialog(null);	
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
			
			String line = null;
			int lines = (int) br.lines().count();
			for (int i = 1; i < lines; i++) {
				line = Files.readAllLines(Paths.get(file.getAbsolutePath())).get(i);
				String[] content = line.split(",");
			
				System.out.println(line);
				
				//System.out.println("longitud del content: "+content.length);
				
				studentsList.add(new ImportedStudents(content[0],content[1],content[2],content[3],content[4],content[5],
						content[6],content[7],content[8],content[9],content[10],content[11],content[12],content[13],
						content[14],content[15],content[16],content[17],content[18],content[19],content[20],content[21],
						content[22],content[23],content[24],content[25],content[26],content[27],content[28],content[29],
						content[30],content[31],content[32],content[33],content[34],content[35],content[36],content[37],
						content[38],content[39],content[40],content[41],content[42],content[43],content[44],content[45],
						content[46],content[47],content[48],content[49],content[50],content[51],content[52],content[53],
						content[54],content[55],content[56],content[57],content[58]));
			}		
			br.close();
			
			idConvocatoria.setCellValueFactory(new PropertyValueFactory<>("Convocatoria"));
			idCodiSolicitud.setCellValueFactory(new PropertyValueFactory<>("Codi_solicitud"));
			idTipusSolicitud.setCellValueFactory(new PropertyValueFactory<>("Tipus_solicitud"));
			idEstatSolicitud.setCellValueFactory(new PropertyValueFactory<>("Estat_solicitud"));
			idNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
			idPrimerCognom.setCellValueFactory(new PropertyValueFactory<>("Primer_cognom"));
			idSegonCognom.setCellValueFactory(new PropertyValueFactory<>("Segon_cognom"));		
			idRalc.setCellValueFactory(new PropertyValueFactory<>("Identificacio_RALC"));
			idTipusAlumne.setCellValueFactory(new PropertyValueFactory<>("Tipus_alumne"));
			idCodiCentre.setCellValueFactory(new PropertyValueFactory<>("Codi_centre"));
			idNomCentre.setCellValueFactory(new PropertyValueFactory<>("Nom_centre"));
			idNaturalesaCentre.setCellValueFactory(new PropertyValueFactory<>("Naturalesa_centre"));
			idMunicipiCentre.setCellValueFactory(new PropertyValueFactory<>("Municipi_centre"));
			idSSTTCentre.setCellValueFactory(new PropertyValueFactory<>("SSTT_centre"));
			idCodiEnsenyament.setCellValueFactory(new PropertyValueFactory<>("Codi_ensenyament"));
			idNomEnsenyament.setCellValueFactory(new PropertyValueFactory<>("Nom_ensenyament"));
			idCodiModalitat.setCellValueFactory(new PropertyValueFactory<>("Codi_modalitat"));
			idModalitat.setCellValueFactory(new PropertyValueFactory<>("Modalitat"));
			idCurs.setCellValueFactory(new PropertyValueFactory<>("Curs"));
			idRegim.setCellValueFactory(new PropertyValueFactory<>("Regim"));
			idTorn.setCellValueFactory(new PropertyValueFactory<>("Torn"));
			idDni.setCellValueFactory(new PropertyValueFactory<>("DNI"));
			idNie.setCellValueFactory(new PropertyValueFactory<>("NIE"));
			idPass.setCellValueFactory(new PropertyValueFactory<>("PASS"));
			idTis.setCellValueFactory(new PropertyValueFactory<>("TIS"));
			idDataNaixement.setCellValueFactory(new PropertyValueFactory<>("Data_naixement"));
			idSexe.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
			idNacionalitat.setCellValueFactory(new PropertyValueFactory<>("Nacionalitat"));
			idPaisNaixement.setCellValueFactory(new PropertyValueFactory<>("Pais_naixement"));
			idMunicipiNaixement.setCellValueFactory(new PropertyValueFactory<>("Municipi_naixement"));
			idTipusVia.setCellValueFactory(new PropertyValueFactory<>("Tipus_via"));
			idNomVia.setCellValueFactory(new PropertyValueFactory<>("Nom_via"));
			idNumeroVia.setCellValueFactory(new PropertyValueFactory<>("Numero_via"));
			idAltresDades.setCellValueFactory(new PropertyValueFactory<>("Altres_dades"));
			idProvinciaResidencia.setCellValueFactory(new PropertyValueFactory<>("Provincia_residencia"));
			idMunicipiResidencia.setCellValueFactory(new PropertyValueFactory<>("Municipi_residencia"));
			idLocalitatResidencia.setCellValueFactory(new PropertyValueFactory<>("Localitat_residencia"));
			idCp.setCellValueFactory(new PropertyValueFactory<>("CP"));
			idPaisResidencia.setCellValueFactory(new PropertyValueFactory<>("Pais_residencia"));
			idTelefon.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
			idCorreuElectronic.setCellValueFactory(new PropertyValueFactory<>("Correu_electronic"));
			idTipusDocTutor.setCellValueFactory(new PropertyValueFactory<>("Tipus_doc_tutor"));
			idNumDocTutor.setCellValueFactory(new PropertyValueFactory<>("Num_doc_tutor"));
			idNomTutor.setCellValueFactory(new PropertyValueFactory<>("Nom_tutor"));
			idPrimerCognomTutor.setCellValueFactory(new PropertyValueFactory<>("Primer_cognom_tutor"));
			idSegonCognomTutor.setCellValueFactory(new PropertyValueFactory<>("Segon_cognom_tutor"));
			idTipusDocTutor2.setCellValueFactory(new PropertyValueFactory<>("Tipus_doc_tutor2"));
			idNumDocTutor2.setCellValueFactory(new PropertyValueFactory<>("Num_doc_tutor2"));
			idNomTutor2.setCellValueFactory(new PropertyValueFactory<>("Nom_tutor2"));
			idPrimerCognomTutor2.setCellValueFactory(new PropertyValueFactory<>("Primer_cognom_tutor2"));
			idSegonCognomTutor2.setCellValueFactory(new PropertyValueFactory<>("Segon_cognom_tutor2"));
			idCodiCentreProc.setCellValueFactory(new PropertyValueFactory<>("Codi_centre_proc"));
			idNomCentreProc.setCellValueFactory(new PropertyValueFactory<>("Nom_centre_proc"));
			idCodiEnsenyamentProc.setCellValueFactory(new PropertyValueFactory<>("Codi_ensenyament_proc"));		
			idNomEnsenyamentProc.setCellValueFactory(new PropertyValueFactory<>("Nom_ensenyament_proc"));
			idCursProc.setCellValueFactory(new PropertyValueFactory<>("Curs_proc"));
			idLlenguaEnten.setCellValueFactory(new PropertyValueFactory<>("Llengua_enten"));
			idReligio.setCellValueFactory(new PropertyValueFactory<>("Religio"));
			idCentreAssignat.setCellValueFactory(new PropertyValueFactory<>("Centre_assignat"));
			
			for (ImportedStudents importedStudents : studentsList) {
				tableid.getItems().add(importedStudents);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void addStudents(ActionEvent event) {

        URL obj;
        try {
            obj = new URL("https://team-danis-api.herokuapp.com/api/importAlumns");

            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            OutputStream os = con.getOutputStream();
            
            studentListJSON = new ArrayList<String>();
            
        	for (ImportedStudents student : tableid.getItems()) {
				
				Gson gson = new Gson();
				String JSON = gson.toJson(student);
				studentListJSON.add(JSON);
				
			}
        	
        	System.out.println(studentListJSON.toString());
        	
        	os.write(studentListJSON.toString().getBytes("UTF-8"));
        	
        	Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("");
			alert.setHeaderText("Alumnos añadidos");
			alert.setContentText("los alumnos se han añadido correctamente!");

			alert.showAndWait();
			
			con.getInputStream();
			os.close();
            
            
            
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL!");
        } catch (IOException e) {
            System.err.println("IO EXCEPTION Error" +e);
        }
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
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