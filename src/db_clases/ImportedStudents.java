package db_clases;

public class ImportedStudents {
	
	private String Convocatoria;
	private String Codi_solicitud;
	private String Tipus_solicitud;
	private String Estat_solicitud;
	private String Nom;
	private String Primer_cognom;
	private String Segon_cognom;
	private String Identificacio_RALC;
	private String Tipus_alumne;
	private String Codi_centre;
	private String Nom_centre;
	private String Naturalesa_centre;
	private String Municipi_centre;
	private String SSTT_centre;
	private String Codi_ensenyament;
	private String Nom_ensenyament;
	private String Codi_modalitat;
	private String Modalitat;
	private String Curs;
	private String Regim;
	private String Torn;
	private String DNI;
	private String NIE;
	private String PASS;
	private String TIS;
	private String Data_naixement;
	private String Sexe;
	private String Nacionalitat;
	private String Pais_naixement;
	private String Municipi_naixement;
	private String Tipus_via;
	private String Nom_via;
	private String Numero_via;
	private String Altres_dades;
	private String Provincia_residencia;
	private String Municipi_residencia;
	private String Localitat_residencia;
	private String CP;
	private String Pais_residencia;
	private String Telefon;
	private String Correu_electronic;
	private String Tipus_doc_tutor;
	private String Num_doc_tutor;
	private String Nom_tutor;
	private String Primer_cognom_tutor;
	private String Segon_cognom_tutor;
	private String Tipus_doc_tutor2;
	private String Num_doc_tutor2;
	private String Nom_tutor2;
	private String Primer_cognom_tutor2;
	private String Segon_cognom_tutor2;
	private String Codi_centre_proc;
	private String Nom_centre_proc;
	private String Codi_ensenyament_proc;
	private String Nom_ensenyament_proc;
	private String Curs_proc;
	private String Llengua_enten;
	private String Religio;
	private String Centre_assignat;
	
	public ImportedStudents() {
		
	}

	public ImportedStudents(String convocatoria, String codi_solicitud, String tipus_solicitud, String estat_solicitud,
			String nom, String primer_cognom, String segon_cognom, String identificacio_RALC, String tipus_alumne,
			String codi_centre, String nom_centre, String naturalesa_centre, String municipi_centre, String sSTT_centre,
			String codi_ensenyament, String nom_ensenyament, String codi_modalitat, String modalitat, String curs,
			String regim, String torn, String dNI, String nIE, String pASS, String tIS, String data_naixement,
			String sexe, String nacionalitat, String pais_naixement, String municipi_naixement, String tipus_via,
			String nom_via, String numero_via, String altres_dades, String provincia_residencia,
			String municipi_residencia, String localitat_residencia, String cP, String pais_residencia, String telefon,
			String correu_electronic, String tipus_doc_tutor, String num_doc_tutor, String nom_tutor,
			String primer_cognom_tutor, String segon_cognom_tutor, String tipus_doc_tutor2, String num_doc_tutor2,
			String nom_tutor2, String primer_cognom_tutor2, String segon_cognom_tutor2, String codi_centre_proc,
			String nom_centre_proc, String codi_ensenyament_proc, String nom_ensenyament_proc, String curs_proc,
			String llengua_enten, String religio, String centre_assignat) {
		super();
		Convocatoria = convocatoria;
		Codi_solicitud = codi_solicitud;
		Tipus_solicitud = tipus_solicitud;
		Estat_solicitud = estat_solicitud;
		Nom = nom;
		Primer_cognom = primer_cognom;
		Segon_cognom = segon_cognom;
		Identificacio_RALC = identificacio_RALC;
		Tipus_alumne = tipus_alumne;
		Codi_centre = codi_centre;
		Nom_centre = nom_centre;
		Naturalesa_centre = naturalesa_centre;
		Municipi_centre = municipi_centre;
		SSTT_centre = sSTT_centre;
		Codi_ensenyament = codi_ensenyament;
		Nom_ensenyament = nom_ensenyament;
		Codi_modalitat = codi_modalitat;
		Modalitat = modalitat;
		Curs = curs;
		Regim = regim;
		Torn = torn;
		DNI = dNI;
		NIE = nIE;
		PASS = pASS;
		TIS = tIS;
		Data_naixement = data_naixement;
		Sexe = sexe;
		Nacionalitat = nacionalitat;
		Pais_naixement = pais_naixement;
		Municipi_naixement = municipi_naixement;
		Tipus_via = tipus_via;
		Nom_via = nom_via;
		Numero_via = numero_via;
		Altres_dades = altres_dades;
		Provincia_residencia = provincia_residencia;
		Municipi_residencia = municipi_residencia;
		Localitat_residencia = localitat_residencia;
		CP = cP;
		Pais_residencia = pais_residencia;
		Telefon = telefon;
		Correu_electronic = correu_electronic;
		Tipus_doc_tutor = tipus_doc_tutor;
		Num_doc_tutor = num_doc_tutor;
		Nom_tutor = nom_tutor;
		Primer_cognom_tutor = primer_cognom_tutor;
		Segon_cognom_tutor = segon_cognom_tutor;
		Tipus_doc_tutor2 = tipus_doc_tutor2;
		Num_doc_tutor2 = num_doc_tutor2;
		Nom_tutor2 = nom_tutor2;
		Primer_cognom_tutor2 = primer_cognom_tutor2;
		Segon_cognom_tutor2 = segon_cognom_tutor2;
		Codi_centre_proc = codi_centre_proc;
		Nom_centre_proc = nom_centre_proc;
		Codi_ensenyament_proc = codi_ensenyament_proc;
		Nom_ensenyament_proc = nom_ensenyament_proc;
		Curs_proc = curs_proc;
		Llengua_enten = llengua_enten;
		Religio = religio;
		Centre_assignat = centre_assignat;
	}

	

	public String getConvocatoria() {
		return Convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		Convocatoria = convocatoria;
	}

	public String getCodi_solicitud() {
		return Codi_solicitud;
	}

	public void setCodi_solicitud(String codi_solicitud) {
		Codi_solicitud = codi_solicitud;
	}

	public String getTipus_solicitud() {
		return Tipus_solicitud;
	}

	public void setTipus_solicitud(String tipus_solicitud) {
		Tipus_solicitud = tipus_solicitud;
	}

	public String getEstat_solicitud() {
		return Estat_solicitud;
	}

	public void setEstat_solicitud(String estat_solicitud) {
		Estat_solicitud = estat_solicitud;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrimer_cognom() {
		return Primer_cognom;
	}

	public void setPrimer_cognom(String primer_cognom) {
		Primer_cognom = primer_cognom;
	}

	public String getSegon_cognom() {
		return Segon_cognom;
	}

	public void setSegon_cognom(String segon_cognom) {
		Segon_cognom = segon_cognom;
	}

	public String getIdentificacio_RALC() {
		return Identificacio_RALC;
	}

	public void setIdentificacio_RALC(String identificacio_RALC) {
		Identificacio_RALC = identificacio_RALC;
	}

	public String getTipus_alumne() {
		return Tipus_alumne;
	}

	public void setTipus_alumne(String tipus_alumne) {
		Tipus_alumne = tipus_alumne;
	}

	public String getCodi_centre() {
		return Codi_centre;
	}

	public void setCodi_centre(String codi_centre) {
		Codi_centre = codi_centre;
	}

	public String getNom_centre() {
		return Nom_centre;
	}

	public void setNom_centre(String nom_centre) {
		Nom_centre = nom_centre;
	}

	public String getNaturalesa_centre() {
		return Naturalesa_centre;
	}

	public void setNaturalesa_centre(String naturalesa_centre) {
		Naturalesa_centre = naturalesa_centre;
	}

	public String getMunicipi_centre() {
		return Municipi_centre;
	}

	public void setMunicipi_centre(String municipi_centre) {
		Municipi_centre = municipi_centre;
	}

	public String getSSTT_centre() {
		return SSTT_centre;
	}

	public void setSSTT_centre(String sSTT_centre) {
		SSTT_centre = sSTT_centre;
	}

	public String getCodi_ensenyament() {
		return Codi_ensenyament;
	}

	public void setCodi_ensenyament(String codi_ensenyament) {
		Codi_ensenyament = codi_ensenyament;
	}

	public String getNom_ensenyament() {
		return Nom_ensenyament;
	}

	public void setNom_ensenyament(String nom_ensenyament) {
		Nom_ensenyament = nom_ensenyament;
	}

	public String getCodi_modalitat() {
		return Codi_modalitat;
	}

	public void setCodi_modalitat(String codi_modalitat) {
		Codi_modalitat = codi_modalitat;
	}

	public String getModalitat() {
		return Modalitat;
	}

	public void setModalitat(String modalitat) {
		Modalitat = modalitat;
	}

	public String getCurs() {
		return Curs;
	}

	public void setCurs(String curs) {
		Curs = curs;
	}

	public String getRegim() {
		return Regim;
	}

	public void setRegim(String regim) {
		Regim = regim;
	}

	public String getTorn() {
		return Torn;
	}

	public void setTorn(String torn) {
		Torn = torn;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNIE() {
		return NIE;
	}

	public void setNIE(String nIE) {
		NIE = nIE;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

	public String getTIS() {
		return TIS;
	}

	public void setTIS(String tIS) {
		TIS = tIS;
	}

	public String getData_naixement() {
		return Data_naixement;
	}

	public void setData_naixement(String data_naixement) {
		Data_naixement = data_naixement;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getNacionalitat() {
		return Nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) {
		Nacionalitat = nacionalitat;
	}

	public String getPais_naixement() {
		return Pais_naixement;
	}

	public void setPais_naixement(String pais_naixement) {
		Pais_naixement = pais_naixement;
	}

	public String getMunicipi_naixement() {
		return Municipi_naixement;
	}

	public void setMunicipi_naixement(String municipi_naixement) {
		Municipi_naixement = municipi_naixement;
	}

	public String getTipus_via() {
		return Tipus_via;
	}

	public void setTipus_via(String tipus_via) {
		Tipus_via = tipus_via;
	}

	public String getNom_via() {
		return Nom_via;
	}

	public void setNom_via(String nom_via) {
		Nom_via = nom_via;
	}

	public String getNumero_via() {
		return Numero_via;
	}

	public void setNumero_via(String numero_via) {
		Numero_via = numero_via;
	}

	public String getAltres_dades() {
		return Altres_dades;
	}

	public void setAltres_dades(String altres_dades) {
		Altres_dades = altres_dades;
	}

	public String getProvincia_residencia() {
		return Provincia_residencia;
	}

	public void setProvincia_residencia(String provincia_residencia) {
		Provincia_residencia = provincia_residencia;
	}

	public String getMunicipi_residencia() {
		return Municipi_residencia;
	}

	public void setMunicipi_residencia(String municipi_residencia) {
		Municipi_residencia = municipi_residencia;
	}

	public String getLocalitat_residencia() {
		return Localitat_residencia;
	}

	public void setLocalitat_residencia(String localitat_residencia) {
		Localitat_residencia = localitat_residencia;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getPais_residencia() {
		return Pais_residencia;
	}

	public void setPais_residencia(String pais_residencia) {
		Pais_residencia = pais_residencia;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	public String getCorreu_electronic() {
		return Correu_electronic;
	}

	public void setCorreu_electronic(String correu_electronic) {
		Correu_electronic = correu_electronic;
	}

	public String getTipus_doc_tutor() {
		return Tipus_doc_tutor;
	}

	public void setTipus_doc_tutor(String tipus_doc_tutor) {
		Tipus_doc_tutor = tipus_doc_tutor;
	}

	public String getNum_doc_tutor() {
		return Num_doc_tutor;
	}

	public void setNum_doc_tutor(String num_doc_tutor) {
		Num_doc_tutor = num_doc_tutor;
	}

	public String getNom_tutor() {
		return Nom_tutor;
	}

	public void setNom_tutor(String nom_tutor) {
		Nom_tutor = nom_tutor;
	}

	public String getPrimer_cognom_tutor() {
		return Primer_cognom_tutor;
	}

	public void setPrimer_cognom_tutor(String primer_cognom_tutor) {
		Primer_cognom_tutor = primer_cognom_tutor;
	}

	public String getSegon_cognom_tutor() {
		return Segon_cognom_tutor;
	}

	public void setSegon_cognom_tutor(String segon_cognom_tutor) {
		Segon_cognom_tutor = segon_cognom_tutor;
	}

	public String getTipus_doc_tutor2() {
		return Tipus_doc_tutor2;
	}

	public void setTipus_doc_tutor2(String tipus_doc_tutor2) {
		Tipus_doc_tutor2 = tipus_doc_tutor2;
	}

	public String getNum_doc_tutor2() {
		return Num_doc_tutor2;
	}

	public void setNum_doc_tutor2(String num_doc_tutor2) {
		Num_doc_tutor2 = num_doc_tutor2;
	}

	public String getNom_tutor2() {
		return Nom_tutor2;
	}

	public void setNom_tutor2(String nom_tutor2) {
		Nom_tutor2 = nom_tutor2;
	}

	public String getPrimer_cognom_tutor2() {
		return Primer_cognom_tutor2;
	}

	public void setPrimer_cognom_tutor2(String primer_cognom_tutor2) {
		Primer_cognom_tutor2 = primer_cognom_tutor2;
	}

	public String getSegon_cognom_tutor2() {
		return Segon_cognom_tutor2;
	}

	public void setSegon_cognom_tutor2(String segon_cognom_tutor2) {
		Segon_cognom_tutor2 = segon_cognom_tutor2;
	}

	public String getCodi_centre_proc() {
		return Codi_centre_proc;
	}

	public void setCodi_centre_proc(String codi_centre_proc) {
		Codi_centre_proc = codi_centre_proc;
	}

	public String getNom_centre_proc() {
		return Nom_centre_proc;
	}

	public void setNom_centre_proc(String nom_centre_proc) {
		Nom_centre_proc = nom_centre_proc;
	}

	public String getCodi_ensenyament_proc() {
		return Codi_ensenyament_proc;
	}

	public void setCodi_ensenyament_proc(String codi_ensenyament_proc) {
		Codi_ensenyament_proc = codi_ensenyament_proc;
	}

	public String getNom_ensenyament_proc() {
		return Nom_ensenyament_proc;
	}

	public void setNom_ensenyament_proc(String nom_ensenyament_proc) {
		Nom_ensenyament_proc = nom_ensenyament_proc;
	}

	public String getCurs_proc() {
		return Curs_proc;
	}

	public void setCurs_proc(String curs_proc) {
		Curs_proc = curs_proc;
	}

	public String getLlengua_enten() {
		return Llengua_enten;
	}

	public void setLlengua_enten(String llengua_enten) {
		Llengua_enten = llengua_enten;
	}

	public String getReligio() {
		return Religio;
	}

	public void setReligio(String religio) {
		Religio = religio;
	}

	public String getCentre_assignat() {
		return Centre_assignat;
	}

	public void setCentre_assignat(String centre_assignat) {
		Centre_assignat = centre_assignat;
	}

	@Override
	public String toString() {
		return "ImportedStudents [Convocatoria=" + Convocatoria + ", Codi_solicitud=" + Codi_solicitud
				+ ", Tipus_solicitud=" + Tipus_solicitud + ", Estat_solicitud=" + Estat_solicitud + ", Nom=" + Nom
				+ ", Primer_cognom=" + Primer_cognom + ", Segon_cognom=" + Segon_cognom + ", Identificació_RALC="
				+ Identificacio_RALC + ", Tipus_alumne=" + Tipus_alumne + ", Codi_centre=" + Codi_centre
				+ ", Nom_centre=" + Nom_centre + ", Naturalesa_centre=" + Naturalesa_centre + ", Municipi_centre="
				+ Municipi_centre + ", SSTT_centre=" + SSTT_centre + ", Codi_ensenyament=" + Codi_ensenyament
				+ ", Nom_ensenyament=" + Nom_ensenyament + ", Codi_modalitat=" + Codi_modalitat + ", Modalitat="
				+ Modalitat + ", Curs=" + Curs + ", Règim=" + Regim + ", Torn=" + Torn + ", DNI=" + DNI + ", NIE=" + NIE
				+ ", PASS=" + PASS + ", TIS=" + TIS + ", Data_naixement=" + Data_naixement + ", Sexe=" + Sexe
				+ ", Nacionalitat=" + Nacionalitat + ", Pais_naixement=" + Pais_naixement + ", Municipi_naixement="
				+ Municipi_naixement + ", Tipus_via=" + Tipus_via + ", Nom_via=" + Nom_via + ", Numero_via="
				+ Numero_via + ", Altres_dades=" + Altres_dades + ", Provincia_residencia=" + Provincia_residencia
				+ ", Municipi_residencia=" + Municipi_residencia + ", Localitat_residencia=" + Localitat_residencia
				+ ", CP=" + CP + ", Pais_residencia=" + Pais_residencia + ", Telefon=" + Telefon
				+ ", Correu_electronic=" + Correu_electronic + ", Tipus_doc_tutor=" + Tipus_doc_tutor
				+ ", Num_doc_tutor=" + Num_doc_tutor + ", Nom_tutor=" + Nom_tutor + ", Primer_cognom_tutor="
				+ Primer_cognom_tutor + ", Segon_cognom_tutor=" + Segon_cognom_tutor + ", Tipus_doc_tutor2="
				+ Tipus_doc_tutor2 + ", Num_doc_tutor2=" + Num_doc_tutor2 + ", Nom_tutor2=" + Nom_tutor2
				+ ", Primer_cognom_tutor2=" + Primer_cognom_tutor2 + ", Segon_cognom_tutor2=" + Segon_cognom_tutor2
				+ ", Codi_centre_proc=" + Codi_centre_proc + ", Nom_centre_proc=" + Nom_centre_proc
				+ ", Codi_ensenyament_proc=" + Codi_ensenyament_proc + ", Nom_ensenyament_proc=" + Nom_ensenyament_proc
				+ ", Curs_proc=" + Curs_proc + ", Llengua_enten=" + Llengua_enten + ", Religio=" + Religio
				+ ", Centre_assignat=" + Centre_assignat + "]";
	}
	
	


}